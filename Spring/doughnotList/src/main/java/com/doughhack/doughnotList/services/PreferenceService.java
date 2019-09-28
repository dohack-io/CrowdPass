package com.doughhack.doughnotList.services;

import com.doughhack.doughnotList.dao.PreferenceDao;
import com.doughhack.doughnotList.dto.PreferenceDto;
import com.doughhack.doughnotList.model.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PreferenceService {
    @Autowired
    private PreferenceDao preferenceDao;

    public void create(Preference preference) {
        preferenceDao.create(preference);
    }

    public void update(Preference preference) {
        preferenceDao.update(preference);
    }

    public Preference getPreference(long id) {
        return preferenceDao.getPreferenceById(id);
    }

    public void delete(long id) {
        Preference preference = getPreference(id);
        if (preference != null)
            preferenceDao.delete(id);
    }
}
