/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DB4OUtil;

import Business.*;
import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.ConfigurationItem;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;

/**
 *
 * @author Bhavna Menghrajani
 */
public class DB4OUtil {

	private static final String FILENAME = System.getProperty("user.dir") + "\\DataBank.db4o";
	private static DB4OUtil dB4OUtil;

	public static synchronized DB4OUtil getInstance() {
		if (dB4OUtil == null) {
			dB4OUtil = new DB4OUtil();
		}
		return dB4OUtil;
	}

	protected static synchronized void shutdown(ObjectContainer conn) {
		if (conn != null) {
			conn.close();
		}
	}

	private ObjectContainer createConnection() {
		try {
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			config.common().add((ConfigurationItem) new TransparentPersistenceSupport());
			config.common().activationDepth(Integer.MAX_VALUE);
			config.common().updateDepth(Integer.MAX_VALUE);
			config.common().objectClass((Object) EcoSystem.class).cascadeOnUpdate(true);
			EmbeddedObjectContainer db = Db4oEmbedded.openFile((EmbeddedConfiguration) config, (String) FILENAME);
			return db;
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
			return null;
		}
	}

	public synchronized void storeSystem(EcoSystem system) {
		ObjectContainer conn = this.createConnection();
		conn.store((Object) system);
		conn.commit();
		conn.close();
	}

	public EcoSystem retrieveSystem() {
		ObjectContainer conn = this.createConnection();
		ObjectSet systems = conn.query((Class) EcoSystem.class);
		EcoSystem system = systems.size() == 0 ? ConfigureEcosystem.configure()
				: (EcoSystem) systems.get(systems.size() - 1);
		conn.close();
		return system;
	}

}
