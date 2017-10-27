package com.opipo.ultimategamesrating.service.impl;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.opipo.ultimategamesrating.model.Sequence;
import com.opipo.ultimategamesrating.service.SequenceService;

@Service
public class SequenceServiceImpl implements SequenceService {
    @Autowired
    private MongoOperations mongo;

    /* (non-Javadoc)
     * @see com.opipo.duties.service.impl.SequenceService#getNextSequence(java.lang.String)
     */
    @Override
    public int getNextSequence(String seqName) {
        Sequence counter = mongo.findAndModify(query(where("_id").is(seqName)), new Update().inc("seq", 1),
                options().returnNew(true).upsert(true), Sequence.class);
        return counter.getSeq();
    }
}