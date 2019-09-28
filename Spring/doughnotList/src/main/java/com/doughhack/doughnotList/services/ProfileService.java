package com.doughhack.doughnotList.services;

import com.doughhack.doughnotList.dao.ProfileDao;
import com.doughhack.doughnotList.model.Profile;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProfileService {
    @Autowired
    private ProfileDao profileDao;

    public void create(Profile profile) {
        profileDao.create(profile);
    }

    public void update(Profile profile) {
        profileDao.update(profile);
    }

    public Profile getProfileById(long id) {
        return profileDao.getProfileById(id);
    }
}
