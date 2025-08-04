package com.app.feejunction.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.feejunction.bean.*;
import com.app.feejunction.dao.DAOFactory;
import com.app.feejunction.dao.MSSQLDAOFactory;
import com.app.feejunction.dao.StudentRegistrationDAO;
//import org.eclipse.jdt.internal.compiler.classfmt.InnerClassInfo;

public class StudentRegistrationService {
	public String insertStudentDetails(StudentRegistrationFormBean studentRegistrationFormBean){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertStudentDetails(studentRegistrationFormBean);
		return responseString;
	}

	public String deleteStudentDetails(String studentId){
		String key = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		key = studentRegistrationDAO.deleteStudentDetails(studentId);
		return key;
	}

	public String editStudentDetails(StudentRegistrationFormBean studentRegistrationFormBean){
		String key = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		key = studentRegistrationDAO.editStudentDetails(studentRegistrationFormBean);
		return key;
	}


	public StudentRegistrationFormBean getStudentCourseDetails(String studentRegistrationId){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getStudentCourseDetails(studentRegistrationId); 
	}

	/*public List getStudentFeesDetails(String studentSpecializationTypePatternId) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getStudentFeesDetails(studentSpecializationTypePatternId); 
	}*/
	public String getStudentRegistrationIdFromUniqueId(String uniqueIdentificationId,String defaultGuestUserId){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getStudentRegistrationIdFromUniqueId(uniqueIdentificationId,defaultGuestUserId); 
	}
	public String getStudentRegistrationIdFromUniqueStudentId(String uniqueIdentificationId, String instituteId) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getStudentRegistrationIdFromUniqueStudentId(uniqueIdentificationId,instituteId);
	}

	public String associateStudent(String studentRegistrationId,String registeredUserId,String loginId) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.associateStudent(studentRegistrationId, registeredUserId, loginId);
	}

	public List getStudentRegistrationIdList(String registrationId) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getStudentRegistrationIdList(registrationId);
	}

	public List getStudentTranscationDetails(String registrationId, String studentRegistrationId) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getStudentTranscationDetails(registrationId, studentRegistrationId);
	}

	public String insertMemberRegDetails(BhuLoginActionFormBean bhuLoginActionFormBean){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertMemberRegDetails(bhuLoginActionFormBean);
		return responseString;
	}

	public String insertGNLUStudentDetails(GNLULoginActionFormBean gnluLoginActionFormBean,String billerId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertGNLUStudentDetails(gnluLoginActionFormBean,billerId);
		return responseString;
	}

	public String getSpsApplicationNo(String uniqueIdentificationId,String defaultGuestUserId){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSpsApplicationNo(uniqueIdentificationId,defaultGuestUserId); 
	}

	public StudentRegistrationFormBean getSCIndiaAdmissionNo(String uniqueIdentificationId,String defaultGuestUserId){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSCIndiaAdmissionNo(uniqueIdentificationId,defaultGuestUserId); 
	}

	public String insertRamaStudentDetails(RamaCollageFormBean ramaCollageFormBean){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertRamaStudentDetails(ramaCollageFormBean);
		return responseString;
	}
	public String insertIITMStudentDetails(RamaCollageFormBean ramaCollageFormBean,String billerId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertIITMStudentDetails(ramaCollageFormBean,billerId);
		return responseString;
	}

	public RamaCollageFormBeanResponse getRamaStudentDetails(String ApplicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getRamaStudentDetails(ApplicationNo);		 
	}

	public String insertIMSStudentDetails(IMSUniversityFormBean imsUniversityFormBean){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertIMSStudentDetails(imsUniversityFormBean);
		return responseString;
	}

	public List<String> getOnlineInstituteAmountList(String billerId) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		List<String> amountList= studentRegistrationDAO.getOnlineInstituteAmountList(billerId);
		return amountList;
	}

	public String insertHIMStudentDetails(HIMAFormBean himaFormBean,String instituteId) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertHIMStudentDetails(himaFormBean,instituteId);
		return responseString;

	}
	public String insertIITBStudentDetails(IITBActionFormBean iitbActionFormBean){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertIITBStudentDetails(iitbActionFormBean);
		return responseString;
	}
	public String insertIITBPostHistoryDetails(IITBPostEmpHistoryFormBean iitbPostEmpHistoryFormBean,String registerId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertIITBPostHistoryDetails(iitbPostEmpHistoryFormBean,registerId);
		return responseString;
	}
	public String insertIITBAccomplishmentDetails(IITBAccomplishmentFormBean iitbAccomplishmentFormBean,String registerId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertIITBAccomplishmentDetails(iitbAccomplishmentFormBean,registerId);
		return responseString;
	}
	public HIMAFormBean getHimaStudentDetails(String ApplicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getHimaStudentDetails(ApplicationNo);		 
	}
	public String insertMadhbStudentDetails(MadhavbaugCollageFormBean madhavbaugCollageFormBean){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertMadhbStudentDetails(madhavbaugCollageFormBean);
		return responseString;
	}
	public IITBActionFormBean getIIITBStudentDetails(String ApplicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getIIITBStudentDetails(ApplicationNo);		 
	}
	public List<IITBPostEmpHistoryFormBean> getIITBPostHistoryDetails(String CandidateId) {
		List<IITBPostEmpHistoryFormBean> IITBPostHistoryList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		IITBPostHistoryList = studentRegistrationDAO.getIITBPostHistoryDetails(CandidateId);
		return IITBPostHistoryList;
	}	
	public List<IITBAccomplishmentFormBean> getIITBAccomplishmentDetails(String CandidateId) {
		List<IITBAccomplishmentFormBean> IITBAccomplishmentList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		IITBAccomplishmentList = studentRegistrationDAO.getIITBAccomplishmentDetails(CandidateId);
		return IITBAccomplishmentList;
	}	
	public String insertBimtStudentDetails(BIMTExistingFormbean bimtExistingFormbean){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertBimtStudentDetails(bimtExistingFormbean);
		return responseString;
	}
	public BIMTExistingFormbean getBimtStudentDetails(String ApplicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getBimtStudentDetails(ApplicationNo);		 
	}
	public String insertBIMTStudentDetails(BIMTFormBean bimtFormBean,String instituteId) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertBIMTStudentDetails(bimtFormBean,instituteId);
		return responseString;
	}

	public BIMTFormBean getBIMTSudentDetails(String registeredUserId, String courseAppliedFor,String applicationNo) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getBIMTSudentDetails(registeredUserId,courseAppliedFor,applicationNo);	
	}
	public String insertWbuteaStudentDetails(WBUTUniversityFormBean wbutUniversityFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertWBUTEAStudentDetails(wbutUniversityFormBean,instituteId);
		return responseString;
	}
	public WBUTUniversityFormBean getWbutStudentDetails(String ApplicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getWbutStudentDetails(ApplicationNo);		 
	}
	public String insertUnisonStudentDetails(UnisonFormBean unisonFormBean,String instituteId) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertUnisonStudentDetails(unisonFormBean,instituteId);
		return responseString;
	}
	public String insertIIMLStudentDetails(IIMLOnlineFormBean iimlOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertIIMLStudentDetails(iimlOnlineFormBean,instituteId);
		return responseString;
	}
	public String insertIimlSubjectMarkDetails(IIMLSubjectMarkFormBean iimlSubjectMarkFormBean,String ApplicationNo){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertIimlSubjectMarkDetails(iimlSubjectMarkFormBean,ApplicationNo);
		return responseString;
	}
	public IIMLOnlineFormBean getIIMLStudentDetails(String applicationNo) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getIIMLStudentDetails(applicationNo);	
	}
	public List<IIMLSubjectMarkFormBean> getIIMLSubjectDetails(String applicationNo) {
		List<IIMLSubjectMarkFormBean> IIMLSubjectMarkList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		IIMLSubjectMarkList = studentRegistrationDAO.getIIMLSubjectDetails(applicationNo);
		return IIMLSubjectMarkList;
	}	
	public String insertGPSStudentDetails(GPSOnlineFormBean gpsOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertGPSStudentDetails(gpsOnlineFormBean,instituteId);
		return responseString;
	}
	public GPSOnlineFormBean getGPSStudentDetails(String applicationNo) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getGPSStudentDetails(applicationNo);	
	}
	public List<String> insertSpringDaleStudentDetails(
			SpringDaleStudentFormBean springDaleStudentFormBean,
			String billerId) {
		List<String> responses=null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responses = studentRegistrationDAO.insertSpringDaleStudentDetails(springDaleStudentFormBean,billerId);
		return responses;
	}

	public String updateOnlineInstitutePaymentStatus(String instCode,String applicationNo, String paymentId,String transactionDateTime, String transactionId, String paymentMode, String errorCode, String errorDesc, String transactionAmount) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.updateOnlineInstitutePaymentStatus(instCode,applicationNo,paymentId,transactionDateTime,transactionId,paymentMode,errorCode,errorDesc,transactionAmount);
		return responseString;
	}

	public String insertGLAUniversityStudentDetails(
			GLAUniversityStudentFormBean glaUniversityStudentFormBean,
			String billerId) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertGLAUniversityStudentDetails(glaUniversityStudentFormBean,billerId);
		return responseString;
	}

	public String insertgpullaReadyStudentDetails(GpullaReadyFormBean gpullaReadyFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertGpullaReadyStudentDetails(gpullaReadyFormBean,instituteId);
		return responseString;
	}	
	public GpullaReadyFormBean getGpullaReddyStudentDetails(String ApplicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getGpullaReddyStudentdetails(ApplicationNo);		 
	}
	public String insertNehuStudentDetails(NEHUFormBean nehuFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertNehuStudentDetails(nehuFormBean,instituteId);
		return responseString;
	}
	public String insertYMCAStudentDetails(YMCAOnlineFormBean ymcaOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertYMCAStudentDetails(ymcaOnlineFormBean,instituteId);
		return responseString;
	}
	public String insertYMCAEducationDetails(EducationDetailsFormbean educationDetailsFormbean,String applicationNo){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertYMCAEducationDetails(educationDetailsFormbean,applicationNo);
		return responseString;
	}
	public YMCAOnlineFormBean getYMCAStudentDetails(String applicationNo) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getYMCAStudentDetails(applicationNo);	
	}
	public List<EducationDetailsFormbean> getYMCAEducationDetails(String applicationNo) {
		List<EducationDetailsFormbean> educationDetailsList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		educationDetailsList = studentRegistrationDAO.getYMCAEducationDetails(applicationNo);
		return educationDetailsList;
	}
	public NEHUFormBean getNehuStudentDetails(String ApplicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getNehuStudentdetails(ApplicationNo);		 
	}

	public URLInstituteResponseBean fetchInstituteSuccessTransReport(
			String instituteId, String fromDate, String toDate) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.fetchInstituteSuccessTransReport(instituteId,fromDate,toDate);	
	}	
	public String insertiimmlStudentDetails(IIMLucknowFormBean iimlucknowFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertIIMMLStudentDetails(iimlucknowFormBean,instituteId);
		return responseString;
	}
	public IIMLucknowFormBean getIIMLucknowStudentDetails(String ApplicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getIIMLucknowStudentdetails(ApplicationNo);		 
	}
	public String insertNITMeghStudentDetails(NITOnlineFormBean nitOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertNITMeghStudentDetails(nitOnlineFormBean,instituteId);
		return responseString;
	}
	public NITOnlineFormBean getNITMeghStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getNITMeghStudentDetails(applicationNo);	
	}
	public String insertCampionSchoolDetails(CampionSchoolFormBean campionSchoolFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertCampionSchoolDetails(campionSchoolFormBean,instituteId);
		return responseString;
	}
	public CampionSchoolFormBean getCampionStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getCampionStudentDetails(applicationNo);	
	}
	public String insertHaryanaStudentDetails(HaryanaFormBean haryanaFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertHaryanaStudentDetails(haryanaFormBean,instituteId);
		return responseString;
	}
	public HaryanaFormBean getHaryanaStudentDetails(String ApplicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getHaryanaStudentdetails(ApplicationNo);		 
	}			
	public String insertBengalCollegeDetails(BengalCollegeOnlineFormBean bengalCollegeOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertBengalCollegeDetails(bengalCollegeOnlineFormBean,instituteId);
		return responseString;
	}

	public BengalCollegeOnlineFormBean loadBengalData(String applicationNo,
			String instituteCode) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.loadBengalData(applicationNo,instituteCode);	
	}		
	public String getvalidateCBSData(String uniqueIdentificationId,String defaultGuestUserId,String instId){

		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getvalidateCBSData(uniqueIdentificationId,defaultGuestUserId,instId); 
	}
	public String insertGLAUniversityStudentDetails(
			URLInstituteRequestBean glaUniversityStudentFormBean,
			String billerId) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertGLAUniversityStudentDetails(glaUniversityStudentFormBean,billerId);
		return responseString;
	}

	public DYPatilResponseBean fetchInstituteDYPatilReport(
			String instId, String merchantID, String merchantTxnRefNumber,
			String date) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.fetchInstituteDYPatilReport(instId,merchantID,merchantTxnRefNumber,date);
	}
	public String insertHaryanaEducationDetails(EducationHaryanaFormBean educationHaryanaFormBean,String applicationNo){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertHaryanaEducationDetails(educationHaryanaFormBean,applicationNo);
		return responseString;
	}
	public List<EducationHaryanaFormBean> getHaryanaEducationDetails(String applicationNo) {
		List<EducationHaryanaFormBean> educationDetailsList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		educationDetailsList = studentRegistrationDAO.getHaryanaEducationDetails(applicationNo);
		return educationDetailsList;
	}		
	public String insertYMCAAllStudentDetails(YMCAOnlineFormBean ymcaOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertYMCAAllStudentDetails(ymcaOnlineFormBean,instituteId);
		return responseString;
	}
	public YMCAOnlineFormBean getYMCAAllStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getYMCAAllStudentDetails(applicationNo);	
	}
	public String insertBSEStudentDetails(BSEFormBean bseFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertBSEStudentDetails(bseFormBean,instituteId);
		return responseString;
	}
	public BSEFormBean getBseStudentDetails(String ApplicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getBSEStudentdetails(ApplicationNo);		 
	}		
	public String insertWelhamSchoolDetails(WelhamSchoolFormBean welhamSchoolFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertWelhamSchoolDetails(welhamSchoolFormBean,instituteId);
		return responseString;
	}
	public WelhamSchoolFormBean getWelhamSchoolDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getWelhamSchoolDetails(applicationNo);		 
	}

	public ChallanOTPProcessBean fetchIITVFees(String FeePayId,String FeeType, String studentcategory) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.fetchIITVFees(FeePayId,FeeType,studentcategory);	
	}
	public String insertNIPRStudentDetails(NIPROnlineFormBean niprOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertNIPRStudentDetails(niprOnlineFormBean,instituteId);
		return responseString;
	}
	public NIPROnlineFormBean getNIPRSchoolDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getNIPRSchoolDetails(applicationNo);		 
	}
	public String insertMGRStudentDetails(MGRMedicalOnlineFormBean mgrMedicalOnlineFormBean,String instituteId) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertMGRStudentDetails(mgrMedicalOnlineFormBean,instituteId);
		return responseString;				
	}
	public String insertFeeHeadDetails(FeeHeadFormbean feeHeadFormbean,String applicationNo){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertFeeHeadDetails(feeHeadFormbean,applicationNo);
		return responseString;	
	}
	public MGRMedicalOnlineFormBean getMGRStudentDetails(String applicationNo){			
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getMGRStudentDetails(applicationNo);	
	}
	public List<FeeHeadFormbean> getFeeHeadDetails(String applicationNo){
		List<FeeHeadFormbean> FeeHeadList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		FeeHeadList = studentRegistrationDAO.getFeeHeadDetails(applicationNo);
		return FeeHeadList;	 
	}
	public String insertSCIStudentDetails(SCIOnlineFormBean sciOnlineFormBean,String instituteId) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSCIStudentDetails(sciOnlineFormBean,instituteId);
		return responseString;						
	}
	public String insertSCICourseDetails(SCICourseNameFormBean sciCourseNameFormBean,String applicationNo){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSCICourseDetails(sciCourseNameFormBean,applicationNo);
		return responseString;					 
	}
	public SCIOnlineFormBean getSCIStudentDetails(String applicationNo){			
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSCIStudentDetails(applicationNo);	
	}
	public List<SCICourseNameFormBean> getSCICourseDetails(String applicationNo,String tranStatus){
		List<SCICourseNameFormBean> courseList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		courseList = studentRegistrationDAO.getSCICourseDetails(applicationNo,tranStatus);
		return courseList;	 
	}

	public Map<String,String> getStudIdExpDate(String uniqueIdentificationId) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();		
		return studentRegistrationDAO.getStudIdExpDate(uniqueIdentificationId);
	}

	public String updatePayLaterDate(Map<String,String> res,String uniqueIdentificationId,String paylater,String yes) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.updatePayLaterDate(res,uniqueIdentificationId,paylater,yes);
		return responseString;	
	}

	public void getCountofPayLaterDatesUpdated(StudentRegistrationFormBean studentRegistrationFormBean) {		
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		studentRegistrationDAO.getCountofPayLaterDatesUpdated(studentRegistrationFormBean);


	}

	public String updateRSSTFees(String uniquiIdentificationId,String admissionType, String section) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.updateRSSTFees(uniquiIdentificationId,admissionType,section);
		return responseString;
	}
	public String insertPTUStudentDetails(PTUOnlineFormBean ptuOnlineFormBean,String instituteId) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertPTUStudentDetails(ptuOnlineFormBean,instituteId);
		return responseString;				
	}
	public String insertPTUFeeHeadDetails(FeeHeadFormbean feeHeadFormbean,String applicationNo){

		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertPTUFeeHeadDetails(feeHeadFormbean,applicationNo);
		return responseString;	
	}
	public PTUOnlineFormBean getPTUStudentDetails(String applicationNo){			
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getPTUStudentDetails(applicationNo);	
	}
	public List<FeeHeadFormbean> getPTUFeeHeadDetails(String applicationNo){
		List<FeeHeadFormbean> FeeHeadList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		FeeHeadList = studentRegistrationDAO.getPTUFeeHeadDetails(applicationNo);
		return FeeHeadList;	 
	}
	public String insertAlgotudentDetails(CandEntryForm candEntryForm,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertAlgoStudentDetails(candEntryForm,instituteId);
		return responseString;
	}
	public CandEntryForm getAngloSchoolDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getAngloSchoolDetails(applicationNo);		 
	}
	public String insertUGIStudentDetails(UGIOnlineFormBean ugiOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertUGIStudentDetails(ugiOnlineFormBean,instituteId);
		return responseString;				
	}
	public UGIOnlineFormBean getUGIStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getUGIStudentDetails(applicationNo);		 
	}
	public String insertPMHPStudentDetails(UGIOnlineFormBean ugiOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertPMHPStudentDetails(ugiOnlineFormBean,instituteId);
		return responseString;				
	}
	public UGIOnlineFormBean getPMHPStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getPMHPStudentDetails(applicationNo);		 
	}
	public String insertDPSSKSStudentDetails(DPSSKSOnlineFormBean dpssksOnlineFormBean,String instituteId) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertDPSSKSStudentDetails(dpssksOnlineFormBean, instituteId);
		return responseString;				
	}
	public String insertDPSSKSClassDetails(DPSSKSDetailsFormBean dpssksDetailsFormBean,String applicationNo){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertDPSSKSClassDetails(dpssksDetailsFormBean,applicationNo);
		return responseString;	
	}
	public DPSSKSOnlineFormBean getDPSSKSStudentDetails(String applicationNo){			
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getDPSSKSStudentDetails(applicationNo);	
	}
	public List<DPSSKSDetailsFormBean> getDPSSKS_ClassDetails(String applicationNo){
		List<DPSSKSDetailsFormBean> classDetailsList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		classDetailsList = studentRegistrationDAO.getDPSSKS_ClassDetails(applicationNo);
		return classDetailsList;	 
	}
	public String insertDOONStudentDetails(DOONOnlineFormBean DOONOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertDOONStudentDetails(DOONOnlineFormBean,instituteId);
		return responseString;
	}
	public DOONOnlineFormBean getDOONStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getDOONStudentDetails(applicationNo);		 
	}
	public String insertJRSTStudentDetails(JRSTOnlineFormBean jrstOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertJRSTStudentDetails(jrstOnlineFormBean,instituteId);
		return responseString;
	}
	public JRSTOnlineFormBean getJRSTStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getJRSTStudentDetails(applicationNo);		 
	}
	public String insertMGCStudentDetails(MGCOnlineFormBean mgcOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertMGCStudentDetails(mgcOnlineFormBean,instituteId);
		return responseString;				
	}
	public MGCOnlineFormBean getMGCStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getMGCStudentDetails(applicationNo);		 
	}
	public String insertDBHPStudentDetails(HPSMasterFormBean hpsMasterFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertDBHPStudentDetails(hpsMasterFormBean,instituteId);
		return responseString;				
	}
	public HPSMasterFormBean getDBHPStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getDBHPStudentDetails(applicationNo);		 
	}
	public String insertNISMStudentDetails(NISMOnlineFormBean nismOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertNISMStudentDetails(nismOnlineFormBean,instituteId);
		return responseString;
	}
	public NISMOnlineFormBean getNismStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getNismStudentDetails(applicationNo);		 
	}
	public String insertNISMParticipantDetails(NISMParticipantFormBean nismParticipantFormBean,String applicationNo){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertNISMParticipantDetails(nismParticipantFormBean,applicationNo);
		return responseString;
	}
	public List<NISMParticipantFormBean> getNISMparticiptDetails(String applicationNo) {
		List<NISMParticipantFormBean> educationDetailsList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		educationDetailsList = studentRegistrationDAO.getNISMParticiptDetails(applicationNo);
		return educationDetailsList;
	}		
	public String insertDOTUStudentDetails(DOTUOnlineFormBean dotuOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertDOTUStudentDetails(dotuOnlineFormBean,instituteId);
		return responseString;
	}
	public DOTUOnlineFormBean getDOTUStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getDOTUStudentDetails(applicationNo);		 
	}
	public String insertKaushalyaStudentDetails(KaushalyaFormBean kaushalyaFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertKaushalyaStudentDetails(kaushalyaFormBean,instituteId);
		return responseString;
	}	
	public KaushalyaFormBean getKAUSHStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getKAUSHStudentDetails(applicationNo);		 
	}
	public String insertRPTMStudentDetails(RPTMOnlineFormBean rptmOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertRPTMStudentDetails(rptmOnlineFormBean,instituteId);
		return responseString;
	}
	public RPTMOnlineFormBean getRPTMStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getRPTMStudentDetails(applicationNo);		 
	}
	public List<NISMOnlineFormBean> getnoteList(String id) {
		List<NISMOnlineFormBean> noteList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		noteList = studentRegistrationDAO.getNoteListData(id);
		return noteList;
	}
	public String insertRUNGTAStudentDetails(RungtanlineFormBean rungtanlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertRUNGTAStudentDetails(rungtanlineFormBean,instituteId);
		return responseString;				
	}
	public RungtanlineFormBean getRUNGTAStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getRUNGTAStudentDetails(applicationNo);		 
	}
	public List<SCICourseNameFormBean> fetchSCICourseDetails() {
		List<SCICourseNameFormBean> courseList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		courseList = studentRegistrationDAO.fetchSCICourseDetails();
		return courseList;
	}
	public UnisonFormBean getunisonStudentDetails(String applicationNo, String instCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getUnisonStudentDetails(applicationNo,instCode);		 
	}
	public String insertChristineStudentDetails(ChristineOnlineFormBean christineOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertChristineStudentDetails(christineOnlineFormBean,instituteId);
		return responseString;				
	}	
	public String insertchristinefeeDetails(form form1,String applicationNo){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertChristinefeeDetails(form1,applicationNo);
		return responseString;
	}
	public ChristineOnlineFormBean getChristineStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getChristineStudentDetails(applicationNo);		 
	}		 
	public String insertBKLIStudentDetails(BKLIOnlineFormBean bkliOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertBKLIStudentDetails(bkliOnlineFormBean,instituteId);
		return responseString;
	}
	public BKLIOnlineFormBean getBKLIStudentDetails(String applicationNo,String tranStatus){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getBKLIStudentDetails(applicationNo,tranStatus);		 
	}
	public String insertMATSStudentDetails(MATSFeesForm matsFeesForm,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertMATSStudentDetails(matsFeesForm,instituteId);
		return responseString;				
	}
	public MATSFeesForm getMATSStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getMATSStudentDetails(applicationNo,instituteCode);		 
	}			
	public String insertBSPRStudentDetails(BSPROnlineFormBean bsprOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertBSPRStudentDetails(bsprOnlineFormBean,instituteId);
		return responseString;
	}
	public BSPROnlineFormBean getBSPRStudentDetails(String applicationNo,String tranStatus){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getBSPRStudentDetails(applicationNo,tranStatus);		 
	}
	public String insertSHARPStudentDetails(SharpmindsOnlineFormBean sharpmindsOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSHARPStudentDetails(sharpmindsOnlineFormBean,instituteId);
		return responseString;
	}
	public SharpmindsOnlineFormBean getSHARPStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSHARPStudentDetails(applicationNo);		 
	}
	public String insertBKLIAdminData(BKLIOnlineFormBean bkliOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertBKLIAdminData(bkliOnlineFormBean,instituteId);
		return responseString;
	}	
	public String insertSaarcStudentDetails(SaarcOnlineFormBean saarcOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSaarcStudentDetails(saarcOnlineFormBean,instituteId);
		return responseString;
	}
	public SaarcOnlineFormBean getSaarcStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSaarcStudentDetails(applicationNo);		 
	}
	public String insertExistSaarcStudentDetails(SAARCExistOnlineFormBean saarcExistOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertExistSaarcStudentDetails(saarcExistOnlineFormBean,instituteId);
		return responseString;
	}
	public String insertExistSaarcGridDetails(SAARCExistGridFormBean saarcExistGridFormBean,String applicationNo){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertExistSaarcGridDetails(saarcExistGridFormBean,applicationNo);
		return responseString;	
	}
	public SAARCExistOnlineFormBean getSAARCExistStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSAARCExistStudentDetails(applicationNo);		 
	}
	public List<SAARCExistGridFormBean> getSAARC_GridDetails(String applicationNo){
		List<SAARCExistGridFormBean> gridDetailsList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		gridDetailsList = studentRegistrationDAO.getSAARC_GridDetails(applicationNo);
		return gridDetailsList;	 
	}
	public String insertSaarcSusStudentDetails(SAARCExistOnlineFormBean saarcExistOnlineFormBean,String instituteId){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSaarcSusStudentDetails(saarcExistOnlineFormBean,instituteId);
		return responseString;
	}
	public String insertSaarcSustainerGridDetails(SAARCExistGridFormBean saarcExistGridFormBean,String applicationNo){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSaarcSustainerGridDetails(saarcExistGridFormBean,applicationNo);
		return responseString;	
	}
	public SAARCExistOnlineFormBean getSAARCSustainerStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSAARCSustainerStudentDetails(applicationNo);		 
	}
	public List<SAARCExistGridFormBean> getSAARCSustainerGridDetails(String applicationNo){
		List<SAARCExistGridFormBean> gridDetailsList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		gridDetailsList = studentRegistrationDAO.getSAARCSustainerGridDetails(applicationNo);
		return gridDetailsList;	 
	}

	public String insertEtoosStudentDetails(EtoosOnlineFormBean etoosOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertEtoosStudentDetails(etoosOnlineFormBean,billerId);
		return responseString;

	}

	public EtoosOnlineFormBean getEtoosStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getEtoosStudentDetails(applicationNo);		 
	}
	public String insertIibmsStudentDetails(IIBMSFormBean iibmsOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertIibmsStudentDetails(iibmsOnlineFormBean,billerId);
		return responseString;

	}

	public IIBMSFormBean getIibmdStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getIibmdStudentDetails(applicationNo);		 
	}

	public String insertPPAStudentDetails(PPAFormBean ppaOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertPPAStudentDetails(ppaOnlineFormBean,billerId);
		return responseString;

	}

	public PPAFormBean getPPAStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getPPAStudentDetails(applicationNo);		 
	}
	public String insertOrigenceStudentDetails(OrigenceOnlineFormBean origenceOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertOrigenceStudentDetails(origenceOnlineFormBean,billerId);
		return responseString;	
	}
	public OrigenceOnlineFormBean getOrigenceStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getOrigenceStudentDetails(applicationNo);		 
	}
	public String insertPrincipalStudentDetails(PrincipalAIAFormBean principalOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertPrincipalStudentDetails(principalOnlineFormBean,billerId);
		return responseString;	
	}

	public PrincipalAIAFormBean getPrincipalStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getPrincipalStudentDetails(applicationNo);		 

	}	
	public List<INTLCourseFormBean> fetchINTLCourseDetails() {
		List<INTLCourseFormBean> courseList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		courseList = studentRegistrationDAO.fetchINTLCourseDetails();
		return courseList;
	}
	public String insertINTLStudentDetails(INTLOnlineFormBean intlOnlineFormBean,String instituteId) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertINTLStudentDetails(intlOnlineFormBean,instituteId);
		return responseString;						
	}
	public String insertINTLCourseDetails(INTLCourseFormBean intlCourseFormBean,String applicationNo){
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertINTLCourseDetails(intlCourseFormBean,applicationNo);
		return responseString;					 
	}
	public INTLOnlineFormBean getINTLStudentDetails(String applicationNo){			
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getINTLStudentDetails(applicationNo);	
	}
	public List<INTLCourseFormBean> getINTLCourseDetails(String applicationNo){
		List<INTLCourseFormBean> courseList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		courseList = studentRegistrationDAO.getINTLCourseDetails(applicationNo);
		return courseList;	 
	}
	public String insertJayotiStudentDetails(JayotiFormBean jayotiFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertJayotiStudentDetails(jayotiFormBean,billerId);
		return responseString;	
	}
	public JayotiFormBean getJayotiStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getJayotiStudentDetails(applicationNo);		 

	}
	public String insertLanStudentDetails(LanOnlineFormBean lanOnlineFormBean,String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertLanStudentDetails(lanOnlineFormBean,billerId);
		return responseString;	
	}
	public LanOnlineFormBean getLanStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getLanStudentDetails(applicationNo);		 

	}		
	public String insertNatlStudentDetails(NATLOnlineFormBean natlOnlineFormBean,String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertNatlStudentDetails(natlOnlineFormBean,billerId);
		return responseString;	
	}
	public NATLOnlineFormBean getNatlStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getNatlStudentDetails(applicationNo);		 

	}

	public String insertRpsStudentDetails(RpsFormBean rpsFormBean,
			String billerId) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertRpsStudentDetails(rpsFormBean,billerId);
		return responseString;	
	}	

	public RpsFormBean getRpsStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getRpsStudentDetails(applicationNo);		 

	}

	public String insertRungtaColStudentDetails(RungtaCollegeFormBean rungtaCollegeFormBean, String instituteID) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertRungtaColStudentDetails(rungtaCollegeFormBean,instituteID);
		return responseString;	
	}	

	public RungtaCollegeFormBean getRungtaColStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getRungtaColStudentDetails(applicationNo,instituteCode);		 

	}

	public String insertDTEStudentDetails(DTEFormBean dteFormBean, String billerId) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertDTEStudentDetails(dteFormBean,billerId);
		return responseString;	
	}	

	public DTEFormBean getDTEStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getDTEStudentDetails(applicationNo,instituteCode);		 

	}

	public String validateDTEAdmin(String userName, String password) {
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.validateDTEAdmin(userName,password);
		return responseString;	
	}

	public Map<String, String>  getAdmissionTypeList() {
		Map<String, String>  admissionTypeMap = new HashMap<String, String>();
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		admissionTypeMap = studentRegistrationDAO.getAdmissionTypeList();
		return admissionTypeMap;	
	}

	public Map<String, String>  getFreshCourseList(String freshAdmissionTypeId) {
		Map<String, String>  courseMap = new HashMap<String, String>();
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		courseMap = studentRegistrationDAO.getFreshCourseList(freshAdmissionTypeId);
		return courseMap;	
	}

	public Map<String, String>  getCollegeList(String courseId) {
		Map<String, String>  collegeMap = new HashMap<String, String>();
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		collegeMap = studentRegistrationDAO.getCollegeList(courseId);
		return collegeMap;	
	}

	public Map<String, String>  getBranchList(String collegeId) {
		Map<String, String>  branchMap = new HashMap<String, String>();
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		branchMap = studentRegistrationDAO.getBranchList(collegeId);
		return branchMap;	
	}

	public Map<String, String>  getCategoryList(String collegeId) {
		Map<String, String>  branchMap = new HashMap<String, String>();
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		branchMap = studentRegistrationDAO.getCategoryList(collegeId);
		return branchMap;	
	}

	public String getAmountByCategory(String collegeId,String categoryId) {
		String  strAmount;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		strAmount = studentRegistrationDAO.getAmountByCategory(collegeId,categoryId);
		return strAmount;
	}
	//CR77462
	public String insertSWARAStudentDetails(SWARAFormBean swaraFormBean,String instituteID) {
		// TODO Auto-generated method stub
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSWARAStudentDetails(swaraFormBean,instituteID);
		return responseString;	
	}
	public SWARAFormBean getSWARAStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSWARAStudentDetails(applicationNo);		 

	}
	// CR NO - 77494 , 77495

	public String insertTOLANIStudentDetails(TOLANIFormBean tolaniFormBean,String instituteID) {
		// TODO Auto-generated method stub
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertTOLANIStudentDetails(tolaniFormBean,instituteID);
		return responseString;	
	}

	public TOLANIFormBean getTOLANIStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getTOLANIStudentDetails(applicationNo);		 

	}

	public ArrayList<String> getApplicationNumberList(String instituteCode) {
		ArrayList<String>  applicationNumberList;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		applicationNumberList = studentRegistrationDAO.getApplicationNumberList(instituteCode);
		return applicationNumberList;
	}

	public ArrayList<String> getDueDateList(String applicationNo,String instituteCode) {
		ArrayList<String>  dueDateList;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		dueDateList = studentRegistrationDAO.getDueDateList(applicationNo,instituteCode);
		return dueDateList;
	}

	public SHIVFormBean getSHIVStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSHIVStudentDetails(applicationNo);		 

	}

	public Map<String, String>  getCourseList() {
		Map<String, String>  courseMap = new HashMap<String, String>();
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		courseMap = studentRegistrationDAO.getCourseList();
		return courseMap;	
	}

	/*	public ArrayList<String> getDurationList(String courseId) {
		ArrayList<String>  durationList;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		durationList = studentRegistrationDAO.getDurationList(courseId);
		return durationList;
	}*/
	public SHIVFormBean getDurationList(String courseId) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getDurationList(courseId); 
	}

	public String insertSHIVStudentDetails(SHIVFormBean shivFormBean,String instituteID) {
		// TODO Auto-generated method stub
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSHIVStudentDetails(shivFormBean,instituteID);
		return responseString;	
	}
	public String insertLiveWireStudentDetails(LiveWireOnlineFormBean liveWireOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertLiveWireStudentDetails(liveWireOnlineFormBean,billerId);
		return responseString;	
	}
	public LiveWireOnlineFormBean getLiveWireStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getLiveWireStudentDetails(applicationNo);		 
	}
	public String insertHydroPowerStudentDetails(HydroPowerOnlineFormBean hydroPowerOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertHydroPowerStudentDetails(hydroPowerOnlineFormBean,billerId);
		return responseString;	
	}
	public HydroPowerOnlineFormBean getHydroPowerStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getHydroPowerStudentDetails(applicationNo,instituteCode);		 
	}

	public String insertAmbikaPurStudentDetails(AmbikapurOnlineFormBean ambikaPurOnlineFormBean, String billerId)
	{
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertAmbikaPurStudentDetails(ambikaPurOnlineFormBean,billerId);
		return responseString;
	}
	public AmbikapurOnlineFormBean getAmbikapurStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getAmbikapurStudentDetails(applicationNo,instituteCode);		 
	}
	public String	getAmbikaStudentFees(String coursetype,String gendertype, String categorytype)
	{
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getAmbikaStudentFees(coursetype,gendertype,categorytype);
	}
	public String insertICBRStudentDetails(ICBROnlineFormBean icbrOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertICBRStudentDetails(icbrOnlineFormBean,billerId);
		return responseString;	
	}
	public ICBROnlineFormBean getICBRStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getICBRStudentDetails(applicationNo,instituteCode);		 
	}
	public String insertRamanujanAAStudentDetails(RamanujanAAOnlineFormBean ramanujanAAOnlineFormBean,String billerId)
	{
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertRamanujanAAStudentDetails(ramanujanAAOnlineFormBean,billerId);
		return responseString;
	}
	public RamanujanAAOnlineFormBean getRamanujanAAStudentDetails(String applicationNo)
	{
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getRamanujanAAStudentDetails(applicationNo);		
	}

	public ShepaOnlineFormBean getShepaStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getShepaStudentDetails(applicationNo);		 
	}	
	public String insertShepaStudentDetails(ShepaOnlineFormBean shepaOnlineFormBean,String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertShepaStudentDetails(shepaOnlineFormBean,billerId);
		return responseString;	
	}

	//CR KASHI STARTS
	public KASHIFormBean getKASHIStudentDetails(String applicationNo) {
		// TODO Auto-generated method stub
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getKASHIStudentDetails(applicationNo);	

	}

	public String insertKASHIStudentDetails(KASHIFormBean kashiFormBean,
			String instituteID) {
		// TODO Auto-generated method stub
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertKASHIStudentDetails(kashiFormBean,instituteID);
		return responseString;	
	}
	//CR KASHI ENDS
	public String insertWeinderStudentDetails(WeidnerOnlineFormBean weidnerOnlineFormBean,String billerId) {				
		String responseString = "";


		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertWeinderStudentDetails(weidnerOnlineFormBean,billerId);
		return responseString;	
	}

	public WeidnerOnlineFormBean getWeidnerStudentDetails(String applicationNo,String instituteCode){



		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getWeidnerStudentDetails(applicationNo,instituteCode);		 
	}	

	public String insertFinolexStudentDetails(FinolexOnlineFormBean finolexOnlineFormBean,String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertFinolexStudentDetails(finolexOnlineFormBean,billerId);
		return responseString;	
	}
	public FinolexOnlineFormBean getFinolexStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getFinolexStudentDetails(applicationNo,instituteCode);		 
	}	
	public Map<String,String> getFinolexInstituteStudentFees(String finolexadmissionType,String finolexadmissionTo)
	{
		Map<String,String> stuFee=null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();

		stuFee=studentRegistrationDAO.getFinolexInstituteStudentFees(finolexadmissionType,finolexadmissionTo);
		return stuFee;

	}
	public Map<String,String>  FetchFinolexStuFees_catWise(String finolexadmissionCategory,String finolexadmissionTo)
	{
		Map<String,String> stuFee=null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();

		stuFee=studentRegistrationDAO.FetchFinolexStuFees_catWise(finolexadmissionCategory,finolexadmissionTo);
		return stuFee;
	}

	public String	getPrincipalUpStudentFees(String coursetype,String gendertype,String practicals,String yearOfStudy,String course)
	{
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getPrincipalUpStudentFees(coursetype,gendertype,practicals,yearOfStudy,course);
	}

	public String insertPrincipalStudentDetails(PrincipalUPOnlineFormBean principalUPOnlineFormBean,String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertPrincipalStudentDetails(principalUPOnlineFormBean,billerId);
		return responseString;	
	}
	public PrincipalUPOnlineFormBean getPrincipalUpStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getPrincipalUpStudentDetails(applicationNo);		 
	}
	public String insertYugantarStudentDetails(ShepaOnlineFormBean shepaOnlineFormBean,String billerId) 
	{				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertYugantarStudentDetails(shepaOnlineFormBean,billerId);
		return responseString;	
	}

	public ShepaOnlineFormBean getYugantarStudentDetails(String applicationNo,String instituteCode)
	{

		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getYugantarStudentDetails(applicationNo,instituteCode);		 
	}	


	//KRISHAK STARTS
	public String insertKrishakStudentDetails(KRISHAKFormBean krishakFormBean,
			String billerId) {
		// TODO Auto-generated method stub
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertKrishakStudentDetails(krishakFormBean,billerId);
		return responseString;
	}
	public KRISHAKFormBean getKrishakStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getKrishakStudentDetails(applicationNo,instituteCode);		 
	}	
	//KRISHAK ENDS

	public String insertMahadeviYadavStudentDetails(MahadeviYadavOnlineFormBean mahadeviYadavOnlineFormBean,
			String billerId) {
		// TODO Auto-generated method stub
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertMahadeviYadavStudentDetails(mahadeviYadavOnlineFormBean,billerId);
		return responseString;
	}
	public MahadeviYadavOnlineFormBean getMahadeviYadavStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getMahadeviYadavStudentDetails(applicationNo,instituteCode);		
	}

	//ABHAY STARTS
	public String insertAbhayStudentDetails(ABHAYFormBean abhayFormBean,
			String billerId) {
		// TODO Auto-generated method stub
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertAbhayStudentDetails(abhayFormBean,billerId);
		return responseString;
	}
	public ABHAYFormBean getAbhayStudentDetails(String applicationNo,String instituteCode){

		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getAbhayStudentDetails(applicationNo,instituteCode);		 
	}	
	//ABHAY ENDS
	public String insertHnbguStudentDetails(HNBGUFormBean hNBGUFormDean,String billerId) {
		// TODO Auto-generated method stub
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertHnbguStudentDetails(hNBGUFormDean,billerId);
		return responseString;
	}
	public Map<String,String> getHNBGUCourseFeesAmt(String className1,String cgroup1 ,String semester1,String typesOfStd)
	{
		Map<String,String> stuFee=null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		stuFee=studentRegistrationDAO.getHNBGUCourseFeesAmt(className1,cgroup1,semester1,typesOfStd);
		return stuFee;
	}
	public HNBGUFormBean getHNBGUStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getHNBGUStudentDetails(applicationNo,instituteCode);		 
	}

	//RAJ Starts
	public String insertRajStudentDetails(RAJFormBean rajFormBean, String billerId) {
		// TODO Auto-generated method stub
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertRajStudentDetails(rajFormBean,billerId);
		return responseString;
	}	
	public RAJFormBean getRajStudentDetails(String applicationNo,String instituteCode){

		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getRajStudentDetails(applicationNo,instituteCode);		 
	}	
	//RAJ ENDS
	public String insertOercStudentDetails(OERCOnlineFormBean oercOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertOercStudentDetails(oercOnlineFormBean,billerId);
		return responseString;	
	}
	public OERCOnlineFormBean getOercStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getOercStudentDetails(applicationNo,instituteCode);		 
	}

	//CR79005 OERCP STARTS
	public String insertOercpStudentDetails(
			OERCPOnlineFormBean oercpOnlineFormBean, String billerId) {
		// TODO Auto-generated method stub
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertOercpStudentDetails(oercpOnlineFormBean,billerId);
		return responseString;	
	}

	public OERCPOnlineFormBean getOercpStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getOercpStudentDetails(applicationNo);		 
	}
	//CR79005 OERCP ENDS
	public StandfordOnlineFormBean getStandStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getStandStudentDetails(applicationNo,instituteCode);		 
	}
	public String insertStandStudentDetails(StandfordOnlineFormBean standfordOnlineFormBean, String billerId,String instcode) {
		// TODO Auto-generated method stub
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertStandStudentDetails(standfordOnlineFormBean,billerId,instcode);
		return responseString;	
	}
	public String insertSheetlaStudentDetails(SheetlaOnlineFormBean sheetlaOnlineFormBean, String billerId){				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSheetlaStudentDetails(sheetlaOnlineFormBean,billerId);
		return responseString;	
	}
	public SheetlaOnlineFormBean getSheetlaStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSheetlaStudentDetails(applicationNo,instituteCode);		 
	}

	public String insertMicronStudentDetails(MicronOnlineFormBean micronOnlineFormBean, String billerId){				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertMicronStudentDetails(micronOnlineFormBean,billerId);
		return responseString;	
	}
	public MicronOnlineFormBean getMicronStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getMicronStudentDetails(applicationNo,instituteCode);		 
	}
	public String getMicronStudentFees(String PaymentCycle,String feecategory)
	{
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getMicronStudentFees(PaymentCycle,feecategory);
	}
	public String insertGarawarStudentDetails(GaharwarOnlineFormBean gaharwarOnlineFormBean, String billerId){				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertGarawarStudentDetails(gaharwarOnlineFormBean,billerId);
		return responseString;	
	}
	public GaharwarOnlineFormBean getGarawarStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getGarawarStudentDetails(applicationNo,instituteCode);		 
	}

	public String insertNehuPayStudentDetails(NehuPayOnlineBean nehuPayOnlineBean, String billerId){				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertNehuPayStudentDetails(nehuPayOnlineBean,billerId);

		return responseString;	
	}
	public NehuPayOnlineBean getNehuPayStudentDetails(String applicationNo)
	{
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getNehuPayStudentDetails(applicationNo);
	}
	public List<String> getNehuPayPaymentTypeList()
	{
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getNehuPayPaymentTypeList();
	}

	public Map<String,String> getNehuPayPaymentTypeFeesList(String nehupayPaymentType)
	{
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getNehuPayPaymentTypeFeesList(nehupayPaymentType);
	}
	public String insertAllenInstituteDetails(ApiInstituteRequestBean[] apiInstituteRequestBean,String instCode ){				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertAllenInstituteDetails(apiInstituteRequestBean,instCode);

		return responseString;	
	}
	public ApiInstituteRequestBean getAllenStudentDetails(String fno){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getAllenStudentDetails(fno);		 
	}
	public String insertApiErrorCode(String institutecode, String status){			
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertApiErrorCode(institutecode,status);

		return responseString;	
	}
	public String insertLuciStudentDetails(LuciOnlineFormBean luciOnlineFormBean, String billerId){				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertLuciStudentDetails(luciOnlineFormBean,billerId);
		return responseString;	
	}
	public LuciOnlineFormBean getLuciStudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getLuciStudentDetails(applicationNo,instituteCode);		 
	}
	public String insertOnlineGeetaColStudentDetails(GeetaCollegeOnlineFormBean geetaCollegeOnlineFormBean, String instituteId)
	{
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory)DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertOnlineGeetaColStudentDetails(geetaCollegeOnlineFormBean, instituteId);
		return responseString;
	}

	public GeetaCollegeOnlineFormBean getGeetaColStudentDetails(String applicationNo)
	{
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory)DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getGeetaColStudentDetails(applicationNo);
	}	 
	public Map<String, String>  getChaduryCourseTypeList(String coursname) {
		Map<String, String>  admissionTypeMap = new HashMap<String, String>();
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		admissionTypeMap = studentRegistrationDAO.getChaduryCourseTypeList(coursname);
		return admissionTypeMap;	
	}
	public String insertChaudharyCollegeStudentDetails(ChaudharyCollegeOnlineBean chaudharyCollegeOnlineBean, String billerId){				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertChaudharyCollegeStudentDetails(chaudharyCollegeOnlineBean,billerId);
		return responseString;	
	}
	public ChaudharyCollegeOnlineBean getchaduryColStudentDetails(String applicationNo)
	{
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getchaduryColStudentDetails(applicationNo);
	}
	public String insertGSFCStudentDetails(GSFCOnlineFormBean gsfcOnlineFormBean, String instituteId)
	{
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory)DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertGSFCStudentDetails(gsfcOnlineFormBean, instituteId);
		return responseString;
	}

	public GSFCOnlineFormBean getGSFCStudentDetails(String applicationNo)
	{
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory)DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getGSFCStudentDetails(applicationNo);
	}
	public Map<String, String>  getChaduryAdmissionTypeList(String studentCategory,String coursname) {
		Map<String, String>  admissionTypeMap = new HashMap<String, String>();
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		admissionTypeMap = studentRegistrationDAO.getChaduryAdmissionTypeList(studentCategory,coursname);
		return admissionTypeMap;	
	}
	public String insertChaudharyAdmisionStudentDetails(ChaudharyADMISSIONOnlineBean chaudharyADMISSIONOnlineBean, String billerId){				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertChaudharyAdmissionStudentDetails(chaudharyADMISSIONOnlineBean,billerId);
		return responseString;	
	}
	public ChaudharyADMISSIONOnlineBean getChaudharyAdmissionStudentDetails(String applicationNo)

	{
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getChaudharyAdmissionStudentDetails(applicationNo);
	}
	public String insertChaudharyMiscellanouStudentDetails(ChaudharyMiscellanousOnlineBean ChaudharyMiscellanousOnlineBean, String billerId){				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertChaudharyMiscellanouStudentDetails(ChaudharyMiscellanousOnlineBean,billerId);
		return responseString;	
	}
	public ChaudharyMiscellanousOnlineBean getChaudharyMiscellanousStudentDetails(String applicationNo)

	{
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getChaudharyMiscellanousStudentDetails(applicationNo);
	}
	public String insertNLUStudentDetails(NLUOnlineFormBean nluOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertNLUStudentDetails(nluOnlineFormBean,billerId);
		return responseString;	
	}
	public NLUOnlineFormBean getNLUStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getNLUStudentDetails(applicationNo);		 
	}
	public String insertDPSCStudentDetails(DPSCOnlineFormBean dpscOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertDPSCStudentDetails(dpscOnlineFormBean,billerId);
		return responseString;	
	}
	public DPSCOnlineFormBean getDPSCStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getDPSCStudentDetails(applicationNo);		 
	}
	public String insertChauFeeDetails(ChaudharyCollegeOnlineBeanGrid chaudharyCollegeOnlineBeanGrid,String applicationNo){

		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertChauFeeDetails(chaudharyCollegeOnlineBeanGrid,applicationNo);
		return responseString;
	}
	public String insertNLU1StudentDetails(NLUOnlineFormBean nluOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertNLU1StudentDetails(nluOnlineFormBean,billerId);
		return responseString;	
	}
	public NLUOnlineFormBean getNLU1StudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getNLU1StudentDetails(applicationNo);		 
	}
	public String insertAmricanStudentDetails(AmericanOnlineFormBean americanOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertAmricanStudentDetails(americanOnlineFormBean,billerId);
		return responseString;	
	}
	public AmericanOnlineFormBean getAmricanStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getAmricanStudentDetails(applicationNo);		 
	}
	public String insertPathFinderStudentDetails(PathFinderOnlineFormBean pathFinderOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertPathFinderStudentDetails(pathFinderOnlineFormBean,billerId);
		return responseString;	
	}
	public PathFinderOnlineFormBean getpathFinderStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getpathFinderStudentDetails(applicationNo);		 
	}
	public String insertKashiTechnologyStudentDetails(FeesForm feesForm, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertKashiTechnologyStudentDetails(feesForm,billerId);
		return responseString;	
	}
	public FeesForm getKashiTechnologyStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getKashiTechnologyStudentDetails(applicationNo);		 
	}
	public String insertThangamInnovativeStudentDetails(ThangamInnovativeOnlineFormBean thangamInnovativeOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertThangamInnovativeStudentDetails(thangamInnovativeOnlineFormBean,billerId);
		return responseString;	
	}
	public ThangamInnovativeOnlineFormBean getThangamInnovativeStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getThangamInnovativeStudentDetails(applicationNo);		 
	}
	public String insertThangamKidzeeStudentDetails(ThangamKidzeeOnlineFormBean thangamKidzeeOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertThangamKidzeeStudentDetails(thangamKidzeeOnlineFormBean,billerId);
		return responseString;	
	}
	public ThangamKidzeeOnlineFormBean getThangamKidzeeStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getThangamKidzeeStudentDetails(applicationNo);		 
	}
	public String insertCUOHaryanaStudentDetails(CUOHaryanaOnlineFormBean CuoHaryanaOnlineFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertCUOHaryanaStudentDetails(CuoHaryanaOnlineFormBean,billerId);
		return responseString;	
	}
	public CUOHaryanaOnlineFormBean getCUOHaryanaStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getCUOHaryanaStudentDetails(applicationNo);		 
	}

	public ArrayList getAllStatesName() {				
		ArrayList<String> listofstate=new ArrayList<String>();
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		listofstate = studentRegistrationDAO.getAllStatesName();
		return listofstate;	
	}
	public String insertCUOKashmirStudentDetails(CUOKashmirOnlineFormBean cuoKashmirFormBean, String billerId) {				
		String responseString = "";
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertCUOKashmirStudentDetails(cuoKashmirFormBean,billerId);
		return responseString;	
	}

	public CUOKashmirOnlineFormBean getCUOKashmirStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getCUOKashmirStudentDetails(applicationNo);		 
	}
	public String insertRoyalDentalStudentDetails(RoyalDentalOnlineFormBean royalDentalOnlineFormBean, String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertRoyalDentalStudentDetails(royalDentalOnlineFormBean,billerId);
		return responseString;
	}
	public RoyalDentalOnlineFormBean getRoyalDentalStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getRoyalDentalStudentDetails(applicationNo);		 
	}
	public String insertVishalInstituteStudentDetails(VishalInstOnlineFormBean vishalInstOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertVishalInstituteStudentDetails(vishalInstOnlineFormBean,billerId);
		return responseString;
	}
	public VishalInstOnlineFormBean getVishalInstStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getVishalInstStudentDetails(applicationNo);		 
	}
	public String insertFeePaymentStudentDetails(FeePaymentOnlineFormBean feePaymentOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertFeePaymentStudentDetails(feePaymentOnlineFormBean,billerId);
		return responseString;
	}
	public FeePaymentOnlineFormBean getFeePaymentStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getFeePaymentStudentDetails(applicationNo);		 
	}
	public String insertFeePayment1StudentDetails(FeePayment1OnlineFormBean feePayment1OnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertFeePayment1StudentDetails(feePayment1OnlineFormBean,billerId);
		return responseString;
	}
	public FeePayment1OnlineFormBean getFeePayment1StudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getFeePayment1StudentDetails(applicationNo);		 
	}
	public String insertJayshreePeriwalStudentDetails(JayshreePeriwalOnlineFormBean jayshreePeriwalOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertJayshreePeriwalStudentDetails(jayshreePeriwalOnlineFormBean,billerId);
		return responseString;
	}
	public JayshreePeriwalOnlineFormBean getJayshreePeriwalStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getJayshreePeriwalStudentDetails(applicationNo);		 
	}
	public String insertJayshreePeriStudentDetails(JayshreePeriOnlineFormBean jayshreePeriOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertJayshreePeriStudentDetails(jayshreePeriOnlineFormBean,billerId);
		return responseString;
	}
	public JayshreePeriOnlineFormBean getJayshreePeriStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getJayshreePeriStudentDetails(applicationNo);		 
	}
	public String insertLancersSchoolStudentDetails(LancersOnlineFormBean lancersOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertLancersSchoolStudentDetails(lancersOnlineFormBean,billerId);
		return responseString;
	}
	public LancersOnlineFormBean getLancersStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getLancersStudentDetails(applicationNo);		 
	}
	public String insertKrishnaLawStudentDetails(KrishnaLawOnlineFormBean krishnaLawOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertKrishnaLawStudentDetails(krishnaLawOnlineFormBean,billerId);
		return responseString;
	}
	public KrishnaLawOnlineFormBean getKrishnaLawStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getKrishnaLawStudentDetails(applicationNo);		 
	}
	//---------Delhi Public School Budgam
	public String insertdpsBudgamDetails(DpsBudgamOnlineFormBean dpsBudgamOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertdpsBudgamDetails(dpsBudgamOnlineFormBean,billerId);
		return responseString;
	}

	public DpsBudgamOnlineFormBean getDpsBudgamStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getDpsBudgamStudentDetails(applicationNo);		 
	}
	//--------End Delhi Publich School Budgam
	public String insertKulluStudentDetails(KulluOnlineFormBean kulluOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertKulluStudentDetails(kulluOnlineFormBean,billerId);
		return responseString;
	}
	public KulluOnlineFormBean getKulluStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getKulluStudentDetails(applicationNo);		 
	}
	public String insertBiyaniStudentDetails(BiyaniOnlineFormBean biyaniOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertBiyaniStudentDetails(biyaniOnlineFormBean,billerId);
		return responseString;
	}
	public BiyaniOnlineFormBean getBiyaniStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getBiyaniStudentDetails(applicationNo);		 
	}
	public String insertShrirRamEducationalDetails(ShriRamEducationalOnlineFormBean shriRamEducationalOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertShrirRamEducationalDetails(shriRamEducationalOnlineFormBean,billerId);
		return responseString;
	}
	public ShriRamEducationalOnlineFormBean getShriRamEducationalDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getShriRamEducationalDetails(applicationNo);	
	}
	public String insertTeamWorkEducationDetails(TeamworkEducationOnlineFormBean teamworkEducationOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertTeamWorkEducationDetails(teamworkEducationOnlineFormBean,billerId);
		return responseString;
	}
	public TeamworkEducationOnlineFormBean getTeamworkEducationDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getTeamworkEducationDetails(applicationNo);	
	}
	//JBCI Start
	public String insertJbciStudentDetails(JBCIOnlineFormBean jbciOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertJbciStudentDetails(jbciOnlineFormBean,billerId);
		return responseString;
	}
	public JBCIOnlineFormBean getJbciStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getJbciStudentDetails(applicationNo);		 
	}
	//JBCI END
	public String insertAbdulKalamDetails(AbdulKalamOnlineFormBean abdulKalamOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertAbdulKalamDetails(abdulKalamOnlineFormBean,billerId);
		return responseString;
	}
	public AbdulKalamOnlineFormBean getAbdulKalamDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getAbdulKalamDetails(applicationNo);	
	}
	//JainSubodh Start
	public String insertJainSubodhDetails(SSJainSubodhOnlineFormBean jainSubodhOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertJainSubodhDetails(jainSubodhOnlineFormBean,billerId);
		return responseString;
	}
	public SSJainSubodhOnlineFormBean getJainSubodhDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getJainSubodhDetails(applicationNo);	
	}
	//JainSubodh End
	//Naiminath Start
	public String insertNaiminathDetails(NaiminathOnlineFormBean naiminathOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertNaiminathDetails(naiminathOnlineFormBean,billerId);
		return responseString;
	}
	public NaiminathOnlineFormBean getNaiminathDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getNaiminathDetails(applicationNo);	
	}
	//Naiminath End
	//SPHSchool Start
	public String insertSPHSchoolDetails(SPHSchoolOnlineFormBean sphSchoolOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSPHSchoolDetails(sphSchoolOnlineFormBean,billerId);
		return responseString;
	}
	public SPHSchoolOnlineFormBean getSPHSchoolDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSPHSchoolDetails(applicationNo);	
	}
	//SPHSchool End

	//Goenka Start
	public String insertGOENKADetails(GOENKAOnlineFormBean goenkaOnlineFormBean,
			String billerId) {
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertGOENKADetails(goenkaOnlineFormBean,billerId);
		return responseString;
	}
	public GOENKAOnlineFormBean getGoenkaStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getGoenkaStudentDetails(applicationNo);	
	}
	//Goenka END
	public String insertGRCosmicStudentDetails(GRCosmicOnlineFormBean grCosmicOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertGRCosmicStudentDetails(grCosmicOnlineFormBean,billerId);
		return responseString;
	}
	public GRCosmicOnlineFormBean getGRCosmicStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getGRCosmicStudentDetails(applicationNo);	
	}
	//Swami Temple Start
	public String insertSwamiTempleDetails(SwamiTempleOnlineFormBean swamiTempleOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSwamiTempleDetails(swamiTempleOnlineFormBean,billerId);
		return responseString;
	}
	public SwamiTempleOnlineFormBean getSwamiTempleDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSwamiTempleDetails(applicationNo);	
	}
	//Swami Temple End
	//Prarambh Start
	public String insertPrarambhDetails(PrarambhOnlineFormBean prarambhOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertPrarambhDetails(prarambhOnlineFormBean,billerId);
		return responseString;
	}
	public PrarambhOnlineFormBean getPrarambhDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		PrarambhOnlineFormBean prarambhOnlineFormBean=studentRegistrationDAO.getPrarambhDetails(applicationNo);

		MSSQLDAOFactory refDAO1 = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO1 = refDAO1.getStudentRegistrationDAO();
		prarambhOnlineFormBean.setFeeDetailsList(studentRegistrationDAO1.getPrarambhFeeDetails(applicationNo));
		return prarambhOnlineFormBean;	
	}
	public String insertPrarambhFeeDetailsDetails(PraramFeeDetailsBean praramFeeDetailsBean,String applicationNo,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertPrarambhFeeDetailsDetails(praramFeeDetailsBean,applicationNo,billerId);
		return responseString;
	}
	//Prarambh End
	public  String getNIPRAmount(String Department,String currency,String fixDate) {
		String totalAmt=null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		totalAmt = studentRegistrationDAO.getNIPRAmount(Department,currency,fixDate);
		studentRegistrationDAO.releaseConnection();
		return totalAmt;
	}
	public String insertShmshiDetails(ShmshiOnlineFormBean shmshiOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertShmshiDetails(shmshiOnlineFormBean,billerId);
		return responseString;
	}
	public ShmshiOnlineFormBean getShmshiStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getShmshiStudentDetails(applicationNo);	
	}
	public String insertRajashtanDetails(RajsthanOnlineFormBean rajsthanOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertRajashtanDetails(rajsthanOnlineFormBean,billerId);
		return responseString;
	}
	public RajsthanOnlineFormBean getRajsthanStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getRajsthanStudentDetails(applicationNo);	
	}
	public String insertUDAIPURDetails(UDAIPUROnlineFormBean udaipurOnlineFormBean,
			String billerId) {
		// TODO Auto-generated method stub
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertUDAIPURDetails(udaipurOnlineFormBean,billerId);
		return responseString;
	}
	public UDAIPUROnlineFormBean getUDAIPURStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getUDAIPURStudentDetails(applicationNo);	
	}
	public String insertRatanalaDetails(RatanalaOnlineFormBean ratanalaOnlineFormBean,
			String billerId) {
		// TODO Auto-generated method stub
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertRatanalaDetails(ratanalaOnlineFormBean,billerId);
		return responseString;
	}
	public RatanalaOnlineFormBean getRatanalaStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getRatanalaStudentDetails(applicationNo) ;	
	}
	public String insertVenkatEduDetails(VenkatEduOnlineFormBean venkatEduOnlineFormBean,
			String billerId) {
		// TODO Auto-generated method stub
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertVenkatEduDetails(venkatEduOnlineFormBean,billerId);
		return responseString;
	}
	public VenkatEduOnlineFormBean getVenkatEduStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getVenkatEduStudentDetails(applicationNo) ;	
	}
	public String insertMahaEduDetails(MahaEduOnlineFormBean mahaEduOnlineFormBean,String billerId) {
		// TODO Auto-generated method stub
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertMahaEduDetails(mahaEduOnlineFormBean,billerId);
		return responseString;
	}
	public MahaEduOnlineFormBean getMahaEduStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getMahaEduStudentDetails(applicationNo) ;	
	}
	public String insertAsianDetails(AsianOnlineFormBean asianOnlineFormBean,String billerId) {
		// TODO Auto-generated method stub
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertAsianDetails(asianOnlineFormBean,billerId);
		return responseString;
	}
	public AsianOnlineFormBean getAsianStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getAsianStudentDetails(applicationNo) ;	
	}
	// smartrepEducation created by amol 
	public String insertSmartrepEdu(SmartrepEductionOnlineFormBean smartrepEductionOnlineFormBean,String billerId) {
		// TODO Auto-generated method stub
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSmartrepEdu(smartrepEductionOnlineFormBean,billerId);
		return responseString;
	}
	public SmartrepEductionOnlineFormBean getSEVikaspuriStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSmartrepEduDetails(applicationNo) ;	
	}
	public String insertindianPoliticalDetails(IndianPoliticalOnlineFormBean indianPoliticalOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertindianPoliticalDetails(indianPoliticalOnlineFormBean,billerId);
		return responseString;
	}
	public IndianPoliticalOnlineFormBean getindianPoliticalStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getindianPoliticalStudentDetails(applicationNo) ;	
	}
	public String insertMalwaDetails(MalwaFormBean malwaFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertMalwaDetails(malwaFormBean,billerId);
		return responseString;
	}
	public MalwaFormBean getMalwaStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getMalwaStudentDetails(applicationNo) ;	
	}

	public String insertKashiInstituteDetails(KashiInstituteFormBean kashiFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertKashiDetails(kashiFormBean,billerId);
		return responseString;
	}
	public KashiInstituteFormBean getKashiStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getKashiStudentDetails(applicationNo) ;	
	}
	public String insertSuccessEaseDetails(SuccessEaseFormBean successEaseFormBeanFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSuccessEaseDetails(successEaseFormBeanFormBean,billerId);
		return responseString;
	}
	public SuccessEaseFormBean getSuccessEaseStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSuccessEaseStudentDetails(applicationNo) ;	
	}
	public String insertSISDetails(SISFormBean sisFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSISDetails(sisFormBean,billerId);
		return responseString;
	}
	public SISFormBean getSISStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSISStudentDetails(applicationNo) ;	
	}
	public String insertHorizonDetails(HorizonOnlineFormBean horizonOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertHorizonDetails(horizonOnlineFormBean,billerId);
		return responseString;
	}


	public HorizonOnlineFormBean getHorizonStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getHorizonStudentDetails(applicationNo) ;	
	}

	public HorizonOnlineFormBean getHorizonStudentDetails_Ereceipt(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getHorizonStudentDetails_Ereceipt(applicationNo) ;	
	}
	public String insertIICSEdu(IICSEductionOnlineFormBean iicsEductionOnlineFormBean,String billerId) {
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertIICSEdu(iicsEductionOnlineFormBean,billerId);
		return responseString;
	}
	public IICSEductionOnlineFormBean getIICSStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getIICSStudentDetails(applicationNo) ;	
	}


	public String insertJawaharStudent(JawaharOnlineFormBean jawaharOnlineFormBean,String billerId) {
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertJawaharStudent(jawaharOnlineFormBean,billerId);
		return responseString;
	}
	public JawaharOnlineFormBean getJawaharStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getJawaharStudentDetails(applicationNo) ;	
	}
	public String insertVenkateshwarStudent(VenkateshwarOnlineFormBean venkateshwarOnlineFormBean,String billerId) {
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertVenkateshwarStudent(venkateshwarOnlineFormBean,billerId);
		return responseString;
	}

	public VenkateshwarOnlineFormBean getvenkateshwarStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getvenkateshwarStudentDetails(applicationNo) ;	
	}

	public String insertDelhiSchool(DelhiSchoolOnlineFormBean delhiSchoolOnlineFormBean,String billerId) {
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertDelhiSchool(delhiSchoolOnlineFormBean,billerId);
		return responseString;
	}
	public DelhiSchoolOnlineFormBean getDelhiSchoolStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getDelhiSchoolStudentDetails(applicationNo) ;	
	}

	public String insertBrainStormEaseDetails(BrainStormFormBean brainStormFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertBrainStormEaseDetails(brainStormFormBean,billerId);
		return responseString;
	}
	public BrainStormFormBean getbrainStormStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getbrainStormStudentDetails(applicationNo) ;	
	}
	public List getStudentTranDetailsList_Lukhnow(String referenceId,String branchId) {
		List returnList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		returnList = studentRegistrationDAO.getStudentTranDetailsList_Lukhnow(referenceId, branchId);
		return returnList;
	}

	//Insert for ICE Details
	public String insertIceDetails(IceonlineFormBean iceBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertIceDetails(iceBean,billerId);
		return responseString;
	}
	public IceonlineFormBean getICEStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getICEStudentDetails(applicationNo) ;	
	}

	//Insert for ICE Details
	public String insertIEIIndiaDetails(IEIIndiaOnlineFormBean ieiIndiaOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertIEIIndiaDetails(ieiIndiaOnlineFormBean,billerId);
		return responseString;
	}
	public IEIIndiaOnlineFormBean getIEIIndiaStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getIEIStudentDetails(applicationNo) ;	
	}
	//Insert for NavJagriti Details
	public String insertNavJagritiDetails(NavJagritiOnlineFormBean navJagritiBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertNavJagritiDetails(navJagritiBean,billerId);
		return responseString;
	}
	public NavJagritiOnlineFormBean getNavJagritiStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getNavJagritiStudentDetails(applicationNo) ;	
	}
	// For Bharti concept Details
	public String insertBhartiConceptDetails(BhartiConceptFormBean bhartiConceptFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertBhartiConceptDetails(bhartiConceptFormBean,billerId);
		return responseString;
	}
	public BhartiConceptFormBean getBhartiConceptDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getBhartiConceptStudentDetails(applicationNo) ;	
	}

	//Insert for TRINITY Details
	public String insertTrinityDetails(TrinityOnlineFormBean trinityBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertTrinityDetails(trinityBean,billerId);
		return responseString;
	}
	public TrinityOnlineFormBean getTrinityDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getTrinityStudentDetails(applicationNo) ;	
	}

	//Test Roorkee
	public String insertRoorkeeDetails(RoorkeeOnlineFornBean roorkeeOnlineFornBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertRoorkeeDetails(roorkeeOnlineFornBean,billerId);
		return responseString;
	}
	public RoorkeeOnlineFornBean getRoorkeeStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getRoorkeeStudentDetails(applicationNo) ;	
	}

	//For Jawahar Navodaya Vidyalaya Maharajganj START
	public String insertJawaharNavodayaVidyalayaMaharajganjDetails(JawaharNavodayaVidyalayaMaharajganjFormBean jawaharNavodayaVidyalayaMaharajganjFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertJawaharNavodayaVidyalayaMaharajganjDetails(jawaharNavodayaVidyalayaMaharajganjFormBean,billerId);
		return responseString;
	}
	public JawaharNavodayaVidyalayaMaharajganjFormBean getJawaharNavodayaVidyalayaMaharajganjDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getJawaharNavodayaVidyalayaMaharajganjDetails(applicationNo) ;	
	}

	//For Jawahar Navodaya Vidyalaya Maharajganj END

	//For Jawahar Navodaya Vidyalaya Mau START
	public String insertJawaharNavodayaVidyalayaMauDetails(JawaharNavodayaVidyalayaMauFormBean jawaharNavodayaVidyalayaMauFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertJawaharNavodayaVidyalayaMauDetails(jawaharNavodayaVidyalayaMauFormBean,billerId);
		return responseString;
	}
	public JawaharNavodayaVidyalayaMauFormBean getJawaharNavodayaVidyalayaMauDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getJawaharNavodayaVidyalayaMauDetails(applicationNo) ;	
	}

	//For Jawahar Navodaya Vidyalaya Mau END
	//For Indraprasth Institute of Aeronautics START
	public String insertIndraprasthAeronauticsDetails(IndraprasthAeronauticsFormBean indraprasthAeronauticsFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertIndraprasthAeronauticsDetails(indraprasthAeronauticsFormBean,billerId);
		return responseString;
	}
	public IndraprasthAeronauticsFormBean getIndraprasthAeronauticsDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getIndraprasthAeronauticsDetails(applicationNo) ;	
	}

	//For Indraprasth Institute of Aeronautics END
	public String insertDronacharyaDetails(DronacharyaOnlineFormBean dronacharyaOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertDronacharyaDetails(dronacharyaOnlineFormBean,billerId);
		return responseString;
	}
	public DronacharyaOnlineFormBean getDronacharyaDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getDronacharyaDetails(applicationNo) ;	
	}

	public String insertEduncleDetails(EduncleOnlineFormBean eduncleOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertEduncleDetails(eduncleOnlineFormBean,billerId);
		return responseString;
	}
	public EduncleOnlineFormBean getEduncleDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getEduncleDetails(applicationNo) ;	
	}

	public String insertDpsPanipatDetails(DpsPanipatOnlineFormBean dpsPanipatOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertDpsPanipatDetails(dpsPanipatOnlineFormBean,billerId);
		return responseString;
	}
	public DpsPanipatOnlineFormBean getDpsPanipatStudentDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getDpsPanipatStudentDetails(applicationNo) ;	
	}

	public String insertToyotaWebinarDetails(ToyotaOnlineFormBean toyotaOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertToyotaWebinarDetails(toyotaOnlineFormBean,billerId);
		return responseString;
	}
	public ToyotaOnlineFormBean getToyotaWebinarDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getToyotaWebinarDetails(applicationNo) ;	
	}

	public String insertDronacharyaGOIDetails(DronacharyaGOIOnlineFormBean dronacharyaGOIOnlineFormBean,
			String InstituteId) {
		String responseString="";
		System.out.println("InstituteId "+InstituteId);
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertDronacharyaGOIstudentDetails(dronacharyaGOIOnlineFormBean,InstituteId);
		return responseString;
	}

//	public DronacharyaGOIOnlineFormBean getDronacharyaGOIstudentDetails(String AppNo, String institute_id, InstituteFormDetailsBean instituteFormDetailsBean){
//		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
//		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
//		return studentRegistrationDAO.getDronacharyaGOIstudentDetails(AppNo,institute_id,instituteFormDetailsBean) ;	
//	}
	
	public DronacharyaGOIOnlineFormBean getDronacharyaGOIstudentDetails(String applicationNo,String instituteCode){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getDronacharyaGOIstudentDetails(applicationNo,instituteCode) ;	
	}

	public String insertAlmAcademyDetails(AlmAcademyOnlineFormBean almAcademyOnlineFormBean,
			String billerId) {
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertAlmAcademystudentDetails(almAcademyOnlineFormBean,billerId);
		return responseString;
	}

	public AlmAcademyOnlineFormBean getAlmAcademyDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getAlmAcademystudentDetails(applicationNo) ;	
	}

	/*Added for NLU Ereciept on Trans Portal 20-08-2020 Start*/
	public List getStudentTranDetailsList_NLUEreceipt(String referenceId,String branchId) {
		List returnList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		returnList = studentRegistrationDAO.getStudentTranDetailsList_NLUEreceipt(referenceId, branchId);
		return returnList;
	}

	public NLUOnlineFormBean getNLUStudentDetails_Ereceipt(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getNLUStudentDetails_EreceiptData(applicationNo) ;	
	}
	/*Added for NLU Ereciept on Trans Portal 20-08-2020 Ends*/

	/*Added for UGI Ereciept on Trans Portal 24-08-2020 Start*/
	public List getStudentTranDetailsList_UGIEreceipt(String referenceId,String branchId) {
		List returnList = null;
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		returnList = studentRegistrationDAO.getStudentTranDetailsList_UGIEreceipt(referenceId, branchId);
		return returnList;
	}

	public UGIOnlineFormBean getUGIStudentDetails_Ereceipt(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getUGIStudentDetails_EreceiptData(applicationNo) ;	
	}
	/*Added for UGI Ereciept on Trans Portal 24-08-2020 Ends*/





	public String insertHisarSchoolDetails(
			HisarSchoolOnlineFormBean hisarSchoolOnlineFormBean, String billerId) {
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertHisarSchoolDetails(hisarSchoolOnlineFormBean,billerId);
		return responseString;
	}

	public HisarSchoolOnlineFormBean getHisarSchoolDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getHisarSchoolDetails(applicationNo) ;	
	}

	//Insert for APSNOIDA Online Form
	public String insertAPSNoidaDetails(NoidaApsOnlineFormBean noidaApsOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertAPSNoidaDetails(noidaApsOnlineFormBean,billerId);
		return responseString;
	}
	//get APSNOIDA form data
	public NoidaApsOnlineFormBean getAPSNoidaDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getAPSNoidaDetails(applicationNo) ;	
	}
	//Insert for DAV School Form Data
	public String insertDAVSchoolDetails(DAVSchoolOnlineFormBean davschoolBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertDAVSchoolDetails(davschoolBean,billerId);
		return responseString;
	}
	//get DAV School form data
	public DAVSchoolOnlineFormBean getDAVSchoolDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getDAVSchoolDetails(applicationNo) ;	
	}
	//Insert for Satyavati School Form Data
	public String insertSatyavatiSchoolDetails(SatyavatiSchoolOnlineFormBean satyavatischoolBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSatyavatiSchoolDetails(satyavatischoolBean,billerId);
		return responseString;
	}
	//get Satyavati School form data
	public SatyavatiSchoolOnlineFormBean getSatyavatiSchoolDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSatyavatiSchoolDetails(applicationNo) ;	
	}

	//Insert for Sri Aurobindo School Form Data
	public String insertSriAurobindoSchoolDetails(SriAurobindoSchoolOnlineFormBean sriAurobindoSchoolOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertSriAurobindoSchoolDetails(sriAurobindoSchoolOnlineFormBean,billerId);
		return responseString;
	}
	//get Sri Aurobindo School form data
	public SriAurobindoSchoolOnlineFormBean getSriAurobindoDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getSriAurobindoDetails(applicationNo) ;	
	}

	//Insert for Gold Croft Form Data
	public String insertGoldCroftDetails(GoldCroftOnlineFormBean goldCroftOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertGoldCroftDetails(goldCroftOnlineFormBean,billerId);
		return responseString;
	}
	//get Gold Croft Form Data
	public GoldCroftOnlineFormBean getGoldCroftDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getGoldCroftDetails(applicationNo) ;	
	}
	//Insert for DPS Budgam Registartion Form Data
	public String insertDpsBudgamregistrationDetails(DpsBudgamRegistrationOnlineFormBean dpsBudgamRegistrationOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertDpsBudgamregistrationDetails(dpsBudgamRegistrationOnlineFormBean,billerId);
		return responseString;
	}
	//get DPS Budgam Registration Form Data
	public DpsBudgamRegistrationOnlineFormBean getDpsBudgamRegistrationDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getDpsBudgamRegistrationDetails(applicationNo) ;	
	}
	//Insert for InderPrastha Form Data
	public String insertInderPrasthaDetails(InderPrasthaOnlineFormBean inderPrasthaOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertInderPrasthaDetails(inderPrasthaOnlineFormBean,billerId);
		return responseString;
	}
	//get InderPrastha Form Data
	public InderPrasthaOnlineFormBean getInderPrasthaDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getInderPrasthaDetails(applicationNo) ;	
	}
	//Insert for InderPrasthaNewStudent Form Data
	public String insertInderPrasthaNewDetails(InderPrasthaNewOnlineFormBean inderPrasthaNewOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertInderPrasthaNewDetails(inderPrasthaNewOnlineFormBean,billerId);
		return responseString;
	}
	//get InderPrasthanewstudent Form Data
	public InderPrasthaNewOnlineFormBean getInderPrasthaNewDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getInderPrasthaNewDetails(applicationNo) ;	
	}

	//Insert for InderPrasthaExistStudent Form Data
	public String insertInderPrasthaExistDetails(InderPrasthaExistOnlineFormBean inderPrasthaExistOnlineFormBean,String billerId){
		String responseString="";
		MSSQLDAOFactory refDAO=(MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO=refDAO.getStudentRegistrationDAO();
		responseString = studentRegistrationDAO.insertInderPrasthaExistDetails(inderPrasthaExistOnlineFormBean,billerId);
		return responseString;
	}
	//get InderPrasthanExiststudent Form Data
	public InderPrasthaExistOnlineFormBean getInderPrasthaExistDetails(String applicationNo){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getInderPrasthaExistDetails(applicationNo) ;	
	}
	public InderPrasthaExistOnlineFormBean FetchInderPrastaExistData(String rollNo) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.FetchInderPrastaExistData(rollNo); 
	}
	public InstituteFormDetailsBean getInstituteFormDetails(String billerId){
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getInstituteFormDetails(billerId);		 
	}

	public String getInstituteId(String instituteCode) {
		MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
		StudentRegistrationDAO studentRegistrationDAO = refDAO.getStudentRegistrationDAO();
		return studentRegistrationDAO.getInstituteId(instituteCode);
	}
	public String  getMerchantId(String instId) {
        String returnString = "";
        MSSQLDAOFactory refDAO = (MSSQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.MSSQL);
        StudentRegistrationDAO instituteMasterActionDAO = refDAO.getStudentRegistrationDAO();
        returnString = instituteMasterActionDAO.getMerchantId(instId);
        instituteMasterActionDAO.releaseConnection();
        return returnString;
    }
	
}