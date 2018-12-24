package com.github.marschall.hibernate.jfr;

import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.AutoFlushEvent;
import org.hibernate.event.spi.AutoFlushEventListener;
import org.hibernate.event.spi.ClearEvent;
import org.hibernate.event.spi.ClearEventListener;
import org.hibernate.event.spi.DeleteEvent;
import org.hibernate.event.spi.DeleteEventListener;
import org.hibernate.event.spi.DirtyCheckEvent;
import org.hibernate.event.spi.DirtyCheckEventListener;
import org.hibernate.event.spi.EvictEvent;
import org.hibernate.event.spi.EvictEventListener;
import org.hibernate.event.spi.FlushEntityEvent;
import org.hibernate.event.spi.FlushEntityEventListener;
import org.hibernate.event.spi.InitializeCollectionEvent;
import org.hibernate.event.spi.InitializeCollectionEventListener;
import org.hibernate.event.spi.LoadEvent;
import org.hibernate.event.spi.LoadEventListener;
import org.hibernate.event.spi.LockEvent;
import org.hibernate.event.spi.LockEventListener;
import org.hibernate.event.spi.MergeEvent;
import org.hibernate.event.spi.MergeEventListener;
import org.hibernate.event.spi.PersistEvent;
import org.hibernate.event.spi.PersistEventListener;
import org.hibernate.event.spi.PostCollectionRemoveEvent;
import org.hibernate.event.spi.PostCollectionRemoveEventListener;
import org.hibernate.event.spi.PostCollectionUpdateEvent;
import org.hibernate.event.spi.PostCollectionUpdateEventListener;
import org.hibernate.event.spi.PostCommitDeleteEventListener;
import org.hibernate.event.spi.PostCommitInsertEventListener;
import org.hibernate.event.spi.PostCommitUpdateEventListener;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PostLoadEvent;
import org.hibernate.event.spi.PostLoadEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.event.spi.PreCollectionRecreateEvent;
import org.hibernate.event.spi.PreCollectionRecreateEventListener;
import org.hibernate.event.spi.PreCollectionRemoveEvent;
import org.hibernate.event.spi.PreCollectionRemoveEventListener;
import org.hibernate.event.spi.PreCollectionUpdateEvent;
import org.hibernate.event.spi.PreCollectionUpdateEventListener;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreLoadEvent;
import org.hibernate.event.spi.PreLoadEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.hibernate.event.spi.RefreshEvent;
import org.hibernate.event.spi.RefreshEventListener;
import org.hibernate.event.spi.ReplicateEvent;
import org.hibernate.event.spi.ReplicateEventListener;
import org.hibernate.event.spi.ResolveNaturalIdEvent;
import org.hibernate.event.spi.ResolveNaturalIdEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;

import jdk.jfr.Category;
import jdk.jfr.Description;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.StackTrace;

public class JfrListener implements

AutoFlushEventListener,
ClearEventListener,
DeleteEventListener,
DirtyCheckEventListener,
EvictEventListener,
FlushEntityEventListener,
InitializeCollectionEventListener,
LoadEventListener,
LockEventListener,
MergeEventListener,
PersistEventListener,
PreCollectionRecreateEventListener,
PreCollectionRemoveEventListener,
PreCollectionUpdateEventListener,
PostCollectionRemoveEventListener,
PostCollectionUpdateEventListener,
PostCommitDeleteEventListener,
PostCommitInsertEventListener,
PostCommitUpdateEventListener,
PostDeleteEventListener,
PreInsertEventListener,
PreLoadEventListener,
PreUpdateEventListener,
PostInsertEventListener,
PostLoadEventListener,
PostUpdateEventListener,
RefreshEventListener,
ReplicateEventListener,
ResolveNaturalIdEventListener,
SaveOrUpdateEventListener {

  @Override
  public boolean requiresPostCommitHanding(EntityPersister persister) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException {
    var jfrEvent = new JfrSaveOrUpdateEvent();
    jfrEvent.entityName = event.getEntityName();
    jfrEvent.commit();
  }

  @Override
  public void onResolveNaturalId(ResolveNaturalIdEvent event) throws HibernateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void onReplicate(ReplicateEvent event) throws HibernateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void onRefresh(RefreshEvent event) throws HibernateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void onRefresh(RefreshEvent event, Map refreshedAlready) throws HibernateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void onPostUpdate(PostUpdateEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onPostLoad(PostLoadEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onPostInsert(PostInsertEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean onPreUpdate(PreUpdateEvent event) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void onPreLoad(PreLoadEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean onPreInsert(PreInsertEvent event) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void onPostDelete(PostDeleteEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onPostUpdateCommitFailed(PostUpdateEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onPostInsertCommitFailed(PostInsertEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onPostDeleteCommitFailed(PostDeleteEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onPostUpdateCollection(PostCollectionUpdateEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onPostRemoveCollection(PostCollectionRemoveEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onPreUpdateCollection(PreCollectionUpdateEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onPreRemoveCollection(PreCollectionRemoveEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onPreRecreateCollection(PreCollectionRecreateEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onPersist(PersistEvent event) throws HibernateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void onPersist(PersistEvent event, Map createdAlready) throws HibernateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void onMerge(MergeEvent event) throws HibernateException {
    var jfrEvent = new JfrMergeEvent();
    jfrEvent.entityName = event.getEntityName();
    jfrEvent.commit();
  }

  @Override
  public void onMerge(MergeEvent event, Map copiedAlready) throws HibernateException {
    this.onMerge(event);
  }

  @Override
  public void onLock(LockEvent event) throws HibernateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void onLoad(LoadEvent event, LoadType loadType) throws HibernateException {
    var jfrEvent = new JfrLoadEvent();
    jfrEvent.entityClassName = event.getEntityClassName();
    jfrEvent.loadType = loadType.getName();
    jfrEvent.commit();

  }

  @Override
  public void onInitializeCollection(InitializeCollectionEvent event) throws HibernateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void onFlushEntity(FlushEntityEvent event) throws HibernateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void onEvict(EvictEvent event) throws HibernateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void onDirtyCheck(DirtyCheckEvent event) throws HibernateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void onDelete(DeleteEvent event) throws HibernateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void onDelete(DeleteEvent event, Set transientEntities) throws HibernateException {
    // TODO Auto-generated method stub

  }

  @Override
  public void onClear(ClearEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onAutoFlush(AutoFlushEvent event) throws HibernateException {
    // TODO Auto-generated method stub

  }

  @Label("Load")
  @Description("A Hibernate Load Event")
  @Category("Hibernate")
  @StackTrace(false)
  static class JfrLoadEvent extends Event {

    @Label("Entity Class Name")
    @Description("The class name of the entity being loaded")
    private String entityClassName;

    @Label("Load Type")
    @Description("The load type")
    private String loadType;

  }
  
  @Label("Merge")
  @Description("A Hibernate Merge Event generated by merge() and saveOrUpdateCopy()")
  @Category("Hibernate")
  @StackTrace(false)
  static class JfrMergeEvent extends Event {
    
    @Label("Entity Name")
    @Description("The name of the entity being merged")
    private String entityName;
    
  }
  
  @Label("SaveOrUpdate")
  @Description("A Hibernate Save or Update Event generated by saveOrUpdate()")
  @Category("Hibernate")
  @StackTrace(false)
  static class JfrSaveOrUpdateEvent extends Event {
    
    @Label("Entity Name")
    @Description("The name of the entity being saved or updated")
    private String entityName;
    
  }

}
