package com.cdt.usermanager.repositories;

import com.cdt.usermanager.domains.UserData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class UsersTest {

    @Autowired
    private Users users;

    @Test
    public void test01() {
        // Trato de obtener un usuario que no existe
        // Given

        // When
        assertThrows(NoSuchElementException.class, () -> users.findById("213").get());

        // Then
    }

    @Test
    public void test02() {
        // Creo un usuariuo invalido
        // Given
        UserData userData = new UserData();

        // When
        assertThrows(DataIntegrityViolationException.class, () -> users.save(userData));

        // Then
    }

    @Test
    public void test03() {
        // Creo y obtengo un usuario correctamente
        // Given
        UserData userData = new UserData();
        userData.setName("Juan Perez");
        userData.setEmail("juan@mail.com");
        userData.setAge(35);

        // When
        UserData userDataCreated = users.save(userData);
        UserData userDataGetted = users.findById(userData.getId()).get();

        // Then
        assertEquals(userDataGetted, userDataCreated);
    }

    @Test
    public void test04() {
        // Creo dos usuarios con la misma informacion
        // Given
        UserData request1 = new UserData();
        request1.setName("Pepe");
        request1.setEmail("pepe@mail.com");
        request1.setAge(50);
        UserData request2 = new UserData();
        request2.setName("Pepe");
        request2.setEmail("pepe@mail.com");
        request2.setAge(50);

        // When
        UserData userData1 = users.save(request1);
        UserData userData2 = users.save(request2);

        // Then
        assertNotEquals(userData1.getId(), userData2.getId());
        assertEquals(userData1.getName(), userData2.getName());
        assertEquals(userData1.getEmail(), userData2.getEmail());
        assertEquals(userData1.getAge(), userData2.getAge());
    }
}