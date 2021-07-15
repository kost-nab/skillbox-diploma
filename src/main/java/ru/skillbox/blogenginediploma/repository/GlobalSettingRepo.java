package ru.skillbox.blogenginediploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skillbox.blogenginediploma.model.GlobalSetting;

@Repository
public interface GlobalSettingRepo extends JpaRepository<GlobalSetting, Integer> {
}
