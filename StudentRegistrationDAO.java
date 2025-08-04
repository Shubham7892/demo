package com.app.feejunction.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.app.feejunction.bean.*;

public interface StudentRegistrationDAO extends BaseDAO{
	public String insertStudentDetails(StudentRegistrationFormBean studentRegistrationFormBean);
	public String deleteStudentDetails(String studentId);
	public String editStudentDetails(StudentRegistrationFormBean studentRegistrationFormBean);
	public StudentRegistrationFormBean getStudentCourseDetails(String studentRegistrationId);
	/*public List getStudentFeesDetails(String studentSpecializationTypePatternId);*/
	public String getStudentRegistrationIdFromUniqueId(String uniqueIdentificationId,String defaultGuestUserId);
	public String getStudentRegistrationIdFromUniqueStudentId(String uniqueIdentificationId, String instituteId);
	public String associateStudent(String studentRegistrationId,String registeredUserId,String loginId);
	public List getStudentRegistrationIdList(String registrationId);
	public List getStudentTranscationDetails(String registrationId, String studentRegistrationId);
	public String insertMemberRegDetails(BhuLoginActionFormBean bhuLoginActionFormBean);
	public String insertGNLUStudentDetails(GNLULoginActionFormBean gnluLoginActionFormBean,String billerId);
	public String getSpsApplicationNo(String uniqueIdentificationId,String defaultGuestUserId);
	public StudentRegistrationFormBean getSCIndiaAdmissionNo(String uniqueIdentificationId,String defaultGuestUserId);
	public String insertRamaStudentDetails(RamaCollageFormBean ramaCollageFormBean);
	public String insertIITMStudentDetails(RamaCollageFormBean ramaCollageFormBean,String billerId);
	public RamaCollageFormBeanResponse getRamaStudentDetails(String ApplicationNo);
	public String insertIMSStudentDetails(IMSUniversityFormBean imsUniversityFormBean);
	public List<String> getOnlineInstituteAmountList(String billerId);
	public String insertHIMStudentDetails(HIMAFormBean himaFormBean,String instituteId);
	public String insertIITBStudentDetails(IITBActionFormBean iitbActionFormBean);
	public String insertIITBPostHistoryDetails(IITBPostEmpHistoryFormBean iitbPostEmpHistoryFormBean,String registerId);
	public String insertIITBAccomplishmentDetails(IITBAccomplishmentFormBean iitbAccomplishmentFormBean,String registerId);
	public HIMAFormBean getHimaStudentDetails(String ApplicationNo);
	public String insertMadhbStudentDetails(MadhavbaugCollageFormBean madhavbaugCollageFormBean);
	public IITBActionFormBean getIIITBStudentDetails(String ApplicationNo);
	public List<IITBPostEmpHistoryFormBean> getIITBPostHistoryDetails(String ApplicationNo);
	public List<IITBAccomplishmentFormBean> getIITBAccomplishmentDetails(String ApplicationNo);
	public String insertBimtStudentDetails(BIMTExistingFormbean bimtExistingFormbean);
	public BIMTExistingFormbean getBimtStudentDetails(String applicationNo);
	public String insertBIMTStudentDetails(BIMTFormBean bimtFormBean,String instituteId);
	public BIMTFormBean getBIMTSudentDetails(String registeredUserId, String courseAppliedFor,String applicationNo);
	public String insertWBUTEAStudentDetails(WBUTUniversityFormBean wbutUniversityFormBean,String instituteId);
	public WBUTUniversityFormBean getWbutStudentDetails(String applicationNo);
	public String insertUnisonStudentDetails(UnisonFormBean unisonFormBean,String instituteId);
	public String insertIIMLStudentDetails(IIMLOnlineFormBean iimlOnlineFormBean,String instituteId);
	public String insertIimlSubjectMarkDetails(IIMLSubjectMarkFormBean iimlSubjectMarkFormBean,String ApplicationNo);
	public IIMLOnlineFormBean getIIMLStudentDetails(String applicationNo);
	public List<IIMLSubjectMarkFormBean> getIIMLSubjectDetails(String ApplicationNo);
	public String insertGPSStudentDetails(GPSOnlineFormBean gpsOnlineFormBean,String instituteId);
	public GPSOnlineFormBean getGPSStudentDetails(String applicationNo);
	public List<String> insertSpringDaleStudentDetails(
			SpringDaleStudentFormBean springDaleStudentFormBean, String billerId);
	public String updateOnlineInstitutePaymentStatus(String instCode,String applicationNo, String paymentId,String transactionDateTime, String transactionId, String paymentMode, String errorCode, String errorDesc, String transactionAmount);
	public String insertGLAUniversityStudentDetails(
			GLAUniversityStudentFormBean glaUniversityStudentFormBean,
			String billerId);
	public String insertGpullaReadyStudentDetails(GpullaReadyFormBean gpullaReadyFormBean,String instituteId);
	public GpullaReadyFormBean getGpullaReddyStudentdetails(String applicationNo);
	public String insertYMCAStudentDetails(YMCAOnlineFormBean ymcaOnlineFormBean,String instituteId);
	public String insertYMCAEducationDetails(EducationDetailsFormbean educationDetailsFormbean,String ApplicationNo);
	public YMCAOnlineFormBean getYMCAStudentDetails(String applicationNo);
	public List<EducationDetailsFormbean> getYMCAEducationDetails(String ApplicationNo);
	public String insertNehuStudentDetails(NEHUFormBean nehuFormBean,String instituteId);
	public NEHUFormBean getNehuStudentdetails(String applicationNo);
	public String insertIIMMLStudentDetails(IIMLucknowFormBean iimlucknowFormBean,String instituteId);
	public IIMLucknowFormBean getIIMLucknowStudentdetails(String applicationNo);
	public URLInstituteResponseBean fetchInstituteSuccessTransReport(String instituteId, String fromDate, String toDate);
	public String insertNITMeghStudentDetails(NITOnlineFormBean nitOnlineFormBean,String instituteId);
	public NITOnlineFormBean getNITMeghStudentDetails(String applicationNo);
	public String insertCampionSchoolDetails(CampionSchoolFormBean campionSchoolFormBean, String instituteId);
	public CampionSchoolFormBean getCampionStudentDetails(String applicationNo);
	public String insertHaryanaStudentDetails(HaryanaFormBean haryanaFormBean,String instituteId);
	public HaryanaFormBean getHaryanaStudentdetails(String applicationNo);	
	public String insertBengalCollegeDetails(BengalCollegeOnlineFormBean bengalCollegeOnlineFormBean,String instituteId);
	public BengalCollegeOnlineFormBean loadBengalData(String applicationNo,String instituteCode);	
	public String getvalidateCBSData(String uniqueIdentificationId,String defaultGuestUserId,String instId);
	public String insertHaryanaEducationDetails(EducationHaryanaFormBean educationHaryanaFormBean,String ApplicationNo);
	public List<EducationHaryanaFormBean> getHaryanaEducationDetails(String ApplicationNo);	
	public String insertGLAUniversityStudentDetails(URLInstituteRequestBean glaUniversityStudentFormBean,String billerId);
	public DYPatilResponseBean fetchInstituteDYPatilReport(String instId,
			String merchantID, String merchantTxnRefNumber, String date);
	 public String insertYMCAAllStudentDetails(YMCAOnlineFormBean ymcaOnlineFormBean,String instituteId);
	 public YMCAOnlineFormBean getYMCAAllStudentDetails(String applicationNo);
	 public String insertBSEStudentDetails(BSEFormBean bseFormBean,String instituteId);
	 public BSEFormBean getBSEStudentdetails(String applicationNo);		 
	public String insertWelhamSchoolDetails(WelhamSchoolFormBean welhamSchoolFormBean,String instituteId);
	public WelhamSchoolFormBean getWelhamSchoolDetails(String applicationNo);
	public ChallanOTPProcessBean fetchIITVFees(String FeePayId,String FeeType, String studentcategory);
	public String insertNIPRStudentDetails(NIPROnlineFormBean niprOnlineFormBean,String instituteId);
	public NIPROnlineFormBean getNIPRSchoolDetails(String applicationNo);
	public String insertMGRStudentDetails(MGRMedicalOnlineFormBean mgrMedicalOnlineFormBean,String instituteId);
	public String insertFeeHeadDetails(FeeHeadFormbean feeHeadFormbean,String applicationNo);
	public MGRMedicalOnlineFormBean getMGRStudentDetails(String applicationNo);
	public List<FeeHeadFormbean> getFeeHeadDetails(String applicationNo);
	public String insertSCIStudentDetails(SCIOnlineFormBean sciOnlineFormBean,String instituteId);
	public String insertSCICourseDetails(SCICourseNameFormBean sciCourseNameFormBean,String applicationNo);
	public SCIOnlineFormBean getSCIStudentDetails(String applicationNo);
	public List<SCICourseNameFormBean> getSCICourseDetails(String applicationNo,String tranStatus);
	public Map getStudIdExpDate(String uniqueIdentificationId);
	public String updatePayLaterDate(Map<String, String> res,String uniqueIdentificationId, String paylater, String yes);
	public void getCountofPayLaterDatesUpdated(StudentRegistrationFormBean studentRegistrationFormBean);
	public String updateRSSTFees(String uniqueIdentificationId,String admissionType, String section);
	public String insertPTUStudentDetails(PTUOnlineFormBean ptuOnlineFormBean,String instituteId);
	public String insertPTUFeeHeadDetails(FeeHeadFormbean feeHeadFormbean,String applicationNo);
	public PTUOnlineFormBean getPTUStudentDetails(String applicationNo);
	public List<FeeHeadFormbean> getPTUFeeHeadDetails(String applicationNo);
	 public String insertAlgoStudentDetails(CandEntryForm candEntryForm,String instituteId);
	 public CandEntryForm getAngloSchoolDetails(String applicationNo);
	 public String insertUGIStudentDetails(UGIOnlineFormBean ugiOnlineFormBean,String instituteId);
	 public UGIOnlineFormBean getUGIStudentDetails(String applicationNo);
	 public String insertPMHPStudentDetails(UGIOnlineFormBean ugiOnlineFormBean,String instituteId);
	 public UGIOnlineFormBean getPMHPStudentDetails(String applicationNo);
	 public String insertDPSSKSStudentDetails(DPSSKSOnlineFormBean dpssksOnlineFormBean,String instituteId);
	 public String insertDPSSKSClassDetails(DPSSKSDetailsFormBean dpssksDetailsFormBean,String applicationNo);
	 public DPSSKSOnlineFormBean getDPSSKSStudentDetails(String applicationNo);
	 public List<DPSSKSDetailsFormBean> getDPSSKS_ClassDetails(String applicationNo);
	 public String insertDOONStudentDetails(DOONOnlineFormBean DOONOnlineFormBean,String instituteId);
	 public DOONOnlineFormBean getDOONStudentDetails(String applicationNo);
	 public String insertJRSTStudentDetails(JRSTOnlineFormBean jrstOnlineFormBean,String instituteId);
	 public JRSTOnlineFormBean getJRSTStudentDetails(String applicationNo);
	 public String insertMGCStudentDetails(MGCOnlineFormBean mgcOnlineFormBean,String instituteId);
	 public MGCOnlineFormBean getMGCStudentDetails(String applicationNo);
	 public String insertDBHPStudentDetails(HPSMasterFormBean hpsMasterFormBean,String instituteId);
	 public HPSMasterFormBean getDBHPStudentDetails(String applicationNo);
	 public String insertNISMStudentDetails(NISMOnlineFormBean nismOnlineFormBean,String instituteId);
	 public NISMOnlineFormBean getNismStudentDetails(String applicationNo);
	 public String insertNISMParticipantDetails(NISMParticipantFormBean nismParticipantFormBean,String ApplicationNo);
	 public List<NISMParticipantFormBean> getNISMParticiptDetails(String ApplicationNo);		 
	 public String insertDOTUStudentDetails(DOTUOnlineFormBean dotuOnlineFormBean,String instituteId);
	 public DOTUOnlineFormBean getDOTUStudentDetails(String applicationNo);
	 public String insertKaushalyaStudentDetails(KaushalyaFormBean kaushalyaFormBean,String instituteId);
	 public KaushalyaFormBean getKAUSHStudentDetails(String applicationNo);
	 public String insertRPTMStudentDetails(RPTMOnlineFormBean rptmOnlineFormBean,String instituteId);
	 public RPTMOnlineFormBean getRPTMStudentDetails(String applicationNo);
	 public List<NISMOnlineFormBean> getNoteListData(String id);	
	 public String insertRUNGTAStudentDetails(RungtanlineFormBean rungtanlineFormBean,String instituteId);
	 public RungtanlineFormBean getRUNGTAStudentDetails(String applicationNo);
	 public List<SCICourseNameFormBean> fetchSCICourseDetails();
	 public UnisonFormBean getUnisonStudentDetails(String applicationNo,String instCode);
	 public String insertChristineStudentDetails(ChristineOnlineFormBean christineOnlineFormBean,String instituteId);
	 public String insertChristinefeeDetails(form form1,String ApplicationNo);
	 public ChristineOnlineFormBean getChristineStudentDetails(String applicationNo);
	 public String insertBKLIStudentDetails(BKLIOnlineFormBean bkliOnlineFormBean,String instituteId);
	 public BKLIOnlineFormBean getBKLIStudentDetails(String applicationNo,String tranStatus);
	 public String insertMATSStudentDetails(MATSFeesForm matsFeesForm,String instituteId);
	 public MATSFeesForm getMATSStudentDetails(String applicationNo,String instituteCode);	 
	 public String insertBSPRStudentDetails(BSPROnlineFormBean bsprOnlineFormBean,String instituteId);
	 public BSPROnlineFormBean getBSPRStudentDetails(String applicationNo,String tranStatus);
	 public String insertSHARPStudentDetails(SharpmindsOnlineFormBean sharpmindsOnlineFormBean,String instituteId);
	 public SharpmindsOnlineFormBean getSHARPStudentDetails(String applicationNo);
	 public String insertBKLIAdminData(BKLIOnlineFormBean bkliOnlineFormBean,String instituteId);	
	 public String insertSaarcStudentDetails(SaarcOnlineFormBean saarcOnlineFormBean,String instituteId);
	 public SaarcOnlineFormBean getSaarcStudentDetails(String applicationNo);
	 public String insertExistSaarcStudentDetails(SAARCExistOnlineFormBean saarcExistOnlineFormBean,String instituteId);
	 public String insertExistSaarcGridDetails(SAARCExistGridFormBean saarcExistGridFormBean,String applicationNo);
	 public SAARCExistOnlineFormBean getSAARCExistStudentDetails(String applicationNo);
	 public List getSAARC_GridDetails(String applicationNo);
	 public String insertSaarcSusStudentDetails(SAARCExistOnlineFormBean saarcExistOnlineFormBean,String instituteId);
	 public String insertSaarcSustainerGridDetails(SAARCExistGridFormBean saarcExistGridFormBean,String applicationNo);
	 public SAARCExistOnlineFormBean getSAARCSustainerStudentDetails(String applicationNo);
	 public List getSAARCSustainerGridDetails(String applicationNo);
	public String insertEtoosStudentDetails(EtoosOnlineFormBean etoosOnlineFormBean, String billerId);
	public EtoosOnlineFormBean getEtoosStudentDetails(String applicationNo);
 	public String insertIibmsStudentDetails(IIBMSFormBean iibmsOnlineFormBean, String billerId);
	 public IIBMSFormBean getIibmdStudentDetails(String applicationNo);

	 public String insertPPAStudentDetails(PPAFormBean ppaOnlineFormBean, String billerId);
	 public PPAFormBean getPPAStudentDetails(String applicationNo);
	 public String insertOrigenceStudentDetails(OrigenceOnlineFormBean origenceOnlineFormBean, String billerId);
	 public OrigenceOnlineFormBean getOrigenceStudentDetails(String applicationNo);
	 public String insertPrincipalStudentDetails(PrincipalAIAFormBean principalOnlineFormBean, String billerId); 
	 public PrincipalAIAFormBean getPrincipalStudentDetails(String applicationNo);
	 public List<INTLCourseFormBean> fetchINTLCourseDetails();
	 public String insertINTLStudentDetails(INTLOnlineFormBean intlOnlineFormBean,String instituteId);
	 public String insertINTLCourseDetails(INTLCourseFormBean intlCourseFormBean,String applicationNo);
	 public INTLOnlineFormBean getINTLStudentDetails(String applicationNo);
	 public List<INTLCourseFormBean> getINTLCourseDetails(String applicationNo);
	 public String insertJayotiStudentDetails(JayotiFormBean jayotiFormBean, String billerId); 
	 public JayotiFormBean getJayotiStudentDetails(String applicationNo);
	 public String insertLanStudentDetails(LanOnlineFormBean lanOnlineFormBean,String billerId);
	 public LanOnlineFormBean getLanStudentDetails(String applicationNo);
	 public String insertNatlStudentDetails(NATLOnlineFormBean natlOnlineFormBean,String billerId);
	 public NATLOnlineFormBean getNatlStudentDetails(String applicationNo);
	public String insertRpsStudentDetails(RpsFormBean rpsFormBean,String billerId);
	public RpsFormBean getRpsStudentDetails(String applicationNo);
	public String insertRungtaColStudentDetails(RungtaCollegeFormBean rungtaCollegeFormBean,String instituteID);
	public RungtaCollegeFormBean getRungtaColStudentDetails(String applicationNo,String instituteCode);
	public String insertDTEStudentDetails(DTEFormBean dteFormBean,String billerId);
	public DTEFormBean getDTEStudentDetails(String applicationNo,String instituteCode);
	public String validateDTEAdmin(String userName, String password);
	public Map<String,String> getFreshCourseList(String freshAdmissionTypeId);
	public Map<String, String> getAdmissionTypeList();
	public Map<String, String> getCollegeList(String courseId);
	public Map<String, String> getBranchList(String collegeId);
	public Map<String, String> getCategoryList(String collegeId);
	public String getAmountByCategory(String collegeId, String categoryId);
	public String insertSWARAStudentDetails(SWARAFormBean swaraFormBean,String instituteID);
	public SWARAFormBean getSWARAStudentDetails(String applicationNo);
	public String insertTOLANIStudentDetails(TOLANIFormBean tolaniFormBean,String instituteID);
	public TOLANIFormBean getTOLANIStudentDetails(String applicationNo);
	public ArrayList<String> getApplicationNumberList(String instituteCode);
	public ArrayList<String> getDueDateList(String applicationNo,String instituteCode);
	public String insertSHIVStudentDetails(SHIVFormBean shivFormBean,String instituteID);
	public SHIVFormBean getSHIVStudentDetails(String applicationNo);
	public Map<String, String> getCourseList();
//	public ArrayList<String> getDurationList(String courseId);
	public SHIVFormBean getDurationList(String courseId);
	
	public String insertLiveWireStudentDetails(LiveWireOnlineFormBean liveWireOnlineFormBean, String billerId);
	public LiveWireOnlineFormBean getLiveWireStudentDetails(String applicationNo);
	public String insertHydroPowerStudentDetails(HydroPowerOnlineFormBean hydroPowerOnlineFormBean, String billerId);
	public HydroPowerOnlineFormBean getHydroPowerStudentDetails(String applicationNo,String instituteCode);
	public String insertAmbikaPurStudentDetails(AmbikapurOnlineFormBean ambikaPurOnlineFormBean, String billerId);
	public AmbikapurOnlineFormBean getAmbikapurStudentDetails(String applicationNo,String instituteCode);
	public String	getAmbikaStudentFees(String coursetype,String gendertype, String categorytype);
	public String insertICBRStudentDetails(ICBROnlineFormBean icbrOnlineFormBean, String billerId);
	public ICBROnlineFormBean getICBRStudentDetails(String applicationNo,String instituteCode);
	public String insertRamanujanAAStudentDetails(RamanujanAAOnlineFormBean ramanujanAAOnlineFormBean,String billerId);
	public RamanujanAAOnlineFormBean getRamanujanAAStudentDetails(String applicationNo);
	public ShepaOnlineFormBean getShepaStudentDetails(String applicationNo);
	public String insertShepaStudentDetails(ShepaOnlineFormBean shepaOnlineFormBean,String billerId);
	//CR KASHI STARTS
	public KASHIFormBean getKASHIStudentDetails(String applicationNo);
	public String insertKASHIStudentDetails(KASHIFormBean kashiFormBean,String instituteID);
	//CR KASHI ENDS
	public String insertWeinderStudentDetails(WeidnerOnlineFormBean weinderOnlineFormBean,String billerId);
	public WeidnerOnlineFormBean getWeidnerStudentDetails(String applicationNo,String instituteCode);
	public String insertFinolexStudentDetails(FinolexOnlineFormBean finolexOnlineFormBean,String billerId);
	public FinolexOnlineFormBean getFinolexStudentDetails(String applicationNo,String instituteCode);
	public Map<String,String> getFinolexInstituteStudentFees(String finolexadmissionType,String finolexadmissionTo);
	public Map<String,String>  FetchFinolexStuFees_catWise(String finolexadmissionCategory,String finolexadmissionTo);
	public String	getPrincipalUpStudentFees(String coursetype,String gendertype,String practicals,String yearOfStudy,String course);
	public PrincipalUPOnlineFormBean getPrincipalUpStudentDetails(String applicationNo);
	public String insertPrincipalStudentDetails(PrincipalUPOnlineFormBean principalUPOnlineFormBean,String billerId);
	public ShepaOnlineFormBean getYugantarStudentDetails(String applicationNo,String instituteCode);
	public String insertYugantarStudentDetails(ShepaOnlineFormBean shepaOnlineFormBean,String billerId);
	public String insertKrishakStudentDetails(KRISHAKFormBean krishakFormBean,String billerId);
	public KRISHAKFormBean getKrishakStudentDetails(String applicationNo,String instituteCode);
	public String insertHnbguStudentDetails(HNBGUFormBean hNBGUFormDean,String billerId);
	public HNBGUFormBean getHNBGUStudentDetails(String applicationNo,String instituteCode);
	public Map<String,String> getHNBGUCourseFeesAmt(String className1,String cgroup1,String semester1,String typesOfStd);
	public MahadeviYadavOnlineFormBean getMahadeviYadavStudentDetails(String applicationNo,String instituteCode);
	public String insertMahadeviYadavStudentDetails(MahadeviYadavOnlineFormBean mahadeviYadavOnlineFormBean,String billerId);
	public String insertAbhayStudentDetails(ABHAYFormBean abhayFormBean,String billerId);
	public ABHAYFormBean getAbhayStudentDetails(String applicationNo,String instituteCode);
	public String insertRajStudentDetails(RAJFormBean rajFormBean,
			String billerId);
	public RAJFormBean getRajStudentDetails(String applicationNo,String instituteCode);
	public String insertOercStudentDetails(OERCOnlineFormBean oercOnlineFormBean, String billerId);
	public OERCOnlineFormBean getOercStudentDetails(String applicationNo,String instituteCode);
	public String insertOercpStudentDetails(OERCPOnlineFormBean oercpOnlineFormBean, String billerId);
	public OERCPOnlineFormBean getOercpStudentDetails(String applicationNo);
	public StandfordOnlineFormBean getStandStudentDetails(String applicationNo,String instituteCode);
	public String insertStandStudentDetails(StandfordOnlineFormBean standfordOnlineFormBean, String billerId,String instcode);
	public String insertSheetlaStudentDetails(SheetlaOnlineFormBean sheetlaOnlineFormBean, String billerId);
	public SheetlaOnlineFormBean getSheetlaStudentDetails(String applicationNo,String instituteCode);
	public String insertMicronStudentDetails(MicronOnlineFormBean  micronOnlineFormBean, String billerId);
	public MicronOnlineFormBean getMicronStudentDetails(String applicationNo,String instituteCode);
	public String getMicronStudentFees(String PaymentCycle,String feecategory);
	public String insertGarawarStudentDetails(GaharwarOnlineFormBean  gaharwarOnlineFormBean, String billerId);
	public GaharwarOnlineFormBean getGarawarStudentDetails(String applicationNo,String instituteCode);
	public String insertNehuPayStudentDetails(NehuPayOnlineBean nehuPayOnlineBean, String billerId);
	public NehuPayOnlineBean getNehuPayStudentDetails(String applicationNo);
	public List<String> getNehuPayPaymentTypeList();
	public Map<String,String> getNehuPayPaymentTypeFeesList(String nehupayPaymentType);
	public String insertAllenInstituteDetails(ApiInstituteRequestBean[] apiInstituteRequestBean,String instCode);
	public ApiInstituteRequestBean getAllenStudentDetails(String fno);
	public String insertApiErrorCode(String institutecode, String status);
	public String insertLuciStudentDetails(LuciOnlineFormBean luciOnlineFormBean, String billerId);
	public LuciOnlineFormBean getLuciStudentDetails(String applicationNo,String instituteCode);
	public String insertOnlineGeetaColStudentDetails(GeetaCollegeOnlineFormBean geetaCollegeOnlineFormBean, String instituteId);
	public GeetaCollegeOnlineFormBean getGeetaColStudentDetails(String applicationNo);
	public Map<String, String> getChaduryCourseTypeList(String coursname);
	public String insertChaudharyCollegeStudentDetails(ChaudharyCollegeOnlineBean chaudharyCollegeOnlineBean, String billerId);
	public ChaudharyCollegeOnlineBean getchaduryColStudentDetails(String applicationNo);
	public String insertGSFCStudentDetails(GSFCOnlineFormBean gsfcOnlineFormBean, String instituteId);
	public GSFCOnlineFormBean getGSFCStudentDetails(String applicationNo);
	public Map<String, String> getChaduryAdmissionTypeList(String studentCategory,String coursname);
	public String insertChaudharyAdmissionStudentDetails(ChaudharyADMISSIONOnlineBean chaudharyADMISSIONOnlineBean, String billerId);
	public ChaudharyADMISSIONOnlineBean getChaudharyAdmissionStudentDetails(String applicationNo);
	public String insertChaudharyMiscellanouStudentDetails(ChaudharyMiscellanousOnlineBean chaudharyMiscellanousOnlineBean, String billerId);
	public ChaudharyMiscellanousOnlineBean getChaudharyMiscellanousStudentDetails(String applicationNo);
	public String insertNLUStudentDetails(NLUOnlineFormBean nluOnlineFormBean, String billerId);
	public NLUOnlineFormBean getNLUStudentDetails(String applicationNo);
	public String insertDPSCStudentDetails(DPSCOnlineFormBean dpscOnlineFormBean, String billerId);
	public DPSCOnlineFormBean getDPSCStudentDetails(String applicationNo);
    public String insertChauFeeDetails(ChaudharyCollegeOnlineBeanGrid chaudharyCollegeOnlineBeanGrid,String ApplicationNo);
    public String insertNLU1StudentDetails(NLUOnlineFormBean nluOnlineFormBean, String billerId);
	public NLUOnlineFormBean getNLU1StudentDetails(String applicationNo);
	public String insertAmricanStudentDetails(AmericanOnlineFormBean americanOnlineFormBean, String billerId);
    public AmericanOnlineFormBean getAmricanStudentDetails(String applicationNo);
	public String insertPathFinderStudentDetails(PathFinderOnlineFormBean pathFinderOnlineFormBean, String billerId);
	public PathFinderOnlineFormBean getpathFinderStudentDetails(String applicationNo);
	public String insertKashiTechnologyStudentDetails(FeesForm feesForm, String billerId);
	public FeesForm getKashiTechnologyStudentDetails(String applicationNo);
	public String insertThangamInnovativeStudentDetails(ThangamInnovativeOnlineFormBean thangamInnovativeOnlineFormBean, String billerId);
	public ThangamInnovativeOnlineFormBean getThangamInnovativeStudentDetails(String applicationNo);
	public String insertThangamKidzeeStudentDetails(ThangamKidzeeOnlineFormBean thangamKidzeeOnlineFormBean, String billerId);
	public ThangamKidzeeOnlineFormBean getThangamKidzeeStudentDetails(String applicationNo);
	public String insertCUOHaryanaStudentDetails(CUOHaryanaOnlineFormBean CuoHaryanaOnlineFormBean, String billerId);
	public CUOHaryanaOnlineFormBean getCUOHaryanaStudentDetails(String applicationNo);
	public ArrayList getAllStatesName();
	public String insertCUOKashmirStudentDetails(CUOKashmirOnlineFormBean cuoKashmirFormBean, String billerId);
	public CUOKashmirOnlineFormBean getCUOKashmirStudentDetails(String applicationNo);
	public String insertRoyalDentalStudentDetails(RoyalDentalOnlineFormBean royalDentalOnlineFormBean, String billerId);	
	public RoyalDentalOnlineFormBean getRoyalDentalStudentDetails(String applicationNo);
	public String insertVishalInstituteStudentDetails(VishalInstOnlineFormBean vishalInstOnlineFormBean,String billerId);
	public VishalInstOnlineFormBean getVishalInstStudentDetails(String applicationNo);
	public String insertFeePaymentStudentDetails(FeePaymentOnlineFormBean feePaymentOnlineFormBean,String billerId);
	public FeePaymentOnlineFormBean getFeePaymentStudentDetails(String applicationNo);
	public String insertFeePayment1StudentDetails(FeePayment1OnlineFormBean feePayment1OnlineFormBean,String billerId);
	public FeePayment1OnlineFormBean getFeePayment1StudentDetails(String applicationNo);
	public String insertJayshreePeriwalStudentDetails(JayshreePeriwalOnlineFormBean jayshreePeriwalOnlineFormBean,String billerId);
	public JayshreePeriwalOnlineFormBean getJayshreePeriwalStudentDetails(String applicationNo);
	public String insertJayshreePeriStudentDetails(JayshreePeriOnlineFormBean jayshreePeriOnlineFormBean,String billerId);
	public JayshreePeriOnlineFormBean getJayshreePeriStudentDetails(String applicationNo);
	public String insertLancersSchoolStudentDetails(LancersOnlineFormBean lancersOnlineFormBean,String billerId);
	public LancersOnlineFormBean getLancersStudentDetails(String applicationNo);
	public String insertKrishnaLawStudentDetails(KrishnaLawOnlineFormBean krishnaLawOnlineFormBean,String billerId);
	public KrishnaLawOnlineFormBean getKrishnaLawStudentDetails(String applicationNo);
	// for dps Budgam
		public String insertdpsBudgamDetails(DpsBudgamOnlineFormBean dpsBudgamOnlineFormBean,String billerId);
		public DpsBudgamOnlineFormBean getDpsBudgamStudentDetails(String applicationNo);
		//----end
	public String insertKulluStudentDetails(KulluOnlineFormBean kulluOnlineFormBean,String billerId);
	public KulluOnlineFormBean getKulluStudentDetails(String applicationNo);
	public String insertBiyaniStudentDetails(BiyaniOnlineFormBean biyaniOnlineFormBean,String billerId);
	public BiyaniOnlineFormBean getBiyaniStudentDetails(String applicationNo);
	public String insertShrirRamEducationalDetails(ShriRamEducationalOnlineFormBean shriRamEducationalOnlineFormBean,String billerId);
	public ShriRamEducationalOnlineFormBean getShriRamEducationalDetails(String applicationNo);
	public String insertTeamWorkEducationDetails(TeamworkEducationOnlineFormBean teamworkEducationOnlineFormBean,String billerId);
	public TeamworkEducationOnlineFormBean getTeamworkEducationDetails(String applicationNo);
	public String insertJbciStudentDetails(JBCIOnlineFormBean jbciOnlineFormBean,String billerId);
	public JBCIOnlineFormBean getJbciStudentDetails(String applicationNo);
	public String insertAbdulKalamDetails(AbdulKalamOnlineFormBean abdulKalamOnlineFormBean,String billerId);
	public AbdulKalamOnlineFormBean getAbdulKalamDetails(String applicationNo);
	public String insertJainSubodhDetails(
			SSJainSubodhOnlineFormBean jainSubodhOnlineFormBean,String billerId);
	public SSJainSubodhOnlineFormBean getJainSubodhDetails(String applicationNo);
	
	public String insertNaiminathDetails(NaiminathOnlineFormBean naiminathOnlineFormBean, String billerId);
	public NaiminathOnlineFormBean getNaiminathDetails(String applicationNo);
	
	public String insertSPHSchoolDetails(SPHSchoolOnlineFormBean sphSchoolOnlineFormBean, String billerId);
	public SPHSchoolOnlineFormBean getSPHSchoolDetails(String applicationNo);
	
	public String insertGOENKADetails(GOENKAOnlineFormBean goenkaOnlineFormBean, String billerId);
	public GOENKAOnlineFormBean getGoenkaStudentDetails(String applicationNo);
	public String insertGRCosmicStudentDetails(GRCosmicOnlineFormBean grCosmicOnlineFormBean, String billerId);
	public GRCosmicOnlineFormBean getGRCosmicStudentDetails(String applicationNo);
	public String insertSwamiTempleDetails(SwamiTempleOnlineFormBean swamiTempleOnlineFormBean, String billerId);
	public SwamiTempleOnlineFormBean getSwamiTempleDetails(String applicationNo);
	public String insertPrarambhDetails(PrarambhOnlineFormBean prarambhOnlineFormBean, String billerId);
	public PrarambhOnlineFormBean getPrarambhDetails(String applicationNo);
	public String insertPrarambhFeeDetailsDetails(PraramFeeDetailsBean praramFeeDetailsBean,String applicationNo,String billerId);
	public ArrayList<PraramFeeDetailsBean> getPrarambhFeeDetails(String applicationNo);
	public  String getNIPRAmount(String Department,String currency,String fixDate);
	public String insertShmshiDetails(ShmshiOnlineFormBean shmshiOnlineFormBean,String billerId);
	public ShmshiOnlineFormBean getShmshiStudentDetails(String applicationNo);
	public String insertRajashtanDetails(RajsthanOnlineFormBean rajsthanOnlineFormBean,String billerId);
	public RajsthanOnlineFormBean getRajsthanStudentDetails(String applicationNo);
	public String insertUDAIPURDetails(UDAIPUROnlineFormBean udaipurOnlineFormBean, String billerId);
	public UDAIPUROnlineFormBean getUDAIPURStudentDetails(String applicationNo);
	public String insertRatanalaDetails(RatanalaOnlineFormBean ratanalaOnlineFormBean, String billerId);
	public RatanalaOnlineFormBean getRatanalaStudentDetails(String applicationNo);
	public String insertVenkatEduDetails(VenkatEduOnlineFormBean venkatEduOnlineFormBean,String billerId);
	public VenkatEduOnlineFormBean getVenkatEduStudentDetails(String applicationNo);
	public String insertMahaEduDetails(MahaEduOnlineFormBean mahaEduOnlineFormBean,String billerId);
	public MahaEduOnlineFormBean getMahaEduStudentDetails(String applicationNo);
	public String insertAsianDetails(AsianOnlineFormBean asianOnlineFormBean,String billerId);
	public AsianOnlineFormBean getAsianStudentDetails(String applicationNo);
	public String insertSmartrepEdu(SmartrepEductionOnlineFormBean smartrepEductionOnlineFormBean,String billerId);
	public SmartrepEductionOnlineFormBean getSmartrepEduDetails(String applicationNo);
	public String insertindianPoliticalDetails(IndianPoliticalOnlineFormBean indianPoliticalOnlineFormBean,String billerId);
	public IndianPoliticalOnlineFormBean getindianPoliticalStudentDetails(String applicationNo);
	public String insertMalwaDetails(MalwaFormBean malwaFormBean,String billerId);
	public MalwaFormBean getMalwaStudentDetails(String applicationNo);
	public String insertKashiDetails(KashiInstituteFormBean kashiFormBean,String instituteId);
	public KashiInstituteFormBean getKashiStudentDetails(String applicationNo);
	public String insertSuccessEaseDetails(SuccessEaseFormBean successEaseFormBeanFormBean,String instituteId);
	public SuccessEaseFormBean getSuccessEaseStudentDetails(String applicationNo);
	public String insertSISDetails(SISFormBean sisFormBean,String instituteId);
	public SISFormBean getSISStudentDetails(String applicationNo);
	public String insertHorizonDetails(HorizonOnlineFormBean horizonOnlineFormBean,String instituteId);
	public HorizonOnlineFormBean getHorizonStudentDetails(String applicationNo);
	public HorizonOnlineFormBean getHorizonStudentDetails_Ereceipt(String applicationNo);
	public String insertIICSEdu(IICSEductionOnlineFormBean iicsEductionOnlineFormBean,String billerId);
	public IICSEductionOnlineFormBean getIICSStudentDetails(String applicationNo);
	public String insertJawaharStudent(JawaharOnlineFormBean jawaharOnlineFormBean,String billerId);
	public JawaharOnlineFormBean getJawaharStudentDetails(String applicationNo);
	public String insertVenkateshwarStudent(VenkateshwarOnlineFormBean venkateshwarOnlineFormBean,String billerId);
	public VenkateshwarOnlineFormBean getvenkateshwarStudentDetails(String applicationNo);
	public String insertDelhiSchool(DelhiSchoolOnlineFormBean delhiSchoolOnlineFormBean,String billerId);
	public DelhiSchoolOnlineFormBean getDelhiSchoolStudentDetails(String applicationNo);
	public String insertBrainStormEaseDetails(BrainStormFormBean brainStormFormBean,String billerId);
	public BrainStormFormBean getbrainStormStudentDetails(String applicationNo);
	public List getStudentTranDetailsList_Lukhnow(String aadharNo,String branchId);
	//Ice 
	public String insertIceDetails(IceonlineFormBean iceBean,String billerId);
	public IceonlineFormBean getICEStudentDetails(String applicationNo);
	public String insertIEIIndiaDetails(IEIIndiaOnlineFormBean ieiIndiaOnlineFormBean,String billerId);
	public IEIIndiaOnlineFormBean getIEIStudentDetails(String applicationNo);
	public String insertNavJagritiDetails(NavJagritiOnlineFormBean navJagritiBean,String billerId);
	public NavJagritiOnlineFormBean getNavJagritiStudentDetails(String applicationNo);
	public String insertBhartiConceptDetails(BhartiConceptFormBean bhartiConceptFormBean,String billerId);
	public BhartiConceptFormBean getBhartiConceptStudentDetails(String applicationNo);
	public String insertTrinityDetails(TrinityOnlineFormBean trinityBean,String billerId);
	public TrinityOnlineFormBean getTrinityStudentDetails(String applicationNo);
	public String insertRoorkeeDetails(RoorkeeOnlineFornBean roorkeeOnlineFornBean,String billerId);
	public RoorkeeOnlineFornBean getRoorkeeStudentDetails(String applicationNo);
	public String insertJawaharNavodayaVidyalayaMaharajganjDetails(JawaharNavodayaVidyalayaMaharajganjFormBean jawaharNavodayaVidyalayaMaharajganjFormBean,String billerId);
	public JawaharNavodayaVidyalayaMaharajganjFormBean getJawaharNavodayaVidyalayaMaharajganjDetails(String applicationNo);
	public String insertJawaharNavodayaVidyalayaMauDetails(JawaharNavodayaVidyalayaMauFormBean jawaharNavodayaVidyalayaMauFormBean,String billerId);
	public JawaharNavodayaVidyalayaMauFormBean getJawaharNavodayaVidyalayaMauDetails(String applicationNo);
	public String insertIndraprasthAeronauticsDetails(IndraprasthAeronauticsFormBean indraprasthAeronauticsFormBean,String billerId);
	public IndraprasthAeronauticsFormBean getIndraprasthAeronauticsDetails(String applicationNo);

	public String insertDronacharyaDetails(DronacharyaOnlineFormBean dronacharyaOnlineFormBean, String billerId);

	public DronacharyaOnlineFormBean getDronacharyaDetails(String applicationNo);

	public String insertEduncleDetails(EduncleOnlineFormBean eduncleOnlineFormBean, String billerId);

	public EduncleOnlineFormBean getEduncleDetails(String applicationNo);
	
	public String insertDpsPanipatDetails(DpsPanipatOnlineFormBean dpsPanipatOnlineFormBean, String billerId);

	public DpsPanipatOnlineFormBean getDpsPanipatStudentDetails(String applicationNo);
	
	public String insertToyotaWebinarDetails(ToyotaOnlineFormBean toyotaOnlineFormBean,String billerId);
	public ToyotaOnlineFormBean getToyotaWebinarDetails(String applicationNo);
	
	public String insertDronacharyaGOIstudentDetails(DronacharyaGOIOnlineFormBean dronacharyaGOIOnlineFormBean, String billerId);

//	public DronacharyaGOIOnlineFormBean getDronacharyaGOIstudentDetails(String AppNo, String institute_id, InstituteFormDetailsBean instituteFormDetailsBean);
	
	public DronacharyaGOIOnlineFormBean getDronacharyaGOIstudentDetails(String AppNo,String instituteCode);
	
	public String insertAlmAcademystudentDetails(AlmAcademyOnlineFormBean almAcademyOnlineFormBean, String billerId);

	public AlmAcademyOnlineFormBean getAlmAcademystudentDetails(String applicationNo);
	public List getStudentTranDetailsList_NLUEreceipt(String referenceId,String branchId);
	public NLUOnlineFormBean getNLUStudentDetails_EreceiptData(String applicationNo);
	
	public List getStudentTranDetailsList_UGIEreceipt(String referenceId,String branchId);
	public UGIOnlineFormBean getUGIStudentDetails_EreceiptData(String applicationNo);
	
	
	public String insertHisarSchoolDetails(HisarSchoolOnlineFormBean hisarSchoolOnlineFormBean, String billerId);
	public HisarSchoolOnlineFormBean getHisarSchoolDetails(String applicationNo);
	
	public String insertAPSNoidaDetails(NoidaApsOnlineFormBean noidaApsOnlineFormBean, String billerId);
	public NoidaApsOnlineFormBean getAPSNoidaDetails(String applicationNo);
	
	public String insertDAVSchoolDetails(DAVSchoolOnlineFormBean davschoolOnlineFormBean, String billerId);
	public DAVSchoolOnlineFormBean getDAVSchoolDetails(String applicationNo);
	
	public String insertSatyavatiSchoolDetails(SatyavatiSchoolOnlineFormBean satyavatischoolOnlineFormBean, String billerId);
	public SatyavatiSchoolOnlineFormBean getSatyavatiSchoolDetails(String applicationNo);
	
	

	public String insertSriAurobindoSchoolDetails(SriAurobindoSchoolOnlineFormBean sriAurobindoSchoolOnlineFormBean, String billerId);
	public SriAurobindoSchoolOnlineFormBean getSriAurobindoDetails(String applicationNo);
	
	public String insertGoldCroftDetails(GoldCroftOnlineFormBean goldcroftOnlineFormBean, String billerId);
	public GoldCroftOnlineFormBean getGoldCroftDetails(String applicationNo);
	
	
	
	
	public String insertDpsBudgamregistrationDetails(DpsBudgamRegistrationOnlineFormBean dpsBudgamRegistrationOnlineFormBean, String billerId);
	public DpsBudgamRegistrationOnlineFormBean getDpsBudgamRegistrationDetails(String applicationNo);
	
	
	public String insertInderPrasthaDetails(InderPrasthaOnlineFormBean inderPrasthaOnlineFormBean, String billerId);
	public InderPrasthaOnlineFormBean getInderPrasthaDetails(String applicationNo);
	
	public String insertInderPrasthaNewDetails(InderPrasthaNewOnlineFormBean inderPrasthaNewOnlineFormBean, String billerId);
	public InderPrasthaNewOnlineFormBean getInderPrasthaNewDetails(String applicationNo);
	
	
	public String insertInderPrasthaExistDetails(InderPrasthaExistOnlineFormBean inderPrasthaExistOnlineFormBean, String billerId);
	public InderPrasthaExistOnlineFormBean getInderPrasthaExistDetails(String applicationNo);
	public InderPrasthaExistOnlineFormBean FetchInderPrastaExistData(String rollNo) ;
	public InstituteFormDetailsBean getInstituteFormDetails(String billerId);
	public String getInstituteId(String instituteCode);
	public String getMerchantId(String instCode) ;
	
	
	
	
}

 

