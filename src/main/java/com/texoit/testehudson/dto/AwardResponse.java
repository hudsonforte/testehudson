package com.texoit.testehudson.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.texoit.testehudson.domain.Producer;

public class AwardResponse implements Serializable{

	
	private static final long serialVersionUID = -2239051228650394115L;
	private List<Producer> min;
    private List<Producer> max;

    public AwardResponse() {
    	
    }       
    
    public AwardResponse(List<Producer> min, List<Producer> max) {
		this.min = min;
		this.max = max;
	}

	public List<Producer> getMin() {
        return min;
    }

    public List<Producer> getMax() {
        return max;
    }	
}