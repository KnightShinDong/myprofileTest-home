package com.sdh.home.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class boardDto {

	private  int qnum;
	private String qid;
	private String qname;
	private String qcontent;
	private String qemail;
	private String qdate;
}
