package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.wahlzeit.services.ObjectManager;

public class AbimottoManager extends ObjectManager {

	private static final Logger log = Logger.getLogger(AbimottoManager.class.getName());
	
	private Map<Integer, Abimotto> abimottos = new HashMap<>();
	private Map<String, AbimottoType> abimottoTypes = new HashMap<>();
	
	private static AbimottoManager instance;
	
	private AbimottoManager() {}
	
	public static synchronized AbimottoManager getInstance() {
		if(instance == null) {
			instance = new AbimottoManager();
		}
		return instance;
	}
	
	public Abimotto createAbimotto(String abimottoName) {
		assertIsValidAbimottoName(abimottoName);
		AbimottoType type = new AbimottoType();
		Abimotto abimotto = type.createInstance();
		abimottos.put(abimotto.getId(), abimotto);
		return abimotto;
	}
		
	public AbimottoType getAbimottoType(String abimottoName) {
		AbimottoType type = abimottoTypes.get(abimottoName);
		if(type == null) {
			type = new AbimottoType();
			abimottoTypes.put(abimottoName, type);
		}
		return type;
	}
	
	public Abimotto getAbimotto(Integer id) {
		return abimottos.get(id);
	}
	
	private void assertIsValidAbimottoName(String abimottoName) {
		if(abimottoName == null) throw new IllegalArgumentException("abimottoName must not be null!");
		if(abimottoName.length() == 0) throw new IllegalArgumentException("abimottoName must not have a length of 0!");
	}
}
