/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.cassandra.hadoop.hive.metastore;

import java.io.IOException;

import org.apache.cassandra.hadoop.CassandraProxyClient;
import org.apache.cassandra.hadoop.CassandraProxyClient.ConnectionStrategy;
import org.apache.cassandra.thrift.Cassandra;
import org.apache.cassandra.thrift.ConsistencyLevel;
import org.apache.cassandra.thrift.InvalidRequestException;
import org.apache.hadoop.conf.Configuration;
import org.apache.thrift.TException;

/**
 * Encapsulates common connection settings use with the Cassandra.Iface
 * raw thrift client.
 */
public class CassandraClientHolder
{
    
    private Cassandra.Iface client;
    private String keyspaceName;
    private String columnFamily;
    private ConsistencyLevel readCl; 
    private ConsistencyLevel writeCl;
    
    
    public CassandraClientHolder(Configuration conf) 
    {
        this.keyspaceName = conf.get(CONF_PARAM_KEYSPACE_NAME, DEF_META_STORE_KEYSPACE);
        this.columnFamily = conf.get(CONF_PARAM_CF_NAME, DEF_META_STORE_CF);
        this.readCl = ConsistencyLevel.findByValue(conf.getInt(CONF_PARAM_READ_CL, ConsistencyLevel.QUORUM.getValue()));
        this.writeCl = ConsistencyLevel.findByValue(conf.getInt(CONF_PARAM_WRITE_CL, ConsistencyLevel.QUORUM.getValue()));
        try 
        {
            client = CassandraProxyClient.newProxyConnection(conf.get(CONF_PARAM_HOST, "localhost"), 
                    conf.getInt(CONF_PARAM_PORT, 9160), 
                    conf.getBoolean(CONF_PARAM_FRAMED,true), 
                    ConnectionStrategy.valueOf(conf.get(CONF_PARAM_CONNECTION_STRATEGY, "STICKY")));
            
        }
        catch (IOException ioe) 
        {
            throw new CassandraHiveMetaStoreException("Could not connect to Cassandra. Reason: " + ioe.getMessage(), ioe);
        }    
    }
    
    public void applyKeyspace() {
        try 
        {
            client.set_keyspace(keyspaceName);
        } 
        catch (InvalidRequestException ire) 
        {
            throw new CassandraHiveMetaStoreException("Could not apply the keyspaceName: " + keyspaceName, ire);
        } 
        catch (TException e) 
        {
            throw new CassandraHiveMetaStoreException("transport problem setting keyspace: " + keyspaceName, e);
        }
    }    
    
    public Cassandra.Iface getClient() 
    {
        return client;
    }        
    
    public String getKeyspaceName()
    {
        return keyspaceName;
    }

    public String getColumnFamily()
    {
        return columnFamily;
    }    

    public ConsistencyLevel getReadCl()
    {
        return readCl;
    }

    public ConsistencyLevel getWriteCl()
    {
        return writeCl;
    }




    // TODO are there more appropriate hive config parameters to use here?
    // Local statics
    public static final String META_DB_ROW_KEY = "__meta__";
    
    public static final String DATABASES_ROW_KEY = "__databases__";
    public static final String DEF_META_STORE_CF = "MetaStore";
    public static final String DEF_META_STORE_KEYSPACE = "HiveMetaStore";
    
    public static final String CONF_PARAM_PREFIX = "cassandra.connection.";
    /** Initial Apache Cassandra node to which we will connect (localhost) */
    public static final String CONF_PARAM_HOST = CONF_PARAM_PREFIX+"host";
    /** Thrift port for Apache Cassandra (9160) */
    public static final String CONF_PARAM_PORT = CONF_PARAM_PREFIX+"port";
    /** Boolean indicating use of Framed vs. Non-Framed Thrift transport (true) */
    public static final String CONF_PARAM_FRAMED = CONF_PARAM_PREFIX+"framed";
    /** Pick a host at random from the ring as opposed to using the same host (STICKY) */
    public static final String CONF_PARAM_CONNECTION_STRATEGY = CONF_PARAM_PREFIX+"connectionStrategy";
    /** Name of the ColumnFamily in which we will store meta information (MetaStore) */
    public static final String CONF_PARAM_CF_NAME = CONF_PARAM_PREFIX + "metaStoreColumnFamilyName";
    /** Name of the keyspace in which to store meta data (HiveMetaStore) */
    public static final String CONF_PARAM_KEYSPACE_NAME = CONF_PARAM_PREFIX + "metaStoreKeyspaceName";
    /** Consistency Level for read operations against the meta store (QUORUM) */
    public static final String CONF_PARAM_READ_CL = CONF_PARAM_PREFIX + "readCL";
    /** Consistency Level for write operations against the meta store (QUORUM) */    
    public static final String CONF_PARAM_WRITE_CL = CONF_PARAM_PREFIX + "writeCL";
    /** The replication factor for the keyspace (1) */
    public static final String CONF_PARAM_REPLICATION_FACTOR = CONF_PARAM_PREFIX + "replicationFactor";

}
