Show problems when infinispan purgeExpired is called.
After checking out the project please call mvn clean test.
Once or multiple times,

The result is similar to:


[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.oneandone.access.ciam.keycloak.infinispan.IspnPurgeExpiredTest
Jul 03, 2024 2:57:53 PM org.jboss.weld.bootstrap.WeldStartup <clinit>
INFO: WELD-000900: 5.1.2 (Final)
Jul 03, 2024 2:57:53 PM org.jboss.weld.bootstrap.WeldStartup startContainer
INFO: WELD-000101: Transactional services not available. Injection of @Inject UserTransaction not available. Transactional observers will be invoked synchronously.
Jul 03, 2024 2:57:53 PM org.jboss.weld.environment.se.WeldContainer fireContainerInitializedEvent
INFO: WELD-ENV-002003: Weld SE container c5af550d-5503-4d14-bf6a-a2e294992611 initialized
Jul 03, 2024 2:57:53 PM org.infinispan.marshall.core.impl.DelegatingUserMarshaller start
INFO: ISPN000556: Starting user marshaller 'org.infinispan.commons.marshall.ImmutableProtoStreamMarshaller'
Jul 03, 2024 2:57:53 PM org.infinispan.remoting.transport.jgroups.JGroupsTransport buildChannel
INFO: ISPN000088: Unable to use any JGroups configuration mechanisms provided in properties {}. Using default JGroups configuration!
2024-07-03 14:57:53 [main] DEBUG org.jgroups.protocols.UDP - thread pool min/max/keep-alive (ms): 0/200/60000
2024-07-03 14:57:53 [main] DEBUG org.jgroups.stack.Configurator - set property org.jgroups.stack.DiagnosticsHandler@78307a56.mcast_addr to default value /224.0.75.75
2024-07-03 14:57:53 [main] TRACE org.jgroups.protocols.UNICAST3 - null: set max_xmit_req_size from 0 to 511600
Jul 03, 2024 2:57:53 PM org.infinispan.remoting.transport.jgroups.JGroupsTransport startJGroupsChannelIfNeeded
INFO: ISPN000078: Starting JGroups channel `ISPN`
2024-07-03 14:57:53 [main] INFO org.jgroups.JChannel - local_addr: 97699d6b-55c2-41af-9287-f6f3f818b76e, name: LXKA-6RLTVL3-46217
2024-07-03 14:57:53 [main] DEBUG org.jgroups.protocols.UDP - sockets will use interface 10.21.255.219
2024-07-03 14:57:53 [main] DEBUG org.jgroups.protocols.UDP - multicast_socket on vpn0
2024-07-03 14:57:53 [main] DEBUG org.jgroups.protocols.UDP - multicast_socket on vpn0
2024-07-03 14:57:53 [main] WARN org.jgroups.protocols.UDP - JGRP000015: the send buffer of socket MulticastSocket was set to 1MB, but the OS only allocated 212.99KB
2024-07-03 14:57:53 [main] WARN org.jgroups.protocols.UDP - JGRP000015: the receive buffer of socket MulticastSocket was set to 20MB, but the OS only allocated 212.99KB
2024-07-03 14:57:53 [main] WARN org.jgroups.protocols.UDP - JGRP000015: the send buffer of socket MulticastSocket was set to 1MB, but the OS only allocated 212.99KB
2024-07-03 14:57:53 [main] WARN org.jgroups.protocols.UDP - JGRP000015: the receive buffer of socket MulticastSocket was set to 25MB, but the OS only allocated 212.99KB
2024-07-03 14:57:53 [main] DEBUG org.jgroups.protocols.UDP - socket information:
mcast_addr=239.6.7.8:46655, bind_addr=/10.21.255.219, ttl=2
sock: bound to 10.21.255.219:60400, receive buffer size=212992, send buffer size=212992
mcast_sock: bound to /239.6.7.8:46655, send buffer size=212992, receive buffer size=212992
/10.21.255.219: using network interface 'vpn0' to any (ephemeral) port
2024-07-03 14:57:53 [main] INFO org.jgroups.protocols.FD_SOCK2 - server listening on *.44864
2024-07-03 14:57:53 [main] TRACE org.jgroups.protocols.pbcast.STABLE - LXKA-6RLTVL3-46217: stable task started
2024-07-03 14:57:53 [main] DEBUG org.jgroups.protocols.pbcast.GMS - address=LXKA-6RLTVL3-46217, cluster=ISPN, physical address=10.21.255.219:60400
2024-07-03 14:57:53 [jgroups-7,LXKA-6RLTVL3-46217] TRACE org.jgroups.protocols.UDP - LXKA-6RLTVL3-46217: sending msg to null, src=LXKA-6RLTVL3-46217, size=102, headers are PING: [GET_MBRS_REQ cluster=ISPN initial_discovery=true], TP: [cluster=ISPN]
2024-07-03 14:57:54 [jgroups-7,LXKA-6RLTVL3-46217] TRACE org.jgroups.protocols.UDP - LXKA-6RLTVL3-46217: sending msg to null, src=LXKA-6RLTVL3-46217, size=102, headers are PING: [GET_MBRS_REQ cluster=ISPN initial_discovery=true], TP: [cluster=ISPN]
2024-07-03 14:57:55 [jgroups-7,LXKA-6RLTVL3-46217] TRACE org.jgroups.protocols.UDP - LXKA-6RLTVL3-46217: sending msg to null, src=LXKA-6RLTVL3-46217, size=102, headers are PING: [GET_MBRS_REQ cluster=ISPN initial_discovery=true], TP: [cluster=ISPN]
2024-07-03 14:57:55 [main] INFO org.jgroups.protocols.pbcast.GMS - LXKA-6RLTVL3-46217: no members discovered after 2001 ms: creating cluster as coordinator
2024-07-03 14:57:55 [main] DEBUG org.jgroups.protocols.pbcast.NAKACK2 -
[LXKA-6RLTVL3-46217 setDigest()]
existing digest:  []
new digest:       LXKA-6RLTVL3-46217: [0 (0)]
resulting digest: LXKA-6RLTVL3-46217: [0 (0)]
2024-07-03 14:57:55 [main] DEBUG org.jgroups.protocols.pbcast.GMS - LXKA-6RLTVL3-46217: installing view [LXKA-6RLTVL3-46217|0] (1) [LXKA-6RLTVL3-46217] (LXKA-6RLTVL3-46217 joined)
2024-07-03 14:57:55 [main] DEBUG org.jgroups.protocols.pbcast.STABLE - LXKA-6RLTVL3-46217: resuming message garbage collection
2024-07-03 14:57:55 [main] TRACE org.jgroups.protocols.UFC - new membership: [LXKA-6RLTVL3-46217]
2024-07-03 14:57:55 [main] TRACE org.jgroups.protocols.MFC - new membership: [LXKA-6RLTVL3-46217]
Jul 03, 2024 2:57:55 PM org.infinispan.remoting.transport.jgroups.JGroupsTransport receiveClusterView
INFO: ISPN000094: Received new cluster view for channel ISPN: [LXKA-6RLTVL3-46217|0] (1) [LXKA-6RLTVL3-46217]
2024-07-03 14:57:55 [main] DEBUG org.jgroups.protocols.pbcast.GMS - LXKA-6RLTVL3-46217: created cluster (first member). My view is [LXKA-6RLTVL3-46217|0], impl is CoordGmsImpl
Jul 03, 2024 2:57:55 PM org.infinispan.remoting.transport.jgroups.JGroupsTransport startJGroupsChannelIfNeeded
INFO: ISPN000079: Channel `ISPN` local address is `LXKA-6RLTVL3-46217`, physical addresses are `[10.21.255.219:60400]`
2024-07-03 14:57:55 [non-blocking-thread--p2-t5] TRACE org.jgroups.protocols.pbcast.NAKACK2 - LXKA-6RLTVL3-46217 --> [all]: #1
2024-07-03 14:57:55 [non-blocking-thread--p2-t5] TRACE org.jgroups.protocols.UDP - LXKA-6RLTVL3-46217: sending msg to null, src=LXKA-6RLTVL3-46217, size=1201, headers are NAKACK2: [MSG, seqno=1], TP: [cluster=ISPN]
2024-07-03 14:57:55 [non-blocking-thread--p2-t5] TRACE org.jgroups.protocols.MFC - LXKA-6RLTVL3-46217 used 1158 credits, 3998842 remaining
Jul 03, 2024 2:57:55 PM org.jboss.threads.Version <clinit>
INFO: JBoss Threads version 3.6.1.Final
2024-07-03 14:57:56 [Timer runner-1,LXKA-6RLTVL3-46217] TRACE org.jgroups.protocols.UDP - LXKA-6RLTVL3-46217: sending msg to null, src=LXKA-6RLTVL3-46217, size=39, headers are NAKACK2: [HIGHEST_SEQNO, seqno=1], TP: [cluster=ISPN]
2024-07-03 14:57:56 [non-blocking-thread--p2-t9] TRACE org.jgroups.protocols.pbcast.NAKACK2 - LXKA-6RLTVL3-46217 --> [all]: #2
2024-07-03 14:57:56 [non-blocking-thread--p2-t9] TRACE org.jgroups.protocols.UDP - LXKA-6RLTVL3-46217: sending msg to null, src=LXKA-6RLTVL3-46217, size=1189, headers are NAKACK2: [MSG, seqno=2], TP: [cluster=ISPN]
2024-07-03 14:57:56 [non-blocking-thread--p2-t9] TRACE org.jgroups.protocols.MFC - LXKA-6RLTVL3-46217 used 1146 credits, 3997696 remaining
2024-07-03 14:57:56 [Timer runner-1,LXKA-6RLTVL3-46217] TRACE org.jgroups.protocols.UDP - LXKA-6RLTVL3-46217: sending msg to null, src=LXKA-6RLTVL3-46217, size=39, headers are NAKACK2: [HIGHEST_SEQNO, seqno=2], TP: [cluster=ISPN]
Jul 03, 2024 2:58:01 PM org.infinispan.persistence.jdbc.common.impl.BaseJdbcStore lambda$delete$5
ERROR: ISPN008025: Error while removing string keys from database
org.h2.jdbc.JdbcSQLTimeoutException: Timeout trying to lock table {0}; SQL statement:
DELETE FROM "ispn_cache_org" WHERE id = ? [50200-200]
at org.h2.message.DbException.getJdbcSQLException(DbException.java:511)
at org.h2.message.DbException.getJdbcSQLException(DbException.java:429)
at org.h2.message.DbException.get(DbException.java:194)
at org.h2.command.Command.filterConcurrentUpdate(Command.java:309)
at org.h2.command.Command.executeUpdate(Command.java:253)
at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:191)
at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:152)
at io.agroal.pool.wrapper.PreparedStatementWrapper.executeUpdate(PreparedStatementWrapper.java:90)
at org.infinispan.persistence.jdbc.common.sql.BaseTableOperations.deleteEntry(BaseTableOperations.java:104)
at org.infinispan.persistence.jdbc.common.impl.BaseJdbcStore.lambda$delete$5(BaseJdbcStore.java:162)
at org.infinispan.util.concurrent.BlockingManagerImpl.supplyBlockingOperation(BlockingManagerImpl.java:150)
at org.infinispan.util.concurrent.BlockingManagerImpl.supplyBlocking(BlockingManagerImpl.java:141)
at org.infinispan.persistence.jdbc.common.impl.BaseJdbcStore.delete(BaseJdbcStore.java:158)
at org.infinispan.persistence.manager.PersistenceManagerImpl.deleteFromAllStores(PersistenceManagerImpl.java:741)
at org.infinispan.interceptors.impl.DistCacheWriterInterceptor.lambda$visitRemoveCommand$4(DistCacheWriterInterceptor.java:118)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNextThenApply(BaseAsyncInterceptor.java:85)
at org.infinispan.interceptors.impl.DistCacheWriterInterceptor.visitRemoveCommand(DistCacheWriterInterceptor.java:111)
at org.infinispan.commands.Visitor.visitRemoveExpiredCommand(Visitor.java:65)
at org.infinispan.commands.write.RemoveExpiredCommand.acceptVisitor(RemoveExpiredCommand.java:47)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNext(BaseAsyncInterceptor.java:58)
at org.infinispan.interceptors.BaseAsyncInterceptor.asyncInvokeNext(BaseAsyncInterceptor.java:231)
at org.infinispan.interceptors.impl.CacheLoaderInterceptor.visitDataCommand(CacheLoaderInterceptor.java:198)
at org.infinispan.interceptors.impl.CacheLoaderInterceptor.visitRemoveCommand(CacheLoaderInterceptor.java:157)
at org.infinispan.commands.Visitor.visitRemoveExpiredCommand(Visitor.java:65)
at org.infinispan.commands.write.RemoveExpiredCommand.acceptVisitor(RemoveExpiredCommand.java:47)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNext(BaseAsyncInterceptor.java:58)
at org.infinispan.interceptors.BaseAsyncInterceptor.asyncInvokeNext(BaseAsyncInterceptor.java:231)
at org.infinispan.interceptors.impl.EntryWrappingInterceptor.setSkipRemoteGetsAndInvokeNextForDataCommand(EntryWrappingInterceptor.java:732)
at org.infinispan.interceptors.impl.EntryWrappingInterceptor.visitRemoveExpiredCommand(EntryWrappingInterceptor.java:413)
at org.infinispan.commands.write.RemoveExpiredCommand.acceptVisitor(RemoveExpiredCommand.java:47)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNextAndFinally(BaseAsyncInterceptor.java:154)
at org.infinispan.interceptors.locking.AbstractLockingInterceptor.lambda$nonTxLockAndInvokeNext$3(AbstractLockingInterceptor.java:318)
at org.infinispan.interceptors.SyncInvocationStage.andHandle(SyncInvocationStage.java:69)
at org.infinispan.interceptors.locking.AbstractLockingInterceptor.nonTxLockAndInvokeNext(AbstractLockingInterceptor.java:313)
at org.infinispan.interceptors.locking.AbstractLockingInterceptor.visitNonTxDataWriteCommand(AbstractLockingInterceptor.java:138)
at org.infinispan.interceptors.locking.AbstractLockingInterceptor.visitRemoveExpiredCommand(AbstractLockingInterceptor.java:107)
at org.infinispan.commands.write.RemoveExpiredCommand.acceptVisitor(RemoveExpiredCommand.java:47)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNextAndHandle(BaseAsyncInterceptor.java:187)
at org.infinispan.statetransfer.StateTransferInterceptor.handleNonTxWriteCommand(StateTransferInterceptor.java:312)
at org.infinispan.statetransfer.StateTransferInterceptor.handleWriteCommand(StateTransferInterceptor.java:256)
at org.infinispan.statetransfer.StateTransferInterceptor.visitRemoveCommand(StateTransferInterceptor.java:113)
at org.infinispan.commands.Visitor.visitRemoveExpiredCommand(Visitor.java:65)
at org.infinispan.commands.write.RemoveExpiredCommand.acceptVisitor(RemoveExpiredCommand.java:47)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNext(BaseAsyncInterceptor.java:58)
at org.infinispan.interceptors.impl.CacheMgmtInterceptor.visitRemoveCommand(CacheMgmtInterceptor.java:433)
at org.infinispan.commands.Visitor.visitRemoveExpiredCommand(Visitor.java:65)
at org.infinispan.commands.write.RemoveExpiredCommand.acceptVisitor(RemoveExpiredCommand.java:47)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNext(BaseAsyncInterceptor.java:58)
at org.infinispan.interceptors.DDAsyncInterceptor.handleDefault(DDAsyncInterceptor.java:54)
at org.infinispan.interceptors.DDAsyncInterceptor.visitRemoveCommand(DDAsyncInterceptor.java:65)
at org.infinispan.commands.Visitor.visitRemoveExpiredCommand(Visitor.java:65)
at org.infinispan.commands.write.RemoveExpiredCommand.acceptVisitor(RemoveExpiredCommand.java:47)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNextAndExceptionally(BaseAsyncInterceptor.java:127)
at org.infinispan.interceptors.impl.InvocationContextInterceptor.visitCommand(InvocationContextInterceptor.java:90)
at org.infinispan.interceptors.impl.AsyncInterceptorChainImpl.invokeAsync(AsyncInterceptorChainImpl.java:211)
at org.infinispan.cache.impl.InvocationHelper.doInvokeAsync(InvocationHelper.java:318)
at org.infinispan.cache.impl.InvocationHelper.invokeAsync(InvocationHelper.java:156)
at org.infinispan.cache.impl.InvocationHelper.invokeAsync(InvocationHelper.java:139)
at org.infinispan.cache.impl.CacheImpl.performVisitableNonTxCommand(CacheImpl.java:750)
at org.infinispan.cache.impl.CacheImpl.removeLifespanExpired(CacheImpl.java:732)
at org.infinispan.cache.impl.DecoratedCache.removeLifespanExpired(DecoratedCache.java:419)
at org.infinispan.expiration.impl.ClusterExpirationManager.handleInStoreExpirationInternal(ClusterExpirationManager.java:416)
at org.infinispan.expiration.impl.ClusterExpirationManager.handleInStoreExpirationInternal(ClusterExpirationManager.java:405)
at org.infinispan.persistence.manager.PersistenceManagerImpl.lambda$purgeExpired$28(PersistenceManagerImpl.java:675)
at io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapCompletable$ConcatMapCompletableObserver.drain(FlowableConcatMapCompletable.java:187)
at io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber.onNext(ConcatMapXMainSubscriber.java:106)
at io.reactivex.rxjava3.processors.UnicastProcessor.drainFused(UnicastProcessor.java:349)
at io.reactivex.rxjava3.processors.UnicastProcessor.drain(UnicastProcessor.java:382)
at io.reactivex.rxjava3.processors.UnicastProcessor.onNext(UnicastProcessor.java:444)
at org.infinispan.persistence.jdbc.stringbased.JdbcStringBasedStore.runBatchAndNotify(JdbcStringBasedStore.java:390)
at org.infinispan.persistence.jdbc.stringbased.JdbcStringBasedStore.lambda$purgeExpired$1(JdbcStringBasedStore.java:354)
at java.base/java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1804)
at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
at org.jboss.threads.EnhancedQueueExecutor$Task.doRunWith(EnhancedQueueExecutor.java:2516)
at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2495)
at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1521)
at java.base/java.lang.Thread.run(Thread.java:1583)
Caused by: org.h2.message.DbException: Concurrent update in table "ispn_cache_org": another transaction has updated or deleted the same row [90131-200]
at org.h2.message.DbException.get(DbException.java:194)
at org.h2.mvstore.db.MVTable.convertException(MVTable.java:707)
at org.h2.mvstore.db.MVPrimaryIndex.lockRow(MVPrimaryIndex.java:232)
at org.h2.mvstore.db.MVPrimaryIndex.lockRow(MVPrimaryIndex.java:224)
at org.h2.mvstore.db.MVTable.lockRow(MVTable.java:567)
at org.h2.command.dml.Delete.update(Delete.java:116)
at org.h2.command.CommandContainer.update(CommandContainer.java:198)
at org.h2.command.Command.executeUpdate(Command.java:251)
... 72 more
Caused by: org.h2.jdbc.JdbcSQLTransientException: Concurrent update in table "ispn_cache_org": another transaction has updated or deleted the same row [90131-200]
at org.h2.message.DbException.getJdbcSQLException(DbException.java:626)
at org.h2.message.DbException.getJdbcSQLException(DbException.java:429)
... 80 more
Caused by: java.lang.IllegalStateException: Map entry <table.6> with key <1> and value null 1/4 [STRINGDECODE('\ufeff8SgRrZXkw'), X'9801ea078a013d0a109801018a010a0a084a0676616c75653012159801058a010f18e0d40320ffffffffffffffffff0118c799b1c5873220ffffffffffffffffff012a00', 1720004336167, 190] is locked by tx 1 and can not be updated by tx 2 within allocated time interval 2000 ms. [1.4.200/101]
at org.h2.mvstore.DataUtils.newIllegalStateException(DataUtils.java:950)
at org.h2.mvstore.tx.TransactionMap.set(TransactionMap.java:316)
at org.h2.mvstore.tx.TransactionMap.lock(TransactionMap.java:263)
at org.h2.mvstore.db.MVPrimaryIndex.lockRow(MVPrimaryIndex.java:230)
... 77 more

Jul 03, 2024 2:58:01 PM org.infinispan.interceptors.impl.InvocationContextInterceptor rethrowException
ERROR: ISPN000136: Error executing command RemoveExpiredCommand on Cache 'cache_org', writing keys [WrappedByteArray[\J04\k\e\y\0 (6 bytes)]]
org.infinispan.persistence.spi.PersistenceException: Error while removing key WrappedByteArray[\J04\k\e\y\0 (6 bytes)] from database
at org.infinispan.persistence.jdbc.common.impl.BaseJdbcStore.lambda$delete$5(BaseJdbcStore.java:165)
at org.infinispan.util.concurrent.BlockingManagerImpl.supplyBlockingOperation(BlockingManagerImpl.java:150)
at org.infinispan.util.concurrent.BlockingManagerImpl.supplyBlocking(BlockingManagerImpl.java:141)
at org.infinispan.persistence.jdbc.common.impl.BaseJdbcStore.delete(BaseJdbcStore.java:158)
at org.infinispan.persistence.manager.PersistenceManagerImpl.deleteFromAllStores(PersistenceManagerImpl.java:741)
at org.infinispan.interceptors.impl.DistCacheWriterInterceptor.lambda$visitRemoveCommand$4(DistCacheWriterInterceptor.java:118)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNextThenApply(BaseAsyncInterceptor.java:85)
at org.infinispan.interceptors.impl.DistCacheWriterInterceptor.visitRemoveCommand(DistCacheWriterInterceptor.java:111)
at org.infinispan.commands.Visitor.visitRemoveExpiredCommand(Visitor.java:65)
at org.infinispan.commands.write.RemoveExpiredCommand.acceptVisitor(RemoveExpiredCommand.java:47)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNext(BaseAsyncInterceptor.java:58)
at org.infinispan.interceptors.BaseAsyncInterceptor.asyncInvokeNext(BaseAsyncInterceptor.java:231)
at org.infinispan.interceptors.impl.CacheLoaderInterceptor.visitDataCommand(CacheLoaderInterceptor.java:198)
at org.infinispan.interceptors.impl.CacheLoaderInterceptor.visitRemoveCommand(CacheLoaderInterceptor.java:157)
at org.infinispan.commands.Visitor.visitRemoveExpiredCommand(Visitor.java:65)
at org.infinispan.commands.write.RemoveExpiredCommand.acceptVisitor(RemoveExpiredCommand.java:47)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNext(BaseAsyncInterceptor.java:58)
at org.infinispan.interceptors.BaseAsyncInterceptor.asyncInvokeNext(BaseAsyncInterceptor.java:231)
at org.infinispan.interceptors.impl.EntryWrappingInterceptor.setSkipRemoteGetsAndInvokeNextForDataCommand(EntryWrappingInterceptor.java:732)
at org.infinispan.interceptors.impl.EntryWrappingInterceptor.visitRemoveExpiredCommand(EntryWrappingInterceptor.java:413)
at org.infinispan.commands.write.RemoveExpiredCommand.acceptVisitor(RemoveExpiredCommand.java:47)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNextAndFinally(BaseAsyncInterceptor.java:154)
at org.infinispan.interceptors.locking.AbstractLockingInterceptor.lambda$nonTxLockAndInvokeNext$3(AbstractLockingInterceptor.java:318)
at org.infinispan.interceptors.SyncInvocationStage.andHandle(SyncInvocationStage.java:69)
at org.infinispan.interceptors.locking.AbstractLockingInterceptor.nonTxLockAndInvokeNext(AbstractLockingInterceptor.java:313)
at org.infinispan.interceptors.locking.AbstractLockingInterceptor.visitNonTxDataWriteCommand(AbstractLockingInterceptor.java:138)
at org.infinispan.interceptors.locking.AbstractLockingInterceptor.visitRemoveExpiredCommand(AbstractLockingInterceptor.java:107)
at org.infinispan.commands.write.RemoveExpiredCommand.acceptVisitor(RemoveExpiredCommand.java:47)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNextAndHandle(BaseAsyncInterceptor.java:187)
at org.infinispan.statetransfer.StateTransferInterceptor.handleNonTxWriteCommand(StateTransferInterceptor.java:312)
at org.infinispan.statetransfer.StateTransferInterceptor.handleWriteCommand(StateTransferInterceptor.java:256)
at org.infinispan.statetransfer.StateTransferInterceptor.visitRemoveCommand(StateTransferInterceptor.java:113)
at org.infinispan.commands.Visitor.visitRemoveExpiredCommand(Visitor.java:65)
at org.infinispan.commands.write.RemoveExpiredCommand.acceptVisitor(RemoveExpiredCommand.java:47)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNext(BaseAsyncInterceptor.java:58)
at org.infinispan.interceptors.impl.CacheMgmtInterceptor.visitRemoveCommand(CacheMgmtInterceptor.java:433)
at org.infinispan.commands.Visitor.visitRemoveExpiredCommand(Visitor.java:65)
at org.infinispan.commands.write.RemoveExpiredCommand.acceptVisitor(RemoveExpiredCommand.java:47)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNext(BaseAsyncInterceptor.java:58)
at org.infinispan.interceptors.DDAsyncInterceptor.handleDefault(DDAsyncInterceptor.java:54)
at org.infinispan.interceptors.DDAsyncInterceptor.visitRemoveCommand(DDAsyncInterceptor.java:65)
at org.infinispan.commands.Visitor.visitRemoveExpiredCommand(Visitor.java:65)
at org.infinispan.commands.write.RemoveExpiredCommand.acceptVisitor(RemoveExpiredCommand.java:47)
at org.infinispan.interceptors.BaseAsyncInterceptor.invokeNextAndExceptionally(BaseAsyncInterceptor.java:127)
at org.infinispan.interceptors.impl.InvocationContextInterceptor.visitCommand(InvocationContextInterceptor.java:90)
at org.infinispan.interceptors.impl.AsyncInterceptorChainImpl.invokeAsync(AsyncInterceptorChainImpl.java:211)
at org.infinispan.cache.impl.InvocationHelper.doInvokeAsync(InvocationHelper.java:318)
at org.infinispan.cache.impl.InvocationHelper.invokeAsync(InvocationHelper.java:156)
at org.infinispan.cache.impl.InvocationHelper.invokeAsync(InvocationHelper.java:139)
at org.infinispan.cache.impl.CacheImpl.performVisitableNonTxCommand(CacheImpl.java:750)
at org.infinispan.cache.impl.CacheImpl.removeLifespanExpired(CacheImpl.java:732)
at org.infinispan.cache.impl.DecoratedCache.removeLifespanExpired(DecoratedCache.java:419)
at org.infinispan.expiration.impl.ClusterExpirationManager.handleInStoreExpirationInternal(ClusterExpirationManager.java:416)
at org.infinispan.expiration.impl.ClusterExpirationManager.handleInStoreExpirationInternal(ClusterExpirationManager.java:405)
at org.infinispan.persistence.manager.PersistenceManagerImpl.lambda$purgeExpired$28(PersistenceManagerImpl.java:675)
at io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapCompletable$ConcatMapCompletableObserver.drain(FlowableConcatMapCompletable.java:187)
at io.reactivex.rxjava3.internal.operators.mixed.ConcatMapXMainSubscriber.onNext(ConcatMapXMainSubscriber.java:106)
at io.reactivex.rxjava3.processors.UnicastProcessor.drainFused(UnicastProcessor.java:349)
at io.reactivex.rxjava3.processors.UnicastProcessor.drain(UnicastProcessor.java:382)
at io.reactivex.rxjava3.processors.UnicastProcessor.onNext(UnicastProcessor.java:444)
at org.infinispan.persistence.jdbc.stringbased.JdbcStringBasedStore.runBatchAndNotify(JdbcStringBasedStore.java:390)
at org.infinispan.persistence.jdbc.stringbased.JdbcStringBasedStore.lambda$purgeExpired$1(JdbcStringBasedStore.java:354)
at java.base/java.util.concurrent.CompletableFuture$AsyncRun.run(CompletableFuture.java:1804)
at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
at org.jboss.threads.EnhancedQueueExecutor$Task.doRunWith(EnhancedQueueExecutor.java:2516)
at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2495)
at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1521)
at java.base/java.lang.Thread.run(Thread.java:1583)
Caused by: org.h2.jdbc.JdbcSQLTimeoutException: Timeout trying to lock table {0}; SQL statement:
DELETE FROM "ispn_cache_org" WHERE id = ? [50200-200]
at org.h2.message.DbException.getJdbcSQLException(DbException.java:511)
at org.h2.message.DbException.getJdbcSQLException(DbException.java:429)
at org.h2.message.DbException.get(DbException.java:194)
at org.h2.command.Command.filterConcurrentUpdate(Command.java:309)
at org.h2.command.Command.executeUpdate(Command.java:253)
at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:191)
at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:152)
at io.agroal.pool.wrapper.PreparedStatementWrapper.executeUpdate(PreparedStatementWrapper.java:90)
at org.infinispan.persistence.jdbc.common.sql.BaseTableOperations.deleteEntry(BaseTableOperations.java:104)
at org.infinispan.persistence.jdbc.common.impl.BaseJdbcStore.lambda$delete$5(BaseJdbcStore.java:162)
... 67 more
Caused by: org.h2.message.DbException: Concurrent update in table "ispn_cache_org": another transaction has updated or deleted the same row [90131-200]
at org.h2.message.DbException.get(DbException.java:194)
at org.h2.mvstore.db.MVTable.convertException(MVTable.java:707)
at org.h2.mvstore.db.MVPrimaryIndex.lockRow(MVPrimaryIndex.java:232)
at org.h2.mvstore.db.MVPrimaryIndex.lockRow(MVPrimaryIndex.java:224)
at org.h2.mvstore.db.MVTable.lockRow(MVTable.java:567)
at org.h2.command.dml.Delete.update(Delete.java:116)
at org.h2.command.CommandContainer.update(CommandContainer.java:198)
at org.h2.command.Command.executeUpdate(Command.java:251)
... 72 more
Caused by: org.h2.jdbc.JdbcSQLTransientException: Concurrent update in table "ispn_cache_org": another transaction has updated or deleted the same row [90131-200]
at org.h2.message.DbException.getJdbcSQLException(DbException.java:626)
at org.h2.message.DbException.getJdbcSQLException(DbException.java:429)
... 80 more
Caused by: java.lang.IllegalStateException: Map entry <table.6> with key <1> and value null 1/4 [STRINGDECODE('\ufeff8SgRrZXkw'), X'9801ea078a013d0a109801018a010a0a084a0676616c75653012159801058a010f18e0d40320ffffffffffffffffff0118c799b1c5873220ffffffffffffffffff012a00', 1720004336167, 190] is locked by tx 1 and can not be updated by tx 2 within allocated time interval 2000 ms. [1.4.200/101]
at org.h2.mvstore.DataUtils.newIllegalStateException(DataUtils.java:950)
at org.h2.mvstore.tx.TransactionMap.set(TransactionMap.java:316)
at org.h2.mvstore.tx.TransactionMap.lock(TransactionMap.java:263)
at org.h2.mvstore.db.MVPrimaryIndex.lockRow(MVPrimaryIndex.java:230)
... 77 more
