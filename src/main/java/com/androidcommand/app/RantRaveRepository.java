package com.androidcommand.app;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors; 

import org.springframework.stereotype.Repository;

@Repository
public class RantRaveRepository implements CommonRepository<RantRave> {
	
	private Map<String,RantRave> rantRaves = new HashMap<>();
	
	@Override
	public RantRave save(RantRave domain) {
		RantRave result = rantRaves.get(domain.getId());
		if(result != null) {
			result.setModified(LocalDateTime.now());
			result.setDescription(domain.getDescription());
			result.setCompleted(domain.isCompleted());
			domain = result;
		}
		rantRaves.put(domain.getId(), domain);
		return rantRaves.get(domain.getId());
	}

	@Override
	public Iterable<RantRave> save(Collection<RantRave> domains) {
		domains.forEach(this::save);
		return findAll();
	}
	
	@Override
	public void delete(RantRave domain) {
		rantRaves.remove(domain.getId());
	}
	
	@Override
	public RantRave findById(String id) { return rantRaves.get(id); }
	
	@Override
	public Iterable<RantRave> findAll() {
		return rantRaves.entrySet().stream().sorted(entryComparator).map(Map.Entry::getValue).collect(Collectors.toList());
	}

	private Comparator<Map.Entry<String,RantRave>> entryComparator = (Map.Entry<String, RantRave> o1, Map.Entry<String, RantRave> o2) -> {
		return o1.getValue().getCreated().compareTo(o2.getValue().getCreated());
	}; 
}