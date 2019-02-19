package com.github.marschall.hibernate.jfr;

import java.util.Map;
import java.util.Set;

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
import org.hibernate.event.spi.FlushEvent;
import org.hibernate.event.spi.FlushEventListener;
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
    FlushEventListener,
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
  public void onSaveOrUpdate(SaveOrUpdateEvent event) {
    var jfrEvent = new JfrSaveOrUpdateEvent();
    jfrEvent.entityName = event.getEntityName();
    jfrEvent.commit();
  }

  @Override
  public void onResolveNaturalId(ResolveNaturalIdEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onReplicate(ReplicateEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onRefresh(RefreshEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onRefresh(RefreshEvent event, Map refreshedAlready) {
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
  public void onPersist(PersistEvent event) {
    var jfrEvent = new JfrPersistEvent();
    jfrEvent.entityName = event.getEntityName();
    jfrEvent.commit();
  }

  @Override
  public void onPersist(PersistEvent event, Map createdAlready) {
    this.onPersist(event);
  }

  @Override
  public void onMerge(MergeEvent event) {
    var jfrEvent = new JfrMergeEvent();
    jfrEvent.entityClass = event.getEntity().getClass();
    jfrEvent.entityName = event.getEntityName();
    jfrEvent.commit();
  }

  @Override
  public void onMerge(MergeEvent event, Map copiedAlready) {
    this.onMerge(event);
  }

  @Override
  public void onLock(LockEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onLoad(LoadEvent event, LoadType loadType) {
    var jfrEvent = new JfrLoadEvent();
    jfrEvent.entityClassName = event.getEntityClassName();
    jfrEvent.loadType = loadType.getName();
    jfrEvent.commit();
  }

  @Override
  public void onInitializeCollection(InitializeCollectionEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onFlushEntity(FlushEntityEvent event) {
    var jfrEvent = new JfrFlushEntityEvent();
    jfrEvent.entityName = event.getEntityEntry().getEntityName();
    jfrEvent.commit();
  }

  @Override
  public void onFlush(FlushEvent event) {
    var jfrEvent = new JfrFlushEvent();
    jfrEvent.numberOfEntitiesProcessed = event.getNumberOfEntitiesProcessed();
    jfrEvent.numberOfCollectionsProcessed = event.getNumberOfCollectionsProcessed();
    jfrEvent.commit();
  }

  @Override
  public void onEvict(EvictEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onDirtyCheck(DirtyCheckEvent event) {
    // TODO Auto-generated method stub

  }

  @Override
  public void onDelete(DeleteEvent event) {
    var jfrEvent = new JfrDeleteEvent();
    jfrEvent.entityClass = event.getObject().getClass();
    jfrEvent.entityName = event.getEntityName();
    jfrEvent.cascadeDeleteEnabled = event.isCascadeDeleteEnabled();
    jfrEvent.commit();
  }

  @Override
  public void onDelete(DeleteEvent event, Set transientEntities) {
    this.onDelete(event);
  }

  @Override
  public void onClear(ClearEvent event) {
    var jfrEvent = new JfrClearEvent();
    jfrEvent.commit();
  }

  @Override
  public void onAutoFlush(AutoFlushEvent event) {
    var jfrEvent = new JfrAutoFlushEvent();
    jfrEvent.flushRequired = event.isFlushRequired();
    jfrEvent.commit();
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

    @Label("Entity Class")
    @Description("The class of the enity being deleted")
    private Class<?> entityClass;

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

  @Label("Delete")
  @Description("A Hibernate Delete Event")
  @Category("Hibernate")
  @StackTrace(false)
  static class JfrDeleteEvent extends Event {

    @Label("Entity Class")
    @Description("The class of the enity being deleted")
    private Class<?> entityClass;

    @Label("Entity Name")
    @Description("The name of the entity being deleted")
    private String entityName;

    @Label("Cascade Delete Enabled")
    @Description("Whether cascading deleted are enabled")
    private boolean cascadeDeleteEnabled;

  }

  @Label("Persist")
  @Description("A Hibernate Persist Event generted by persist()")
  @Category("Hibernate")
  @StackTrace(false)
  static class JfrPersistEvent extends Event {

    @Label("Entity Name")
    @Description("The name of the entity being persisted")
    private String entityName;

  }

  @Label("Flush Entity")
  @Description("A Hibernate Flush Entity Event")
  @Category("Hibernate")
  @StackTrace(false)
  static class JfrFlushEntityEvent extends Event {

    @Label("Entity Name")
    @Description("The name of the entity being flushed")
    private String entityName;

  }

  @Label("Flush")
  @Description("A Hibernate Flush Event")
  @Category("Hibernate")
  @StackTrace(false)
  static class JfrFlushEvent extends Event {

    @Label("#Entities Processed")
    @Description("The Number of Entities Processed")
    private int numberOfEntitiesProcessed;

    @Label("#Collections Processed")
    @Description("The Number of Collections Processed")
    private int numberOfCollectionsProcessed;

  }

  @Label("Auto Flush")
  @Description("A Hibernate Event generated by auto-flushing of a Session")
  @Category("Hibernate")
  @StackTrace(false)
  static class JfrAutoFlushEvent extends Event {

    @Label("Flush Required")
    @Description("Whether a Flush is Required")
    private boolean flushRequired;

  }

  @Label("Clear")
  @Description("A Hibernate Event generated by clear()")
  @Category("Hibernate")
  @StackTrace(false)
  static class JfrClearEvent extends Event {

  }

}
