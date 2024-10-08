package com.cdt.usermanager.repositories;

import com.cdt.usermanager.domains.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users extends JpaRepository<UserData, String> {
}
