/**
 * 
 */
package org.martinlaw.bo.courtcase;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.martinlaw.bo.MatterWork;

/**
 * a transactional document whose notes/attachments have work done about a {@link CourtCase}
 * 
 * @author mugo
 *
 */
@Entity(name="court_case_work")
@Table(name="martinlaw_court_case_work_doc_t")
public class Work extends MatterWork {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6173589951133038815L;

	/**
	 * default constructor to initialize matter class
	 * 
	 * adapted from {@link http://stackoverflow.com/questions/182636/how-to-determine-the-class-of-a-generic-type}
	 */
	public Work() {
		super();
		setMatterClass(CourtCase.class);
	}

}
