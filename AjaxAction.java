/*      */ package com.app.feejunction.action;
/*      */ 
/*      */ import com.Decryption;
/*      */ import com.app.feejunction.bean.AddChallanChargesBean;
/*      */ import com.app.feejunction.bean.CandEntryForm;
/*      */ import com.app.feejunction.bean.ChallanOTPProcessBean;
/*      */ import com.app.feejunction.bean.ChaudharyMiscellanousOnlineBean;
/*      */ import com.app.feejunction.bean.CourseDetailsBean;
/*      */ import com.app.feejunction.bean.FJBean;
/*      */ import com.app.feejunction.bean.FeesPayChargesFormBean;
/*      */ import com.app.feejunction.bean.InderPrasthaExistOnlineFormBean;
/*      */ import com.app.feejunction.bean.InstituteConfigBean;
/*      */ import com.app.feejunction.bean.InstituteMasterFormBean;
/*      */ import com.app.feejunction.bean.LoginActionFormBean;
/*      */ import com.app.feejunction.bean.NISMOnlineFormBean;
/*      */ import com.app.feejunction.bean.PathFinderOnlineFormBean;
/*      */ import com.app.feejunction.bean.PaymentRequestBean;
/*      */ import com.app.feejunction.bean.SHIVFormBean;
/*      */ import com.app.feejunction.bean.StudentFeesFormBean;
/*      */ import com.app.feejunction.bean.StudentRegistrationFormBean;
/*      */ import com.app.feejunction.helper.ChecksumGenerator;
/*      */ import com.app.feejunction.helper.HttpsClientSMS;
/*      */ import com.app.feejunction.service.ChallanHistoryService;
/*      */ import com.app.feejunction.service.CourseDetailsService;
/*      */ import com.app.feejunction.service.InstituteMasterActionService;
/*      */ import com.app.feejunction.service.LoginActionService;
/*      */ import com.app.feejunction.service.PaymentService;
/*      */ import com.app.feejunction.service.StudentDataService;
/*      */ import com.app.feejunction.service.StudentRegistrationService;
/*      */ import com.tpsl.emailsms.EmailSMSManager;
/*      */ import com.tpsl.util.DateUtil;
/*      */ import com.tpsl.util.PropertyReader;
/*      */ import java.text.MessageFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import org.slf4j.Logger;
/*      */ import org.slf4j.LoggerFactory;
/*      */ import org.slf4j.MDC;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class AjaxAction
/*      */   extends FJAction
/*      */ {
/*   58 */   private static final Logger logger = LoggerFactory.getLogger(AjaxAction.class);
/*   59 */   private static final Logger audit = LoggerFactory.getLogger("audit");
/*      */   
/*   61 */   private String courseID = "";
/*   62 */   private String courseDetailID = "";
/*   63 */   private String courseTypeID = "";
/*   64 */   private String branchID = "";
/*   65 */   private String studentId = "";
/*   66 */   private String transactionId = "";
/*   67 */   private String uniquiIdentificationId = "";
/*   68 */   private Map<String, String> mapCourseList = new LinkedHashMap<>();
/*   69 */   private Map<String, String> mapCourseDetailsList = new LinkedHashMap<>();
/*   70 */   private Map<String, String> mapCourseTypeList = new LinkedHashMap<>();
/*   71 */   private Map<String, String> mapCoursePatternList = new LinkedHashMap<>();
/*   72 */   private Map<String, String> mapCourseTermList = new LinkedHashMap<>();
/*   73 */   private Map<String, String> mapCourseYearList = new LinkedHashMap<>();
/*   74 */   private InstituteConfigBean instituteConfigBean = new InstituteConfigBean();
/*   75 */   CandEntryForm candEntryForm = new CandEntryForm();
/*      */   
/*   77 */   PathFinderOnlineFormBean pathFinderOnlineFormBean = new PathFinderOnlineFormBean();
/*   78 */   private String courseTypeDefaultValue = "";
/*   79 */   private String coursePatternDefaultValue = "";
/*   80 */   private String courseTermDefaultValue = "";
/*      */   
/*      */   CourseDetailsBean courseData;
/*      */   StudentRegistrationFormBean studentRegistrationFormBean;
/*      */   private Map instituteBranchMap;
/*      */   private PaymentRequestBean appData;
/*   86 */   private String challanMode = "";
/*      */   private List StudentTranDetailsList;
/*   88 */   private List studentFeesList = new ArrayList();
/*      */   private String uniqueIdentificationId;
/*      */   private String Email_ID;
/*      */   private String Mobile_No;
/*   92 */   private String application_No = "";
/*   93 */   private Map<String, String> diplomaBranchMapList = null;
/*   94 */   private Map<String, String> gradBranchMapList = null;
/*   95 */   private Map<String, String> postGradBranchMapList = null;
/*   96 */   private Map<String, String> NISMAmountDetails = null;
/*   97 */   NISMOnlineFormBean nismOnlineFormBean = new NISMOnlineFormBean();
/*      */   
/*      */   private String courseDetails;
/*      */   
/*      */   private List listnote;
/*      */   private String courseType;
/*      */   private List<String> selectCourseTypeMumbaiList;
/*      */   private String freshAdmissionType;
/*      */   private String strAmount;
/*      */   private String instituteId;
/*      */   private ArrayList<String> applicationNumber;
/*      */   private String ambikaSelectedStdFees;
/*      */   private String genderType;
/*      */   private String categoryType;
/*      */   private String finolexadmissionCategory;
/*      */   private String finolexadmissionType;
/*      */   private String finolexadmissionTo;
/*  114 */   private Map<String, String> finolexStuFeeMap = null;
/*      */   
/*      */   private String course;
/*      */   private Map<String, String> stuFeeList;
/*      */   private String className;
/*      */   private String semester;
/*      */   private String cgroup;
/*      */   private String typesOfStd;
/*  122 */   SHIVFormBean shivFormBean = new SHIVFormBean();
/*      */   
/*      */   private String FeeCategory;
/*      */   private String PaymentCycle;
/*      */   private String micronAmount;
/*      */   private String category;
/*  128 */   private ArrayList<String> allState = null;
/*      */   private String seatType;
/*      */   private String rollNo;
/*      */   private String strKulluRollNo;
/*      */   private String selectCourse;
/*      */   private String courseAmount;
/*  134 */   ChaudharyMiscellanousOnlineBean chaudharyMiscellanousOnlineBean = new ChaudharyMiscellanousOnlineBean();
/*      */   
/*      */   private String referenceId;
/*      */   private String dronaamount;
/*      */   private InderPrasthaExistOnlineFormBean inderPrasthaExistOnlineFormBean;
/*      */   private AddChallanChargesBean addChallanChargesBean;
/*      */   private ChallanOTPProcessBean challanOTPProcessBean;
/*      */   
/*      */   public InderPrasthaExistOnlineFormBean getInderPrasthaExistOnlineFormBean() {
/*  143 */     return this.inderPrasthaExistOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setInderPrasthaExistOnlineFormBean(InderPrasthaExistOnlineFormBean inderPrasthaExistOnlineFormBean) {
/*  148 */     this.inderPrasthaExistOnlineFormBean = inderPrasthaExistOnlineFormBean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDronaamount() {
/*  154 */     return this.dronaamount;
/*      */   }
/*      */   
/*      */   public void setDronaamount(String dronaamount) {
/*  158 */     this.dronaamount = dronaamount;
/*      */   }
/*      */   
/*      */   public String getReferenceId() {
/*  162 */     return this.referenceId;
/*      */   }
/*      */   
/*      */   public void setReferenceId(String referenceId) {
/*  166 */     this.referenceId = referenceId;
/*      */   }
/*      */   
/*      */   public String getSelectCourse() {
/*  170 */     return this.selectCourse;
/*      */   }
/*      */   
/*      */   public void setSelectCourse(String selectCourse) {
/*  174 */     this.selectCourse = selectCourse;
/*      */   }
/*      */   
/*      */   public String getCourseAmount() {
/*  178 */     return this.courseAmount;
/*      */   }
/*      */   
/*      */   public void setCourseAmount(String courseAmount) {
/*  182 */     this.courseAmount = courseAmount;
/*      */   }
/*      */   
/*      */   public ChaudharyMiscellanousOnlineBean getChaudharyMiscellanousOnlineBean() {
/*  186 */     return this.chaudharyMiscellanousOnlineBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setChaudharyMiscellanousOnlineBean(ChaudharyMiscellanousOnlineBean chaudharyMiscellanousOnlineBean) {
/*  191 */     this.chaudharyMiscellanousOnlineBean = chaudharyMiscellanousOnlineBean;
/*      */   }
/*      */   
/*      */   public ArrayList<String> getAllState() {
/*  195 */     return this.allState;
/*      */   }
/*      */   
/*      */   public void setAllState(ArrayList<String> allState) {
/*  199 */     this.allState = allState;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getCourse() {
/*  204 */     return this.course;
/*      */   }
/*      */   
/*      */   public void setCourse(String course) {
/*  208 */     this.course = course;
/*      */   }
/*      */   
/*      */   public String getCategory() {
/*  212 */     return this.category;
/*      */   }
/*      */   
/*      */   public void setCategory(String category) {
/*  216 */     this.category = category;
/*      */   }
/*      */   public PathFinderOnlineFormBean getPathFinderOnlineFormBean() {
/*  219 */     return this.pathFinderOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPathFinderOnlineFormBean(PathFinderOnlineFormBean pathFinderOnlineFormBean) {
/*  224 */     this.pathFinderOnlineFormBean = pathFinderOnlineFormBean;
/*      */   }
/*      */   public String getMicronAmount() {
/*  227 */     return this.micronAmount;
/*      */   }
/*      */   
/*      */   public void setMicronAmount(String micronAmount) {
/*  231 */     this.micronAmount = micronAmount;
/*      */   }
/*      */   
/*      */   public String getFeeCategory() {
/*  235 */     return this.FeeCategory;
/*      */   }
/*      */   
/*      */   public void setFeeCategory(String feeCategory) {
/*  239 */     this.FeeCategory = feeCategory;
/*      */   }
/*      */   
/*      */   public String getPaymentCycle() {
/*  243 */     return this.PaymentCycle;
/*      */   }
/*      */   
/*      */   public void setPaymentCycle(String paymentCycle) {
/*  247 */     this.PaymentCycle = paymentCycle;
/*      */   }
/*      */   
/*      */   public SHIVFormBean getShivFormBean() {
/*  251 */     return this.shivFormBean;
/*      */   }
/*      */   
/*      */   public void setShivFormBean(SHIVFormBean shivFormBean) {
/*  255 */     this.shivFormBean = shivFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getTypesOfStd() {
/*  260 */     return this.typesOfStd;
/*      */   }
/*      */   
/*      */   public void setTypesOfStd(String typesOfStd) {
/*  264 */     this.typesOfStd = typesOfStd;
/*      */   }
/*      */ 
/*      */   
/*      */   public Map<String, String> getStuFeeList() {
/*  269 */     return this.stuFeeList;
/*      */   }
/*      */   
/*      */   public void setStuFeeList(Map<String, String> stuFeeList) {
/*  273 */     this.stuFeeList = stuFeeList;
/*      */   }
/*      */   
/*      */   public String getClassName() {
/*  277 */     return this.className;
/*      */   }
/*      */   
/*      */   public void setClassName(String className) {
/*  281 */     this.className = className;
/*      */   }
/*      */   
/*      */   public String getSemester() {
/*  285 */     return this.semester;
/*      */   }
/*      */   
/*      */   public void setSemester(String semester) {
/*  289 */     this.semester = semester;
/*      */   }
/*      */   
/*      */   public String getCgroup() {
/*  293 */     return this.cgroup;
/*      */   }
/*      */   
/*      */   public void setCgroup(String cgroup) {
/*  297 */     this.cgroup = cgroup;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFinolexadmissionCategory() {
/*  305 */     return this.finolexadmissionCategory;
/*      */   }
/*      */   
/*      */   public void setFinolexadmissionCategory(String finolexadmissionCategory) {
/*  309 */     this.finolexadmissionCategory = finolexadmissionCategory;
/*      */   }
/*      */   
/*      */   public String getFinolexadmissionType() {
/*  313 */     return this.finolexadmissionType;
/*      */   }
/*      */   
/*      */   public void setFinolexadmissionType(String finolexadmissionType) {
/*  317 */     this.finolexadmissionType = finolexadmissionType;
/*      */   }
/*      */   
/*      */   public String getFinolexadmissionTo() {
/*  321 */     return this.finolexadmissionTo;
/*      */   }
/*      */   
/*      */   public void setFinolexadmissionTo(String finolexadmissionTo) {
/*  325 */     this.finolexadmissionTo = finolexadmissionTo;
/*      */   }
/*      */   
/*      */   public Map<String, String> getFinolexStuFeeMap() {
/*  329 */     return this.finolexStuFeeMap;
/*      */   }
/*      */   
/*      */   public void setFinolexStuFeeMap(Map<String, String> finolexStuFeeMap) {
/*  333 */     this.finolexStuFeeMap = finolexStuFeeMap;
/*      */   }
/*      */   
/*      */   public String getAmbikaSelectedStdFees() {
/*  337 */     return this.ambikaSelectedStdFees;
/*      */   }
/*      */   
/*      */   public void setAmbikaSelectedStdFees(String ambikaSelectedStdFees) {
/*  341 */     this.ambikaSelectedStdFees = ambikaSelectedStdFees;
/*      */   }
/*      */   
/*      */   public String getGenderType() {
/*  345 */     return this.genderType;
/*      */   }
/*      */   
/*      */   public void setGenderType(String genderType) {
/*  349 */     this.genderType = genderType;
/*      */   }
/*      */   
/*      */   public String getCategoryType() {
/*  353 */     return this.categoryType;
/*      */   }
/*      */   
/*      */   public void setCategoryType(String categoryType) {
/*  357 */     this.categoryType = categoryType;
/*      */   }
/*      */   
/*      */   public ArrayList<String> getApplicationNumber() {
/*  361 */     return this.applicationNumber;
/*      */   }
/*      */   
/*      */   public void setApplicationNumber(ArrayList<String> applicationNumber) {
/*  365 */     this.applicationNumber = applicationNumber;
/*      */   }
/*      */   public String getInstituteId() {
/*  368 */     return this.instituteId;
/*      */   }
/*      */   
/*      */   public void setInstituteId(String instituteId) {
/*  372 */     this.instituteId = instituteId;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getStrAmount() {
/*  377 */     return this.strAmount;
/*      */   }
/*      */   
/*      */   public void setStrAmount(String strAmount) {
/*  381 */     this.strAmount = strAmount;
/*      */   }
/*      */   public String getFreshAdmissionType() {
/*  384 */     return this.freshAdmissionType;
/*      */   }
/*      */   
/*      */   public void setFreshAdmissionType(String freshAdmissionType) {
/*  388 */     this.freshAdmissionType = freshAdmissionType;
/*      */   }
/*      */   
/*      */   public List<String> getSelectCourseTypeMumbaiList() {
/*  392 */     return this.selectCourseTypeMumbaiList;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSelectCourseTypeMumbaiList(List<String> selectCourseTypeMumbaiList) {
/*  397 */     this.selectCourseTypeMumbaiList = selectCourseTypeMumbaiList;
/*      */   }
/*      */   
/*      */   public String getCourseType() {
/*  401 */     return this.courseType;
/*      */   }
/*      */   
/*      */   public void setCourseType(String courseType) {
/*  405 */     this.courseType = courseType;
/*      */   }
/*      */   
/*      */   public List getListnote() {
/*  409 */     return this.listnote;
/*      */   }
/*      */   
/*      */   public void setListnote(List listnote) {
/*  413 */     this.listnote = listnote;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCourseDetails() {
/*  419 */     return this.courseDetails;
/*      */   }
/*      */   
/*      */   public void setCourseDetails(String courseDetails) {
/*  423 */     this.courseDetails = courseDetails;
/*      */   }
/*      */   
/*      */   public NISMOnlineFormBean getNismOnlineFormBean() {
/*  427 */     return this.nismOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setNismOnlineFormBean(NISMOnlineFormBean nismOnlineFormBean) {
/*  431 */     this.nismOnlineFormBean = nismOnlineFormBean;
/*      */   }
/*      */   
/*      */   public Map<String, String> getNISMAmountDetails() {
/*  435 */     return this.NISMAmountDetails;
/*      */   }
/*      */   
/*      */   public void setNISMAmountDetails(Map<String, String> nISMAmountDetails) {
/*  439 */     this.NISMAmountDetails = nISMAmountDetails;
/*      */   }
/*      */   
/*      */   public Map<String, String> getPostGradBranchMapList() {
/*  443 */     return this.postGradBranchMapList;
/*      */   }
/*      */   
/*      */   public void setPostGradBranchMapList(Map<String, String> postGradBranchMapList) {
/*  447 */     this.postGradBranchMapList = postGradBranchMapList;
/*      */   }
/*      */   
/*      */   public Map<String, String> getGradBranchMapList() {
/*  451 */     return this.gradBranchMapList;
/*      */   }
/*      */   
/*      */   public void setGradBranchMapList(Map<String, String> gradBranchMapList) {
/*  455 */     this.gradBranchMapList = gradBranchMapList;
/*      */   }
/*      */   
/*      */   public Map<String, String> getDiplomaBranchMapList() {
/*  459 */     return this.diplomaBranchMapList;
/*      */   }
/*      */   
/*      */   public void setDiplomaBranchMapList(Map<String, String> diplomaBranchMapList) {
/*  463 */     this.diplomaBranchMapList = diplomaBranchMapList;
/*      */   }
/*      */   
/*      */   public List getStudentTranDetailsList() {
/*  467 */     return this.StudentTranDetailsList;
/*      */   }
/*      */   
/*      */   public void setStudentTranDetailsList(List studentTranDetailsList) {
/*  471 */     this.StudentTranDetailsList = studentTranDetailsList;
/*      */   }
/*      */   
/*      */   public String getUniqueIdentificationId() {
/*  475 */     return this.uniqueIdentificationId;
/*      */   }
/*      */   
/*      */   public void setUniqueIdentificationId(String uniqueIdentificationId) {
/*  479 */     this.uniqueIdentificationId = uniqueIdentificationId;
/*      */   }
/*      */   
/*      */   public String getEmail_ID() {
/*  483 */     return this.Email_ID;
/*      */   }
/*      */   
/*      */   public void setEmail_ID(String email_ID) {
/*  487 */     this.Email_ID = email_ID;
/*      */   }
/*      */   
/*      */   public String getMobile_No() {
/*  491 */     return this.Mobile_No;
/*      */   }
/*      */   
/*      */   public String getApplication_No() {
/*  495 */     return this.application_No;
/*      */   }
/*      */   
/*      */   public void setApplication_No(String application_No) {
/*  499 */     this.application_No = application_No;
/*      */   }
/*      */   
/*      */   public void setMobile_No(String mobile_No) {
/*  503 */     this.Mobile_No = mobile_No;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*  508 */   private String totalfee = "";
/*      */   private String studentRegistrationId;
/*      */   private String strPaymentType;
/*      */   private String strPaymentMode;
/*  512 */   FeesPayChargesFormBean feesPayChargesFormBean = new FeesPayChargesFormBean();
/*      */   private List<String> feesPayList;
/*  514 */   private String totalLateFee = "";
/*  515 */   private String totalAmount = "";
/*  516 */   private String studentName = "";
/*      */   
/*      */   private Map studentData;
/*      */   
/*      */   private String maxCount;
/*      */   private String incomeslab;
/*      */   private String programme;
/*      */   private String studentcategory;
/*      */   private String academicFeesId;
/*      */   private String academicFeesAmnt;
/*      */   private String messFeesId;
/*      */   private String messFeesAmnt;
/*      */   private String payLaterDate;
/*      */   private String admissionType;
/*      */   private String section;
/*      */   
/*      */   public String getStrKulluRollNo() {
/*  533 */     return this.strKulluRollNo;
/*      */   }
/*      */   
/*      */   public void setStrKulluRollNo(String strKulluRollNo) {
/*  537 */     this.strKulluRollNo = strKulluRollNo;
/*      */   }
/*      */   
/*      */   public String getSeatType() {
/*  541 */     return this.seatType;
/*      */   }
/*      */   
/*      */   public void setSeatType(String seatType) {
/*  545 */     this.seatType = seatType;
/*      */   }
/*      */   
/*      */   public String getRollNo() {
/*  549 */     return this.rollNo;
/*      */   }
/*      */   
/*      */   public void setRollNo(String rollNo) {
/*  553 */     this.rollNo = rollNo;
/*      */   }
/*      */   
/*      */   public String getMaxCount() {
/*  557 */     return this.maxCount;
/*      */   }
/*      */   
/*      */   public void setMaxCount(String maxCount) {
/*  561 */     this.maxCount = maxCount;
/*      */   }
/*      */   public Map getStudentData() {
/*  564 */     return this.studentData;
/*      */   }
/*      */   
/*      */   public void setStudentData(Map studentData) {
/*  568 */     this.studentData = studentData;
/*      */   }
/*      */ 
/*      */   
/*      */   public ChallanOTPProcessBean getChallanOTPProcessBean() {
/*  573 */     return this.challanOTPProcessBean;
/*      */   }
/*      */   
/*      */   public void setChallanOTPProcessBean(ChallanOTPProcessBean challanOTPProcessBean) {
/*  577 */     this.challanOTPProcessBean = challanOTPProcessBean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPayLaterDate() {
/*  583 */     return this.payLaterDate;
/*      */   }
/*      */   
/*      */   public void setPayLaterDate(String payLaterDate) {
/*  587 */     this.payLaterDate = payLaterDate;
/*      */   }
/*      */   
/*      */   public AjaxAction() {
/*  591 */     logger.info("Filling institute config bean in local object of AjaxAction - START");
/*  592 */     if (getUserSessionMap().get("INSTCONFIG") != null) {
/*  593 */       logger.info("Inside Ajax Action INSTCONFIG not null-->");
/*  594 */       setInstituteConfigBean((InstituteConfigBean)getUserSessionMap().get("INSTCONFIG"));
/*      */     } 
/*  596 */     logger.info("Filling institute config bean in local object of AjaxAction - END");
/*      */   }
/*      */   
/*      */   public String fetchCourses() {
/*      */     try {
/*  601 */       this.courseData = (CourseDetailsBean)getUserSessionMap().get("COURSEDATA");
/*  602 */       logger.info("Inside fetchCourses");
/*  603 */       displayParams();
/*  604 */       CourseDetailsService courseDetailsService = new CourseDetailsService();
/*  605 */       getMapCourseList().putAll(courseDetailsService.getCourseList(getBranchID(), "Q"));
/*  606 */       this.courseData.setMapCourseList(getMapCourseList());
/*      */     
/*      */     }
/*  609 */     catch (Exception e) {
/*  610 */       logger.error("Exception  " + e);
/*      */     } 
/*      */     
/*  613 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String fetchCourseDetails() {
/*      */     try {
/*  622 */       this.courseData = (CourseDetailsBean)getUserSessionMap().get("COURSEDATA");
/*  623 */       logger.info("Inside fetchCourseDetails");
/*  624 */       displayParams();
/*  625 */       CourseDetailsService courseDetailsService = new CourseDetailsService();
/*  626 */       getMapCourseDetailsList().putAll(courseDetailsService.getCourseSpecializationList(getCourseID()));
/*  627 */       this.courseData.setMapCourseDetailList(getMapCourseDetailsList());
/*      */     
/*      */     }
/*  630 */     catch (Exception e) {
/*  631 */       logger.error("Exception  " + e);
/*      */     } 
/*      */     
/*  634 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchCourseTypeNPattern() {
/*      */     try {
/*  639 */       this.courseData = (CourseDetailsBean)getUserSessionMap().get("COURSEDATA");
/*  640 */       logger.info("Inside fetchCourseTypeNPattern");
/*  641 */       displayParams();
/*  642 */       CourseDetailsService courseDetailsService = new CourseDetailsService();
/*  643 */       setMapCourseTypeList(courseDetailsService.getCourseSpecializationTypeList(getCourseDetailID()));
/*  644 */       setMapCoursePatternList(courseDetailsService.getCourseSpecializationPatternList(getCourseDetailID()));
/*  645 */       setMapCourseTermList(courseDetailsService.getCourseSpecializationTermList(getCourseDetailID()));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  650 */       this.courseData.setMapCourseTypeList(getMapCourseTypeList());
/*  651 */       this.courseData.setMapCoursePatternList(getMapCoursePatternList());
/*  652 */       this.courseData.setMapCourseTermList(getMapCourseTermList());
/*      */     }
/*  654 */     catch (Exception e) {
/*  655 */       logger.error("Exception  " + e);
/*      */     } 
/*      */     
/*  658 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String fetchCourseType() {
/*  666 */     this.courseData = (CourseDetailsBean)getUserSessionMap().get("COURSEDATA");
/*  667 */     logger.info("Inside fetchCourseType");
/*      */     
/*  669 */     getMapCourseTypeList().put("1", "Full Time");
/*  670 */     getMapCourseTypeList().put("2", "Part Time");
/*  671 */     this.courseData.setMapCourseTypeList(this.mapCourseTypeList);
/*      */     
/*  673 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String fetchCourseYear() {
/*  681 */     this.courseData = (CourseDetailsBean)getUserSessionMap().get("COURSEDATA");
/*  682 */     getMapCourseYearList().put("1", "2012-2013");
/*  683 */     getMapCourseYearList().put("2", "2013-2014");
/*  684 */     this.courseData.setMapCourseYearList(this.mapCourseYearList);
/*      */     
/*  686 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchAllCourseData() {
/*  690 */     logger.info("login module - fetchAllCourseData - this.getStudentId() : - " + getStudentId() + " START");
/*  691 */     fetchCourseDataFromStudentId(getStudentId());
/*  692 */     logger.info("login module - fetchAllCourseData - this.getStudentId() : - " + getStudentId() + " ~END~");
/*      */     
/*  694 */     this.studentData = null;
/*  695 */     String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/*  696 */     LoginActionService loginActionService = new LoginActionService();
/*  697 */     setStudentData(loginActionService.getRegisteredStudentList(registeredUserId));
/*      */ 
/*      */     
/*  700 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchAllCourseDataByUniqueId() {
/*  704 */     logger.info("!!!!!!!!!!!!!!!!!!!!!!");
/*  705 */     logger.info("~~~ " + getUniquiIdentificationId() + " ~~~");
/*  706 */     MDC.put("UserId", getUniquiIdentificationId());
/*  707 */     MDC.put("MerchantId", (String)getUserSessionMap().get("_institutecode"));
/*  708 */     logger.info("!!!!!!!!!!!!!!!!!!!!!!");
/*  709 */     String uniqueId = getUniquiIdentificationId();
/*      */     
/*  711 */     StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*  712 */     FJBean fjBean = (FJBean)getUserSessionMap().get("BASEDATA");
/*  713 */     InstituteMasterActionService instituteMasterActionService = new InstituteMasterActionService();
/*  714 */     String instCode = instituteMasterActionService.getInstituteCode(fjBean.getBillerId());
/*  715 */     String defaultGuestUserId = fjBean.getRegisteredUserId();
/*  716 */     if (instCode.equalsIgnoreCase("CBSSB") || instCode.equalsIgnoreCase("CBSIB") || instCode.equalsIgnoreCase("CBSFB") || 
/*  717 */       instCode.equalsIgnoreCase("DPIV") || instCode.equalsIgnoreCase("DPST") || instCode.equalsIgnoreCase("DPSE")) {
/*  718 */       String studentRegistrationId = studentRegistrationService.getvalidateCBSData(uniqueId, defaultGuestUserId);
/*  719 */       if (studentRegistrationId != null && !"".equalsIgnoreCase(studentRegistrationId)) {
/*  720 */         fetchCourseDataFromStudentId(studentRegistrationId);
/*      */         
/*  722 */         logger.info("studentRegistrationId after method calling : - " + this.studentRegistrationFormBean.getStudentRegistrationId());
/*      */       } else {
/*  724 */         addActionError("student Not registered with us...please contact administrator...");
/*      */       } 
/*      */     } else {
/*  727 */       getUserSessionMap().put("UniqueIdentificationId", uniqueId);
/*  728 */       String studentRegistrationId = studentRegistrationService.getStudentRegistrationIdFromUniqueId(uniqueId, defaultGuestUserId);
/*  729 */       if (studentRegistrationId != null && !"".equalsIgnoreCase(studentRegistrationId)) {
/*  730 */         fetchCourseDataFromStudentId(studentRegistrationId);
/*      */         
/*  732 */         logger.info("studentRegistrationId after method calling : - " + this.studentRegistrationFormBean.getStudentRegistrationId());
/*      */       } else {
/*  734 */         addActionError("student Not registered with us...please contact administrator...");
/*      */       } 
/*      */     } 
/*      */     
/*  738 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String testproceed() {
/*  744 */     logger.info("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
/*      */     
/*  746 */     logger.info("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  752 */       this.instituteConfigBean = (InstituteConfigBean)getUserSessionMap().get("INSTCONFIG");
/*  753 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/*  754 */       logger.info("~~~~~~~~~~ " + getStudentRegistrationId() + " ~~~~~~~~~");
/*  755 */       logger.info("Am Inside Quick Pay Proceed");
/*  756 */       setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/*  757 */       StudentRegistrationFormBean studentRegistrationFormBean = new StudentRegistrationFormBean();
/*  758 */       studentRegistrationFormBean = getRegisteredStudentDetails(getStudentRegistrationId());
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  763 */       applyFees(studentRegistrationFormBean);
/*      */       
/*  765 */       QuickPayAction quickPayAction = new QuickPayAction();
/*  766 */       this.appData = new PaymentRequestBean();
/*  767 */       this.appData.setStudentRegistrationId(getStudentRegistrationId());
/*      */       
/*  769 */       quickPayAction.setAppDataFromStudentBean(this.appData, studentRegistrationFormBean, this.feesPayList);
/*      */ 
/*      */ 
/*      */       
/*  773 */       getUserSessionMap().put("APPDATA", getAppData());
/*      */     }
/*  775 */     catch (Exception e) {
/*  776 */       logger.error("Exception  " + e);
/*  777 */       return "error";
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  782 */     this.strPaymentType = "Online Payment";
/*      */     
/*  784 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/*  785 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/*  786 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/*  788 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/*  790 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/*  792 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */ 
/*      */     
/*  795 */     String totalLateFee = this.appData.getTotalLateFees();
/*  796 */     String totalAmount = this.appData.getPayableAmount();
/*  797 */     setTotalfee(this.appData.getTotalPayableFees());
/*  798 */     setTotalLateFee(totalLateFee);
/*  799 */     setTotalAmount(totalAmount);
/*  800 */     setStudentId(this.appData.getStrStudentId());
/*  801 */     setStudentName(this.appData.getStrStudentName());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  809 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchStudentCourseDataByUniqueId() {
/*  813 */     logger.info("!!!!!!!!!!!!!!!!!!!!!!");
/*  814 */     logger.info("~~~ " + getUniquiIdentificationId() + " ~~~");
/*  815 */     logger.info("!!!!!!!!!!!!!!!!!!!!!!");
/*  816 */     FJBean fjBean = (FJBean)getUserSessionMap().get("BASEDATA");
/*  817 */     StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*  818 */     String studentRegistrationId = studentRegistrationService.getStudentRegistrationIdFromUniqueStudentId(getUniquiIdentificationId(), fjBean.getBillerId());
/*  819 */     if (studentRegistrationId != null && !"".equalsIgnoreCase(studentRegistrationId)) {
/*  820 */       if ("AE".equalsIgnoreCase(studentRegistrationId)) {
/*  821 */         this.studentRegistrationFormBean = new StudentRegistrationFormBean();
/*  822 */         this.studentRegistrationFormBean.setStudentRegistrationId(studentRegistrationId);
/*  823 */         studentRegistrationId = null;
/*      */       } else {
/*  825 */         fetchCourseDataFromStudentId(studentRegistrationId);
/*      */ 
/*      */         
/*  828 */         logger.info("studentRegistrationId after method calling : - " + this.studentRegistrationFormBean.getStudentRegistrationId());
/*      */       } 
/*      */     } else {
/*      */       
/*  832 */       addActionError("student Not registered with us...please contact administrator...");
/*      */     } 
/*      */     
/*  835 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public void fetchCourseDataFromStudentId(String studentRegistrationId) {
/*  840 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/*  841 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/*  842 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */ 
/*      */     
/*  845 */     this.studentRegistrationFormBean = new StudentRegistrationFormBean();
/*  846 */     StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*  847 */     this.studentRegistrationFormBean = studentRegistrationService.getStudentCourseDetails(studentRegistrationId);
/*  848 */     applyFees(this.studentRegistrationFormBean);
/*  849 */     getUserSessionMap().put("_studentFeesList", this.studentRegistrationFormBean.getStudentFeesList());
/*      */     
/*  851 */     if ("Y".equalsIgnoreCase(this.instituteConfigBean.getPayLaterFlg())) {
/*  852 */       studentRegistrationService.getCountofPayLaterDatesUpdated(this.studentRegistrationFormBean);
/*      */     }
/*  854 */     transDetailsList(this.studentRegistrationFormBean);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String printViewStudentDetails() {
/*  860 */     logger.info("!!!!!!!!!!!!!!!!!!!!!!");
/*      */     
/*  862 */     logger.info("!!!!!!!!!!!!!!!!!!!!!!");
/*  863 */     InstituteMasterFormBean instituteMasterFormBean = (InstituteMasterFormBean)getUserSessionMap().get("INSTDATA");
/*      */     
/*  865 */     String branchId = getUserSessionMap().get("branchId").toString();
/*      */     
/*  867 */     StudentDataService studentDataService = new StudentDataService();
/*  868 */     List studentTransDetailsList = studentDataService.getStudentTranDetailsList(this.uniqueIdentificationId, branchId);
/*  869 */     this.studentRegistrationFormBean = new StudentRegistrationFormBean();
/*  870 */     this.studentRegistrationFormBean.setStudentTranDetailsList(studentTransDetailsList);
/*      */     
/*  872 */     getUserSessionMap().put("studentRegistrationFormBean", this.studentRegistrationFormBean);
/*  873 */     return "success";
/*      */   }
/*      */   
/*      */   public void displayFeesSection(List<StudentFeesFormBean> list) {
/*  877 */     if (list != null && list.size() > 0) {
/*  878 */       logger.info("-----------------------------------------------------");
/*  879 */       for (int count = 0; count < list.size(); count++) {
/*  880 */         StudentFeesFormBean studentFeesFormBean = list.get(count);
/*  881 */         logger.info("studentFeesFormBean.getFeesTypeId() : - " + studentFeesFormBean.getFeesTypeId());
/*  882 */         logger.info("studentFeesFormBean.getFeesTypeName() : - " + studentFeesFormBean.getFeesTypeName());
/*  883 */         logger.info("studentFeesFormBean.getFeesCalculationType() : - " + studentFeesFormBean.getFeesCalculationType());
/*  884 */         logger.info("studentFeesFormBean.getFees() : - " + studentFeesFormBean.getFees());
/*  885 */         logger.info("studentFeesFormBean.getLateFees() : - " + studentFeesFormBean.getLateFees());
/*  886 */         logger.info("studentFeesFormBean.getDiscountedFees() : - " + studentFeesFormBean.getDiscountedFees());
/*  887 */         logger.info("studentFeesFormBean.getPayableFees() : - " + studentFeesFormBean.getPayableFees());
/*  888 */         logger.info("studentFeesFormBean.getStartDate() : - " + studentFeesFormBean.getStartDate());
/*  889 */         logger.info("studentFeesFormBean.getDueDate() : - " + studentFeesFormBean.getDueDate());
/*  890 */         logger.info("studentFeesFormBean.getExpiryDate() : - " + studentFeesFormBean.getExpiryDate());
/*  891 */         logger.info("studentFeesFormBean.getNoOfDaysPrior() : - " + studentFeesFormBean.getNoOfDaysPrior());
/*  892 */         logger.info("studentFeesFormBean.getNoOfDaysDelay() : - " + studentFeesFormBean.getNoOfDaysDelay());
/*  893 */         logger.info("studentFeesFormBean.getNoOfDaysExpired() : - " + studentFeesFormBean.getNoOfDaysExpired());
/*  894 */         logger.info("studentFeesFormBean.getIsDisplay() : - " + studentFeesFormBean.getIsDisplay());
/*  895 */         logger.info("studentFeesFormBean.getTotalLateFees() : - " + studentFeesFormBean.getTotalLateFees());
/*  896 */         logger.info("studentFeesFormBean.getTotalPayableFees() : - " + studentFeesFormBean.getTotalPayableFees());
/*  897 */         logger.info("studentFeesFormBean.getLateFeesDelaySlot() : - " + studentFeesFormBean.getLateFeesDelaySlot());
/*  898 */         logger.info("studentFeesFormBean.getIsExpired() : - " + studentFeesFormBean.getIsExpired());
/*  899 */         logger.info("studentFeesFormBean.getFeePayId() : - " + studentFeesFormBean.getFeePayId());
/*  900 */         logger.info("studentFeesFormBean.getFeePayDetailId() : - " + studentFeesFormBean.getFeePayDetailId());
/*  901 */         logger.info("studentFeesFormBean.getSpecializationTypePatternId() : - " + studentFeesFormBean.getSpecializationTypePatternId());
/*      */       } 
/*  903 */       logger.info("-----------------------------------------------------");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String fetchStudentDetailsByID() {
/*  909 */     logger.info("~~~~~~~~~ " + getStudentId() + " ~~~~~~~~~~");
/*      */     
/*  911 */     CourseDetailsService courseDetailsService = new CourseDetailsService();
/*  912 */     setStudentRegistrationFormBean(findStudentCourseDetails(getStudentId()));
/*  913 */     logger.info("studentInstituteBranchName:::::\t" + this.studentRegistrationFormBean.getStudentInstituteBranchName());
/*  914 */     setInstituteBranchMap(courseDetailsService.getBillerBranchList(getStudentRegistrationFormBean().getStrBillerID()));
/*  915 */     logger.info("getInstituteBranchMap().size()::::::\t" + getInstituteBranchMap().size());
/*      */     
/*  917 */     setMapCourseList(courseDetailsService.getCourseList(getStudentRegistrationFormBean().getBillerBranchId(), "Q"));
/*      */     
/*  919 */     setMapCourseDetailsList(courseDetailsService.getCourseSpecializationList(getStudentRegistrationFormBean().getStrCourse()));
/*  920 */     setMapCourseTypeList(courseDetailsService.getCourseSpecializationTypeList(getStudentRegistrationFormBean().getStrCourseDetails()));
/*  921 */     setMapCoursePatternList(courseDetailsService.getCourseSpecializationPatternList(getStudentRegistrationFormBean().getStrCourseDetails()));
/*  922 */     setMapCourseTermList(courseDetailsService.getCourseSpecializationTermList(getStudentRegistrationFormBean().getStrCourseDetails()));
/*      */     
/*  924 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String showEreceiptData() {
/*  929 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String insertEmailData() {
/*  939 */     String studentId = this.uniqueIdentificationId;
/*  940 */     String emailId = this.Email_ID;
/*  941 */     String mobileNo = this.Mobile_No;
/*  942 */     String instCode = (String)getUserSessionMap().get("_institutecode");
/*  943 */     StudentDataService studentDataService = new StudentDataService();
/*  944 */     studentDataService.getUpdateStudentEmailIdMobData(studentId, emailId, mobileNo, instCode);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  949 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String fetchChallanCharges() {
/*  956 */     String challanModetype = getChallanMode();
/*  957 */     this.appData = (PaymentRequestBean)getUserSessionMap().get("APPDATA");
/*      */     
/*  959 */     this.appData.setStrPaymentType(challanModetype);
/*  960 */     PaymentService paymentService = new PaymentService();
/*  961 */     getAppData().setStrLoginId(((FJBean)getUserSessionMap().get("BASEDATA")).getLoginID());
/*  962 */     getAppData().setStrBillerId(((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId());
/*      */     
/*  964 */     double totalfee = Double.parseDouble(this.appData.getTotalPayableFees());
/*      */     
/*  966 */     String instituteId = this.appData.getStrBillerId();
/*  967 */     logger.info("instituteId" + instituteId);
/*      */ 
/*      */ 
/*      */     
/*  971 */     this.addChallanChargesBean = new AddChallanChargesBean();
/*      */     
/*  973 */     Double addChallanCharges = (new ChallanHistoryService()).getChallanCharges(instituteId, totalfee, challanModetype);
/*  974 */     this.addChallanChargesBean.setChallanCharges(addChallanCharges.doubleValue());
/*  975 */     this.addChallanChargesBean.setChallan(challanModetype);
/*  976 */     getAddChallanChargesBean().setChallanCharges(addChallanCharges.doubleValue());
/*  977 */     getAddChallanChargesBean().setChallan(challanModetype);
/*  978 */     getUserSessionMap().put("addChallanChargesBean", this.addChallanChargesBean);
/*  979 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String fetchGenericOTPNumber() {
/* 1014 */     int otp = 0;
/* 1015 */     String emailId = "";
/* 1016 */     String mobileNo = "";
/* 1017 */     String name = "";
/*      */     try {
/* 1019 */       while (otp / 100000 <= 0) {
/* 1020 */         otp = (int)(Math.random() * 999999.0D);
/*      */       }
/* 1022 */       this.challanOTPProcessBean = new ChallanOTPProcessBean();
/* 1023 */       this.challanOTPProcessBean.setOtp(otp);
/* 1024 */       this.challanOTPProcessBean.setOtp15timestamp((new Date()).getTime());
/* 1025 */       logger.info("OTP--------------------" + otp);
/*      */       
/* 1027 */       this.instituteConfigBean = (InstituteConfigBean)getUserSessionMap().get("INSTCONFIG");
/* 1028 */       if (this.instituteConfigBean.getQuickPayRegId() == null) {
/* 1029 */         String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1030 */         String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1031 */         LoginActionService loginActionService = new LoginActionService();
/* 1032 */         LoginActionFormBean loginActionFormBean = loginActionService.getDefaultGuestUserDetails(registeredUserId, billerId);
/* 1033 */         mobileNo = loginActionFormBean.getStrMobileNumber();
/* 1034 */         emailId = loginActionFormBean.getStrEmailID();
/* 1035 */         name = loginActionFormBean.getStrCustomerID();
/*      */       } else {
/*      */         
/* 1038 */         String result = fetchAllCourseDataByUniqueId();
/* 1039 */         mobileNo = this.studentRegistrationFormBean.getStudentMobileNumber();
/* 1040 */         emailId = this.studentRegistrationFormBean.getRdStudentEmailId();
/* 1041 */         name = this.studentRegistrationFormBean.getStudentFirstName();
/*      */       } 
/* 1043 */       String rp = mobileNo.substring(7);
/* 1044 */       this.challanOTPProcessBean.setMobileNumber("*******" + rp);
/* 1045 */       String emailbody = MessageFormat.format(PropertyReader.getProperty("generic.otp.email.body"), (Object[])new String[] { name, "SmartHub Education", (new StringBuilder(String.valueOf(otp))).toString() });
/* 1046 */       String emailSubject = MessageFormat.format(PropertyReader.getProperty("generic.otp.email.subject"), (Object[])new String[] { "SmartHub Education" });
/* 1047 */       String smsBody = MessageFormat.format(PropertyReader.getProperty("generic.otp.sms.body"), (Object[])new String[] { name, "SmartHub Education", (new StringBuilder(String.valueOf(otp))).toString() });
/* 1048 */       if ("E".equalsIgnoreCase(this.instituteConfigBean.getInstOTPFlg()) && 
/* 1049 */         emailId != null && 
/* 1050 */         !emailId.equals("")) {
/*      */         
/* 1052 */         EmailSMSManager ACL = new EmailSMSManager();
/* 1053 */         ACL.sendEmail("smarthub.education@hdfcbank.net", 
/* 1054 */             emailId, 
/* 1055 */             emailbody, 
/* 1056 */             emailSubject);
/*      */       }
/* 1058 */       else if ("M".equalsIgnoreCase(this.instituteConfigBean.getInstOTPFlg()) && 
/* 1059 */         mobileNo != null && 
/* 1060 */         !mobileNo.equals("")) {
/* 1061 */         HttpsClientSMS httpsclientsms = new HttpsClientSMS();
/* 1062 */         httpsclientsms.sendSMS(mobileNo, smsBody);
/*      */       }
/* 1064 */       else if ("B".equalsIgnoreCase(this.instituteConfigBean.getInstOTPFlg()) && 
/* 1065 */         mobileNo != null && 
/* 1066 */         !mobileNo.equals("") && 
/* 1067 */         emailId != null && 
/* 1068 */         !emailId.equals("")) {
/* 1069 */         HttpsClientSMS httpsclientsms = new HttpsClientSMS();
/* 1070 */         httpsclientsms.sendSMS(mobileNo, smsBody);
/*      */ 
/*      */         
/* 1073 */         EmailSMSManager ACL = new EmailSMSManager();
/* 1074 */         ACL.sendEmail("smarthub.education@hdfcbank.net", 
/* 1075 */             emailId, 
/* 1076 */             emailbody, 
/* 1077 */             emailSubject);
/*      */       }
/*      */       else {
/*      */         
/* 1081 */         this.challanOTPProcessBean.setOtp(0);
/*      */       }
/*      */     
/* 1084 */     } catch (Exception e) {
/* 1085 */       logger.error("Exception  " + e);
/* 1086 */       this.challanOTPProcessBean.setOtp(0);
/*      */     } 
/*      */     
/* 1089 */     return "success";
/*      */   }
/*      */   public String fetchTypeOFMember() {
/* 1092 */     logger.info("login module - fetchTypeOFMember - this.getStudentId() : - " + getStudentId() + " START");
/*      */     
/* 1094 */     logger.info("login module - fetchAllCourseData - this.getStudentId() : - " + getStudentId() + " ~END~");
/*      */     
/* 1096 */     this.studentData = null;
/* 1097 */     String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1098 */     LoginActionService loginActionService = new LoginActionService();
/* 1099 */     setStudentData(loginActionService.getAmount(getStudentId()));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1104 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchGnluCategory() {
/* 1108 */     logger.info("login module - fetchGnluCategory - this.getStudentId() : - " + getStudentId() + " START");
/*      */     
/* 1110 */     logger.info("login module - fetchGnluCategory - this.getStudentId() : - " + getStudentId() + " ~END~");
/*      */     
/* 1112 */     this.studentData = null;
/* 1113 */     String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1114 */     LoginActionService loginActionService = new LoginActionService();
/* 1115 */     setStudentData(loginActionService.getGnluAmount(getStudentId()));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1120 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchApplicationNo() {
/* 1124 */     logger.info("~~~ " + getUniquiIdentificationId() + " ~~~");
/* 1125 */     logger.info("!!!!!!!!!!!!!!!!!!!!!!");
/*      */     
/* 1127 */     StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 1128 */     FJBean fjBean = (FJBean)getUserSessionMap().get("BASEDATA");
/* 1129 */     getUserSessionMap().put("UniqueIdentificationId", getUniquiIdentificationId());
/* 1130 */     String defaultGuestUserId = fjBean.getRegisteredUserId();
/*      */ 
/*      */     
/* 1133 */     setStudentRegistrationId(studentRegistrationService.getSpsApplicationNo(getUniquiIdentificationId(), defaultGuestUserId));
/*      */     
/* 1135 */     if (this.studentRegistrationId == null || "".equalsIgnoreCase(this.studentRegistrationId))
/*      */     {
/*      */ 
/*      */ 
/*      */       
/* 1140 */       addActionError("student Not registered with us...please contact administrator...");
/*      */     }
/*      */     
/* 1143 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchSCIndiaAdmissionNo() {
/* 1147 */     logger.info("~~~ " + getUniquiIdentificationId() + " ~~~");
/* 1148 */     logger.info("!!!!!!!!!!!!!!!!!!!!!!");
/*      */     
/* 1150 */     StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 1151 */     FJBean fjBean = (FJBean)getUserSessionMap().get("BASEDATA");
/* 1152 */     getUserSessionMap().put("UniqueIdentificationId", getUniquiIdentificationId());
/* 1153 */     String defaultGuestUserId = fjBean.getRegisteredUserId();
/* 1154 */     StudentRegistrationFormBean studentRegistrationFormBean = new StudentRegistrationFormBean();
/*      */ 
/*      */     
/* 1157 */     studentRegistrationFormBean = studentRegistrationService.getSCIndiaAdmissionNo(getUniquiIdentificationId(), defaultGuestUserId);
/*      */     
/* 1159 */     setStudentRegistrationId(studentRegistrationFormBean.getApplication_No());
/* 1160 */     setStudentName(studentRegistrationFormBean.getStudentName());
/*      */     
/* 1162 */     if (this.studentRegistrationId == null || "".equalsIgnoreCase(this.studentRegistrationId))
/*      */     {
/*      */ 
/*      */ 
/*      */       
/* 1167 */       addActionError("student Not registered with us...please contact administrator...");
/*      */     }
/*      */     
/* 1170 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchRamaCollageCategory() {
/* 1174 */     logger.info("login module - fetchGnluCategory - this.getStudentId() : - " + getStudentId() + " START");
/*      */     
/* 1176 */     logger.info("login module - fetchGnluCategory - this.getStudentId() : - " + getStudentId() + " ~END~");
/*      */     
/* 1178 */     this.studentData = null;
/* 1179 */     String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1180 */     LoginActionService loginActionService = new LoginActionService();
/* 1181 */     setStudentData(loginActionService.getRamaCollageAmount(getStudentId(), getInstituteId()));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1186 */     return "success";
/*      */   }
/*      */   public String fetchDiplomaBranchName() {
/* 1189 */     logger.info("login module - fetchDiplomaBranchName - this.getStudentId() : - " + getStudentId() + " START");
/*      */ 
/*      */ 
/*      */     
/* 1193 */     this.diplomaBranchMapList = null;
/* 1194 */     String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1195 */     LoginActionService loginActionService = new LoginActionService();
/* 1196 */     setDiplomaBranchMapList(loginActionService.getDiplomaBranchList(getStudentId()));
/* 1197 */     logger.info("login module - fetchDiplomaBranchName - this.getStudentId() : - " + getStudentId() + " ~END~");
/*      */     
/* 1199 */     return "success";
/*      */   }
/*      */   public String fetchGraduationBranchName() {
/* 1202 */     logger.info("login module - fetchGraduationBranchName - this.getStudentId() : - " + getStudentId() + " START");
/*      */ 
/*      */ 
/*      */     
/* 1206 */     this.gradBranchMapList = null;
/* 1207 */     String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1208 */     LoginActionService loginActionService = new LoginActionService();
/* 1209 */     setGradBranchMapList(loginActionService.getGraduationBranchList(getStudentId()));
/* 1210 */     logger.info("login module - fetchGraduationBranchName - this.getStudentId() : - " + getStudentId() + " ~END~");
/*      */     
/* 1212 */     return "success";
/*      */   }
/*      */   public String fetchPostGraduationBranchName() {
/* 1215 */     logger.info("login module - fetchGraduationBranchName - this.getStudentId() : - " + getStudentId() + " START");
/*      */ 
/*      */ 
/*      */     
/* 1219 */     this.gradBranchMapList = null;
/* 1220 */     String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1221 */     LoginActionService loginActionService = new LoginActionService();
/* 1222 */     setPostGradBranchMapList(loginActionService.getPostGraduationBranchList(getStudentId()));
/* 1223 */     logger.info("login module - fetchGraduationBranchName - this.getStudentId() : - " + getStudentId() + " ~END~");
/*      */     
/* 1225 */     return "success";
/*      */   }
/*      */   public String fetchMaxCount() {
/* 1228 */     logger.info("login module - fetchMaxCount - this.getStudentId() : - " + getStudentId() + " START");
/* 1229 */     this.maxCount = null;
/*      */     
/* 1231 */     LoginActionService loginActionService = new LoginActionService();
/* 1232 */     setMaxCount(loginActionService.getmaxcountUniqId());
/*      */     
/* 1234 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchAmountEncryption() {
/* 1238 */     logger.info(" fetchAmountEncryption()-- Start ");
/* 1239 */     logger.info("total amount for encryption-------------------" + getTotalAmount());
/* 1240 */     String amnt = getTotalAmount();
/* 1241 */     String fin = ChecksumGenerator.hmacSha1GLA(amnt, "1989083233a696819f2623039a9f8adf");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1259 */     logger.info("encrypted total amount-------------------" + fin);
/* 1260 */     this.challanOTPProcessBean = new ChallanOTPProcessBean();
/* 1261 */     this.challanOTPProcessBean.setEncryptedAmount(fin);
/* 1262 */     logger.info(" fetchAmountEncryption()-- End ");
/* 1263 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String fetchIITVFees() {
/* 1268 */     logger.info("inside fetchIITVFees()-- Start ");
/*      */ 
/*      */     
/* 1271 */     logger.info("category-------------------" + getStudentcategory());
/*      */     
/* 1273 */     List<StudentFeesFormBean> StudentList = (List)getUserSessionMap().get("_studentFeesList");
/*      */     
/* 1275 */     StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 1276 */     if (!getStudentcategory().equalsIgnoreCase("NA")) {
/* 1277 */       for (int count = 0; count < StudentList.size(); count++) {
/* 1278 */         this.challanOTPProcessBean = new ChallanOTPProcessBean();
/* 1279 */         StudentFeesFormBean studentFeesFormBean = StudentList.get(count);
/* 1280 */         getUserSessionMap().put("studentCategory", getStudentcategory());
/* 1281 */         this.challanOTPProcessBean = studentRegistrationService.fetchIITVFees(studentFeesFormBean.getFeePayId(), studentFeesFormBean.getFeesTypeName(), getStudentcategory());
/* 1282 */         logger.info("academic fee-------------------" + this.challanOTPProcessBean.getAcademicFee());
/* 1283 */         logger.info("academic fee-------------------" + this.challanOTPProcessBean.getMessFee());
/* 1284 */         if (this.challanOTPProcessBean.getAcademicFee() == null || (this.challanOTPProcessBean.getAcademicFee().equals("") && !this.challanOTPProcessBean.getResponse().equalsIgnoreCase("success"))) {
/* 1285 */           this.studentFeesList = new ArrayList();
/*      */         } else {
/* 1287 */           this.studentFeesList.add(this.challanOTPProcessBean);
/*      */         } 
/*      */       } 
/*      */     } else {
/* 1291 */       this.studentFeesList = new ArrayList();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1303 */     logger.info(" fetchIITVFees()-- End ");
/* 1304 */     return "success";
/*      */   }
/*      */   
/*      */   public String updatePayLaterDate() {
/* 1308 */     logger.info(" updatePayLaterDate()-- Start ");
/* 1309 */     logger.info("unique id-------------------" + getUniqueIdentificationId());
/* 1310 */     logger.info("pay later date-------------------" + getPayLaterDate());
/* 1311 */     String paylater = getPayLaterDate();
/*      */     
/* 1313 */     this.challanOTPProcessBean = new ChallanOTPProcessBean();
/* 1314 */     StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 1315 */     Map<String, String> res = studentRegistrationService.getStudIdExpDate(getUniqueIdentificationId());
/* 1316 */     logger.info("Data in the Map----->>>" + res);
/*      */     
/* 1318 */     String maxExpDate = "2000-01-01";
/* 1319 */     logger.info("Maximum expire date initialised" + maxExpDate);
/*      */     
/* 1321 */     for (Map.Entry<String, String> entry : res.entrySet()) {
/* 1322 */       int i = DateUtil.dateCompare(DateUtil.dateFormat(maxExpDate, "yyyy-mm-dd"), 
/* 1323 */           DateUtil.dateFormat(entry.getValue(), "yyyy-mm-dd"));
/* 1324 */       if (i < 0) {
/* 1325 */         maxExpDate = entry.getValue(); continue;
/* 1326 */       }  if (i == 0) {
/* 1327 */         maxExpDate = entry.getValue(); continue;
/* 1328 */       }  if (i > 0) {
/* 1329 */         maxExpDate = maxExpDate; continue;
/*      */       } 
/* 1331 */       logger.info("fail");
/*      */     } 
/* 1333 */     logger.info("After calculating max of expire dates" + maxExpDate);
/*      */     
/* 1335 */     int o = DateUtil.dateCompare(DateUtil.dateFormat(maxExpDate, "yyyy-MM-dd"), 
/* 1336 */         DateUtil.dateFormat(paylater, "dd/MM/yyyy"));
/* 1337 */     logger.info("result of comparing max expire date and pay later date" + o);
/*      */     
/* 1339 */     if (o < 0) {
/* 1340 */       this.challanOTPProcessBean.setResponse("Pay Later date cannot exceed the last expiry date");
/*      */     } else {
/* 1342 */       String msg = studentRegistrationService.updatePayLaterDate(res, getUniqueIdentificationId(), paylater, "Y");
/* 1343 */       if ("greatercount".equalsIgnoreCase(msg)) {
/* 1344 */         this.challanOTPProcessBean.setResponse("greatercount");
/*      */       }
/* 1346 */       else if ("success".equalsIgnoreCase(msg)) {
/* 1347 */         this.challanOTPProcessBean.setResponse("success");
/*      */       } else {
/*      */         
/* 1350 */         this.challanOTPProcessBean.setResponse("failure");
/*      */       } 
/*      */     } 
/*      */     
/* 1354 */     logger.info("response-------------------" + this.challanOTPProcessBean.getResponse());
/* 1355 */     logger.info(" updatePayLaterDate()-- END ");
/* 1356 */     return "success";
/*      */   }
/*      */   public String fetchNIPRAmount() {
/* 1359 */     logger.info("login module - fetchNIPRAmount - this.getStudentId() : - " + getStudentId() + " START");
/*      */     
/* 1361 */     logger.info("this.getUniqueIdentificationId().." + getUniqueIdentificationId());
/* 1362 */     String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1363 */     LoginActionService loginActionService = new LoginActionService();
/*      */     
/* 1365 */     setTotalAmount(loginActionService.getNIPRAmount(getStudentId(), getUniqueIdentificationId(), getProgramme()));
/*      */     
/* 1367 */     logger.info("login module - fetchNIPRAmount - this.getStudentId() : - " + getStudentId() + " ~END~");
/*      */ 
/*      */     
/* 1370 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchAmountDetails() {
/* 1374 */     logger.info("login module - fetchAmountDetails - this.getStudentId() : - " + getStudentId() + " START");
/* 1375 */     this.nismOnlineFormBean = new NISMOnlineFormBean();
/*      */     
/* 1377 */     LoginActionService loginActionService = new LoginActionService();
/*      */     
/* 1379 */     String[] data = getCourseDetails().split("~");
/* 1380 */     this.nismOnlineFormBean.setFeeAmt(data[3]);
/* 1381 */     this.nismOnlineFormBean.setDiscountAmt(data[2]);
/* 1382 */     this.listnote = loginActionService.getnoteList(data[0]);
/* 1383 */     logger.info("login module - fetchAmountDetails - this.getStudentId() : - " + getStudentId() + " START");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1390 */     return "success";
/*      */   }
/*      */   public String fetchBSPRLateFees() {
/* 1393 */     logger.info("login module - fetchBSPRLateFees - this.getStudentId() : - " + getStudentId() + " START");
/* 1394 */     String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1395 */     LoginActionService loginActionService = new LoginActionService();
/*      */     
/* 1397 */     String MaxSeatMsg = loginActionService.fetchBSPRLateFees(getStudentId());
/* 1398 */     if (MaxSeatMsg.equalsIgnoreCase("success")) {
/* 1399 */       setMaxCount("1");
/*      */     } else {
/* 1401 */       setMaxCount("0");
/*      */     } 
/*      */     
/* 1404 */     logger.info("login module - fetchBSPRLateFees - this.getStudentId() : - " + getStudentId() + " ~END~");
/*      */ 
/*      */     
/* 1407 */     return "success";
/*      */   }
/*      */   public String fetchBKLIEntranceDate() {
/* 1410 */     logger.info("login module - fetchDiplomaBranchName - this.getStudentId() : - " + getStudentId().toString() + " START");
/*      */ 
/*      */     
/* 1413 */     this.diplomaBranchMapList = null;
/* 1414 */     String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1415 */     LoginActionService loginActionService = new LoginActionService();
/* 1416 */     setDiplomaBranchMapList(loginActionService.getBKLIEntranceDateList(getStudentId()));
/* 1417 */     logger.info("login module - fetchDiplomaBranchName - this.getStudentId() : - " + getStudentId() + " ~END~");
/*      */     
/* 1419 */     return "success";
/*      */   }
/*      */   public String fetchBKLINoOfSeats() {
/* 1422 */     logger.info("login module - fetchBKLINoOfSeats - this.getStudentId() : - " + getStudentId() + " START");
/* 1423 */     String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1424 */     LoginActionService loginActionService = new LoginActionService();
/*      */     
/* 1426 */     String MaxSeatMsg = loginActionService.getBKLICourseMaxSeat(getStudentId(), getProgramme());
/* 1427 */     if (MaxSeatMsg.equalsIgnoreCase("0")) {
/* 1428 */       setMaxCount("0");
/*      */     } else {
/* 1430 */       setMaxCount(MaxSeatMsg);
/*      */     } 
/*      */     
/* 1433 */     logger.info("login module - fetchBKLINoOfSeats - this.getStudentId() : - " + getStudentId() + " ~END~");
/*      */ 
/*      */     
/* 1436 */     return "success";
/*      */   }
/*      */   
/*      */   public CandEntryForm getCandEntryForm() {
/* 1440 */     return this.candEntryForm;
/*      */   }
/*      */   
/*      */   public void setCandEntryForm(CandEntryForm candEntryForm) {
/* 1444 */     this.candEntryForm = candEntryForm;
/*      */   }
/*      */   
/*      */   public String fetchAnglocoursetype() {
/* 1448 */     logger.info(" - fetchAnglocoursetype -  START");
/* 1449 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1450 */     LoginActionService loginActionService = new LoginActionService();
/* 1451 */     this.candEntryForm.setSelectCourseTypeMumbaiList(loginActionService.getAnglocourseDetailsList(getCourseType(), billerId));
/* 1452 */     logger.info(" - fetchAnglocoursetype -  END");
/* 1453 */     return "success";
/*      */   }
/*      */   public String fetchAnglocoursetypeId() {
/* 1456 */     logger.info(" - fetchAnglocoursetypeId -  START");
/* 1457 */     LoginActionService loginActionService = new LoginActionService();
/*      */ 
/*      */ 
/*      */     
/* 1461 */     this.candEntryForm = loginActionService.getCourseId(getCourseType());
/* 1462 */     logger.info(" fetchAnglocoursetypeId -  END");
/* 1463 */     return "success";
/*      */   }
/*      */   public String fetchOERCDetails() {
/* 1466 */     logger.info("fetchOERCDetails - this.getStudentId() : - " + getStudentId() + " START");
/* 1467 */     LoginActionService loginActionService = new LoginActionService();
/* 1468 */     String[] data = loginActionService.fetchOERCDetails(getStudentId());
/* 1469 */     String amount = data[0];
/* 1470 */     String duration = data[1];
/* 1471 */     setStrAmount(amount);
/* 1472 */     setCourseDetails(duration);
/* 1473 */     logger.info("fetchOERCDetails - this.getStudentId() : - " + getStudentId() + " ~END~");
/*      */ 
/*      */     
/* 1476 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String fetchOERCPDetails() {
/* 1481 */     logger.info("fetchOERCDetails - this.getStudentId() : - " + getStudentId() + " START");
/* 1482 */     LoginActionService loginActionService = new LoginActionService();
/* 1483 */     String[] data = loginActionService.fetchOERCPDetails(getStudentId());
/* 1484 */     String amount = data[0];
/* 1485 */     String duration = data[1];
/* 1486 */     setStrAmount(amount);
/* 1487 */     setCourseDetails(duration);
/* 1488 */     logger.info("fetchOERCDetails - this.getStudentId() : - " + getStudentId() + " ~END~");
/*      */ 
/*      */     
/* 1491 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCourseID() {
/* 1497 */     return this.courseID;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCourseID(String courseID) {
/* 1504 */     this.courseID = courseID;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, String> getMapCourseTypeList() {
/* 1511 */     return this.mapCourseTypeList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMapCourseTypeList(Map<String, String> mapCourseTypeList) {
/* 1518 */     this.mapCourseTypeList = mapCourseTypeList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCourseDetailID() {
/* 1525 */     return this.courseDetailID;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCourseDetailID(String courseDetailID) {
/* 1532 */     this.courseDetailID = courseDetailID;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, String> getMapCourseYearList() {
/* 1539 */     return this.mapCourseYearList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMapCourseYearList(Map<String, String> mapCourseYearList) {
/* 1546 */     this.mapCourseYearList = mapCourseYearList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, String> getMapCourseDetailsList() {
/* 1553 */     return this.mapCourseDetailsList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMapCourseDetailsList(Map<String, String> mapCourseDetailsList) {
/* 1560 */     this.mapCourseDetailsList = mapCourseDetailsList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCourseTypeID() {
/* 1567 */     return this.courseTypeID;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCourseTypeID(String courseTypeID) {
/* 1574 */     this.courseTypeID = courseTypeID;
/*      */   }
/*      */   
/*      */   public String getBranchID() {
/* 1578 */     return this.branchID;
/*      */   }
/*      */   
/*      */   public void setBranchID(String branchID) {
/* 1582 */     this.branchID = branchID;
/*      */   }
/*      */   
/*      */   public Map<String, String> getMapCourseList() {
/* 1586 */     return this.mapCourseList;
/*      */   }
/*      */   
/*      */   public void setMapCourseList(Map<String, String> mapCourseList) {
/* 1590 */     this.mapCourseList = mapCourseList;
/*      */   }
/*      */   
/*      */   public Map<String, String> getMapCoursePatternList() {
/* 1594 */     return this.mapCoursePatternList;
/*      */   }
/*      */   
/*      */   public void setMapCoursePatternList(Map<String, String> mapCoursePatternList) {
/* 1598 */     this.mapCoursePatternList = mapCoursePatternList;
/*      */   }
/*      */   
/*      */   public StudentRegistrationFormBean getStudentRegistrationFormBean() {
/* 1602 */     return this.studentRegistrationFormBean;
/*      */   }
/*      */   
/*      */   public void setStudentRegistrationFormBean(StudentRegistrationFormBean studentRegistrationFormBean) {
/* 1606 */     this.studentRegistrationFormBean = studentRegistrationFormBean;
/*      */   }
/*      */   
/*      */   public String getStudentId() {
/* 1610 */     return this.studentId;
/*      */   }
/*      */   
/*      */   public void setStudentId(String studentId) {
/* 1614 */     this.studentId = studentId;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map getInstituteBranchMap() {
/* 1621 */     return this.instituteBranchMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setInstituteBranchMap(Map instituteBranchMap) {
/* 1628 */     this.instituteBranchMap = instituteBranchMap;
/*      */   }
/*      */   
/*      */   public void displayParams() {
/* 1632 */     logger.info("*************************************************");
/* 1633 */     logger.info("this.getBranchID() : - " + getBranchID());
/* 1634 */     logger.info("this.getCourseID() : - " + getCourseID());
/* 1635 */     logger.info("this.getCourseDetailID() : - " + getCourseDetailID());
/* 1636 */     logger.info("this.getCourseTypeID() : - " + getCourseTypeID());
/* 1637 */     logger.info("*************************************************");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, String> getMapCourseTermList() {
/* 1645 */     return this.mapCourseTermList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMapCourseTermList(Map<String, String> mapCourseTermList) {
/* 1652 */     this.mapCourseTermList = mapCourseTermList;
/*      */   }
/*      */   
/*      */   public String getUniquiIdentificationId() {
/* 1656 */     return this.uniquiIdentificationId;
/*      */   }
/*      */   
/*      */   public void setUniquiIdentificationId(String uniquiIdentificationId) {
/* 1660 */     this.uniquiIdentificationId = uniquiIdentificationId;
/*      */   }
/*      */   
/*      */   public String getCourseTypeDefaultValue() {
/* 1664 */     return this.courseTypeDefaultValue;
/*      */   }
/*      */   
/*      */   public void setCourseTypeDefaultValue(String courseTypeDefaultValue) {
/* 1668 */     this.courseTypeDefaultValue = courseTypeDefaultValue;
/*      */   }
/*      */   
/*      */   public String getCoursePatternDefaultValue() {
/* 1672 */     return this.coursePatternDefaultValue;
/*      */   }
/*      */   
/*      */   public void setCoursePatternDefaultValue(String coursePatternDefaultValue) {
/* 1676 */     this.coursePatternDefaultValue = coursePatternDefaultValue;
/*      */   }
/*      */   
/*      */   public String getCourseTermDefaultValue() {
/* 1680 */     return this.courseTermDefaultValue;
/*      */   }
/*      */   
/*      */   public void setCourseTermDefaultValue(String courseTermDefaultValue) {
/* 1684 */     this.courseTermDefaultValue = courseTermDefaultValue;
/*      */   }
/*      */   
/*      */   public InstituteConfigBean getInstituteConfigBean() {
/* 1688 */     return this.instituteConfigBean;
/*      */   }
/*      */   
/*      */   public void setInstituteConfigBean(InstituteConfigBean instituteConfigBean) {
/* 1692 */     this.instituteConfigBean = instituteConfigBean;
/*      */   }
/*      */   
/*      */   public String getChallanMode() {
/* 1696 */     return this.challanMode;
/*      */   }
/*      */   
/*      */   public void setChallanMode(String challanMode) {
/* 1700 */     this.challanMode = challanMode;
/*      */   }
/*      */   
/*      */   public String getTotalfee() {
/* 1704 */     return this.totalfee;
/*      */   }
/*      */   
/*      */   public void setTotalfee(String totalfee) {
/* 1708 */     this.totalfee = totalfee;
/*      */   }
/*      */   
/*      */   public String getStudentRegistrationId() {
/* 1712 */     return this.studentRegistrationId;
/*      */   }
/*      */   
/*      */   public void setStudentRegistrationId(String studentRegistrationId) {
/* 1716 */     this.studentRegistrationId = studentRegistrationId;
/*      */   }
/*      */   
/*      */   public CourseDetailsBean getCourseData() {
/* 1720 */     return this.courseData;
/*      */   }
/*      */   
/*      */   public void setCourseData(CourseDetailsBean courseData) {
/* 1724 */     this.courseData = courseData;
/*      */   }
/*      */   
/*      */   public String getStrPaymentType() {
/* 1728 */     return this.strPaymentType;
/*      */   }
/*      */   
/*      */   public void setStrPaymentType(String strPaymentType) {
/* 1732 */     this.strPaymentType = strPaymentType;
/*      */   }
/*      */   
/*      */   public String getStrPaymentMode() {
/* 1736 */     return this.strPaymentMode;
/*      */   }
/*      */   
/*      */   public void setStrPaymentMode(String strPaymentMode) {
/* 1740 */     this.strPaymentMode = strPaymentMode;
/*      */   }
/*      */   
/*      */   public AddChallanChargesBean getAddChallanChargesBean() {
/* 1744 */     return this.addChallanChargesBean;
/*      */   }
/*      */   
/*      */   public void setAddChallanChargesBean(AddChallanChargesBean addChallanChargesBean) {
/* 1748 */     this.addChallanChargesBean = addChallanChargesBean;
/*      */   }
/*      */   
/*      */   public PaymentRequestBean getAppData() {
/* 1752 */     return this.appData;
/*      */   }
/*      */   
/*      */   public void setAppData(PaymentRequestBean appData) {
/* 1756 */     this.appData = appData;
/*      */   }
/*      */   
/*      */   public String getTotalLateFee() {
/* 1760 */     return this.totalLateFee;
/*      */   }
/*      */   
/*      */   public void setTotalLateFee(String totalLateFee) {
/* 1764 */     this.totalLateFee = totalLateFee;
/*      */   }
/*      */   
/*      */   public String getTotalAmount() {
/* 1768 */     return this.totalAmount;
/*      */   }
/*      */   
/*      */   public void setTotalAmount(String totalAmount) {
/* 1772 */     this.totalAmount = totalAmount;
/*      */   }
/*      */   
/*      */   public List<String> getFeesPayList() {
/* 1776 */     return this.feesPayList;
/*      */   }
/*      */   
/*      */   public void setFeesPayList(List<String> feesPayList) {
/* 1780 */     this.feesPayList = feesPayList;
/*      */   }
/*      */   
/*      */   public String getStudentName() {
/* 1784 */     return this.studentName;
/*      */   }
/*      */   
/*      */   public void setStudentName(String studentName) {
/* 1788 */     this.studentName = studentName;
/*      */   }
/*      */   
/*      */   public String getIncomeslab() {
/* 1792 */     return this.incomeslab;
/*      */   }
/*      */   
/*      */   public void setIncomeslab(String incomeslab) {
/* 1796 */     this.incomeslab = incomeslab;
/*      */   }
/*      */   
/*      */   public String getProgramme() {
/* 1800 */     return this.programme;
/*      */   }
/*      */   
/*      */   public void setProgramme(String programme) {
/* 1804 */     this.programme = programme;
/*      */   }
/*      */   
/*      */   public String getStudentcategory() {
/* 1808 */     return this.studentcategory;
/*      */   }
/*      */   
/*      */   public void setStudentcategory(String studentcategory) {
/* 1812 */     this.studentcategory = studentcategory;
/*      */   }
/*      */   
/*      */   public String getAcademicFeesId() {
/* 1816 */     return this.academicFeesId;
/*      */   }
/*      */   
/*      */   public void setAcademicFeesId(String academicFeesId) {
/* 1820 */     this.academicFeesId = academicFeesId;
/*      */   }
/*      */   
/*      */   public String getAcademicFeesAmnt() {
/* 1824 */     return this.academicFeesAmnt;
/*      */   }
/*      */   
/*      */   public void setAcademicFeesAmnt(String academicFeesAmnt) {
/* 1828 */     this.academicFeesAmnt = academicFeesAmnt;
/*      */   }
/*      */   
/*      */   public String getMessFeesId() {
/* 1832 */     return this.messFeesId;
/*      */   }
/*      */   
/*      */   public void setMessFeesId(String messFeesId) {
/* 1836 */     this.messFeesId = messFeesId;
/*      */   }
/*      */   
/*      */   public String getMessFeesAmnt() {
/* 1840 */     return this.messFeesAmnt;
/*      */   }
/*      */   
/*      */   public void setMessFeesAmnt(String messFeesAmnt) {
/* 1844 */     this.messFeesAmnt = messFeesAmnt;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAdmissionType() {
/* 1849 */     return this.admissionType;
/*      */   }
/*      */   
/*      */   public void setAdmissionType(String admissionType) {
/* 1853 */     this.admissionType = admissionType;
/*      */   }
/*      */   
/*      */   public String getSection() {
/* 1857 */     return this.section;
/*      */   }
/*      */   
/*      */   public void setSection(String section) {
/* 1861 */     this.section = section;
/*      */   }
/*      */   public List getStudentFeesList() {
/* 1864 */     return this.studentFeesList;
/*      */   }
/*      */   
/*      */   public void setStudentFeesList(List studentFeesList) {
/* 1868 */     this.studentFeesList = studentFeesList;
/*      */   }
/*      */ 
/*      */   
/*      */   public String fetchAdmissionType() {
/* 1873 */     logger.info(" Inside fetchAdmissionType");
/* 1874 */     StudentRegistrationService service = new StudentRegistrationService();
/* 1875 */     setMapCourseList(service.getAdmissionTypeList());
/* 1876 */     logger.info("outside Inside fetchAdmissionType");
/* 1877 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String fetchCoursesFromFreshAdmissionType() {
/* 1882 */     StudentRegistrationService service = new StudentRegistrationService();
/* 1883 */     String freshAdmissionTypeId = getFreshAdmissionType();
/* 1884 */     logger.info(" Inside fetchCoursesFromFreshAdmissionType" + freshAdmissionTypeId);
/* 1885 */     setMapCourseList(service.getFreshCourseList(freshAdmissionTypeId));
/* 1886 */     logger.info("outside Inside fetchCoursesFromFreshAdmissionType :");
/* 1887 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String fetchCollegeFromCouserId() {
/* 1892 */     String courseId = getFreshAdmissionType();
/* 1893 */     logger.info(" Inside fetchCollegeFromCouserId courseId is :" + courseId);
/* 1894 */     StudentRegistrationService service = new StudentRegistrationService();
/* 1895 */     setMapCourseList(service.getCollegeList(courseId));
/* 1896 */     logger.info("outside Inside fetchCollegeFromCouserId");
/* 1897 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String fetchCoursesForShiv() {
/* 1905 */     logger.info(" Inside fetchCoursesForShiv");
/* 1906 */     StudentRegistrationService service = new StudentRegistrationService();
/* 1907 */     setMapCourseList(service.getCourseList());
/* 1908 */     logger.info("outside Inside fetchCoursesForShiv");
/* 1909 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchDurationFromCourseName() {
/* 1913 */     String courseId = getFreshAdmissionType();
/* 1914 */     StudentRegistrationService service = new StudentRegistrationService();
/* 1915 */     this.shivFormBean = service.getDurationList(courseId);
/* 1916 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchBranchFromCollegeId() {
/* 1920 */     String collegeId = getFreshAdmissionType();
/* 1921 */     logger.info(" Inside fetchCourseFromCollegeId collegeId is :" + collegeId);
/* 1922 */     StudentRegistrationService service = new StudentRegistrationService();
/* 1923 */     setMapCourseList(service.getBranchList(collegeId));
/* 1924 */     logger.info("outside Inside fetchCourseFromCollegeId");
/* 1925 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String fetchCategoryFromCollegeId() {
/* 1931 */     String collegeId = getFreshAdmissionType();
/* 1932 */     logger.info(" Inside fetchCategoryFromCollegeId collegeId is :" + collegeId);
/* 1933 */     StudentRegistrationService service = new StudentRegistrationService();
/* 1934 */     setMapCourseList(service.getCategoryList(collegeId));
/* 1935 */     logger.info("outside Inside fetchCategoryFromCollegeId");
/* 1936 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String fetchAmountFromCollegeAndCategory() {
/* 1942 */     String collegeId = getFreshAdmissionType();
/* 1943 */     String categoryId = getCourseType();
/* 1944 */     logger.info(" Inside fetchAmountFromCollegeAndCategory collegeId is :" + collegeId + "and categoryId is :" + this.courseType);
/* 1945 */     StudentRegistrationService service = new StudentRegistrationService();
/* 1946 */     setStrAmount(service.getAmountByCategory(collegeId, categoryId));
/* 1947 */     logger.info("outside Inside fetchAmountFromCollegeAndCategory");
/* 1948 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String fetchApplicationNumber() {
/* 1956 */     String instituteCode = getFreshAdmissionType();
/* 1957 */     logger.info(" Inside fetchApplicationNumber instituteCode is :" + instituteCode);
/* 1958 */     StudentRegistrationService service = new StudentRegistrationService();
/* 1959 */     setApplicationNumber(service.getApplicationNumberList(instituteCode));
/* 1960 */     logger.info("outside Inside fetchApplicationNumber");
/* 1961 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String fetchDueDateFromApplicationNo() {
/* 1967 */     String instituteCode = getCourseType();
/* 1968 */     String applicationNo = getFreshAdmissionType();
/* 1969 */     logger.info(" Inside fetchDueDateFromApplicationNo applicationNo is :" + applicationNo + "  and instituteCode is :" + instituteCode);
/* 1970 */     StudentRegistrationService service = new StudentRegistrationService();
/* 1971 */     setApplicationNumber(service.getDueDateList(applicationNo, instituteCode));
/* 1972 */     logger.info("outside Inside fetchDueDateFromApplicationNo");
/* 1973 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String FetchAmbikapurFeesAmt() {
/* 1979 */     logger.info(" Inside FetchAmbikapurFeesAmt courseId is :");
/*      */     
/* 1981 */     String coursetype = getCourseType();
/* 1982 */     String gendertype = getGenderType();
/* 1983 */     String categorytype = getCategoryType();
/*      */     
/* 1985 */     StudentRegistrationService service = new StudentRegistrationService();
/* 1986 */     logger.info("coursetype : " + coursetype + " gendertype : " + gendertype + " categorytype : " + categorytype);
/* 1987 */     this.ambikaSelectedStdFees = service.getAmbikaStudentFees(coursetype, gendertype, categorytype);
/* 1988 */     logger.info("outside Inside FetchAmbikapurFeesAmt");
/* 1989 */     return "success";
/*      */   }
/*      */   
/*      */   public String FetchFinolexStuFees() {
/* 1993 */     logger.info(" Inside FetchFinolexStuFees courseId is :");
/*      */     
/* 1995 */     this.finolexStuFeeMap = new HashMap<>();
/* 1996 */     String finolexadmissionType = getFinolexadmissionType();
/* 1997 */     String finolexadmissionTo = getFinolexadmissionTo();
/* 1998 */     StudentRegistrationService service = new StudentRegistrationService();
/* 1999 */     logger.info(" finolexadmissionType : " + finolexadmissionType + " finolexadmissionTo : " + finolexadmissionTo);
/* 2000 */     this.finolexStuFeeMap = service.getFinolexInstituteStudentFees(finolexadmissionType, finolexadmissionTo);
/* 2001 */     logger.info("outside Inside FetchFinolexStuFees");
/*      */     
/* 2003 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String FetchFinolexStuFees_catWise() {
/* 2008 */     logger.info(" Inside FetchFinolexStuFees_catWise ");
/*      */     
/* 2010 */     this.finolexStuFeeMap = new HashMap<>();
/* 2011 */     String finolexadmissionCategory = getFinolexadmissionCategory();
/* 2012 */     String finolexadmissionTo = getFinolexadmissionTo();
/* 2013 */     StudentRegistrationService service = new StudentRegistrationService();
/* 2014 */     logger.info(" finolexadmissionCategory : " + finolexadmissionCategory + " finolexadmissionTo : " + finolexadmissionTo);
/* 2015 */     this.finolexStuFeeMap = service.FetchFinolexStuFees_catWise(finolexadmissionCategory, finolexadmissionTo);
/* 2016 */     logger.info("outside Inside FetchFinolexStuFees_catWise  finolexStuFeeMap :" + this.finolexStuFeeMap);
/*      */     
/* 2018 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String FetchHNBGUCourseFeesAmt() {
/* 2023 */     logger.info(" Inside FetchHNBGUCourseFeesAmt  is :");
/*      */     
/* 2025 */     this.stuFeeList = new HashMap<>();
/* 2026 */     String className1 = getClassName();
/* 2027 */     String cgroup1 = getCgroup();
/* 2028 */     String semester1 = getSemester();
/* 2029 */     String typesOfStd1 = getTypesOfStd();
/* 2030 */     StudentRegistrationService service = new StudentRegistrationService();
/* 2031 */     logger.info(" className1 : " + className1 + " cgroup1 : " + cgroup1 + " semester1 : " + semester1 + "typesOfStd :" + this.typesOfStd);
/* 2032 */     this.stuFeeList = service.getHNBGUCourseFeesAmt(className1, cgroup1, semester1, typesOfStd1);
/* 2033 */     logger.info("outside Inside FetchHNBGUCourseFeesAmt StuFeeList ==" + this.stuFeeList);
/*      */     
/* 2035 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String FetchMicronFeesAmt() {
/* 2040 */     logger.info(" Inside FetchMicronFeesAmt :");
/*      */     
/* 2042 */     String feecategory = getFeeCategory();
/* 2043 */     String PaymentCycle = getPaymentCycle();
/*      */     
/* 2045 */     StudentRegistrationService service = new StudentRegistrationService();
/* 2046 */     logger.info("feecategory : " + feecategory + " PaymentCycle : " + PaymentCycle);
/* 2047 */     this.micronAmount = service.getMicronStudentFees(PaymentCycle, feecategory);
/* 2048 */     logger.info("outside Inside FetchMicronFeesAmt");
/* 2049 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchChaduryCourseIdDetails() {
/* 2053 */     String coursname = getCourseType();
/* 2054 */     logger.info(" Inside fetchAdmissionType");
/* 2055 */     StudentRegistrationService service = new StudentRegistrationService();
/* 2056 */     setMapCourseList(service.getChaduryCourseTypeList(coursname));
/* 2057 */     logger.info("outside Inside fetchAdmissionType");
/* 2058 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String fetchChaduryAdmissionDetails() {
/* 2063 */     String studentCategory = getCategory();
/* 2064 */     String coursname = getCourseType();
/* 2065 */     logger.info(" Inside fetchAdmissionType");
/* 2066 */     StudentRegistrationService service = new StudentRegistrationService();
/* 2067 */     setMapCourseList(service.getChaduryAdmissionTypeList(studentCategory, coursname));
/* 2068 */     logger.info("outside Inside fetchAdmissionType");
/* 2069 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchNRIFeeDetails() {
/* 2073 */     logger.info("login module - fetchNRIFeeDetails - this.getCourse() : - " + getCourse() + " START");
/* 2074 */     String course = getCourse();
/* 2075 */     String nriType = getCategory();
/* 2076 */     String semester = getSemester();
/* 2077 */     LoginActionService loginActionService = new LoginActionService();
/* 2078 */     setMapCourseList(loginActionService.fetchNRIFeeDetails(course, nriType, semester));
/* 2079 */     String totalAmt = getMapCourseList().get("1");
/* 2080 */     setStrAmount(totalAmt);
/*      */     
/* 2082 */     getMapCourseList().remove("1");
/* 2083 */     logger.info("login module - fetchNRIFeeDetails - this.getCourse() : - " + getCourse() + " ~END~");
/* 2084 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchPathFinderCoursetypeId() {
/* 2088 */     LoginActionService loginActionService = new LoginActionService();
/* 2089 */     this.pathFinderOnlineFormBean = loginActionService.getPathfindercourseId(getCourseType());
/*      */     
/* 2091 */     return "success";
/*      */   }
/*      */   
/*      */   public String PrintViewOldStudentDetails() {
/* 2095 */     logger.info("inside PrintViewOldStudentDetails start");
/*      */     
/* 2097 */     logger.info("!!!!!!!!!!!!!!!!!!!!!!");
/* 2098 */     InstituteMasterFormBean instituteMasterFormBean = (InstituteMasterFormBean)getUserSessionMap().get("INSTDATA");
/*      */     
/* 2100 */     String branchId = getUserSessionMap().get("branchId").toString();
/*      */     
/* 2102 */     StudentDataService studentDataService = new StudentDataService();
/* 2103 */     List studentTransDetailsList = studentDataService.getStudentOldTranDetailsList(this.uniqueIdentificationId, branchId);
/* 2104 */     this.studentRegistrationFormBean = new StudentRegistrationFormBean();
/* 2105 */     this.studentRegistrationFormBean.setStudentTranDetailsList(studentTransDetailsList);
/*      */     
/* 2107 */     getUserSessionMap().put("studentRegistrationFormBean", this.studentRegistrationFormBean);
/* 2108 */     logger.info("inside PrintViewOldStudentDetails End");
/* 2109 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchAllStates() {
/* 2113 */     logger.info(" Inside fetchAllStates ");
/*      */     
/* 2115 */     this.allState = new ArrayList<>();
/*      */     
/* 2117 */     StudentRegistrationService service = new StudentRegistrationService();
/* 2118 */     this.allState = service.getAllStatesName();
/* 2119 */     logger.info("outside Inside fetchAllStates");
/*      */ 
/*      */     
/* 2122 */     return "success";
/*      */   }
/*      */   
/*      */   public String fetchChaduryMiscellanousDetails() {
/* 2126 */     LoginActionService loginActionService = new LoginActionService();
/*      */     
/* 2128 */     this.chaudharyMiscellanousOnlineBean = loginActionService.getChaduryMiscellanousTypeList(getCourseType());
/*      */     
/* 2130 */     return "success";
/*      */   }
/*      */   public String fetchKulluFeeDetails() {
/* 2133 */     logger.info("login module - FetchKulluFeeDetails - this.getCourse() : - " + getCourse() + " START");
/* 2134 */     String course = getCourse();
/* 2135 */     String seatType = getSeatType();
/* 2136 */     String semester = getSemester();
/* 2137 */     LoginActionService loginActionService = new LoginActionService();
/* 2138 */     setStrAmount(loginActionService.fetchKulluFeeDetails(course, seatType, semester));
/*      */     
/* 2140 */     logger.info("login module - FetchKulluFeeDetails - this.getCourse() : - " + getCourse() + " ~END~");
/* 2141 */     return "success";
/*      */   }
/*      */   public String fetchKulluRollNoDetails() {
/* 2144 */     logger.info("login module - fetchKulluRollNoDetails - this.getRollNo() : - " + getRollNo() + " START");
/* 2145 */     String rollNo = getRollNo();
/* 2146 */     LoginActionService loginActionService = new LoginActionService();
/* 2147 */     setStrKulluRollNo(loginActionService.fetchKulluRollNoDetails(rollNo));
/*      */     
/* 2149 */     logger.info("login module - fetchKulluRollNoDetails - this.getRollNo() : - " + getRollNo() + " ~END~");
/* 2150 */     return "success";
/*      */   }
/*      */   public String fetchGenericOTPNumberforE_Receipt() {
/* 2153 */     int otp = 0;
/* 2154 */     String emailId = "";
/* 2155 */     String mobileNo = "";
/* 2156 */     String name = "";
/*      */     try {
/* 2158 */       while (otp / 100000 <= 0) {
/* 2159 */         otp = (int)(Math.random() * 999999.0D);
/*      */       }
/* 2161 */       this.challanOTPProcessBean = new ChallanOTPProcessBean();
/* 2162 */       this.challanOTPProcessBean.setOtp(otp);
/* 2163 */       this.challanOTPProcessBean.setOtp15timestamp((new Date()).getTime());
/* 2164 */       logger.info("OTP--------------------" + otp);
/*      */       
/* 2166 */       this.instituteConfigBean = (InstituteConfigBean)getUserSessionMap().get("INSTCONFIG");
/* 2167 */       if (this.instituteConfigBean.getQuickPayRegId() == null) {
/* 2168 */         String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 2169 */         String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2170 */         LoginActionService loginActionService = new LoginActionService();
/* 2171 */         LoginActionFormBean loginActionFormBean = loginActionService.getDefaultGuestUserDetails(registeredUserId, billerId);
/* 2172 */         mobileNo = loginActionFormBean.getStrMobileNumber();
/* 2173 */         emailId = loginActionFormBean.getStrEmailID();
/* 2174 */         name = loginActionFormBean.getStrCustomerID();
/*      */       } else {
/*      */         
/* 2177 */         String result = fetchAllCourseDataByUniqueId();
/* 2178 */         mobileNo = this.studentRegistrationFormBean.getStudentMobileNumber();
/* 2179 */         emailId = this.studentRegistrationFormBean.getRdStudentEmailId();
/* 2180 */         name = this.studentRegistrationFormBean.getStudentFirstName();
/*      */       } 
/* 2182 */       String rp = mobileNo.substring(7);
/* 2183 */       this.challanOTPProcessBean.setMobileNumber("*******" + rp);
/* 2184 */       String emailbody = MessageFormat.format(PropertyReader.getProperty("generic.otp.email.body"), (Object[])new String[] { name, "SmartHub Education", (new StringBuilder(String.valueOf(otp))).toString() });
/* 2185 */       String emailSubject = MessageFormat.format(PropertyReader.getProperty("generic.otp.email.subject"), (Object[])new String[] { "SmartHub Education" });
/* 2186 */       String smsBody = MessageFormat.format(PropertyReader.getProperty("generic.otp.sms.body"), (Object[])new String[] { name, "SmartHub Education", (new StringBuilder(String.valueOf(otp))).toString() });
/* 2187 */       if ("E".equalsIgnoreCase(this.instituteConfigBean.getInstOTP_E_Received_Flg()) && 
/* 2188 */         emailId != null && 
/* 2189 */         !emailId.equals("")) {
/*      */         
/* 2191 */         EmailSMSManager ACL = new EmailSMSManager();
/* 2192 */         ACL.sendEmail("smarthub.education@hdfcbank.net", 
/* 2193 */             emailId, 
/* 2194 */             emailbody, 
/* 2195 */             emailSubject);
/*      */       }
/* 2197 */       else if ("M".equalsIgnoreCase(this.instituteConfigBean.getInstOTP_E_Received_Flg()) && 
/* 2198 */         mobileNo != null && 
/* 2199 */         !mobileNo.equals("")) {
/* 2200 */         HttpsClientSMS httpsclientsms = new HttpsClientSMS();
/* 2201 */         httpsclientsms.sendSMS(mobileNo, smsBody);
/*      */       }
/* 2203 */       else if ("B".equalsIgnoreCase(this.instituteConfigBean.getInstOTP_E_Received_Flg()) && 
/* 2204 */         mobileNo != null && 
/* 2205 */         !mobileNo.equals("") && 
/* 2206 */         emailId != null && 
/* 2207 */         !emailId.equals("")) {
/* 2208 */         HttpsClientSMS httpsclientsms = new HttpsClientSMS();
/* 2209 */         httpsclientsms.sendSMS(mobileNo, smsBody);
/*      */ 
/*      */         
/* 2212 */         EmailSMSManager ACL = new EmailSMSManager();
/* 2213 */         ACL.sendEmail("smarthub.education@hdfcbank.net", 
/* 2214 */             emailId, 
/* 2215 */             emailbody, 
/* 2216 */             emailSubject);
/*      */       }
/*      */       else {
/*      */         
/* 2220 */         this.challanOTPProcessBean.setOtp(0);
/*      */       }
/*      */     
/* 2223 */     } catch (Exception e) {
/* 2224 */       logger.error("Exception  " + e);
/* 2225 */       this.challanOTPProcessBean.setOtp(0);
/*      */     } 
/*      */     
/* 2228 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String fetchLuciCourseAmount() {
/* 2235 */     logger.info("**********fetchLuciCourseAmount ~START~**********" + System.currentTimeMillis());
/* 2236 */     logger.info("**********selectCourse **********" + this.selectCourse);
/* 2237 */     LoginActionService loginActionService = new LoginActionService();
/* 2238 */     this.courseAmount = loginActionService.getLuciCourseAmt(this.selectCourse);
/*      */     
/* 2240 */     logger.info("**********LuciCourse AMount Result ~END~**********" + this.courseAmount);
/* 2241 */     logger.info("**********fetchLuciCourseAmount ~END~**********" + System.currentTimeMillis());
/* 2242 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String printViewHorizonDetails() {
/* 2249 */     logger.info("!!!!!!!!!!printViewHorizonDetails()-->!!!!!!!!!!!!");
/*      */     
/* 2251 */     logger.info("!!!!!!!!!!!!!!!!!!!!!!");
/*      */     
/* 2253 */     String branchId = getUserSessionMap().get("branchId").toString();
/* 2254 */     StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 2255 */     List studentTransDetailsList = studentRegistrationService.getStudentTranDetailsList_Horizon(this.referenceId, branchId);
/* 2256 */     this.studentRegistrationFormBean = new StudentRegistrationFormBean();
/* 2257 */     this.studentRegistrationFormBean.setStudentTranDetailsList(studentTransDetailsList);
/*      */ 
/*      */     
/* 2260 */     getUserSessionMap().put("studentRegistrationFormBean", this.studentRegistrationFormBean);
/*      */     
/* 2262 */     setUniqueSessionIdentifier(getUserSessionMap().get("sessionKey").toString());
/* 2263 */     logger.info("!!!!!!!!!!printViewHorizonDetails()END-->!!!!!!!!!!!!");
/* 2264 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String printViewUGIDetails() {
/* 2269 */     logger.info("!!!!!!!!!!printViewUGIDetails() START-->!!!!!!!!!!!!");
/*      */     
/* 2271 */     logger.info("!!!!!!!!!!!!!!!!!!!!!!");
/* 2272 */     logger.info("printViewUGIDetails :-Student Id----" + this.referenceId);
/* 2273 */     String branchId = getUserSessionMap().get("branchId").toString();
/* 2274 */     StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 2275 */     List studentTransDetailsList = studentRegistrationService.getStudentTranDetailsList_UGIEreceipt(this.referenceId, branchId);
/* 2276 */     this.studentRegistrationFormBean = new StudentRegistrationFormBean();
/* 2277 */     this.studentRegistrationFormBean.setStudentTranDetailsList(studentTransDetailsList);
/*      */ 
/*      */     
/* 2280 */     getUserSessionMap().put("studentRegistrationFormBean", this.studentRegistrationFormBean);
/*      */     
/* 2282 */     setUniqueSessionIdentifier(getUserSessionMap().get("sessionKey").toString());
/* 2283 */     logger.info("!!!!!!!!!!printViewUGIDetails() END-->!!!!!!!!!!!!");
/* 2284 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String printViewNLUDetails() {
/* 2290 */     logger.info("!!!!!!!!!!printViewNLUDetails()-->!!!!!!!!!!!!");
/*      */     
/* 2292 */     logger.info("!!!!!!!!!!!!!!!!!!!!!!");
/*      */     
/* 2294 */     String branchId = getUserSessionMap().get("branchId").toString();
/* 2295 */     StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 2296 */     List studentTransDetailsList = studentRegistrationService.getStudentTranDetailsList_NLUEreceipt(this.referenceId, branchId);
/* 2297 */     this.studentRegistrationFormBean = new StudentRegistrationFormBean();
/* 2298 */     this.studentRegistrationFormBean.setStudentTranDetailsList(studentTransDetailsList);
/*      */ 
/*      */     
/* 2301 */     getUserSessionMap().put("studentRegistrationFormBean", this.studentRegistrationFormBean);
/*      */     
/* 2303 */     setUniqueSessionIdentifier(getUserSessionMap().get("sessionKey").toString());
/* 2304 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String FetchInderPrastaExistData() {
/* 2310 */     StudentRegistrationService service = new StudentRegistrationService();
/* 2311 */     this.inderPrasthaExistOnlineFormBean = service.FetchInderPrastaExistData(this.rollNo);
/*      */     
/* 2313 */     return "success";
/*      */   }
/*      */   public String fetchAmountDEncryption() {
/* 2316 */     logger.info(" fetchAmountDEncryption()-- Start ");
/* 2317 */     logger.info("total amount for encryption-------------------" + getTotalAmount().replaceAll(" ", "+"));
/* 2318 */     Decryption obj1 = new Decryption();
/* 2319 */     String amnt = obj1.decryptRSA(getTotalAmount().replaceAll(" ", "+"));
/*      */     
/* 2321 */     logger.info("total amount for encryption-amnt------------------" + amnt);
/* 2322 */     String fin = ChecksumGenerator.hmacSha1GLA(amnt, "1989083233a696819f2623039a9f8adf");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2340 */     logger.info("encrypted total amount-------------------" + fin);
/* 2341 */     this.challanOTPProcessBean = new ChallanOTPProcessBean();
/* 2342 */     this.challanOTPProcessBean.setEncryptedAmount(fin);
/* 2343 */     logger.info(" fetchAmountEncryption()-- End ");
/* 2344 */     return "success";
/*      */   }
/*      */ }


/* Location:              C:\SmartFees.war\SmartFees.war\WEB-INF\classes\!\com\app\feejunction\action\AjaxAction.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */