package com.doughhack.doughnotList.services;

import com.doughhack.doughnotList.dao.EntryDao;
import com.doughhack.doughnotList.model.Entry;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EntryService {
    private final EntryDao entryDao;

    public EntryService(EntryDao entryDao) {
        this.entryDao = entryDao;
    }

    public void create(Entry entry) {
        entryDao.create(entry);
    }

    public void update(Entry entry) {
        entryDao.update(entry);
    }

    public Entry getEntry(long id) {
        return entryDao.getEntryById(id);
    }

    public void delete(long id) {
        Entry entry = getEntry(id);
        if (entry != null) entryDao.delete(id);
    }
}
