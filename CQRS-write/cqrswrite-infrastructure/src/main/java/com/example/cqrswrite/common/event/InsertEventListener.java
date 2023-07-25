package com.example.cqrswrite.common.event;

import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InsertEventListener implements PostInsertEventListener {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void onPostInsert(PostInsertEvent event) {
        eventPublisher.publishEvent(new GenericCreateEvent<>(event.getEntity()));
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister persister) {
        return false;
    }
}
