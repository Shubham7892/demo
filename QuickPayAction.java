/*      */
package com.app.feejunction.action;

/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.PrintWriter;
/*      */ import java.lang.reflect.Method;
/*      */ import java.text.DecimalFormat;
/*      */ import java.text.MessageFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Properties;

/*      */ import javax.servlet.RequestDispatcher;
/*      */ import javax.servlet.ServletException;
/*      */ import javax.servlet.ServletRequest;
/*      */ import javax.servlet.ServletResponse;
/*      */ import javax.servlet.http.HttpServletRequest;
/*      */ import javax.servlet.http.HttpServletResponse;

/*      */ import org.apache.commons.lang.StringEscapeUtils;
/*      */ import org.apache.struts2.ServletActionContext;
/*      */ import org.slf4j.Logger;
/*      */ import org.slf4j.LoggerFactory;
/*      */ import org.slf4j.MDC;

/*      */
/*      */ import com.app.feejunction.bean.AddChallanChargesBean;
/*      */ import com.app.feejunction.bean.BKLIOnlineFormBean;
/*      */ import com.app.feejunction.bean.BSEFormBean;
/*      */ import com.app.feejunction.bean.BSPROnlineFormBean;
/*      */ import com.app.feejunction.bean.BengalCollegeOnlineFormBean;
/*      */ import com.app.feejunction.bean.CampionSchoolFormBean;
/*      */ import com.app.feejunction.bean.CandEntryForm;
/*      */ import com.app.feejunction.bean.ChallanHistoryFormBean;
/*      */ import com.app.feejunction.bean.ChristineOnlineFormBean;
/*      */ import com.app.feejunction.bean.CourseDetailsBean;
/*      */ import com.app.feejunction.bean.DOONOnlineFormBean;
/*      */ import com.app.feejunction.bean.DOTUOnlineFormBean;
/*      */ import com.app.feejunction.bean.DTEFormBean;
/*      */ import com.app.feejunction.bean.EtoosOnlineFormBean;
/*      */ import com.app.feejunction.bean.FJBean;
/*      */ import com.app.feejunction.bean.FeesPayChargesFormBean;
/*      */ import com.app.feejunction.bean.GPSOnlineFormBean;
/*      */ import com.app.feejunction.bean.GpullaReadyFormBean;
/*      */ import com.app.feejunction.bean.HaryanaFormBean;
/*      */ import com.app.feejunction.bean.HorizonOnlineFormBean;
/*      */ import com.app.feejunction.bean.HydroPowerOnlineFormBean;
/*      */ import com.app.feejunction.bean.IEIIndiaOnlineFormBean;
/*      */ import com.app.feejunction.bean.IIBMSFormBean;
/*      */ import com.app.feejunction.bean.IITBActionFormBean;
/*      */ import com.app.feejunction.bean.INTLCourseFormBean;
/*      */ import com.app.feejunction.bean.INTLOnlineFormBean;
/*      */ import com.app.feejunction.bean.InstituteAliasCodeConfigBean;
/*      */ import com.app.feejunction.bean.InstituteConfigBean;
/*      */ import com.app.feejunction.bean.InstituteMasterFormBean;
/*      */ import com.app.feejunction.bean.JRSTOnlineFormBean;
/*      */ import com.app.feejunction.bean.JayotiFormBean;
/*      */ import com.app.feejunction.bean.KaushalyaFormBean;
/*      */ import com.app.feejunction.bean.LanOnlineFormBean;
/*      */ import com.app.feejunction.bean.LuciOnlineFormBean;
/*      */ import com.app.feejunction.bean.MATSFeesForm;
/*      */ import com.app.feejunction.bean.MGCOnlineFormBean;
/*      */ import com.app.feejunction.bean.MGRMedicalOnlineFormBean;
/*      */ import com.app.feejunction.bean.MerchantDetailsFormBean;
/*      */ import com.app.feejunction.bean.NATLOnlineFormBean;
/*      */ import com.app.feejunction.bean.NIPROnlineFormBean;
/*      */ import com.app.feejunction.bean.NISMOnlineFormBean;
/*      */ import com.app.feejunction.bean.NISMParticipantFormBean;
/*      */ import com.app.feejunction.bean.NITOnlineFormBean;
/*      */ import com.app.feejunction.bean.OnlineFormBean;
/*      */ import com.app.feejunction.bean.OrigenceOnlineFormBean;
/*      */ import com.app.feejunction.bean.PPAFormBean;
/*      */ import com.app.feejunction.bean.PaymentRequestBean;
/*      */ import com.app.feejunction.bean.PrincipalAIAFormBean;
/*      */ import com.app.feejunction.bean.RPTMOnlineFormBean;
/*      */ import com.app.feejunction.bean.RamaCollageFormBeanResponse;
/*      */ import com.app.feejunction.bean.RungtaCollegeFormBean;
/*      */ import com.app.feejunction.bean.RungtanlineFormBean;
/*      */ import com.app.feejunction.bean.SHIVFormBean;
/*      */ import com.app.feejunction.bean.SWARAFormBean;
/*      */ import com.app.feejunction.bean.SharpmindsOnlineFormBean;
/*      */ import com.app.feejunction.bean.ShoppingKartParameterFormBean;
/*      */ import com.app.feejunction.bean.StudentFeesFormBean;
/*      */ import com.app.feejunction.bean.StudentRegistrationFormBean;
/*      */ import com.app.feejunction.bean.TOLANIFormBean;
/*      */ import com.app.feejunction.bean.UGIOnlineFormBean;
/*      */ import com.app.feejunction.bean.URLInstituteRequestBean;
/*      */ import com.app.feejunction.bean.UnisonFormBean;
/*      */ import com.app.feejunction.bean.WBUTUniversityFormBean;
/*      */ import com.app.feejunction.bean.WelhamSchoolFormBean;
/*      */ import com.app.feejunction.bean.YMCAOnlineFormBean;
/*      */ import com.app.feejunction.helper.HttpsClientSMS;
/*      */ import com.app.feejunction.service.ChallanHistoryService;
/*      */ import com.app.feejunction.service.CourseDetailsService;
/*      */ import com.app.feejunction.service.InstituteMasterActionService;
/*      */ import com.app.feejunction.service.LoginActionService;
/*      */ import com.app.feejunction.service.PaymentService;
/*      */ import com.app.feejunction.service.StudentDataService;
/*      */ import com.app.feejunction.service.StudentRegistrationService;
/*      */ import com.tpsl.emailsms.EmailEreceipt;
/*      */ import com.tpsl.feespay.model.PaymentDetails;
/*      */ import com.tpsl.util.ChallanServiceUtil;
/*      */ import com.tpsl.util.EncryptDecryptString;
/*      */ import com.tpsl.util.PG_Payment_Response;
/*      */ import com.tpsl.util.PaymentServiceUtil;
/*      */ import com.tpsl.util.PropertyReader;
/*      */ import com.tpsl.util.SaveObject;
/*      */ import com.tpsl.util.Utility;

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
/*      */ public class QuickPayAction/*      */ extends FJAction
/*      */ {
	/* 130 */ private static final Logger logger = LoggerFactory.getLogger(QuickPayAction.class);
	/* 131 */ private static final Logger audit = LoggerFactory.getLogger("audit");
	/*      */
	/*      */ String redirectionURL;
	/*      */
	/*      */ String responseurlgla;
	/*      */ private PaymentRequestBean appData;
	/* 137 */ private CourseDetailsBean courseData = new CourseDetailsBean();
	/*      */ private String strPaymentType;
	/*      */ private String strPaymentMode;
	/*      */ private InputStream fileInputStream;
	/* 141 */ private String strChallanPath = "NA";
	private String studentRegistrationId;
	/*      */ private Map studentData;
	/*      */ private List<String> feesPayList;
	/*      */ private String payableFeeIndexes;
	/*      */ private String uniqueIdentificationId;
	/*      */ private StudentRegistrationFormBean appdata1;
	/*      */ private RamaCollageFormBeanResponse ramaresponse;
	/*      */ private IITBActionFormBean iiitbResponse;

	/*      */
	/*      */ public IITBActionFormBean getIiitbResponse() {
		/* 151 */ return this.iiitbResponse;
		/*      */ }

	/*      */ public void setIiitbResponse(IITBActionFormBean iiitbResponse) {
		/* 154 */ this.iiitbResponse = iiitbResponse;
		/*      */ }

	/*      */
	/* 157 */ private Map<String, String> iitbUniversityList = null;
	/* 158 */ private Map<String, String> stateMapList = null;
	/* 159 */ private Map<String, String> diplomaMapList = null;
	/* 160 */ private Map<String, String> gradMapList = null;
	/* 161 */ private Map<String, String> postGradMapList = null;
	/*      */ private NISMOnlineFormBean nismOnlineFormBean;
	/*      */ private List<String> nismcoursedetails;
	/*      */ private CandEntryForm candEntryForm;
	/*      */ private String instituteId;
	/* 166 */ HorizonOnlineFormBean horizonOnlineFormBean = null;
	/* 167 */ String VASPmtId = new String();
	private String courseDetails;
	/*      */ private AddChallanChargesBean addChallanChargesBean;

	/*      */
	/*      */ public String getVASPmtId() {
		/* 171 */ return this.VASPmtId;
		/*      */ }

	/*      */ public void setVASPmtId(String vASPmtId) {
		/* 174 */ this.VASPmtId = vASPmtId;
		/*      */ }

	/*      */
	/*      */
	/*      */ public HorizonOnlineFormBean getHorizonOnlineFormBean() {
		/* 179 */ return this.horizonOnlineFormBean;
		/*      */ }

	/*      */ public void setHorizonOnlineFormBean(HorizonOnlineFormBean horizonOnlineFormBean) {
		/* 182 */ this.horizonOnlineFormBean = horizonOnlineFormBean;
		/*      */ }

	/*      */ public String getInstituteId() {
		/* 185 */ return this.instituteId;
		/*      */ }

	/*      */ public void setInstituteId(String instituteId) {
		/* 188 */ this.instituteId = instituteId;
		/*      */ }

	/*      */
	/*      */ public CandEntryForm getCandEntryForm() {
		/* 192 */ return this.candEntryForm;
		/*      */ }

	/*      */ public void setCandEntryForm(CandEntryForm candEntryForm) {
		/* 195 */ this.candEntryForm = candEntryForm;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public String getCourseDetails() {
		/* 203 */ return this.courseDetails;
		/*      */ }

	/*      */ public void setCourseDetails(String courseDetails) {
		/* 206 */ this.courseDetails = courseDetails;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public List<String> getNismcoursedetails() {
		/* 216 */ return this.nismcoursedetails;
		/*      */ }

	/*      */ public void setNismcoursedetails(List<String> nismcoursedetails) {
		/* 219 */ this.nismcoursedetails = nismcoursedetails;
		/*      */ }

	/*      */ public NISMOnlineFormBean getNismOnlineFormBean() {
		/* 222 */ return this.nismOnlineFormBean;
		/*      */ }

	/*      */ public void setNismOnlineFormBean(NISMOnlineFormBean nismOnlineFormBean) {
		/* 225 */ this.nismOnlineFormBean = nismOnlineFormBean;
		/*      */ }

	/*      */ public Map<String, String> getPostGradMapList() {
		/* 228 */ return this.postGradMapList;
		/*      */ }

	/*      */ public void setPostGradMapList(Map<String, String> postGradMapList) {
		/* 231 */ this.postGradMapList = postGradMapList;
		/*      */ }

	/*      */ public Map<String, String> getGradMapList() {
		/* 234 */ return this.gradMapList;
		/*      */ }

	/*      */ public void setGradMapList(Map<String, String> gradMapList) {
		/* 237 */ this.gradMapList = gradMapList;
		/*      */ }

	/*      */ public Map<String, String> getDiplomaMapList() {
		/* 240 */ return this.diplomaMapList;
		/*      */ }

	/*      */ public void setDiplomaMapList(Map<String, String> diplomaMapList) {
		/* 243 */ this.diplomaMapList = diplomaMapList;
		/*      */ }

	/*      */ public Map<String, String> getStateMapList() {
		/* 246 */ return this.stateMapList;
		/*      */ }

	/*      */ public void setStateMapList(Map<String, String> stateMapList) {
		/* 249 */ this.stateMapList = stateMapList;
		/*      */ }

	/*      */ public Map<String, String> getIitbUniversityList() {
		/* 252 */ return this.iitbUniversityList;
		/*      */ }

	/*      */ public void setIitbUniversityList(Map<String, String> iitbUniversityList) {
		/* 255 */ this.iitbUniversityList = iitbUniversityList;
		/*      */ }

	/*      */ public StudentRegistrationFormBean getAppdata1() {
		/* 258 */ return this.appdata1;
		/*      */ }

	/*      */ public RamaCollageFormBeanResponse getRamaresponse() {
		/* 261 */ return this.ramaresponse;
		/*      */ }

	/*      */ public void setRamaresponse(RamaCollageFormBeanResponse ramaresponse) {
		/* 264 */ this.ramaresponse = ramaresponse;
		/*      */ }

	/*      */ public void setAppdata1(StudentRegistrationFormBean appdata1) {
		/* 267 */ this.appdata1 = appdata1;
		/*      */ }

	/*      */ public String getResponseurlgla() {
		/* 270 */ return this.responseurlgla;
		/*      */ }

	/*      */ public void setResponseurlgla(String responseurlgla) {
		/* 273 */ this.responseurlgla = responseurlgla;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/* 278 */ private String StudentName = "";
	/* 279 */ private String EmailID = "";
	/* 280 */ private String MobileNo = "";
	/* 281 */ private String TotalFeesAmount = "";
	/*      */ private String UniquiIdentificationId;
	/* 283 */ private String remark = "";
	/*      */
	/*      */ private String transactionId;

	/*      */
	/*      */ public String getRemark() {
		/* 288 */ return this.remark;
		/*      */ }

	/*      */ public void setRemark(String remark) {
		/* 291 */ this.remark = remark;
		/*      */ }

	/*      */ public String getUniquiIdentificationId() {
		/* 294 */ return this.UniquiIdentificationId;
		/*      */ }

	/*      */ public void setUniquiIdentificationId(String uniquiIdentificationId) {
		/* 297 */ this.UniquiIdentificationId = uniquiIdentificationId;
		/*      */ }

	/*      */
	/*      */
	/* 301 */ FeesPayChargesFormBean feesPayChargesFormBean = new FeesPayChargesFormBean();
	/* 302 */ InstituteConfigBean instituteConfigBean = new InstituteConfigBean();

	/*      */
	/*      */
	/*      */ public String directQuickPay() {
		/* 306 */ String billerId = ((FJBean) getUserSessionMap().get("BASEDATA")).getBillerId();
		/* 307 */ InstituteMasterActionService service = new InstituteMasterActionService();
		/* 308 */ billerId = service.getInstituteCode(billerId);
		/* 309 */ if (billerId.equalsIgnoreCase("SKV"))
		/*      */ {
			/* 311 */ return FJAction.SKVHOME;
		}
		/* 312 */ if (billerId.equalsIgnoreCase("SPS")) {
			/* 313 */ return FJAction.SPSSML;
			/*      */ }
		/* 315 */ if (billerId.equalsIgnoreCase("IITV")) {
			/* 316 */ return "iitvhome";
			/*      */ }
		/*      */
		/* 319 */ return "success";
		/*      */ }

	/*      */
	/*      */ public String load() throws Exception {
		/* 323 */ if (!isValidSession()) {
			/* 324 */ addActionError("Your session has been invalidated. Please login again.");
			/* 325 */ return "error";
			/*      */ }
		/* 327 */ this.studentData = null;
		/* 328 */ String registeredUserId = ((FJBean) getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
		/* 329 */ LoginActionService loginActionService = new LoginActionService();
		/* 330 */ setStudentData(loginActionService.getRegisteredStudentList(registeredUserId));
		/* 331 */ return "success";
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */ public String directLoad() throws Exception {
		/* 337 */ if (!isValidSession()) {
			/* 338 */ addActionError("Your session has been invalidated. Please login again.");
			/* 339 */ return "error";
			/*      */ }
		/* 341 */ String billerId = ((FJBean) getUserSessionMap().get("BASEDATA")).getBillerId();
		/* 342 */ InstituteConfigBean instituteConfigBean = (InstituteConfigBean) getUserSessionMap().get("INSTCONFIG");
		/* 343 */ LoginActionService loginActionService = new LoginActionService();
		/* 344 */ InstituteMasterActionService service = new InstituteMasterActionService();
		/* 345 */ billerId = service.getInstituteCode(billerId);
		/* 346 */ if (billerId.equalsIgnoreCase("BHU")) {
			/*      */
			/* 348 */ this.studentData = null;
			/* 349 */ setStudentData(loginActionService.getMember_Flag());
			/* 350 */ return FJAction.BHUHOME;
			/*      */ }
		/* 352 */ if (billerId.equalsIgnoreCase("GNLU")) {
			/*      */
			/* 354 */ this.studentData = null;
			/* 355 */ setStudentData(loginActionService.getGnlu_category());
			/* 356 */ return FJAction.GNLUHOME;
			/* 357 */ }
		if (billerId.equalsIgnoreCase("SPS"))
		/*      */ {
			/* 359 */ return FJAction.SPSSML;
		}
		/* 360 */ if (billerId.equalsIgnoreCase("SKV"))
		/*      */ {
			/* 362 */ return FJAction.SKVHOME;
		}
		/* 363 */ if (billerId.equalsIgnoreCase("RAMOL")) {
			/*      */
			/* 365 */ this.studentData = null;
			/* 366 */ setStudentData(loginActionService.getRamaCollage_category());
			/* 367 */ return FJAction.RAMHOME;
			/*      */ }
		/* 369 */ if (billerId.equalsIgnoreCase("3038")) {
			/*      */
			/* 371 */ this.studentData = null;
			/* 372 */ setStudentData(loginActionService.getIITMCollage_category());
			/* 373 */ setInstituteId(billerId);
			/*      */
			/* 375 */ return "ramhome2";
			/*      */ }
		/* 377 */ if (billerId.equalsIgnoreCase("IMS"))
		/*      */ {
			/*      */
			/* 380 */ return FJAction.IMSHOME;
			/*      */ }
		/* 382 */ if (billerId.equalsIgnoreCase("WBUTEA") || billerId.equalsIgnoreCase("WBUTEAN"))
		/*      */ {
			/* 384 */ return FJAction.WBUTHOME;
		}
		/* 385 */ if (billerId.equalsIgnoreCase("IIITB")) {
			/*      */
			/* 387 */ setIitbUniversityList(loginActionService.getIitbUniversityList(billerId));
			/* 388 */ setStateMapList(loginActionService.getStateMapList());
			/* 389 */ setDiplomaMapList(loginActionService.getDeplomaMapList());
			/* 390 */ setGradMapList(loginActionService.getGraduationMapList());
			/* 391 */ setPostGradMapList(loginActionService.getPostGraduationMapList());
			/* 392 */ Date date = new Date();
			/* 393 */ String currentDate = (new SimpleDateFormat("yyyy-MM-dd")).format(date);
			/* 394 */ String admissionLastDate = ((InstituteConfigBean) getUserSessionMap().get("INSTCONFIG"))
					.getAdmissionLastDate();
			/* 395 */ admissionLastDate = admissionLastDate.substring(0, 10);
			/* 396 */ if (currentDate.equalsIgnoreCase(admissionLastDate))
			/*      */ {
				/* 398 */ return FJAction.IIITBADMCLOSED;
				/*      */ }
			/* 400 */ return FJAction.IITBHOME;
			/*      */ }
		/*      */
		/* 403 */ if (billerId.equalsIgnoreCase("GPR"))
		/*      */ {
			/* 405 */ return FJAction.GPULLAREADYHOME;
			/*      */ }
		/* 407 */ if ("UWS".equalsIgnoreCase(billerId) || "UWSD".equalsIgnoreCase(billerId))
		/*      */ {
			/* 409 */ return FJAction.UWSHOME;
			/*      */ }
		/* 411 */ if ("YMCAMS".equalsIgnoreCase(billerId) || "YMCAMT".equalsIgnoreCase(billerId)) {
			/* 412 */ getUserSessionMap().put("INSTCODE", billerId);
			/* 413 */ return FJAction.YMCAHOME;
			/*      */ }
		/* 415 */ if (billerId.equalsIgnoreCase("NITMEGH"))
		/*      */ {
			/* 417 */ return FJAction.NITMEGHHOME;
			/*      */ }
		/* 419 */ if (billerId.equalsIgnoreCase("CHAMPIO") || billerId.equalsIgnoreCase("JRKG")) {
			/*      */
			/* 421 */ Date date = new Date();
			/* 422 */ String currentDate = (new SimpleDateFormat("yyyy-MM-dd")).format(date);
			/* 423 */ String admissionLastDate = ((InstituteConfigBean) getUserSessionMap().get("INSTCONFIG"))
					.getAdmissionLastDate();
			/* 424 */ admissionLastDate = admissionLastDate.substring(0, 10);
			/* 425 */ if (currentDate.equalsIgnoreCase(admissionLastDate))
			/*      */ {
				/* 427 */ return FJAction.IIITBADMCLOSED;
				/*      */ }
			/* 429 */ return FJAction.CAMPIONHOME;
			/*      */ }
		/*      */
		/* 432 */ if (billerId.equalsIgnoreCase("CUOH"))
		/*      */ {
			/* 434 */ return FJAction.HARYANAHOME;
			/*      */ }
		/* 436 */ if (billerId.equalsIgnoreCase("BCE") || billerId.equalsIgnoreCase("BCENEW") ||
		/* 437 */ billerId.equalsIgnoreCase("BCET") || billerId.equalsIgnoreCase("BCETNEW") ||
		/* 438 */ billerId.equalsIgnoreCase("BCPSR") || billerId.equalsIgnoreCase("BCPSRNEW") ||
		/* 439 */ billerId.equalsIgnoreCase("BCPO") || billerId.equalsIgnoreCase("BCPONEW")) {
			/*      */
			/* 441 */ setStateMapList(loginActionService.getStateMapList());
			/* 442 */ return FJAction.BCHOME;
			/* 443 */ }
		if (billerId.equalsIgnoreCase("YMCABT") || billerId.equalsIgnoreCase("YMCBTL") ||
		/* 444 */ billerId.equalsIgnoreCase("YMCMBA") || billerId.equalsIgnoreCase("YMCMCA") ||
		/* 445 */ billerId.equalsIgnoreCase("YMCMTL")) {
			/* 446 */ getUserSessionMap().put("INSTCODE", billerId);
			/* 447 */ return FJAction.YMCAALLHOME;
			/* 448 */ }
		if (billerId.equalsIgnoreCase("BSEL"))
		/*      */ {
			/* 450 */ return FJAction.BSEHOME;
			/*      */ }
		/* 452 */ if (billerId.equalsIgnoreCase("WBSDDN"))
		/*      */ {
			/* 454 */ return FJAction.WELHAMHOME;
			/*      */ }
		/* 456 */ if (billerId.equalsIgnoreCase("IITV"))
		/*      */ {
			/* 458 */ return "iitvhome";
			/*      */ }
		/* 460 */ if (billerId.equalsIgnoreCase("MGRU"))
		/*      */ {
			/* 462 */ return "mgrHome";
			/*      */ }
		/* 464 */ if (billerId.equalsIgnoreCase("NIPR"))
		/*      */ {
			/* 466 */ return "niprHome";
		}
		/* 467 */ if ("Y".equalsIgnoreCase(instituteConfigBean.getMonthlyFeeDispFlg()))
		/*      */ {
			/* 469 */ return "mfdhome";
		}
		/* 470 */ if (billerId.equalsIgnoreCase("AEMD") || billerId.equalsIgnoreCase("AEMM")) {
			/* 471 */ this.candEntryForm = new CandEntryForm();
			/* 472 */ this.candEntryForm.setSelectCourseTypeMumbaiList(new ArrayList());
			/* 473 */ getUserSessionMap().put("INSTCODE", billerId);
			/* 474 */ return FJAction.ANGLOHOME;
			/* 475 */ }
		if (billerId.equalsIgnoreCase("AEAM")) {
			/* 476 */ this.candEntryForm = new CandEntryForm();
			/* 477 */ this.candEntryForm
					.setSelectCourseTypeMumbaiList(loginActionService.getcourseDetailsList(billerId));
			/*      */
			/* 479 */ getUserSessionMap().put("INSTCODE", billerId);
			/* 480 */ return FJAction.ANGLOHOME;
			/* 481 */ }
		if (billerId.equalsIgnoreCase("UGI") || billerId.equalsIgnoreCase("UIMA") ||
		/* 482 */ billerId.equalsIgnoreCase("UIEM") || billerId.equalsIgnoreCase("UIT") ||
		/* 483 */ billerId.equalsIgnoreCase("UIP") || billerId.equalsIgnoreCase("UIMF") ||
		/* 484 */ billerId.equalsIgnoreCase("UIOM") || billerId.equalsIgnoreCase("UCOE")) {
			/* 485 */ getUserSessionMap().put("INSTCODE", billerId);
			/* 486 */ return FJAction.UGIHOME;
			/* 487 */ }
		if (billerId.equalsIgnoreCase("PMHP"))
		/*      */ {
			/* 489 */ return "pmhpHome";
			/*      */ }
		/* 491 */ if (billerId.equalsIgnoreCase("DSDOON") || billerId.equalsIgnoreCase("DOIN"))
		/*      */ {
			/* 493 */ return "doonHome";
			/*      */ }
		/* 495 */ if (billerId.equalsIgnoreCase("JRST"))
		/*      */ {
			/* 497 */ return "jrstHome";
			/*      */ }
		/* 499 */ if (billerId.equalsIgnoreCase("MIES") || billerId.equalsIgnoreCase("MESL") ||
		/* 500 */ billerId.equalsIgnoreCase("MIMT") || billerId.equalsIgnoreCase("MCMT") ||
		/* 501 */ billerId.equalsIgnoreCase("MIIT") || billerId.equalsIgnoreCase("MEPI")) {
			/* 502 */ getUserSessionMap().put("INSTCODE", billerId);
			/* 503 */ return FJAction.MGCHOME;
			/* 504 */ }
		if (billerId.equalsIgnoreCase("DOTU"))
		/*      */ {
			/* 506 */ return FJAction.DOTUHOME;
		}
		/* 507 */ if (billerId.equalsIgnoreCase("RPTM"))
		/*      */ {
			/* 509 */ return FJAction.RPTMHOME;
		}
		/* 510 */ if (billerId.equalsIgnoreCase("OMSA") || billerId.equalsIgnoreCase("GRTR"))
		/*      */ {
			/* 512 */ return FJAction.KAUSHHOME;
		}
		/* 513 */ if (billerId.equalsIgnoreCase("RUEC") || billerId.equalsIgnoreCase("GDRU") ||
		/* 514 */ billerId.equalsIgnoreCase("RUNG") || billerId.equalsIgnoreCase("PSAR")) {
			/* 515 */ getUserSessionMap().put("INSTCODE", billerId);
			/* 516 */ return FJAction.RUNGTAHOME;
			/* 517 */ }
		if (billerId.equalsIgnoreCase("NISM")) {
			/*      */
			/* 519 */ this.nismOnlineFormBean = new NISMOnlineFormBean();
			/* 520 */ this.nismOnlineFormBean.setNismcoursedetails(loginActionService.getNISMCourseDetailsList());
			/*      */
			/* 522 */ return FJAction.NISMHOME;
			/* 523 */ }
		if (billerId.equalsIgnoreCase("CVIP"))
		/*      */ {
			/* 525 */ return FJAction.CHRISTINEHOME;
		}
		/* 526 */ if (billerId.equalsIgnoreCase("SEPL"))
		/*      */ {
			/* 528 */ return FJAction.SHARPHOME;
			/*      */ }
		/* 530 */ if (billerId.equalsIgnoreCase("2632"))
		/*      */ {
			/* 532 */ return FJAction.ETOOSHOME;
		}
		/* 533 */ if (billerId.equalsIgnoreCase("2659"))
		/*      */ {
			/* 535 */ return FJAction.MATSHOME;
		}
		/* 536 */ if (billerId.equalsIgnoreCase("2672"))
		/*      */ {
			/* 538 */ return FJAction.BSPRHOME;
		}
		/* 539 */ if (billerId.equalsIgnoreCase("BKLI"))
		/*      */ {
			/* 541 */ return FJAction.BKLIHOME;
		}
		/* 542 */ if (billerId.equalsIgnoreCase("2734"))
		/*      */ {
			/* 544 */ return "iimbsHome";
		}
		/* 545 */ if (billerId.equalsIgnoreCase("2754"))
		/*      */ {
			/* 547 */ return "ppaHome";
		}
		/* 548 */ if (billerId.equalsIgnoreCase("2831"))
		/*      */ {
			/* 550 */ return "jayotiHome";
		}
		/* 551 */ if (billerId.equalsIgnoreCase("2846"))
		/*      */ {
			/* 553 */ return "principalHome";
		}
		/* 554 */ if (billerId.equalsIgnoreCase("2872")) {
			/* 555 */ StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
			/* 556 */ List<INTLCourseFormBean> courseDataList = studentRegistrationService.fetchINTLCourseDetails();
			/* 557 */ if (courseDataList != null && courseDataList.size() > 0) {
				/* 558 */ getUserSessionMap().put("_gnluChallanDataList", courseDataList);
				/*      */ } else {
				/* 560 */ getUserSessionMap().put("_gnluChallanDataList", courseDataList);
				/* 561 */ addActionError("No records found for the specified condition");
				/*      */ }
			/* 563 */ return "intliitHome";
			/* 564 */ }
		if (billerId.equalsIgnoreCase("2879"))
		/*      */ {
			/* 566 */ return "origenceHome";
		}
		/* 567 */ if (billerId.equalsIgnoreCase("2925"))
		/*      */ {
			/* 569 */ return "natlHome";
		}
		/* 570 */ if (billerId.equalsIgnoreCase("2931"))
		/*      */ {
			/* 572 */ return "lanHome";
			/*      */ }
		/* 574 */ if (billerId.equalsIgnoreCase("DIRE"))
		/*      */ {
			/* 576 */ return "dteFHome";
			/*      */ }
		/* 578 */ if (billerId.equalsIgnoreCase("DIRT"))
		/*      */ {
			/* 580 */ return "dteRHome";
			/*      */ }
		/* 582 */ if (billerId.equalsIgnoreCase("2988") || billerId.equalsIgnoreCase("2989")
				|| billerId.equalsIgnoreCase("2990") || billerId.equalsIgnoreCase("2991"))
		/*      */ {
			/* 584 */ return "rungtaColHome";
		}
		/* 585 */ if (billerId.equalsIgnoreCase("3046"))
		/*      */ {
			/* 587 */ return FJAction.GPSHOME;
			/*      */ }
		/* 589 */ if (billerId.equalsIgnoreCase("3106") || billerId.equalsIgnoreCase("3126")
				|| billerId.equalsIgnoreCase("3128"))
		/*      */ {
			/* 591 */ return "tolaniHome";
			/*      */ }
		/* 593 */ if (billerId.equalsIgnoreCase("3138"))
		/*      */ {
			/* 595 */ return "shivHome";
			/*      */ }
		/* 597 */ if (billerId.equalsIgnoreCase("3145"))
		/*      */ {
			/* 599 */ return "hydroPowerHome";
			/*      */ }
		/* 601 */ if (billerId.equalsIgnoreCase("3150"))
		/*      */ {
			/* 603 */ return "swaraHome";
			/*      */ }
		/* 605 */ if (billerId.equalsIgnoreCase("3279")) {
			/*      */
			/* 607 */ setGradMapList(loginActionService.getOERCCourseDetails());
			/* 608 */ String returnMapping = ((InstituteAliasCodeConfigBean) getUserSessionMap()
					.get("_instituteAliasCodeConfigBean")).getLoadReturnMapping();
			/* 609 */ return returnMapping;
			/*      */ }
		/*      */
		/* 612 */ if (billerId.equalsIgnoreCase("3281")) {
			/*      */
			/* 614 */ setGradMapList(loginActionService.getOERCPCourseDetails());
			/* 615 */ String returnMapping = ((InstituteAliasCodeConfigBean) getUserSessionMap()
					.get("_instituteAliasCodeConfigBean")).getLoadReturnMapping();
			/* 616 */ return returnMapping;
			/* 617 */ }
		if (billerId.equalsIgnoreCase("3377") || billerId.equalsIgnoreCase("3378")) {
			/* 618 */ if (billerId.equalsIgnoreCase("3377")) {
				/* 619 */ setUniqueIdentificationId(loginActionService.fetchUniqueIdForLuci());
				/* 620 */ setStateMapList(loginActionService.getStateMapList());
				/*      */ } else {
				/* 622 */ String appUniqueId = (String) getUserSessionMap().get("_applicationNo");
				/* 623 */ String decryptedappUniqueId = EncryptDecryptString.decrypt(appUniqueId);
				/* 624 */ String[] strDetails = loginActionService.fetchLuciDetails(decryptedappUniqueId);
				/* 625 */ setStudentName(strDetails[0]);
				/* 626 */ setMobileNo(strDetails[1]);
				/* 627 */ setRemark(strDetails[2]);
				/* 628 */ setCourseDetails(strDetails[3]);
				/* 629 */ setUniqueIdentificationId(decryptedappUniqueId);
				/*      */ }
			/*      */
			/* 632 */ String returnMapping = ((InstituteAliasCodeConfigBean) getUserSessionMap()
					.get("_instituteAliasCodeConfigBean")).getLoadReturnMapping();
			/* 633 */ return returnMapping;
			/*      */ }
		/*      */
		/*      */
		/*      */
		/* 638 */ getUserSessionMap().put("_institutecode", billerId);
		/* 639 */ getUserSessionMap().put("_logoutButtonOff", "N");
		/* 640 */ if ((InstituteAliasCodeConfigBean) getUserSessionMap().get("_instituteAliasCodeConfigBean") != null) {
			/* 641 */ String returnMapping = ((InstituteAliasCodeConfigBean) getUserSessionMap()
					.get("_instituteAliasCodeConfigBean")).getLoadReturnMapping();
			/* 642 */ if (returnMapping != null)
				/* 643 */ return returnMapping;
			/*      */ }
		/* 645 */ return DIRECT_QUICK_PAY;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public String _load() throws Exception {
		/* 653 */ if (!isValidSession()) {
			/* 654 */ addActionError("Your session has been invalidated. Please login again.");
			/* 655 */ return "error";
			/*      */ }
		/*      */
		/* 658 */ CourseDetailsService courseDetailsService = new CourseDetailsService();
		/* 659 */ String billerId = ((FJBean) getUserSessionMap().get("BASEDATA")).getBillerId();
		/* 660 */ Map instituteBranchMap = courseDetailsService.getBillerBranchList(billerId);
		/*      */
		/* 662 */ if (instituteBranchMap != null && !instituteBranchMap.isEmpty()) {
			/*      */
			/* 664 */ getCourseData().setMapInstituteBranchList(instituteBranchMap);
			/* 665 */ if (instituteBranchMap.size() == 1) {
				/* 666 */ logger.info("Institute Branch Size is 1 ...so taking default branch");
				/* 667 */ getCourseData().setMapCourseList(courseDetailsService.getCourseList(billerId, "Q"));
				/*      */ }
			/*      */ } else {
			/* 670 */ logger.info("branch MAP is empty");
			/*      */ }
		/* 672 */ getUserSessionMap().put("COURSEDATA", getCourseData());
		/* 673 */ return "success";
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public String confirm() {
		/* 684 */ HttpServletRequest request = ServletActionContext.getRequest();
		/* 685 */ logger.info("Inside QuickPayAction --> confirm()" + request);
		/*      */
		/*      */
		/*      */
		/*      */
		/*      */
		/*      */
		/*      */
		/* 693 */ logger.info("Before VASPmtId Confirm()-->");
		/* 694 */ String newPmtId = request.getParameter("merchantRefNo");
		/* 695 */ if (newPmtId != null) {
			/* 696 */ logger.info("getting merchantRefNo from request-->" + newPmtId);
			/*      */ } else {
			/*      */
			/* 699 */ logger.info("getting merchantRefNo is blank or null-->");
			/*      */ }
		/*      */
		/* 702 */ logger.info("Before pmtMode Confirm()-->");
		/* 703 */ String pmtMode = request.getParameter("strPaymentMode");
		/* 704 */ logger.info("getting pmtMode from request-->" + pmtMode);
		/* 705 */ if (getStrPaymentMode() == null) {
			/* 706 */ setStrPaymentMode(pmtMode);
			/* 707 */ logger.info("Setting value of PmtMode");
			/*      */ }
		/*      */
		/* 710 */ logger.info("Before pmtType Confirm()-->");
		/* 711 */ String pmtType = request.getParameter("strPaymentType");
		/* 712 */ logger.info("getting pmtType from request-->" + pmtType);
		/* 713 */ if (getStrPaymentType() == null) {
			/* 714 */ setStrPaymentType(pmtType);
			/* 715 */ logger.info("Setting value of pmtType");
			/*      */ }
		/*      */
		/*      */
		/* 719 */ this.VASPmtId = newPmtId;
		/* 720 */ if (this.VASPmtId != null) {
			/* 721 */ setVASPmtId(this.VASPmtId);
			/* 722 */ getUserSessionMap().put("VASPmtId", this.VASPmtId);
			/* 723 */ logger.info("VASPmtId value Inside Confirm ()--" + this.VASPmtId);
			/*      */ } else {
			/*      */
			/* 726 */ logger.info("VASPmtId value Inside Confirm () blank or null--");
			/*      */ }
		/*      */
		/* 729 */ SaveObject getSaveObj = new SaveObject();
		/*      */
		/*      */
		/* 732 */ if (this.appData == null && this.VASPmtId != null) {
			/*      */ try {
				/* 734 */ this.appData = (PaymentRequestBean) getSaveObj.getObject(this.VASPmtId, "APPDATA_OfflineVAS");
				/*      */
				/* 736 */ getUserSessionMap().put("APPDATA", this.appData);
				/* 737 */ } catch (Exception e) {
				/*      */
				/* 739 */ logger.error("Exception  " + e);
				/*      */ }
			/*      */ } else {
			/*      */
			/* 743 */ logger.info("appData value Inside Confirm () blank or null--");
			/*      */ }
		/*      */
		/*      */
		/*      */
		/* 748 */ if (getUserSessionMap().get("BASEDATA") == null && this.VASPmtId != null) {
			/*      */
			/*      */ try {
				/* 751 */ FJBean fjBeanVas = (FJBean) getSaveObj.getObject(this.VASPmtId, "BASEDATA_OfflineVAS");
				/* 752 */ logger.info("Inside Confirm Getting BASEDATA object from DB for VASPmtId-->" + this.VASPmtId
						+ "\t" + fjBeanVas.toString());
				/* 753 */ getUserSessionMap().put("BASEDATA", fjBeanVas);
				/* 754 */ } catch (Exception e) {
				/*      */
				/* 756 */ logger.error("Exception  " + e);
				/*      */ }
			/*      */
			/*      */ } else {
			/*      */
			/* 761 */ logger.info("BASEDATA value Inside Confirm () blank or null--");
			/*      */ }
		/*      */
		/*      */
		/*      */
		/* 766 */ if (getUserSessionMap().get("glaUniversityStudentFormBean") == null && this.VASPmtId != null) {
			/*      */
			/*      */ try {
				/* 769 */ URLInstituteRequestBean glaUniversityStudentFormBean = (URLInstituteRequestBean) getSaveObj
						.getObject(this.VASPmtId, "glaUniversityStudentFormBean_OfflineVAS");
				/* 770 */ logger.info(
						"Inside Confirm Getting glaUniversityStudentFormBean_OfflineVAS object from DB for VASPmtId-->"
								+ this.VASPmtId + "\t" + glaUniversityStudentFormBean.toString());
				/* 771 */ getUserSessionMap().put("glaUniversityStudentFormBean", glaUniversityStudentFormBean);
				/* 772 */ } catch (Exception e) {
				/*      */
				/* 774 */ logger.error("Exception  " + e);
				/*      */ }
			/*      */
			/*      */ } else {
			/*      */
			/* 779 */ logger.info("glaUniversityStudentFormBean value Inside Confirm () not null--");
			/*      */ }
		/*      */
		/*      */
		/*      */
		/* 784 */ if (getUserSessionMap().get("_instituteConfigBean") == null && this.VASPmtId != null) {
			/*      */
			/*      */ try {
				/* 787 */ InstituteConfigBean instituteConfigBean = (InstituteConfigBean) getSaveObj
						.getObject(this.VASPmtId, "instituteConfigBean_OfflineVAS");
				/* 788 */ logger
						.info("Inside Confirm Getting instituteConfigBean_OfflineVAS object from DB for VASPmtId-->"
								+ this.VASPmtId + "\t" + instituteConfigBean.toString());
				/* 789 */ getUserSessionMap().put("_instituteConfigBean", instituteConfigBean);
				/* 790 */ } catch (Exception e) {
				/*      */
				/* 792 */ logger.error("Exception  " + e);
				/*      */ }
			/*      */
			/*      */ } else {
			/*      */
			/* 797 */ logger.info("_instituteConfigBean value Inside Confirm () not null--");
			/*      */ }
		/*      */
		/*      */
		/*      */
		/* 802 */ if (getUserSessionMap().get("INSTDATA") == null && this.VASPmtId != null) {
			/*      */
			/*      */ try {
				/* 805 */ InstituteMasterFormBean instituteMasterFormBean = (InstituteMasterFormBean) getSaveObj
						.getObject(this.VASPmtId, "INSTDATA_OfflineVAS");
				/* 806 */ logger.info("Getting INSTDATA confirm details from DB-->");
				/* 807 */ getUserSessionMap().put("INSTDATA", instituteMasterFormBean);
				/* 808 */ if (instituteMasterFormBean != null) {
					/* 809 */ logger.info(" INSTDATA confirm details from DB-->" + instituteMasterFormBean.toString());
					/*      */ } else {
					/*      */
					/* 812 */ logger.info("INSTDATA confirm data from DB Blank or Null-->");
					/*      */ }
				/* 814 */ } catch (Exception e1) {
				/*      */
				/* 816 */ e1.printStackTrace();
				/*      */ }
			/*      */ } else {
			/*      */
			/* 820 */ logger.info("INSTDATA  confirm data from not Null-->");
			/*      */ }
		/*      */
		/*      */
		/*      */
		/* 825 */ if (getUserSessionMap().get("INSTCONFIG") == null && this.VASPmtId != null) {
			/*      */
			/*      */ try {
				/* 828 */ InstituteConfigBean instituteConfigBean = (InstituteConfigBean) getSaveObj
						.getObject(this.VASPmtId, "INSTCONFIG_OfflineVAS");
				/* 829 */ logger.info("Getting INSTCONFIG confirm details from DB-->");
				/* 830 */ getUserSessionMap().put("INSTCONFIG", instituteConfigBean);
				/* 831 */ if (instituteConfigBean != null) {
					/* 832 */ logger.info("INSTCONFIG confirm details from DB-->" + instituteConfigBean.toString());
					/*      */ } else {
					/*      */
					/* 835 */ logger.info("INSTCONFIG  confirm data from DB Blank or Null-->");
					/*      */ }
				/* 837 */ } catch (Exception e1) {
				/*      */
				/* 839 */ e1.printStackTrace();
				/*      */ }
			/*      */ } else {
			/*      */
			/* 843 */ logger.info("INSTCONFIG  confirm data from not Null-->");
			/*      */ }
		/*      */
		/*      */
		/*      */
		/* 848 */ if (getUserSessionMap().get("INSTCONFIG1") == null && this.VASPmtId != null) {
			/*      */
			/*      */ try {
				/* 851 */ InstituteConfigBean instituteConfigBean1 = (InstituteConfigBean) getSaveObj
						.getObject(this.VASPmtId, "INSTCONFIG1_OfflineVAS");
				/* 852 */ logger.info("Getting INSTCONFIG1 confirm details from DB-->");
				/* 853 */ getUserSessionMap().put("INSTCONFIG1", instituteConfigBean1);
				/* 854 */ if (instituteConfigBean1 != null) {
					/* 855 */ logger.info("INSTCONFIG1 confirm details from DB-->" + instituteConfigBean1.toString());
					/*      */ } else {
					/*      */
					/* 858 */ logger.info("INSTCONFIG1 confirm data from DB Blank or Null-->");
					/*      */ }
				/* 860 */ } catch (Exception e1) {
				/*      */
				/* 862 */ e1.printStackTrace();
				/*      */ }
			/*      */ } else {
			/*      */
			/* 866 */ logger.info("INSTCONFIG1  confirm data from not Null-->");
			/*      */ }
		/*      */
		/*      */
		/* 870 */ this.appData = (PaymentRequestBean) getUserSessionMap().get("APPDATA");
		/* 871 */ this.appData.setStrPaymentMode(this.strPaymentMode);
		/* 872 */ this.appData.setStrPaymentType(this.strPaymentType);
		/* 873 */ PaymentService paymentService = new PaymentService();
		/* 874 */ getAppData().setStrLoginId(((FJBean) getUserSessionMap().get("BASEDATA")).getLoginID());
		/* 875 */ getAppData().setStrBillerId(((FJBean) getUserSessionMap().get("BASEDATA")).getBillerId());
		/* 876 */ MDC.put("UserId", getAppData().getStrStudentId());
		/* 877 */ MDC.put("MerchantId",
				paymentService.getInstituteCode(((FJBean) getUserSessionMap().get("BASEDATA")).getBillerId()));
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
		/* 895 */ logger.info("@@@@@@@@@");
		/* 896 */ logger.info("appdata.strPaymentType:" + this.appData.getStrPaymentType());
		/* 897 */ logger.info("appData.getStrPaymentMode:" + this.appData.getStrPaymentMode());
		/* 898 */ logger.info("appData.getStudentRegistrationId:" + this.appData.getStudentRegistrationId());
		/* 899 */ logger.info("appData.getSpecializationId:" + this.appData.getSpecializationId());
		/* 900 */ logger.info("appData.getRegistrationId:" + this.appData.getRegistrationId());
		/* 901 */ logger.info("appData.getCourseId:" + this.appData.getCourseId());
		/* 902 */ logger.info("@@@@@@@@@ appData.getChallan_Type() : " + this.appData.getChallan_Type());
		/* 903 */ logger.info(getAppData().getLateFeeAmount());
		/* 904 */ logger.info(getAppData().getPayableAmount());
		/* 905 */ logger.info(getAppData().getTotalPayableAmount());
		/*      */
		/* 907 */ URLInstituteRequestBean uRLInstituteRequestBean = (URLInstituteRequestBean) getUserSessionMap()
				.get("glaUniversityStudentFormBean");
		/* 908 */ if (uRLInstituteRequestBean != null) {
			/* 909 */ HttpServletRequest requestduplicate = ServletActionContext.getRequest();
			/* 910 */ HttpServletResponse response = ServletActionContext.getResponse();
			/* 911 */ RequestDispatcher rd = null;
			/* 912 */ int cnt = paymentService
					.fetchCountOnlineModeMerchantTxnRefNo(uRLInstituteRequestBean.getMerchantRefNo());
			/* 913 */ if (cnt > 0) {
				/* 914 */ String statusone = uRLInstituteRequestBean.getReturnURL();
				/* 915 */ SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
				/* 916 */ Date now = new Date();
				/* 917 */ String strProcessDate = sdfDate.format(now);
				/* 918 */ String strClearingDate = "";
				/* 919 */ String status = "";
				/* 920 */ strClearingDate = "";
				/* 921 */ status = "F";
				/* 922 */ String responseurlgladuplicate = (new InstituteURLAction()).createResponseMessage(
						(URLInstituteRequestBean) getUserSessionMap().get("glaUniversityStudentFormBean"), status, "",
						"Payment with online payment mode with this reference no alreadt exists", "", "",
						strProcessDate, strClearingDate);
				/* 923 */ responseurlgladuplicate = String.valueOf(statusone) + "?" + responseurlgladuplicate;
				/* 924 */ String urlToBeForwarded = "responsetogla.jsp?responseurlgla=" + responseurlgladuplicate;
				/* 925 */ rd = request.getRequestDispatcher(urlToBeForwarded);
				/* 926 */ setUniqueSessionIdentifier(getUserSessionMap().get("sessionKey").toString());
				/*      */ try {
					/* 928 */ rd.forward((ServletRequest) requestduplicate, (ServletResponse) response);
					/* 929 */ } catch (ServletException e) {
					/*      */
					/* 931 */ logger.error("Exception  " + e);
					/* 932 */ } catch (IOException e) {
					/*      */
					/* 934 */ logger.error("Exception  " + e);
					/*      */ }
				/* 936 */ return null;
				/*      */ }
			/*      */ }
		/*      */
		/*      */
		/*      */
		/* 942 */ int paymentId = paymentService.insertPrePaymentDetails(getAppData());
		/*      */
		/* 944 */ List<StudentFeesFormBean> studentFeesList = getAppData().getStudentFeesList();
		/* 945 */ if (!Utility.isListEmpty(studentFeesList)) {
			/* 946 */ for (int count = 0; count < studentFeesList.size(); count++) {
				/* 947 */ StudentFeesFormBean studentFeesFormBean = studentFeesList.get(count);
				/* 948 */ paymentService.insertPrePaymentFeesDetails(paymentId, studentFeesFormBean);
				/*      */ }
			/*      */ } else {
			/* 951 */ logger.info("studentFeesList() is Empty, so not inserting data in PrePaymentFeesDetails");
			/*      */ }
		/*      */
		/* 954 */ CourseDetailsService courseDetailsService = new CourseDetailsService();
		/* 955 */ logger.info("prePaymentId ==>" + paymentId);
		/* 956 */ String InstituteCode = paymentService
				.getInstituteCode(((FJBean) getUserSessionMap().get("BASEDATA")).getBillerId());
		/*      */
		/* 958 */ if (this.strPaymentType != null
				&& ("Challan".equalsIgnoreCase(this.strPaymentType) || this.strPaymentType.contains("Challan"))) {
			/* 959 */ logger.info("User has selected challan as payment Mode");
			/* 960 */ logger.info("Payment Mode = " + this.strPaymentMode);
			/* 961 */ String fileName = String.valueOf(this.strPaymentMode) + "Challan_" + this.appData.getStrBillerId()
					+ "_" + this.appData.getStrStudentId().replaceAll("/", "") + "-"
					+ Utility.getCurrentDateTimeAsString() + ".pdf";
			/*      */
			/*      */
			/*      */
			/*      */
			/* 966 */ ChallanServiceUtil challanServiceUtil = new ChallanServiceUtil();
			/* 967 */ String filePath = null;
			/* 968 */ logger.info("Biller ID Before Challan:" + this.appData.getStrBillerId());
			/* 969 */ logger.info("Registration ID Before Challan:" + this.appData.getRegistrationId());
			/* 970 */ logger.info("Payment ID Before Challan:" + this.appData.getPaymentID());
			/* 971 */ logger.info("Pre Payment ID Before Challan:" + this.appData.getPrePaymentID());
			/*      */
			/* 973 */ int insertCnt = 0;
			/* 974 */ String strDueDate = "2011-04-01 00:00:00.000";
			/*      */
			/* 976 */ String paymentID = (new Integer(paymentId)).toString();
			/*      */
			/* 978 */ PaymentDetails paymentDetails = new PaymentDetails();
			/* 979 */ if (InstituteCode.equalsIgnoreCase("NIPR")) {
				/* 980 */ if (this.appData.getCurrency() != null
						&& this.appData.getCurrency().equalsIgnoreCase("USD")) {
					/* 981 */ InstituteCode = "NIP";
					/* 982 */ String instId = paymentService.getInstituteIdFromInstCode(InstituteCode);
					/* 983 */ this.appData.setStrBillerId(instId);
					/*      */ }
				/* 985 */ } else if (InstituteCode.equalsIgnoreCase("DSDOON")) {
				/* 986 */ String instId = paymentService.getInstituteIdFromInstCode(this.appData.getCurrency());
				/* 987 */ this.appData.setStrBillerId(instId);
				/*      */ }
			/*      */
			/* 990 */ paymentDetails.setStrBankCode("NA");
			/* 991 */ paymentDetails.setStrPGAccNo("1");
			/*      */
			/*      */
			/* 994 */ logger.info("Logic Changes for Chrome Browser VAS Offline--appData.getStrPaymentType()-->"
					+ this.appData.getStrPaymentType());
			/* 995 */ if (this.appData.getStrPaymentType().equalsIgnoreCase("Challan")) {
				/* 996 */ logger.info(" Chrome Browser VAS Offline--");
				/* 997 */ String challanModetype = this.strPaymentMode;
				/* 998 */ this.appData = (PaymentRequestBean) getUserSessionMap().get("APPDATA");
				/*      */
				/*      */
				/*      */
				/* 1002 */ getAppData().setStrLoginId(((FJBean) getUserSessionMap().get("BASEDATA")).getLoginID());
				/* 1003 */ getAppData().setStrBillerId(((FJBean) getUserSessionMap().get("BASEDATA")).getBillerId());
				/* 1004 */ logger.info("QuickPayAction **************************************************AJAX");
				/*      */
				/* 1006 */ double totalfee = Double.parseDouble(this.appData.getTotalPayableFees());
				/*      */
				/* 1008 */ String instituteId = this.appData.getStrBillerId();
				/* 1009 */ logger.info("instituteId" + instituteId);
				/*      */
				/* 1011 */ logger.info("totalfees to pay ==== " + totalfee);
				/*      */
				/* 1013 */ this.addChallanChargesBean = new AddChallanChargesBean();
				/*      */
				/* 1015 */ Double addChallanCharges = (new ChallanHistoryService()).getChallanCharges(instituteId,
						totalfee, challanModetype);
				/* 1016 */ this.addChallanChargesBean.setChallanCharges(addChallanCharges.doubleValue());
				/* 1017 */ this.addChallanChargesBean.setChallan(challanModetype);
				/* 1018 */ getAddChallanChargesBean().setChallanCharges(addChallanCharges.doubleValue());
				/* 1019 */ getAddChallanChargesBean().setChallan(challanModetype);
				/* 1020 */ getUserSessionMap().put("addChallanChargesBean", this.addChallanChargesBean);
				/* 1021 */ logger.info("outside Chrome Browser VAS Offline--");
				/*      */ }
			/*      */
			/*      */
			/*      */
			/* 1026 */ this.addChallanChargesBean = (AddChallanChargesBean) getUserSessionMap()
					.get("addChallanChargesBean");
			/*      */
			/* 1028 */ if (this.appData.getStrPaymentType().equalsIgnoreCase("Challan")) {
				/* 1029 */ paymentDetails.setStrTxnAmt(Double.parseDouble(this.appData.getStrAmount())
						+ this.addChallanChargesBean.getChallanCharges());
				/* 1030 */ logger.info("Challan Charges--->" + this.addChallanChargesBean.getChallanCharges());
				/*      */
				/* 1032 */ DecimalFormat decimalFormat = new DecimalFormat("0.00");
				/* 1033 */ double finalAmt = Double.parseDouble(getAppData().getTotalPayableAmount())
						+ this.addChallanChargesBean.getChallanCharges();
				/* 1034 */ this.appData.setStrAmount(decimalFormat.format(finalAmt));
				/*      */
				/*      */ }
			/*      */ else {
				/*      */
				/*      */
				/* 1040 */ logger.info("else part online flow--");
				/* 1041 */ paymentDetails.setStrTxnAmt(Double.parseDouble(this.appData.getStrAmount()));
				/*      */ }
			/* 1043 */ paymentDetails.setStrPayeeId(this.appData.getStrBillerId());
			/* 1044 */ paymentDetails
					.setStrUserId(String.valueOf(this.appData.getStrMerchantId()) + this.appData.getStrCustomerId());
			/* 1045 */ paymentDetails.setStrConsumerCd(this.appData.getStrConsumerId());
			/* 1046 */ paymentDetails.setStrCustName(this.appData.getStrStudentName());
			/* 1047 */ paymentDetails.setStrDueDate(strDueDate);
			/* 1048 */ paymentDetails.setStrBankName(this.appData.getStrBankName());
			/* 1049 */ paymentDetails.setStrPaymentMode(this.appData.getStrPaymentMode());
			/* 1050 */ paymentDetails.setStrPrepaymentID(paymentID);
			/* 1051 */ paymentDetails.setStrLoginId(this.appData.getStrLoginId());
			/*      */
			/* 1053 */ paymentDetails.setInstituteCode(InstituteCode);
			/* 1054 */ paymentDetails.setChallanCharges(this.addChallanChargesBean.getChallanCharges());
			/* 1055 */ insertCnt = paymentService.insertPaymentDetails(paymentDetails);
			/*      */
			/* 1057 */ if (uRLInstituteRequestBean != null) {
				/* 1058 */ String str = paymentService.insertURLInstituteData(paymentDetails, uRLInstituteRequestBean);
				/*      */ }
			/*      */
			/*      */
			/*      */
			/*      */
			/* 1064 */ logger.info("insertCnt---->" + insertCnt);
			/*      */
			/*      */
			/* 1067 */ this.appData.setPrePaymentID(paymentDetails.getStrPrepaymentID());
			/* 1068 */ this.appData.setPaymentID(paymentDetails.getStrPaymentId());
			/* 1069 */ logger.info("prePaymentId : - " + this.appData.getPrePaymentID());
			/* 1070 */ logger.info("paymentId : - " + this.appData.getPaymentID());
			/* 1071 */ Map<String, Object> userSessionMap = getUserSessionMap();
			/* 1072 */ String challanType = "";
			/* 1073 */ if (this.strPaymentMode != null && this.strPaymentMode.equalsIgnoreCase("Cash")) {
				/* 1074 */ challanType = "C";
				/* 1075 */ logger.info("In Challan Cash ");
				/* 1076 */ if ("ICICI".equalsIgnoreCase(this.appData.getChallan_Type())) {
					/*      */
					/* 1078 */ filePath = challanServiceUtil.generateCashChallan_ICICI(userSessionMap, this.appData,
							fileName);
					/* 1079 */ logger.info("generateCashChallan_ICICI Name :: " + filePath);
					/*      */ }
				/*      */ else {
					/*      */
					/* 1083 */ filePath = challanServiceUtil.generateCashChallan(userSessionMap, this.appData,
							fileName);
					/*      */ }
				/* 1085 */ } else if (this.strPaymentMode != null && this.strPaymentMode.equalsIgnoreCase("Cheque")) {
				/* 1086 */ challanType = "H";
				/*      */
				/* 1088 */ logger.info("In Challan Cheque ");
				/* 1089 */ if ("ICICI".equalsIgnoreCase(this.appData.getChallan_Type()))
				/*      */ {
					/* 1091 */ filePath = challanServiceUtil.generateChequeChallan_ICICI(userSessionMap, this.appData,
							fileName, this.appData.getStrBillerId(), this.appData.getRegistrationId());
					/* 1092 */ logger.info("generateChequeChallan_ICICI Name :: " + filePath);
					/*      */ }
				/*      */ else
				/*      */ {
					/* 1096 */ filePath = challanServiceUtil.generateChequeChallan(userSessionMap, this.appData,
							fileName, this.appData.getStrBillerId(), this.appData.getRegistrationId());
					/*      */ }
				/*      */
				/* 1099 */ } else if (this.strPaymentMode != null
						&& this.strPaymentMode.equalsIgnoreCase("Demand_Draft")) {
				/* 1100 */ challanType = "D";
				/* 1101 */ logger.info("In Challan Cash ");
				/* 1102 */ if ("ICICI".equalsIgnoreCase(this.appData.getChallan_Type()))
				/*      */ {
					/* 1104 */ filePath = challanServiceUtil.generateDDChallan_ICICI(userSessionMap, this.appData,
							fileName, this.appData.getStrBillerId(), this.appData.getRegistrationId());
					/* 1105 */ logger.info("generateDDChallan_ICICI Name :: " + filePath);
					/*      */ }
				/*      */ else
				/*      */ {
					/* 1109 */ filePath = challanServiceUtil.generateDDChallan(userSessionMap, this.appData, fileName,
							this.appData.getStrBillerId(), this.appData.getRegistrationId());
					/*      */ }
				/*      */
				/* 1112 */ } else if (this.strPaymentMode != null
						&& this.strPaymentMode.equalsIgnoreCase("NEFT_RTGS")) {
				/* 1113 */ challanType = "N";
				/* 1114 */ logger.info("In Challan NEFT/RTGS ");
				/* 1115 */ filePath = challanServiceUtil.generateNEFTRTGSChallan(userSessionMap, this.appData,
						fileName);
				/*      */ }
			/*      */
			/*      */
			/* 1119 */ logger.info("Full File Path : - " + filePath);
			/* 1120 */ String strFilePath = filePath;
			/* 1121 */ String strFileName = fileName;
			/* 1122 */ if (insertCnt > 0) {
				/* 1123 */ logger.info("data successfully inserted in SJ_BillPayments");
				/* 1124 */ logger.info("loginActionFormBean.getStrLoginId() : - " + this.appData.getStrLoginId());
				/* 1125 */ logger.info("strFileName : - " + strFileName);
				/* 1126 */ logger.info("strFilePath : - " + strFilePath);
				/* 1127 */ logger.info("CHALLAN : - CHALLAN");
				/* 1128 */ logger.info("REMARKS : - REMARKS");
				/*      */
				/* 1130 */ logger
						.info("paymentDetails.getStrPrepaymentID() : - " + paymentDetails.getStrPrepaymentID());
				/* 1131 */ logger.info("paymentDetails.getStrPaymentId() : - " + paymentDetails.getStrPaymentId());
				/*      */
				/*      */
				/* 1134 */ FJBean fjBean = (FJBean) getUserSessionMap().get("BASEDATA");
				/* 1135 */ ChallanHistoryService challanHistoryService = new ChallanHistoryService();
				/* 1136 */ ChallanHistoryFormBean challanHistoryFormBean = new ChallanHistoryFormBean();
				/* 1137 */ challanHistoryFormBean.setStrBillerId(this.appData.getStrBillerId());
				/* 1138 */ challanHistoryFormBean.setStrRegistrationId(fjBean.getRegisteredUserId());
				/* 1139 */ challanHistoryFormBean.setStrLoginID(this.appData.getStrLoginId());
				/*      */
				/*      */
				/* 1142 */ challanHistoryFormBean.setStrChallanName(strFileName);
				/* 1143 */ challanHistoryFormBean.setStrChallanPath(strFilePath);
				/* 1144 */ challanHistoryFormBean.setStrChallanType("CHALLAN");
				/* 1145 */ challanHistoryFormBean.setStrRemarks("REMARK");
				/* 1146 */ challanHistoryFormBean.setStrPrePaymentId(paymentDetails.getStrPrepaymentID());
				/* 1147 */ challanHistoryFormBean.setStrPaymentId(paymentDetails.getStrPaymentId());
				/*      */
				/* 1149 */ String returnString = challanHistoryService.insertChallanDetails(challanHistoryFormBean);
				/* 1150 */ if (InstituteCode.equalsIgnoreCase("BCE") || InstituteCode.equalsIgnoreCase("BCET") ||
				/* 1151 */ InstituteCode.equalsIgnoreCase("BCPSR") || InstituteCode.equalsIgnoreCase("BCPO") ||
				/* 1152 */ InstituteCode.equalsIgnoreCase("BCENEW") || InstituteCode.equalsIgnoreCase("BCETNEW") ||
				/* 1153 */ InstituteCode.equalsIgnoreCase("BCPSRNEW") || InstituteCode.equalsIgnoreCase("BCPONEW")) {
					/* 1154 */ String smsBody = MessageFormat.format(
							PropertyReader.getProperty("challan.mobile.sms.body"),
							(Object[]) new String[] { InstituteCode, this.appData.getStrStudentId() });
					/* 1155 */ HttpsClientSMS httpsclientsms = new HttpsClientSMS();
					/* 1156 */ httpsclientsms.sendSMS(this.appData.getStrMobileNo(), smsBody);
					/*      */ }
				/*      */
				/* 1159 */ logger.info("Before Going Forward");
				/*      */ try {
					/* 1161 */ this.strChallanPath = strFileName;
					/* 1162 */ File f = new File(strFilePath);
					/* 1163 */ long fileLength = f.length();
					/*      */
					/* 1165 */ this.fileInputStream = new FileInputStream(f);
					/*      */
					/*      */ }
				/* 1168 */ catch (FileNotFoundException ex) {
					/*      */
					/* 1170 */ logger.info("EXCEPTION :  " + ex.getMessage());
					/* 1171 */ logger.error("Exception  " + ex);
					/*      */ }
				/*      */
				/*      */
				/* 1175 */ if (uRLInstituteRequestBean != null && "Y".equalsIgnoreCase(
						((InstituteConfigBean) getUserSessionMap().get("_instituteConfigBean")).getVasChallanEmail())) {
					/* 1176 */ logger.info("VAS challan Email");
					/* 1177 */ String toEmail = uRLInstituteRequestBean.getCustomerEmailId();
					/* 1178 */ String subject = String.valueOf(
							((InstituteMasterFormBean) getUserSessionMap().get("INSTDATA")).getStrInstituteName())
							+ " Challan copy.";
					/* 1179 */ String body = "Dear User,<br/>Please find the attached copy of challan generated for payment.";
					/* 1180 */ if (toEmail == null || "".equalsIgnoreCase(toEmail.trim())
							|| !toEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
						/* 1181 */ toEmail = "moinkhan.jariwala@techprocess.co.in";
						/* 1182 */ subject = "VAS Challan Attachment Error";
						/* 1183 */ body = "Please find the attached challan.However the email id is incorrect for this Transaction : "
								+ paymentDetails.getStrPaymentId();
						/*      */ }
					/* 1185 */ (new InstituteURLAction()).sendEmailAttachment("", toEmail, subject, body,
							strFilePath.replace("\\", "/"));
					/*      */ }
				/*      */
				/*      */
				/*      */
				/*      */
				/* 1191 */ if (uRLInstituteRequestBean != null
						&& "Y".equalsIgnoreCase(((InstituteConfigBean) getUserSessionMap().get("_instituteConfigBean"))
								.getVasChallanRedirect())) {
					/* 1192 */ logger.info("VAS challan redirect");
					/* 1193 */ HttpServletRequest requestduplicate = ServletActionContext.getRequest();
					/* 1194 */ HttpServletResponse response = ServletActionContext.getResponse();
					/* 1195 */ RequestDispatcher rd = null;
					/* 1196 */ String statusone = uRLInstituteRequestBean.getReturnURL();
					/* 1197 */ SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
					/* 1198 */ Date now = new Date();
					/* 1199 */ String strProcessDate = sdfDate.format(now);
					/* 1200 */ String strClearingDate = "";
					/* 1201 */ String status = "";
					/* 1202 */ strClearingDate = "";
					/* 1203 */ status = "P";
					/* 1204 */ String responseurlgladuplicate = (new InstituteURLAction()).createResponseMessage(
							(URLInstituteRequestBean) getUserSessionMap().get("glaUniversityStudentFormBean"), status,
							"", "Pending", paymentDetails.getStrPaymentId(), challanType, strProcessDate,
							strClearingDate);
					/* 1205 */ responseurlgladuplicate = statusone + "?" + responseurlgladuplicate;
					/* 1206 */ String urlToBeForwarded = "responsetogla.jsp?responseurlgla=" + responseurlgladuplicate
							+ "&fileURL=" + strFilePath.replace("\\", "/");
					/* 1207 */ logger.info("urlToBeForwarded-*****->" + urlToBeForwarded);
					/* 1208 */ rd = request.getRequestDispatcher(urlToBeForwarded);
					/* 1209 */ if (getUserSessionMap().get("sessionKey") != null) {
						/* 1210 */ logger.info("session key is not null");
						/* 1211 */ setUniqueSessionIdentifier(getUserSessionMap().get("sessionKey").toString());
						/*      */ } else {
						/*      */
						/* 1214 */ logger.info("session key is null so skipping it");
						/*      */ }
					/* 1216 */ try {
						rd.forward(requestduplicate, response);
					} catch (ServletException e) {
						logger.error("Exception  " + e);
					} catch (IOException e) {
						e.printStackTrace();
					}
					/* 1217 */ return null;
					/*      */ }
				/*      */
				/*      */
				/*      */
				/* 1222 */ return DOWNLOAD;
				/*      */ }
			/*      */ }
		/*      */
		/* 1226 */ this.strPaymentType = "Online Payment";
		/* 1227 */ if (this.strPaymentType != null && this.strPaymentType.equalsIgnoreCase("Online Payment")) {
			/* 1228 */ this.appData.setStrAmount(getAppData().getTotalPayableAmount());
			/*      */
			/*      */
			/*      */
			/* 1232 */ this.redirectionURL = pgPaymentRequest(paymentId);
			/* 1233 */ if (uRLInstituteRequestBean != null
					&& uRLInstituteRequestBean.getPaymentMode().equalsIgnoreCase("o")) {
				/* 1234 */ return this.redirectionURL;
				/*      */ }
			/* 1236 */ logger.info("---Final-----redirectToPG-----------");
			/* 1237 */ return "redirectToPG";
			/*      */ }
		/*      */
		/*      */
		/*      */
		/* 1242 */ logger.info("After This ==>");
		/*      */
		/* 1244 */ return CONFIRM;
		/*      */ }

	/*      */
	/*      */ public String confirmTest() {
		/* 1248 */ HttpServletRequest request = ServletActionContext.getRequest();
		/* 1249 */ logger.info("Inside QuickPayAction --> confirm()" + request);
		/*      */
		/* 1251 */ if (!isValidSession()) {
			/* 1252 */ addActionError("Your session has been invalidated. Please login again.");
			/* 1253 */ return "error";
			/*      */ }
		/*      */
		/*      */
		/* 1257 */ String applicationID = (String) getUserSessionMap().get("UniqueIdentificationId");
		/*      */
		/*      */
		/*      */
		/*      */
		/*      */
		/* 1263 */ this.appdata1 = new StudentRegistrationFormBean();
		/* 1264 */ String registeredUserId = ((FJBean) getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
		/* 1265 */ this.appdata1.setStudentName(getStudentName());
		/* 1266 */ this.appdata1.setStudentEmailId(getEmailID());
		/* 1267 */ this.appdata1.setStudentMobileNumber(getMobileNo());
		/* 1268 */ this.appdata1.setTotalFees(getTotalFeesAmount());
		/* 1269 */ this.appdata1.setRegistrationId(registeredUserId);
		/*      */
		/* 1271 */ PaymentService paymentService1 = new PaymentService();
		/* 1272 */ String studentRegistrationId = paymentService1.insertOnlinePaymentPopup(applicationID,
				getAppdata1());
		/*      */
		/* 1274 */ StudentRegistrationFormBean studentRegistrationFormBean = getRegisteredStudentDetails(
				getAppdata1().getStudentRegistrationId());
		/* 1275 */ studentRegistrationFormBean.setTotalPayableFees(getAppdata1().getTotalFees());
		/* 1276 */ studentRegistrationFormBean.setStudentId(applicationID);
		/*      */
		/* 1278 */ applyFees(studentRegistrationFormBean);
		/* 1279 */ this.appData = new PaymentRequestBean();
		/* 1280 */ this.appData.setStudentRegistrationId(getAppdata1().getStudentRegistrationId());
		/*      */
		/* 1282 */ setAppDataFromStudentBean(this.appData, studentRegistrationFormBean, this.feesPayList);
		/*      */
		/* 1284 */ PaymentService paymentService = new PaymentService();
		/* 1285 */ int paymentId = paymentService.insertPrePaymentDetails(this.appData);
		/*      */
		/*      */
		/* 1288 */ List<StudentFeesFormBean> studentFeesList = getAppData().getStudentFeesList();
		/* 1289 */ if (!Utility.isListEmpty(studentFeesList)) {
			/* 1290 */ for (int count = 0; count < studentFeesList.size(); count++) {
				/* 1291 */ StudentFeesFormBean studentFeesFormBean = studentFeesList.get(count);
				/* 1292 */ paymentService.insertPrePaymentFeesDetails(paymentId, studentFeesFormBean);
				/*      */ }
			/*      */ } else {
			/* 1295 */ logger.info("studentFeesList() is Empty, so not inserting data in PrePaymentFeesDetails");
			/*      */ }
		/* 1297 */ if (this.strPaymentType != null && "Challan".equalsIgnoreCase(this.strPaymentType)) {
			/* 1298 */ logger.info("User has selected challan as payment Mode");
			/* 1299 */ logger.info("Payment Mode = " + this.strPaymentMode);
			/* 1300 */ String fileName = String.valueOf(this.strPaymentMode) + "Challan_"
					+ this.appData.getStrBillerId() + "_" + this.appData.getStrStudentId() + "-"
					+ Utility.getCurrentDateTimeAsString() + ".pdf";
			/*      */
			/* 1302 */ ChallanServiceUtil challanServiceUtil = new ChallanServiceUtil();
			/* 1303 */ String filePath = null;
			/* 1304 */ logger.info("Biller ID Before Challan:" + this.appData.getStrBillerId());
			/* 1305 */ logger.info("Registration ID Before Challan:" + this.appData.getRegistrationId());
			/* 1306 */ logger.info("Payment ID Before Challan:" + this.appData.getPaymentID());
			/* 1307 */ logger.info("Pre Payment ID Before Challan:" + this.appData.getPrePaymentID());
			/*      */
			/*      */
			/* 1310 */ int insertCnt = 0;
			/* 1311 */ String strDueDate = "2011-04-01 00:00:00.000";
			/* 1312 */ String paymentID = (new Integer(paymentId)).toString();
			/* 1313 */ String InstituteCode1 = paymentService
					.getInstituteCode(((FJBean) getUserSessionMap().get("BASEDATA")).getBillerId());
			/*      */
			/* 1315 */ PaymentDetails paymentDetails = new PaymentDetails();
			/* 1316 */ paymentDetails.setStrBankCode("NA");
			/* 1317 */ paymentDetails.setStrPGAccNo("1");
			/* 1318 */ this.addChallanChargesBean = (AddChallanChargesBean) getUserSessionMap()
					.get("addChallanChargesBean");
			/*      */
			/* 1320 */ if (this.appData.getStrPaymentType().equalsIgnoreCase("Challan")) {
				/* 1321 */ paymentDetails.setStrTxnAmt(Double.parseDouble(this.appData.getStrAmount())
						+ this.addChallanChargesBean.getChallanCharges());
				/* 1322 */ double finalAmt = Double.parseDouble(this.appData.getStrAmount())
						+ this.addChallanChargesBean.getChallanCharges();
				/* 1323 */ this.appData.setStrAmount(Double.toString(finalAmt));
				/*      */ } else {
				/* 1325 */ paymentDetails.setStrTxnAmt(Double.parseDouble(this.appData.getStrAmount()));
				/*      */ }
			/* 1327 */ paymentDetails.setStrPayeeId(this.appData.getStrBillerId());
			/* 1328 */ paymentDetails
					.setStrUserId(String.valueOf(this.appData.getStrMerchantId()) + this.appData.getStrCustomerId());
			/* 1329 */ paymentDetails.setStrConsumerCd(this.appData.getStrConsumerId());
			/* 1330 */ paymentDetails.setStrCustName(this.appData.getStrStudentName());
			/* 1331 */ paymentDetails.setStrDueDate(strDueDate);
			/* 1332 */ paymentDetails.setStrBankName(this.appData.getStrBankName());
			/* 1333 */ paymentDetails.setStrPaymentMode(this.appData.getStrPaymentMode());
			/* 1334 */ paymentDetails.setStrPrepaymentID(paymentID);
			/* 1335 */ paymentDetails.setStrLoginId(this.appData.getStrLoginId());
			/*      */
			/* 1337 */ paymentDetails.setInstituteCode(InstituteCode1);
			/*      */
			/* 1339 */ insertCnt = paymentService.insertPaymentDetails(paymentDetails);
			/* 1340 */ logger.info("insertCnt---->" + insertCnt);
			/*      */
			/*      */
			/* 1343 */ this.appData.setPrePaymentID(paymentDetails.getStrPrepaymentID());
			/* 1344 */ this.appData.setPaymentID(paymentDetails.getStrPaymentId());
			/* 1345 */ logger.info("prePaymentId : - " + this.appData.getPrePaymentID());
			/* 1346 */ logger.info("paymentId : - " + this.appData.getPaymentID());
			/* 1347 */ Map<String, Object> userSessionMap = getUserSessionMap();
			/* 1348 */ if (this.strPaymentMode != null && this.strPaymentMode.equalsIgnoreCase("Cash")) {
				/* 1349 */ logger.info("In Challan Cash ");
				/* 1350 */ filePath = challanServiceUtil.generateCashChallan(userSessionMap, this.appData, fileName);
				/* 1351 */ } else if (this.strPaymentMode != null && this.strPaymentMode.equalsIgnoreCase("Cheque")) {
				/*      */
				/* 1353 */ logger.info("In Challan Cheque ");
				/* 1354 */ filePath = challanServiceUtil.generateChequeChallan(userSessionMap, this.appData, fileName,
						this.appData.getStrBillerId(), this.appData.getRegistrationId());
				/*      */ }
			/* 1356 */ else if (this.strPaymentMode != null && this.strPaymentMode.equalsIgnoreCase("Demand_Draft")) {
				/* 1357 */ logger.info("In Challan Cash ");
				/* 1358 */ filePath = challanServiceUtil.generateDDChallan(userSessionMap, this.appData, fileName,
						this.appData.getStrBillerId(), this.appData.getRegistrationId());
				/*      */ }
			/* 1360 */ else if (this.strPaymentMode != null && this.strPaymentMode.equalsIgnoreCase("NEFT_RTGS")) {
				/* 1361 */ logger.info("In Challan NEFT/RTGS ");
				/* 1362 */ filePath = challanServiceUtil.generateNEFTRTGSChallan(userSessionMap, this.appData,
						fileName);
				/*      */ }
			/*      */
			/*      */
			/* 1366 */ logger.info("Full File Path : - " + filePath);
			/* 1367 */ String strFilePath = filePath;
			/* 1368 */ String strFileName = fileName;
			/* 1369 */ if (insertCnt > 0) {
				/* 1370 */ logger.info("data successfully inserted in SJ_BillPayments");
				/* 1371 */ logger.info("loginActionFormBean.getStrLoginId() : - " + this.appData.getStrLoginId());
				/* 1372 */ logger.info("strFileName : - " + strFileName);
				/* 1373 */ logger.info("strFilePath : - " + strFilePath);
				/* 1374 */ logger.info("CHALLAN : - CHALLAN");
				/* 1375 */ logger.info("REMARKS : - REMARKS");
				/*      */
				/* 1377 */ logger
						.info("paymentDetails.getStrPrepaymentID() : - " + paymentDetails.getStrPrepaymentID());
				/* 1378 */ logger.info("paymentDetails.getStrPaymentId() : - " + paymentDetails.getStrPaymentId());
				/*      */
				/*      */
				/* 1381 */ FJBean fjBean = (FJBean) getUserSessionMap().get("BASEDATA");
				/* 1382 */ ChallanHistoryService challanHistoryService = new ChallanHistoryService();
				/* 1383 */ ChallanHistoryFormBean challanHistoryFormBean = new ChallanHistoryFormBean();
				/* 1384 */ challanHistoryFormBean.setStrBillerId(this.appData.getStrBillerId());
				/* 1385 */ challanHistoryFormBean.setStrRegistrationId(fjBean.getRegisteredUserId());
				/* 1386 */ challanHistoryFormBean.setStrLoginID(this.appData.getStrLoginId());
				/*      */
				/*      */
				/* 1389 */ challanHistoryFormBean.setStrChallanName(strFileName);
				/* 1390 */ challanHistoryFormBean.setStrChallanPath(strFilePath);
				/* 1391 */ challanHistoryFormBean.setStrChallanType("CHALLAN");
				/* 1392 */ challanHistoryFormBean.setStrRemarks("REMARK");
				/* 1393 */ challanHistoryFormBean.setStrPrePaymentId(paymentDetails.getStrPrepaymentID());
				/* 1394 */ challanHistoryFormBean.setStrPaymentId(paymentDetails.getStrPaymentId());
				/*      */
				/* 1396 */ String returnString = challanHistoryService.insertChallanDetails(challanHistoryFormBean);
				/*      */
				/* 1398 */ logger.info("Before Going Forward");
				/*      */ try {
					/* 1400 */ this.strChallanPath = strFileName;
					/* 1401 */ File f = new File(strFilePath);
					/* 1402 */ long fileLength = f.length();
					/*      */
					/* 1404 */ this.fileInputStream = new FileInputStream(f);
					/*      */
					/*      */ }
				/* 1407 */ catch (FileNotFoundException ex) {
					/*      */
					/* 1409 */ logger.info("EXCEPTION :  " + ex.getMessage());
					/* 1410 */ logger.error("Exception  " + ex);
					/*      */ }
				/* 1412 */ return DOWNLOAD;
				/*      */ }
			/*      */ }
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
		/* 1431 */ getUserSessionMap().put("APPDATA", this.appData);
		/* 1432 */ this.strPaymentType = "Online Payment";
		/* 1433 */ if (this.strPaymentType != null && this.strPaymentType.equalsIgnoreCase("Online Payment")) {
			/*      */
			/* 1435 */ this.appData.setStrPaymentMode(this.strPaymentMode);
			/* 1436 */ this.redirectionURL = pgPaymentRequest(paymentId);
			/* 1437 */ return "redirectToPG";
			/*      */ }
		/*      */
		/*      */
		/* 1441 */ return CONFIRMTEST;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */ public String proceed() {
		/* 1447 */ if (!isValidSession()) {
			/* 1448 */ return INVALID_SESSION;
			/*      */ }
		/*      */ try {
			/* 1451 */ logger.info("~~~~~~~~~~ " + getStudentRegistrationId() + " ~~~~~~~~~");
			/* 1452 */ logger.info("Am Inside Quick Pay Proceed");
			/* 1453 */ setCourseData((CourseDetailsBean) getUserSessionMap().get("COURSEDATA"));
			/* 1454 */ StudentRegistrationFormBean studentRegistrationFormBean = new StudentRegistrationFormBean();
			/* 1455 */ studentRegistrationFormBean = getRegisteredStudentDetails(getStudentRegistrationId());
			/*      */
			/*      */
			/*      */
			/*      */
			/* 1460 */ applyFees(studentRegistrationFormBean);
			/*      */
			/*      */
			/* 1463 */ this.appData = new PaymentRequestBean();
			/* 1464 */ this.appData.setStudentRegistrationId(getStudentRegistrationId());
			/*      */
			/*      */
			/*      */
			/*      */
			/* 1469 */ getUserSessionMap().put("APPDATA", getAppData());
			/*      */ }
		/* 1471 */ catch (Exception e) {
			/* 1472 */ logger.error("Exception  " + e);
			/* 1473 */ return "error";
			/*      */ }
		/*      */
		/*      */
		/*      */
		/* 1478 */ this.strPaymentType = "Online Payment";
		/*      */
		/* 1480 */ String billerId = ((FJBean) getUserSessionMap().get("BASEDATA")).getBillerId();
		/* 1481 */ this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
		/* 1482 */ if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
			/*      */
			/* 1484 */ this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
			/*      */
			/* 1486 */ getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
			/*      */ }
		/* 1488 */ getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
		/*      */
		/* 1490 */ String totalfee = this.appData.getTotalPayableFees();
		/*      */
		/*      */
		/*      */
		/*      */
		/*      */
		/*      */
		/* 1497 */ return (((InstituteConfigBean) getUserSessionMap().get("INSTCONFIG")).getRegistrationId() == null)
				? PROCEED
				: QPAY_PROCEED;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public void setAppDataFromStudentBean(PaymentRequestBean appData,
			StudentRegistrationFormBean studentRegistrationFormBean, List feesPayList) {
		/* 1507 */ logger.info("Before VASPmtId-->");
		/* 1508 */ this.VASPmtId = (String) getUserSessionMap().get("VASPmtId");
		/* 1509 */ if (this.VASPmtId != null) {
			/* 1510 */ setVASPmtId(this.VASPmtId);
			/* 1511 */ getUserSessionMap().put("VASPmtId", this.VASPmtId);
			/* 1512 */ logger.info("VASPmtId value inside setAppDataFromStudentBean()--" + this.VASPmtId);
			/*      */ }
		/*      */
		/* 1515 */ SaveObject getSaveObj = new SaveObject();
		/*      */
		/*      */
		/* 1518 */ if (appData == null) {
			/*      */ try {
				/* 1520 */ appData = (PaymentRequestBean) getSaveObj.getObject(this.VASPmtId, "APPDATA_OfflineVAS");
				/* 1521 */ logger.info(
						"Getting APPDATA object from DB for reqTxnId-->" + this.VASPmtId + "\t" + appData.toString());
				/* 1522 */ getUserSessionMap().put("APPDATA", appData);
				/* 1523 */ } catch (Exception e) {
				/*      */
				/* 1525 */ logger.error("Exception  " + e);
				/*      */ }
			/*      */ }
		/*      */
		/*      */
		/*      */
		/* 1531 */ if (getUserSessionMap().get("BASEDATA") == null) {
			/*      */
			/*      */ try {
				/* 1534 */ FJBean fjBeanVas = (FJBean) getSaveObj.getObject(this.VASPmtId, "BASEDATA_OfflineVAS");
				/* 1535 */ logger.info("Getting BASEDATA object from DB for reqTxnId-->" + this.VASPmtId + "\t"
						+ fjBeanVas.toString());
				/* 1536 */ getUserSessionMap().put("BASEDATA", fjBeanVas);
				/* 1537 */ } catch (Exception e) {
				/*      */
				/* 1539 */ logger.error("Exception  " + e);
				/*      */ }
			/*      */ }
		/*      */
		/*      */
		/* 1544 */ logger.info("getting appData.getStudentRegistrationId()-->" + appData.getStudentRegistrationId());
		/*      */
		/*      */
		/* 1547 */ FJBean fjBean = (FJBean) getUserSessionMap().get("BASEDATA");
		/* 1548 */ String billerId = ((FJBean) getUserSessionMap().get("BASEDATA")).getBillerId();
		/* 1549 */ this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
		/*      */
		/* 1551 */ logger.info("After getting fjBean-->" + fjBean.toString());
		/* 1552 */ logger.info("After getting billerId-->" + billerId);
		/* 1553 */ logger.info("After getting instituteConfigBean-->" + this.instituteConfigBean.toString());
		/* 1554 */ logger.info("After getting fjBean-->" + this.instituteConfigBean.getChallan_type());
		/*      */
		/*      */
		/* 1557 */ appData.setChallan_Type(this.instituteConfigBean.getChallan_type());
		/* 1558 */ appData.setBillerBranchId(studentRegistrationFormBean.getBillerBranchId());
		/* 1559 */ appData.setStrStudentId(studentRegistrationFormBean.getStudentId());
		/*      */
		/*      */
		/* 1562 */ appData.setStrStudentName(studentRegistrationFormBean.getStudentName());
		/* 1563 */ appData.setStrStudentName1(studentRegistrationFormBean.getStudentName());
		/*      */
		/*      */
		/* 1566 */ appData.setStrCourse(studentRegistrationFormBean.getStudentCourseName());
		/* 1567 */ appData.setStrCourseDetails(studentRegistrationFormBean.getStudentSpecializationName());
		/* 1568 */ appData.setStrCourseType(studentRegistrationFormBean.getStudentCourseType());
		/* 1569 */ appData.setStrCoursePattern(studentRegistrationFormBean.getStudentCoursePattern());
		/* 1570 */ appData.setStrCourseTerm(studentRegistrationFormBean.getStudentCourseTerm());
		/* 1571 */ appData.setBillerBranchName(studentRegistrationFormBean.getStudentInstituteBranchName());
		/*      */
		/* 1573 */ appData.setStrMerchantId("");
		/* 1574 */ appData.setStrCustomerId("");
		/* 1575 */ appData.setStrBillerId(fjBean.getBillerId());
		/* 1576 */ appData.setStrConsumerId("");
		/*      */
		/* 1578 */ appData.setStrBankId("");
		/* 1579 */ appData.setStrBankName("");
		/* 1580 */ appData.setStrPaymentMode("");
		/*      */
		/* 1582 */ appData.setStrMobileNo(studentRegistrationFormBean.getStudentMobileNumber());
		/* 1583 */ appData.setStrEmailId(studentRegistrationFormBean.getStudentEmailId());
		/* 1584 */ appData.setStrCourseTypeDesc("");
		/* 1585 */ appData.setStrBankType("");
		/* 1586 */ appData.setStrLoginId("");
		/* 1587 */ appData.setStrPaymentType("");
		/* 1588 */ appData.setStrPgTranid("");
		/* 1589 */ appData.setStrPgTranDesc("");
		/*      */
		/* 1591 */ appData.setCourseId(studentRegistrationFormBean.getStrCourse());
		/* 1592 */ appData.setSpecializationId(studentRegistrationFormBean.getStrCourseDetails());
		/* 1593 */ appData.setCourseTypeId(studentRegistrationFormBean.getStrCourseType());
		/* 1594 */ appData.setCoursePatternId(studentRegistrationFormBean.getStrCoursePattern());
		/* 1595 */ appData.setCourseTermId(studentRegistrationFormBean.getStrCourseTerm());
		/* 1596 */ appData.setStudentFatherName(studentRegistrationFormBean.getStudentFatherName());
		/* 1597 */ appData.setTotalFees(studentRegistrationFormBean.getTotalFees());
		/* 1598 */ appData.setToalDiscountedFees(studentRegistrationFormBean.getToalDiscountedFees());
		/* 1599 */ appData.setTotalPayableAmount(studentRegistrationFormBean.getTotalPayableFees());
		/* 1600 */ appData.setStudentAlias(studentRegistrationFormBean.getStudentAlias());
		/* 1601 */ appData.setCurrency(studentRegistrationFormBean.getCurrency());
		/*      */
		/*      */
		/*      */
		/*      */
		/* 1606 */ appData.setCoursePattern(studentRegistrationFormBean.getCoursePattern());
		/* 1607 */ appData.setCourseType(studentRegistrationFormBean.getCourseType());
		/* 1608 */ appData.setCourseYear(studentRegistrationFormBean.getCourseYear());
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
		/* 1620 */ logger.info("studentRegistrationFormBean.getRegistrationId()--->"
				+ studentRegistrationFormBean.getRegistrationId());
		/* 1621 */ appData.setRegistrationId(studentRegistrationFormBean.getRegistrationId());
		/*      */
		/* 1623 */ logger.info(appData.getStudentRegistrationId());
		/* 1624 */ InstituteMasterActionService service = new InstituteMasterActionService();
		/* 1625 */ billerId = service.getInstituteCode(billerId);
		/* 1626 */ logger.info("value of biller Id from InstituteMasterActionService-->" + billerId);
		/* 1627 */ logger.info(
				"value of instituteConfigBean.getOnlineFormFlg()-->" + this.instituteConfigBean.getOnlineFormFlg());
		/*      */
		/* 1629 */ if ("Y".equalsIgnoreCase(this.instituteConfigBean.getOnlineFormFlg())) {
			/*      */
			/*      */
			/*      */
			/*      */
			/*      */
			/*      */
			/*      */
			/*      */
			/*      */
			/* 1639 */ double totalpayablefees = 0.0D;
			/* 1640 */ List<StudentFeesFormBean> selectedFeesList = new ArrayList();
			/*      */
			/* 1642 */ List<StudentFeesFormBean> studentFeesList = studentRegistrationFormBean.getStudentFeesList();
			/* 1643 */ for (int count = 0; count < studentFeesList.size(); count++) {
				/* 1644 */ StudentFeesFormBean studentFeesFormBean = studentFeesList.get(count);
				/* 1645 */ logger.info("value of studentFeesFormBean-->" + studentFeesFormBean.toString());
				/* 1646 */ totalpayablefees = Double.parseDouble(studentRegistrationFormBean.getTotalPayableFees());
				/* 1647 */ logger.info("value of totalpayablefees-->" + totalpayablefees);
				/* 1648 */ if ("CHAMPIO".equalsIgnoreCase(billerId) || "JRKG".equalsIgnoreCase(billerId)
						|| "BCENEW".equalsIgnoreCase(billerId) ||
						/* 1649 */ "BCETNEW".equalsIgnoreCase(billerId) || "BCPSRNEW".equalsIgnoreCase(billerId) ||
						/* 1650 */ "BCPONEW".equalsIgnoreCase(billerId) || billerId.equalsIgnoreCase("WBSDDN") ||
						/* 1651 */ this.instituteConfigBean.getEnable_VasFlg().equalsIgnoreCase("Y")) {
					/*      */
					/* 1653 */ logger.info("Inside if instituteConfigBean.getEnable_VasFlg()-->");
					/* 1654 */ studentFeesFormBean.setTotalPayableFees(studentFeesFormBean.getPayableFees());
					/*      */ }
				/*      */ else {
					/*      */
					/* 1658 */ logger.info("Inside else instituteConfigBean.getEnable_VasFlg()-->");
					/* 1659 */ studentFeesFormBean.setTotalPayableFees(String.valueOf(totalpayablefees));
					/*      */ }
				/* 1661 */ selectedFeesList.add(studentFeesFormBean);
				/*      */ }
			/* 1663 */ appData.setLateFeeAmount("0");
			/* 1664 */ appData.setPayableAmount("0");
			/* 1665 */ appData.setDiscountAmount("0");
			/* 1666 */ appData.setStrAmount((new Double(totalpayablefees)).toString());
			/* 1667 */ appData.setStudentFeesList(selectedFeesList);
			/* 1668 */ appData.setTotalPayableFees((new Double(totalpayablefees)).toString());
			/* 1669 */ appData.setTotalPayableAmount((new Double(totalpayablefees)).toString());
			/*      */ } else {
			/*      */
			/* 1672 */ logger.info("Inside else studentRegistrationFormBean.getStudentFeesFetchType()-->"
					+ studentRegistrationFormBean.getStudentFeesFetchType());
			/* 1673 */ List<StudentFeesFormBean> studentFeesList = studentRegistrationFormBean.getStudentFeesList();
			/* 1674 */ if (!Utility.isListEmpty(studentFeesList)) {
				/* 1675 */ logger.info("if studentFeesList not empty-->" + studentFeesList.toString());
				/* 1676 */ List<StudentFeesFormBean> selectedFeesList = new ArrayList();
				/* 1677 */ double totalPayableFees = 0.0D;
				/* 1678 */ double totalPayableFeesNew = 0.0D;
				/* 1679 */ double totalLateFees = 0.0D;
				/* 1680 */ double totalFees = 0.0D;
				/* 1681 */ String academicYearId = null;
				/* 1682 */ String academicYear = null;
				/* 1683 */ String strTotalFees = "";
				/* 1684 */ HttpServletRequest request = ServletActionContext.getRequest();
				/* 1685 */ for (int count = 0; count < studentFeesList.size(); count++) {
					/* 1686 */ if (this.instituteConfigBean.getPartial_payment().equals("Y")) {
						/* 1687 */ strTotalFees = request.getParameter("totalFees" + count);
						/* 1688 */ logger.info(
								"Inside instituteConfigBean.getPartial_payment() Y strTotalFees-->" + strTotalFees);
						/*      */ }
					/* 1690 */ double payableFees = 0.0D;
					/* 1691 */ double calculatedLateFees = 0.0D;
					/* 1692 */ double balanceAmt = 0.0D;
					/* 1693 */ StudentFeesFormBean studentFeesFormBean = studentFeesList.get(count);
					/*      */
					/* 1695 */ logger.info("feesPayList : " + feesPayList.size() + " : " + feesPayList);
					/*      */
					/* 1697 */ logger
							.info(" studentFeesFormBean.getFeePayId()----> " + studentFeesFormBean.getFeePayId());
					/*      */
					/* 1699 */ if (feesPayList.contains(studentFeesFormBean.getFeePayId())) {
						/* 1700 */ calculatedLateFees = Double.parseDouble(studentFeesFormBean.getTotalLateFees());
						/* 1701 */ if (this.instituteConfigBean.getPartial_payment().equals("Y")) {
							/* 1702 */ payableFees = Double.parseDouble(strTotalFees);
							/* 1703 */ balanceAmt = Double.parseDouble(studentFeesFormBean.getBalanceAmt());
							/* 1704 */ if (payableFees + calculatedLateFees != balanceAmt
									&& balanceAmt != payableFees) {
								/* 1705 */ totalLateFees = 0.0D;
								/* 1706 */ studentFeesFormBean.setTotalLateFees("0");
								/* 1707 */ totalFees += payableFees;
								/* 1708 */ studentFeesFormBean.setPayableFees(String.valueOf(payableFees));
								/*      */ } else {
								/* 1710 */ totalLateFees += calculatedLateFees;
								/* 1711 */ totalFees = totalFees + payableFees - calculatedLateFees;
								/* 1712 */ studentFeesFormBean
										.setPayableFees(String.valueOf(payableFees - calculatedLateFees));
								/*      */ }
							/* 1714 */ studentFeesFormBean.setTotalPayableFees(String.valueOf(payableFees));
							/*      */ } else {
							/*      */
							/* 1717 */ Double balAmount = Double
									.valueOf(Double.parseDouble(studentFeesFormBean.getBalanceAmt()));
							/* 1718 */ logger.info("Inside else balAmount" + balAmount);
							/* 1719 */ if (balAmount.doubleValue() > 0.0D) {
								/*      */
								/* 1721 */ payableFees = balAmount.doubleValue();
								/*      */ } else {
								/* 1723 */ payableFees = Double.parseDouble(studentFeesFormBean.getPayableFees());
								/*      */ }
							/*      */
							/*      */
							/* 1727 */ totalLateFees += calculatedLateFees;
							/* 1728 */ totalFees += payableFees;
							/*      */ }
						/*      */
						/*      */
						/* 1732 */ if (this.instituteConfigBean.getPartial_payment().equals("Y")) {
							/* 1733 */ totalPayableFees += payableFees;
							/*      */ } else {
							/* 1735 */ totalPayableFeesNew += payableFees;
							/* 1736 */ totalPayableFees += calculatedLateFees + payableFees;
							/* 1737 */ logger.info("Inside else totalPayableFees-->" + totalPayableFees);
							/*      */ }
						/* 1739 */ selectedFeesList.add(studentFeesFormBean);
						/* 1740 */ if (academicYear == null || "".equalsIgnoreCase(academicYear)
								|| academicYearId == null || "".equalsIgnoreCase(academicYearId)) {
							/* 1741 */ academicYear = studentFeesFormBean.getAcademicYear();
							/* 1742 */ academicYearId = studentFeesFormBean.getAcademicYearId();
							/*      */ }
						/*      */ } else {
						/* 1745 */ logger.info("checkbox is not selected..." + studentFeesFormBean.getFeePayId());
						/*      */ }
					/*      */ }
				/*      */
				/* 1749 */ logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				/* 1750 */ logger.info("selected student fees list data : - " + selectedFeesList.size());
				/* 1751 */ logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				/* 1752 */ appData.setStudentFeesList(selectedFeesList);
				/*      */
				/* 1754 */ appData.setTotalFees((new Double(totalFees)).toString());
				/* 1755 */ appData.setTotalLateFees((new Double(totalLateFees)).toString());
				/* 1756 */ appData.setTotalPayableFees((new Double(totalPayableFees)).toString());
				/*      */
				/* 1758 */ appData.setLateFeeAmount((new Double(totalLateFees)).toString());
				/* 1759 */ appData.setPayableAmount((new Double(totalFees)).toString());
				/* 1760 */ appData.setDiscountAmount("0");
				/* 1761 */ appData.setTotalPayableAmount((new Double(totalPayableFees)).toString());
				/*      */
				/* 1763 */ logger.info("=====================================================");
				/* 1764 */ logger.info("totalFees : - " + totalFees);
				/* 1765 */ logger.info("totalLateFees : - " + totalLateFees);
				/* 1766 */ logger.info("totalPayableFees : - " + totalPayableFees);
				/* 1767 */ logger.info("=====================================================");
				/*      */
				/*      */
				/* 1770 */ if (this.instituteConfigBean.getPartial_payment().equals("Y")) {
					/* 1771 */ appData.setStrAmount((new Double(totalPayableFees)).toString());
					/*      */ } else {
					/*      */
					/* 1774 */ appData.setStrAmount((new Double(totalPayableFees)).toString());
					/*      */ }
				/*      */
				/* 1777 */ logger.info("****************************************************");
				/* 1778 */ logger.info("academicYear : - " + academicYear);
				/* 1779 */ logger.info("academicYearId : - " + academicYearId);
				/* 1780 */ appData.setStrYear(academicYear);
				/* 1781 */ appData.setAcademicYearId(academicYearId);
				/* 1782 */ logger.info("****************************************************");
				/*      */
				/*      */
				/*      */ }
			/*      */ else {
				/*      */
				/*      */
				/* 1789 */ appData.setPayableAmount("0");
				/* 1790 */ appData.setLateFeeAmount("0");
				/* 1791 */ appData.setTotalPayableAmount("0");
				/* 1792 */ appData.setDiscountAmount("0");
				/*      */ }
			/*      */ }
		/* 1795 */ appData.setStudentFeesFetchType(studentRegistrationFormBean.getStudentFeesFetchType());
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public String pgPaymentRequest(int paymentId) {
		/* 1804 */ if (!isValidSession()) {
			/* 1805 */ return INVALID_SESSION;
			/*      */ }
		/*      */
		/* 1808 */ logger.info("Am Inside pgPaymentRequest");
		/*      */
		/* 1810 */ HttpServletRequest request = ServletActionContext.getRequest();
		/* 1811 */ HttpServletResponse response = ServletActionContext.getResponse();
		/* 1812 */ PaymentDetails paymentDetails = new PaymentDetails();
		/* 1813 */ PrintWriter out = null;
		/* 1814 */ PaymentRequestBean paymentRequestBean = null;
		/* 1815 */ ShoppingKartParameterFormBean shoppingKartParameterFormBean = new ShoppingKartParameterFormBean();
		/* 1816 */ PaymentService paymentService = new PaymentService();
		/*      */
		/* 1818 */ Properties properties = null;
		/* 1819 */ String strPaymentRequestURL = "";
		/* 1820 */ String instituteId = ((FJBean) getUserSessionMap().get("BASEDATA")).getBillerId();
		/* 1821 */ String instituteCode = paymentService.getInstituteCode(instituteId);
		/*      */
		/*      */
		/*      */ try {
			/* 1825 */ paymentRequestBean = (PaymentRequestBean) getUserSessionMap().get("APPDATA");
			/*      */
			/* 1827 */ logger.info("Inside Try block");
			/* 1828 */ out = response.getWriter();
			/*      */
			/* 1830 */ logger.info("After1");
			/* 1831 */ properties = new Properties();
			/*      */
			/* 1833 */ MerchantDetailsFormBean merchantDetailsFormBean = new MerchantDetailsFormBean();
			/* 1834 */ String billerId = ((FJBean) getUserSessionMap().get("BASEDATA")).getBillerId();
			/* 1835 */ if (instituteCode.equalsIgnoreCase("NIPR")) {
				/* 1836 */ if (paymentRequestBean.getCurrency().equalsIgnoreCase("INR")) {
					/* 1837 */ merchantDetailsFormBean = paymentService.getMerchantDetails(billerId);
					/*      */ } else {
					/* 1839 */ instituteCode = "NIP";
					/* 1840 */ instituteId = paymentService.getInstituteIdFromInstCode(instituteCode);
					/* 1841 */ this.appData.setStrBillerId(instituteId);
					/* 1842 */ merchantDetailsFormBean = paymentService.getMerchantDetails(instituteId);
					/*      */ }
				/*      */
				/* 1845 */ } else if (instituteCode.equalsIgnoreCase("DSDOON")) {
				/* 1846 */ instituteCode = paymentRequestBean.getCurrency();
				/* 1847 */ instituteId = paymentService.getInstituteIdFromInstCode(instituteCode);
				/* 1848 */ this.appData.setStrBillerId(instituteId);
				/* 1849 */ merchantDetailsFormBean = paymentService.getMerchantDetails(instituteId);
				/*      */ }
			/* 1851 */ else if (instituteCode.equalsIgnoreCase("2734")) {
				/*      */
				/* 1853 */ if (paymentRequestBean.getCurrency().equalsIgnoreCase("INR")) {
					/* 1854 */ merchantDetailsFormBean = paymentService.getMerchantDetails(billerId);
					/*      */ } else {
					/* 1856 */ String instituteCd = "3048";
					/* 1857 */ String instId = paymentService.getInstituteIdFromInstCode(instituteCd);
					/* 1858 */ this.appData.setStrBillerId(instituteId);
					/* 1859 */ merchantDetailsFormBean = paymentService.getMerchantDetails(instId);
					/*      */ }
				/*      */
				/* 1862 */ merchantDetailsFormBean.setCRN(paymentRequestBean.getCurrency());
				/* 1863 */ logger.info("instituteCode : " + instituteCode + " instituteId : " + instituteId
						+ " currency :: " + merchantDetailsFormBean.getCRN());
				/*      */ } else {
				/* 1865 */ merchantDetailsFormBean = paymentService.getMerchantDetails(billerId);
				/*      */ }
			/* 1867 */ paymentDetails.setCurrancy(merchantDetailsFormBean.getCRN());
			/*      */
			/* 1869 */ strPaymentRequestURL = merchantDetailsFormBean.getPg_PaymentRequestURL();
			/*      */
			/* 1871 */ logger.info("strPaymentRequestURL-->" + strPaymentRequestURL);
			/* 1872 */ response.setContentType("text/html;charset=UTF-8");
			/*      */
			/*      */
			/*      */
			/* 1876 */ PaymentServiceUtil pymtUtil = new PaymentServiceUtil();
			/*      */
			/* 1878 */ String pmtMode = "";
			/* 1879 */ String bank = "NA";
			/* 1880 */ String bankCode = "";
			/* 1881 */ Map<Object, Object> pymtMap = null;
			/*      */
			/* 1883 */ String strCustName = "Test User";
			/* 1884 */ String strDueDate = "2011-04-01 00:00:00.000";
			/* 1885 */ String bankName = "";
			/* 1886 */ int insertCnt = 0;
			/*      */
			/*      */
			/* 1889 */ String billerID = "";
			/*      */
			/*      */
			/* 1892 */ logger.info("After2");
			/*      */
			/* 1894 */ pmtMode = this.appData.getStrPaymentMode();
			/* 1895 */ bankCode = (this.appData.getStrBankId() != null
					&& !"".equalsIgnoreCase(this.appData.getStrBankId())) ? this.appData.getStrBankId() : "NA";
			/* 1896 */ logger.info("bankCode : - " + bankCode);
			/* 1897 */ logger.info("in PaymentRequestServlet------->");
			/* 1898 */ logger.info("pmtMode ------->" + this.appData.getStrPaymentMode());
			/* 1899 */ logger.info("banks-------->" + bank);
			/*      */
			/*      */
			/*      */
			/*      */
			/* 1904 */ if (bank != null)
			/*      */ {
				/* 1906 */ StringBuffer stringBuffer = new StringBuffer();
				/* 1907 */ stringBuffer.append(this.appData.getStrBillerId());
				/* 1908 */ stringBuffer.append("~").append(this.appData.getStrStudentId());
				/*      */
				/* 1910 */ stringBuffer.append("~").append(paymentRequestBean.getStrCourse());
				/* 1911 */ stringBuffer.append("~").append(paymentRequestBean.getStrCourseDetails());
				/* 1912 */ stringBuffer.append("~").append(paymentRequestBean.getStrCourseTerm());
				/* 1913 */ stringBuffer.append("~").append(paymentRequestBean.getStrCourseType());
				/* 1914 */ stringBuffer.append("~").append(paymentRequestBean.getStrCoursePattern());
				/* 1915 */ stringBuffer.append("~").append(paymentRequestBean.getStudentFeesList().size());
				/* 1916 */ List<StudentFeesFormBean> studentFeesList = paymentRequestBean.getStudentFeesList();
				/* 1917 */ for (int count = 0; count < studentFeesList.size(); count++) {
					/* 1918 */ StudentFeesFormBean studentFeesFormBean = studentFeesList.get(count);
					/* 1919 */ stringBuffer.append("~").append(studentFeesFormBean.getFeesTypeName());
					/* 1920 */ stringBuffer.append("~").append(studentFeesFormBean.getTotalPayableFees());
					/*      */ }
				/* 1922 */ stringBuffer.append("~").append(this.appData.getStrYear());
				/*      */
				/*      */
				/* 1925 */ paymentDetails.setParameters(stringBuffer.toString());
				/*      */
				/*      */
				/*      */
				/*      */
				/* 1930 */ logger.info("bankCode-------->" + bankCode);
				/*      */
				/* 1932 */ paymentDetails.setStrBankCode("NA");
				/* 1933 */ paymentDetails.setStrPGAccNo("1");
				/* 1934 */ logger.info("amount---------->" + Double.parseDouble(this.appData.getStrAmount()));
				/* 1935 */ paymentDetails.setStrTxnAmt(Double.parseDouble(this.appData.getStrAmount()));
				/* 1936 */ if (this.appData.getStrBillerId() != null && !this.appData.getStrBillerId().equals("")) {
					/* 1937 */ paymentDetails.setStrPayeeId(this.appData.getStrBillerId());
					/*      */ } else {
					/* 1939 */ paymentDetails.setStrPayeeId(instituteId);
					/*      */ }
				/* 1941 */ paymentDetails.setStrUserId(
						String.valueOf(this.appData.getStrMerchantId()) + this.appData.getStrCustomerId());
				/* 1942 */ paymentDetails.setStrConsumerCd(this.appData.getStrConsumerId());
				/* 1943 */ paymentDetails.setStrCustName(this.appData.getStrStudentName());
				/* 1944 */ paymentDetails.setStrDueDate(strDueDate);
				/* 1945 */ paymentDetails.setStrBankName(this.appData.getStrBankName());
				/* 1946 */ paymentDetails.setInstituteCode(instituteCode);
				/*      */
				/*      */
				/*      */
				/* 1950 */ paymentDetails.setStrPaymentMode("online");
				/*      */
				/* 1952 */ logger.info("After3");
				/* 1953 */ paymentDetails.setStrLoginId(this.appData.getStrLoginId());
				/* 1954 */ paymentDetails.setStrPrepaymentID((new StringBuilder(String.valueOf(paymentId))).toString());
				/* 1955 */ insertCnt = paymentService.insertPaymentDetails(paymentDetails);
				/* 1956 */ URLInstituteRequestBean uRLInstituteRequestBean = (URLInstituteRequestBean) getUserSessionMap()
						.get("glaUniversityStudentFormBean");
				/* 1957 */ if (uRLInstituteRequestBean != null) {
					/* 1958 */ String str = paymentService.insertURLInstituteData(paymentDetails,
							uRLInstituteRequestBean);
					/*      */ }
				/*      */
				/* 1961 */ String strDateTime = paymentService.getTranDateTime(paymentId);
				/* 1962 */ paymentRequestBean.setStrTransactionDateTime(strDateTime);
				/*      */
				/* 1964 */ logger.info("paymentDetails : ============================" + paymentDetails.getStrUserId());
				/* 1965 */ logger.info("insertCnt####" + insertCnt);
				/* 1966 */ if (insertCnt > 0) {
					/* 1967 */ pymtMap = new HashMap<>();
					/* 1968 */ logger.info("paymentDetails.getPymtId()--->" + paymentDetails.getStrPaymentId());
					/* 1969 */ logger.info("paymentDetails----->");
					/* 1970 */ pymtMap.put(paymentDetails.getStrPaymentId(), paymentDetails);
					/*      */
					/* 1972 */ getUserSessionMap().put("pymtMap", pymtMap);
					/* 1973 */ logger.info("After4");
					/* 1974 */ logger.info("request pmt id--->" + paymentDetails.getStrPaymentId());
					/*      */
					/* 1976 */ paymentDetails = paymentService
							.getRequestMessageDetails(paymentDetails.getStrPaymentId());
					/*      */
					/* 1978 */ paymentDetails.setReturn_Url(merchantDetailsFormBean.getPg_PaymentResponseUrl());
					/* 1979 */ paymentDetails
							.setFeeTypeMap(paymentService.getFeesDetails(paymentDetails.getPayment_Id()));
					/*      */
					/* 1981 */ paymentDetails.setMerchantDetailsFormBean(merchantDetailsFormBean);
					/* 1982 */ logger.info("merchantDetailsFormBean.getWebServiceLocator()---->"
							+ merchantDetailsFormBean.getWebServiceLocator());
					/* 1983 */ paymentDetails.setWebServiceLocation(merchantDetailsFormBean.getWebServiceLocator());
					/* 1984 */ paymentDetails.setStrIV(merchantDetailsFormBean.getIv());
					/* 1985 */ paymentDetails.setStrKey(merchantDetailsFormBean.getMerchantKey());
					/* 1986 */ paymentDetails.setStrLogPath(merchantDetailsFormBean.getLogPath());
					/* 1987 */ paymentDetails.setStrPayeeId(instituteId);
					/* 1988 */ paymentDetails.setStrCourse(paymentRequestBean.getStrCourse().replaceAll("[()]+", ""));
					/* 1989 */ paymentDetails
							.setStrCourseDetails(paymentRequestBean.getStrCourseDetails().replaceAll("[()]+", ""));
					/* 1990 */ if (uRLInstituteRequestBean != null)
					/*      */ {
						/* 1992 */ if (instituteCode.equalsIgnoreCase("5103"))
						/*      */ {
							/* 1994 */ paymentDetails.setITC(uRLInstituteRequestBean.getAddInfo());
							/*      */ }
						/*      */ }
					/* 1997 */ if (instituteCode.equalsIgnoreCase("MAYO")) {
						/* 1998 */ paymentDetails.setITC(String.valueOf(this.appData.getStrStudentId()) + "~"
								+ this.appData.getStrStudentName() + "~" + this.appData.getStrCourse());
						/* 1999 */ logger.info(
								"Setting ITC parameter for MAYO QuickPayAction-->" + this.appData.getStrStudentId()
										+ "~" + this.appData.getStrStudentName() + "~" + this.appData.getStrCourse());
						/*      */ }
					/* 2001 */ if (instituteCode.equalsIgnoreCase("5503") || instituteCode.equalsIgnoreCase("5585")) {
						/*      */
						/* 2003 */ paymentDetails.setITC(String.valueOf(this.appData.getStrStudentId()) + "~"
								+ this.appData.getStrStudentName() + "~" + this.appData.getStudentFatherName());
						/* 2004 */ logger.info("Setting ITC parameter for Dronacharya QuickPayAction-->"
								+ this.appData.getStrStudentId() + "~" + this.appData.getStrStudentName() + "~"
								+ this.appData.getStudentFatherName());
						/*      */ }
					/*      */
					/* 2007 */ pymtUtil.pgrequest_Rechargechecksum(paymentDetails);
					/* 2008 */ logger.info("PG request message---->" + paymentDetails.getStrResponseMsg());
					/*      */
					/*      */
					/* 2011 */ getUserSessionMap().put("APPDATA", paymentRequestBean);
					/* 2012 */ if (paymentDetails.getStrResponseMsg() != null) {
						/*      */
						/*      */
						/*      */
						/* 2016 */ request.getSession().setAttribute("paymentDets", paymentDetails);
						/*      */
						/*      */
						/* 2019 */ PaymentRequestBean objPaymentRequestBean = (PaymentRequestBean) getUserSessionMap()
								.get("APPDATA");
						/*      */
						/* 2021 */ PaymentDetails objPaymentDetails = (PaymentDetails) request.getSession()
								.getAttribute("paymentDets");
						/*      */
						/* 2023 */ FJBean objBaseData = (FJBean) getUserSessionMap().get("BASEDATA");
						/*      */
						/* 2025 */ logger.info("Payment Details-->");
						/* 2026 */ logger.info("objBaseData-->" + objBaseData.toString());
						/*      */
						/* 2028 */ SaveObject obj = new SaveObject();
						/*      */
						/* 2030 */ logger.info("Payment Id-->" + objPaymentDetails.getMerchant_Txn_Reference());
						/* 2031 */ logger
								.info("INSIDE START PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
						/* 2032 */ logger.info("Value of pymtMap-->");
						/* 2033 */ logger.info("Value of BASEDATA-->" + getUserSessionMap().get("BASEDATA").toString());
						/*      */
						/*      */ try {
							/* 2036 */ logger
									.info("INSIDE TRY PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2038 */ obj.setJavaObject(objPaymentRequestBean);
							/* 2039 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(), "APPDATA");
							/* 2040 */ logger
									.info("AFTER APPDATA PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2042 */ obj.setJavaObject(objPaymentDetails);
							/* 2043 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(), "paymentDets");
							/* 2044 */ logger.info(
									"AFTER paymentDets PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2046 */ obj.setJavaObject(objBaseData);
							/* 2047 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(), "BASEDATA");
							/* 2048 */ logger.info(
									"AFTER BASEDATA PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2050 */ obj.setJavaObject(getUserSessionMap().get("pymtMap"));
							/* 2051 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(), "pymtMap");
							/* 2052 */ logger
									.info("AFTER pymtMap PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/*      */
							/* 2055 */ logger.info("_instituteAliasCodeConfigBean-->"
									+ getUserSessionMap().get("_instituteAliasCodeConfigBean"));
							/* 2056 */ obj.setJavaObject(getUserSessionMap().get("_instituteAliasCodeConfigBean"));
							/* 2057 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(),
									"_instituteAliasCodeConfigBean");
							/* 2058 */ logger.info("AFTER _instituteAliasCodeConfigBean PG Object-->"
									+ objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2060 */ logger
									.info("VAS (GLA) obj-->" + getUserSessionMap().get("glaUniversityStudentFormBean"));
							/* 2061 */ obj.setJavaObject(getUserSessionMap().get("glaUniversityStudentFormBean"));
							/* 2062 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(),
									"glaUniversityStudentFormBean");
							/* 2063 */ logger
									.info("AFTER VAS GLA PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2065 */ logger.info("VAS (_instituteConfigBean) obj-->"
									+ getUserSessionMap().get("_instituteConfigBean"));
							/* 2066 */ obj.setJavaObject(getUserSessionMap().get("_instituteConfigBean"));
							/* 2067 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(),
									"_instituteConfigBean");
							/* 2068 */ logger.info("AFTER VAS _instituteConfigBean PG Object-->"
									+ objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2070 */ logger.info("COURSEDATA obj-->" + getUserSessionMap().get("COURSEDATA"));
							/* 2071 */ obj.setJavaObject(getUserSessionMap().get("COURSEDATA"));
							/* 2072 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(), "COURSEDATA");
							/* 2073 */ logger.info(
									"AFTER COURSEDATA PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/*      */
							/* 2076 */ logger.info("INSTDATA obj-->" + getUserSessionMap().get("INSTDATA"));
							/* 2077 */ obj.setJavaObject(getUserSessionMap().get("INSTDATA"));
							/* 2078 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(), "INSTDATA");
							/* 2079 */ logger.info(
									"AFTER INSTDATA PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2081 */ logger.info("INSTCONFIG obj-->" + getUserSessionMap().get("INSTCONFIG"));
							/* 2082 */ obj.setJavaObject(getUserSessionMap().get("INSTCONFIG"));
							/* 2083 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(), "INSTCONFIG");
							/* 2084 */ logger.info(
									"AFTER INSTCONFIG PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2086 */ logger.info("INSTCONFIG1 obj-->" + getUserSessionMap().get("INSTCONFIG1"));
							/* 2087 */ obj.setJavaObject(getUserSessionMap().get("INSTCONFIG1"));
							/* 2088 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(), "INSTCONFIG1");
							/* 2089 */ logger.info(
									"AFTER INSTCONFIG1 PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2091 */ logger.info(
									"_gnluChallanDataList obj-->" + getUserSessionMap().get("_gnluChallanDataList"));
							/* 2092 */ obj.setJavaObject(getUserSessionMap().get("_gnluChallanDataList"));
							/* 2093 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(),
									"_gnluChallanDataList");
							/* 2094 */ logger.info("AFTER _gnluChallanDataList PG Object-->"
									+ objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2096 */ logger.info(
									"_paymentRequestBean obj-->" + getUserSessionMap().get("_paymentRequestBean"));
							/* 2097 */ obj.setJavaObject(getUserSessionMap().get("_paymentRequestBean"));
							/* 2098 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(),
									"_paymentRequestBean");
							/* 2099 */ logger.info("AFTER _paymentRequestBean PG Object-->"
									+ objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2101 */ logger.info("_feesPayChargesFormBean obj-->"
									+ getUserSessionMap().get("_feesPayChargesFormBean"));
							/* 2102 */ obj.setJavaObject(getUserSessionMap().get("_feesPayChargesFormBean"));
							/* 2103 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(),
									"_feesPayChargesFormBean");
							/* 2104 */ logger.info("AFTER _feesPayChargesFormBean PG Object-->"
									+ objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2106 */ logger.info("BSPRDATA obj-->" + getUserSessionMap().get("BSPRDATA"));
							/* 2107 */ obj.setJavaObject(getUserSessionMap().get("BSPRDATA"));
							/* 2108 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(), "BSPRDATA");
							/* 2109 */ logger.info(
									"AFTER BSPRDATA PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2111 */ logger.info("ONLINEFORMDATA obj-->" + getUserSessionMap().get("ONLINEFORMDATA"));
							/* 2112 */ obj.setJavaObject(getUserSessionMap().get("ONLINEFORMDATA"));
							/* 2113 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(), "ONLINEFORMDATA");
							/* 2114 */ logger.info("AFTER ONLINEFORMDATA PG Object-->"
									+ objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2116 */ logger.info("admissionType obj-->" + getUserSessionMap().get("admissionType"));
							/* 2117 */ obj.setJavaObject(getUserSessionMap().get("admissionType"));
							/* 2118 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(), "admissionType");
							/* 2119 */ logger.info(
									"AFTER admissionType PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2121 */ logger.info("branchId obj-->" + getUserSessionMap().get("branchId"));
							/* 2122 */ obj.setJavaObject(getUserSessionMap().get("branchId"));
							/* 2123 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(), "branchId");
							/* 2124 */ logger.info(
									"AFTER branchId PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
							/*      */
							/* 2126 */ logger
									.info("Bankwise Redirect obj-->" + getUserSessionMap().get("_bankWiseRedirect"));
							/* 2127 */ obj.setJavaObject(getUserSessionMap().get("_bankWiseRedirect"));
							/* 2128 */ obj.saveObject(objPaymentDetails.getMerchant_Txn_Reference(),
									"_bankWiseRedirect");
							/* 2129 */ logger.info("AFTER bankWiseRedirect PG Object-->"
									+ objPaymentDetails.getMerchant_Txn_Reference());
							/*      */ }
						/* 2131 */ catch (Exception e) {
							/* 2132 */ logger
									.info("INSIDE CATCH PG Object-->" + objPaymentDetails.getMerchant_Txn_Reference());
							/* 2133 */ logger.error("Exception  " + e);
							/*      */ }
						/*      */
						/*      */
						/* 2137 */ return paymentDetails.getStrResponseMsg();
						/*      */ }
					/*      */ } else {
					/*      */
					/* 2141 */ logger.info("Payment insertion failed");
					/*      */ }
				/*      */
				/*      */ }
			/*      */
			/*      */ }
		/* 2147 */ catch (NumberFormatException ex) {
			/* 2148 */ logger.error("Exception  " + ex);
			/* 2149 */ } catch (IOException e) {
			/* 2150 */ logger.error("Exception  " + e);
			/* 2151 */ } catch (Exception e) {
			/* 2152 */ logger.error("Exception  " + e);
			/*      */ }
		/*      */
		/*      */
		/* 2156 */ return null;
		/*      */ }

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
	/*      */ public String pgPaymentResponse() {
		/* 2208 */ HttpServletRequest request = ServletActionContext.getRequest();
		/* 2209 */ HttpServletResponse response = ServletActionContext.getResponse();
		/*      */
		/* 2211 */ PrintWriter out = null;
		/* 2212 */ String responseMsg = "";
		/* 2213 */ PaymentServiceUtil pymtSrvcUtil = new PaymentServiceUtil();
		/* 2214 */ PG_Payment_Response pg_payment_response = null;
		/* 2215 */ String reqTxnId = "";
		/* 2216 */ RequestDispatcher rd = null;
		/* 2217 */ PaymentDetails pymtVO = new PaymentDetails();
		/* 2218 */ int updateCnt = 0;
		/* 2219 */ String msg = "";
		/* 2220 */ String merchantID = "";
		/* 2221 */ String customerID = "";
		/* 2222 */ String billerID = "";
		/* 2223 */ String consumerCode = "";
		/* 2224 */ String billamount = "";
		/* 2225 */ String vmtTranId = "";
		/* 2226 */ String amount = "";
		/* 2227 */ String pgMerchantid = "";
		/* 2228 */ PaymentService paymentService = null;
		/* 2229 */ Map<String, String> statusMap = null;
		/*      */
		/*      */
		/*      */ try {
			/* 2233 */ logger.info("Inside PG Reponse received---->");
			/* 2234 */ out = response.getWriter();
			/* 2235 */ responseMsg = (request.getParameter("msg") == null) ? "" : request.getParameter("msg").trim();
			/* 2236 */ pgMerchantid = (request.getParameter("tpsl_mrct_cd") == null) ? ""
					: request.getParameter("tpsl_mrct_cd").trim();
			/* 2237 */ responseMsg = StringEscapeUtils.escapeHtml(responseMsg);
			/* 2238 */ responseMsg.replaceAll("[<>;&^?%.]", "");
			/*      */
			/* 2240 */ pgMerchantid = StringEscapeUtils.escapeHtml(pgMerchantid);
			/* 2241 */ pgMerchantid.replaceAll("[<>;&^?%.]", "");
			/*      */
			/* 2243 */ logger.info("responseMsg-->" + responseMsg);
			/* 2244 */ logger.info("pgMerchantid-->" + pgMerchantid);
			/*      */
			/* 2246 */ SaveObject getSaveObj = new SaveObject();
			/* 2247 */ InstituteAliasCodeConfigBean instituteAliasCodeConfigBean = new InstituteAliasCodeConfigBean();
			/*      */
			/* 2249 */ PaymentDetails paymentDetails = new PaymentDetails();
			/* 2250 */ logger.info("Original Response message-->" + responseMsg);
			/* 2251 */ if (!"".equals(responseMsg)) {
				/* 2252 */ logger.info("Fetching Key and IV from DB with LID-->" + pgMerchantid);
				/* 2253 */ PaymentService paymentService2 = new PaymentService();
				/* 2254 */ MerchantDetailsFormBean merchantDetailsFormBean = paymentService2
						.getMerchantDetails_PGResponse(pgMerchantid);
				/*      */
				/* 2256 */ paymentDetails.setStrKey(merchantDetailsFormBean.getMerchantKey());
				/* 2257 */ paymentDetails.setStrIV(merchantDetailsFormBean.getIv());
				/* 2258 */ paymentDetails.setStrLogPath(merchantDetailsFormBean.getLogPath());
				/*      */
				/* 2260 */ logger.info("paymentDetails-->" + paymentDetails.getStrKey() + "\t"
						+ paymentDetails.getStrIV() + "\t" + paymentDetails.getStrLogPath());
				/*      */
				/*      */
				/* 2263 */ pg_payment_response = pymtSrvcUtil.pgresponse_Rechargechecksum(responseMsg, paymentDetails);
				/* 2264 */ reqTxnId = pg_payment_response.getMerchantReferenceNo();
				/*      */
				/*      */
				/*      */
				/*      */
				/* 2269 */ this.appData = (PaymentRequestBean) getSaveObj.getObject(reqTxnId, "APPDATA");
				/*      */
				/* 2271 */ getUserSessionMap().put("APPDATA", this.appData);
				/* 2272 */ if (this.appData == null)
				/*      */ {
					/*      */
					/*      */
					/*      */
					/* 2277 */ logger.info("APPDATA from DB is Blank or null-->");
					/*      */ }
				/*      */
				/*      */
				/*      */
				/* 2282 */ CourseDetailsBean courseDetailsBean = (CourseDetailsBean) getSaveObj.getObject(reqTxnId,
						"COURSEDATA");
				/*      */
				/* 2284 */ getUserSessionMap().put("COURSEDATA", courseDetailsBean);
				/*      */
				/* 2286 */ if (courseDetailsBean != null) {
					/* 2287 */ logger.info("COURSEDATA from DB-->" + getUserSessionMap().get("COURSEDATA"));
					/*      */ }
				/*      */ else {
					/*      */
					/* 2291 */ logger.info("COURSEDATA from DB is Blank or null-->");
					/*      */ }
				/*      */
				/*      */
				/*      */
				/*      */
				/* 2297 */ Map pymtMap = (Map) getSaveObj.getObject(reqTxnId, "pymtMap");
				/* 2298 */ getUserSessionMap().put("pymtMap", pymtMap);
				/* 2299 */ if (pymtMap == null)
				/*      */ {
					/*      */
					/*      */
					/*      */
					/* 2304 */ logger.info("pymtMap from DB is Blank or null-->");
					/*      */ }
				/*      */
				/*      */
				/*      */
				/* 2309 */ paymentDetails = (PaymentDetails) getSaveObj.getObject(reqTxnId, "paymentDets");
				/*      */
				/* 2311 */ getUserSessionMap().put("paymentDets", paymentDetails);
				/* 2312 */ if (paymentDetails == null)
				/*      */ {
					/*      */
					/*      */
					/*      */
					/* 2317 */ logger.info("paymentDets from DB is Blank or null-->");
					/*      */ }
				/*      */
				/*      */
				/*      */
				/* 2322 */ FJBean objBaseData = (FJBean) getSaveObj.getObject(reqTxnId, "BASEDATA");
				/* 2323 */ getUserSessionMap().put("BASEDATA", objBaseData);
				/* 2324 */ if (objBaseData != null) {
					/* 2325 */ logger.info("Getting BASEDATA details from DB-->" + objBaseData.toString());
					/*      */ }
				/*      */ else {
					/*      */
					/* 2329 */ logger.info("BASEDATA from DB is Blank or null-->");
					/*      */ }
				/*      */
				/*      */
				/*      */
				/* 2334 */ instituteAliasCodeConfigBean = (InstituteAliasCodeConfigBean) getSaveObj.getObject(reqTxnId,
						"_instituteAliasCodeConfigBean");
				/* 2335 */ getUserSessionMap().put("_instituteAliasCodeConfigBean", instituteAliasCodeConfigBean);
				/*      */
				/*      */
				/*      */
				/* 2339 */ InstituteMasterFormBean instituteMasterFormBean = (InstituteMasterFormBean) getSaveObj
						.getObject(reqTxnId, "INSTDATA");
				/* 2340 */ logger.info("Getting INSTDATA details from DB-->");
				/* 2341 */ getUserSessionMap().put("INSTDATA", instituteMasterFormBean);
				/* 2342 */ if (instituteMasterFormBean != null) {
					/* 2343 */ logger.info(" INSTDATA details from DB-->" + instituteMasterFormBean.toString());
					/*      */ } else {
					/*      */
					/* 2346 */ logger.info("INSTDATA data from DB Blank or Null-->");
					/*      */ }
				/*      */
				/*      */
				/*      */
				/* 2351 */ InstituteConfigBean instituteConfigBean = (InstituteConfigBean) getSaveObj
						.getObject(reqTxnId, "INSTCONFIG");
				/* 2352 */ logger.info("Getting INSTCONFIG details from DB-->");
				/* 2353 */ getUserSessionMap().put("INSTCONFIG", instituteConfigBean);
				/* 2354 */ if (instituteConfigBean != null) {
					/* 2355 */ logger.info("INSTCONFIG details from DB-->" + instituteConfigBean.toString());
					/*      */ } else {
					/*      */
					/* 2358 */ logger.info("INSTCONFIG data from DB Blank or Null-->");
					/*      */ }
				/*      */
				/*      */
				/*      */
				/* 2363 */ InstituteConfigBean instituteConfigBean1 = (InstituteConfigBean) getSaveObj
						.getObject(reqTxnId, "INSTCONFIG1");
				/* 2364 */ logger.info("Getting INSTCONFIG1 details from DB-->");
				/* 2365 */ getUserSessionMap().put("INSTCONFIG1", instituteConfigBean1);
				/* 2366 */ if (instituteConfigBean1 != null) {
					/* 2367 */ logger.info("INSTCONFIG1 details from DB-->" + instituteConfigBean1.toString());
					/*      */ } else {
					/*      */
					/* 2370 */ logger.info("INSTCONFIG1 data from DB Blank or Null-->");
					/*      */ }
				/*      */
				/*      */
				/*      */
				/*      */
				/*      */
				/* 2377 */ PaymentRequestBean paymentRequestBean = (PaymentRequestBean) getSaveObj.getObject(reqTxnId,
						"_paymentRequestBean");
				/* 2378 */ logger.info("Getting _paymentRequestBean details from DB-->");
				/* 2379 */ getUserSessionMap().put("_paymentRequestBean", paymentRequestBean);
				/* 2380 */ if (paymentRequestBean != null) {
					/* 2381 */ logger.info("_paymentRequestBean details from DB-->" + paymentRequestBean.toString());
					/*      */ } else {
					/*      */
					/* 2384 */ logger.info("_paymentRequestBean data from DB Blank or Null-->");
					/*      */ }
				/*      */
				/*      */
				/*      */
				/* 2389 */ FeesPayChargesFormBean feesPayChargesFormBean = (FeesPayChargesFormBean) getSaveObj
						.getObject(reqTxnId, "_feesPayChargesFormBean");
				/* 2390 */ logger.info("Getting _feesPayChargesFormBean details from DB-->");
				/* 2391 */ getUserSessionMap().put("_feesPayChargesFormBean", feesPayChargesFormBean);
				/* 2392 */ if (feesPayChargesFormBean != null) {
					/* 2393 */ logger
							.info("_feesPayChargesFormBean details from DB-->" + feesPayChargesFormBean.toString());
					/*      */ } else {
					/*      */
					/* 2396 */ logger.info("_feesPayChargesFormBean data from DB Blank or Null-->");
					/*      */ }
				/*      */
				/*      */
				/*      */
				/* 2401 */ BSPROnlineFormBean BSPROnlineFormBean = (BSPROnlineFormBean) getSaveObj.getObject(reqTxnId,
						"BSPRDATA");
				/* 2402 */ logger.info("Getting BSPRDATA details from DB-->");
				/* 2403 */ getUserSessionMap().put("BSPRDATA", BSPROnlineFormBean);
				/* 2404 */ if (BSPROnlineFormBean != null) {
					/* 2405 */ logger.info("BSPRDATA details from DB-->" + BSPROnlineFormBean.toString());
					/*      */ } else {
					/*      */
					/* 2408 */ logger.info("BSPRDATA data from DB Blank or Null-->");
					/*      */ }
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
				/* 2425 */ String admissionType = (String) getSaveObj.getObject(reqTxnId, "admissionType");
				/* 2426 */ logger.info("Getting admissionType details from DB-->");
				/* 2427 */ getUserSessionMap().put("admissionType", admissionType);
				/* 2428 */ if (admissionType != null) {
					/* 2429 */ logger.info("admissionType details from DB-->" + admissionType);
					/*      */ } else {
					/*      */
					/* 2432 */ logger.info("admissionType data from DB Blank or Null-->");
					/*      */ }
				/*      */
				/*      */
				/*      */
				/* 2437 */ String branchId = (String) getSaveObj.getObject(reqTxnId, "branchId");
				/* 2438 */ logger.info("Getting branchId details from DB-->");
				/* 2439 */ getUserSessionMap().put("branchId", branchId);
				/* 2440 */ if (branchId != null) {
					/* 2441 */ logger.info("branchId details from DB-->" + branchId);
					/*      */ } else {
					/*      */
					/* 2444 */ logger.info("branchId data from DB Blank or Null-->");
					/*      */ }
				/*      */
				/*      */
				/*      */
				/* 2449 */ String bankWiseRedirect = (String) getSaveObj.getObject(reqTxnId, "_bankWiseRedirect");
				/* 2450 */ logger.info("Getting _bankWiseRedirect details from DB-->");
				/* 2451 */ getUserSessionMap().put("_bankWiseRedirect", bankWiseRedirect);
				/* 2452 */ if (bankWiseRedirect != null) {
					/* 2453 */ logger.info("_bankWiseRedirect details from DB-->" + bankWiseRedirect);
					/*      */ } else {
					/*      */
					/* 2456 */ logger.info("_bankWiseRedirect data from DB Blank or Null-->");
					/*      */ }
				/*      */
				/*      */
				/*      */
				/* 2461 */ pymtSrvcUtil.pgVerifyDB(paymentDetails);
				/* 2462 */ logger.info("pgVerifyDB done------->");
				/* 2463 */ statusMap = new HashMap<>();
				/* 2464 */ statusMap = (Map<String, String>) getUserSessionMap().get("sessionMap");
				/* 2465 */ if (((String) statusMap.get("txn_status")).equalsIgnoreCase("0300")) {
					/* 2466 */ pg_payment_response.setStrpgPaymentStatus("Y");
					/*      */ }
				/* 2468 */ else if (((String) statusMap.get("txn_status")).equalsIgnoreCase("0398")) {
					/* 2469 */ pg_payment_response.setStrpgPaymentStatus("I");
					/*      */ } else {
					/*      */
					/* 2472 */ pg_payment_response.setStrpgPaymentStatus("N");
					/*      */ }
				/*      */
				/*      */
				/*      */
				/* 2477 */ logger.error("reqTxnId------->" + reqTxnId);
				/* 2478 */ logger.error("PG Response Status:::" + pg_payment_response.getStrpgPaymentStatus());
				/*      */
				/* 2480 */ String TransactionMsg = (pg_payment_response.getTransactionErrorCode() == null) ? ""
						: pg_payment_response.getTransactionErrorCode();
				/* 2481 */ String TransactionErrorMsg = (pg_payment_response.getTransactionErrorDescription() == null)
						? ""
						: pg_payment_response.getTransactionErrorDescription();
				/* 2482 */ MDC.put("Txn_Amt", pg_payment_response.getTransactionAmount());
				/* 2483 */ MDC.put("Payee_Id", paymentDetails.getStrPayeeId());
				/* 2484 */ MDC.put("Pmt_Id", pg_payment_response.getMerchantReferenceNo());
				/* 2485 */ MDC.put("PGTxnID", pg_payment_response.getTPSLTransactionID());
				/* 2486 */ MDC.put("pg_pmt_status", pg_payment_response.getStrpgPaymentStatus());
				/* 2487 */ MDC.put("payment_id", paymentDetails.getPayment_Id());
				/* 2488 */ MDC.put("PG_Response_Message", String.valueOf(TransactionMsg) + "~" + TransactionErrorMsg);
				/*      */
				/* 2490 */ logger.info(" PG Transaction Amount:::---->" + pg_payment_response.getTransactionAmount());
				/* 2491 */ logger.info(" SmartHub Payee ID::::::---->" + paymentDetails.getStrPayeeId());
				/* 2492 */ logger.info(" PG SRC_PRN::::::---->" + pg_payment_response.getMerchantReferenceNo());
				/* 2493 */ logger.info(" PGxNID::::::---->" + pg_payment_response.getTPSLTransactionID());
				/* 2494 */ logger.info(" PG Transaction Status:::---->" + pg_payment_response.getStrpgPaymentStatus());
				/* 2495 */ logger.info(" SmartHub Payment ID:::::: ---->" + paymentDetails.getPayment_Id());
				/* 2496 */ logger.info(
						"PG Transaction Response Message:::::---->" + pg_payment_response.getTransactionErrorCode()
								+ "~" + pg_payment_response.getTransactionErrorDescription());
				/*      */
				/*      */
				/*      */
				/*      */
				/* 2501 */ if (pymtMap != null && pymtMap.containsKey(reqTxnId.trim())) {
					/* 2502 */ String billerId = ((FJBean) getUserSessionMap().get("BASEDATA")).getBillerId();
					/* 2503 */ instituteConfigBean = (new InstituteMasterActionService())
							.getInstituteConfigDetails(billerId);
					/* 2504 */ pymtVO = (PaymentDetails) pymtMap.get(reqTxnId.trim());
					/* 2505 */ pymtVO.setStrPGPaymentId(pg_payment_response.getTPSLTransactionID());
					/* 2506 */ pymtVO.setStrResponseMsg(pg_payment_response.getTransactionErrorDescription());
					/* 2507 */ if (pg_payment_response.getStrpgPaymentStatus().equalsIgnoreCase("Y")) {
						/* 2508 */ logger.info("Payment Successfully done.");
						/* 2509 */ msg = "Your transaction has been successfully processed...";
						/*      */
						/*      */
						/* 2512 */ if (getAppData().getStudentFeesFetchType() != null
								&& "I".equalsIgnoreCase(getAppData().getStudentFeesFetchType())) {
							/* 2513 */ logger.info("Update payMent status...");
							/* 2514 */ List<StudentFeesFormBean> studentFeesList = getAppData().getStudentFeesList();
							/* 2515 */ if (!Utility.isListEmpty(studentFeesList)) {
								/* 2516 */ StudentDataService studentDataService = new StudentDataService();
								/* 2517 */ List<Integer> studentIdList = studentDataService
										.fetchStudentIdByPmtId(reqTxnId);
								/* 2518 */ for (int count = 0; count < studentFeesList.size(); count++) {
									/* 2519 */ StudentFeesFormBean studentFeesFormBean = studentFeesList.get(count);
									/* 2520 */ logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
									/* 2521 */ logger.info(studentFeesFormBean.getFeePayId());
									/* 2522 */ if (!studentIdList.contains(
											Integer.valueOf(Integer.parseInt(studentFeesFormBean.getFeePayId())))) {
										/*      */
										/*      */
										/*      */
										/* 2526 */ int cnt = studentDataService.insertSessionOverlapData(this.appData,
												pg_payment_response);
										/* 2527 */ addActionError(
												"Your session has been invalidated. Please login again.");
										/* 2528 */ invalidateSessions();
										/* 2529 */ return "error";
										/*      */ }
									/* 2531 */ logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
									/* 2532 */ if (instituteConfigBean.getPartial_payment().equals("Y")) {
										/* 2533 */ if (Double.parseDouble(studentFeesFormBean.getBalanceAmt()) - Double
												.parseDouble(studentFeesFormBean.getTotalPayableFees()) < 0.0D) {
											/* 2534 */ studentFeesFormBean
													.setTotalPayableFees(studentFeesFormBean.getBalanceAmt());
											/*      */ }
										/* 2536 */ StudentFeesFormBean sFeesFormBean = studentDataService
												.updateStudentFeesBalance(studentFeesFormBean.getFeePayId().trim(),
														Double.valueOf(Double.parseDouble(
																studentFeesFormBean.getTotalPayableFees())));
										/* 2537 */ studentFeesFormBean.setBalanceAmt(sFeesFormBean.getBalanceAmt());
										/* 2538 */ if (sFeesFormBean.getBalanceAmt().equals("0")
												|| sFeesFormBean.getBalanceAmt().equals("0.00")) {
											/* 2539 */ String status = studentDataService
													.updateStudentFeesPaymentStatus(
															studentFeesFormBean.getFeePayId().trim());
											/* 2540 */ if (status != null && "Updated".equalsIgnoreCase(status)) {
												/* 2541 */ logger
														.info("feePayId payment status flag updated successfully...");
												/*      */ } else {
												/* 2543 */ logger.info(
														"some problem while updating the payment status in StudentData table");
												/*      */ }
											/*      */ }
										/*      */ } else {
										/* 2547 */ String status = studentDataService.updateStudentFeesPaymentStatus(
												studentFeesFormBean.getFeePayId().trim());
										/* 2548 */ logger
												.info("STATUS VALUE while updating Student Data Table-->" + status);
										/* 2549 */ if (status != null && "Updated".equalsIgnoreCase(status)) {
											/* 2550 */ logger.info(
													"feePayId payment status flag updated successfully...getFeePayId-->"
															+ studentFeesFormBean.getFeePayId().trim());
											/*      */ } else {
											/* 2552 */ logger.info(
													"FALSE LOG please ignore (DATA Updated)--some problem while updating the payment status in StudentData table getFeePayId-->"
															+ studentFeesFormBean.getFeePayId().trim());
											/*      */ }
										/*      */ }
									/*      */ }
								/*      */ }
							/* 2557 */ } else if (getAppData().getStudentFeesFetchType() != null
									&& "D".equalsIgnoreCase(getAppData().getStudentFeesFetchType())) {
							/* 2558 */ logger.info("Default feesFetchType");
							/*      */ } else {
							/* 2560 */ logger.info("FeesFetchType problem need to check...");
							/*      */ }
						/* 2562 */ } else if ("I".equalsIgnoreCase(pg_payment_response.getStrpgPaymentStatus())) {
						/* 2563 */ msg = "Your transaction has been successfully initiated...";
						/*      */ } else {
						/*      */
						/* 2566 */ String errorCode = pg_payment_response.getTransactionErrorDescription();
						/*      */
						/* 2568 */ logger.info("Payment fail for amount.");
						/* 2569 */ msg = "Your transaction is Failed...";
						/*      */ }
					/*      */
					/*      */
					/*      */
					/* 2574 */ String str1 = pg_payment_response.getTransactedBankCode();
					/*      */ }
				/*      */ else {
					/*      */
					/* 2578 */ logger.info("Txn id not found----->");
					/*      */ }
				/*      */
				/*      */ } else {
				/*      */
				/* 2583 */ logger.info("payment fail");
				/*      */ }
			/* 2585 */ paymentService = new PaymentService();
			/*      */
			/* 2587 */ updateCnt = paymentService.updatePGPayment(pymtVO, pg_payment_response);
			/* 2588 */ audit.info("paymentinformation");
			/* 2589 */ logger.info("update SJ_billpayment------------>>" + updateCnt
					+ "pg_payment_response.getStrpgPaymentStatus()---->>"
					+ pg_payment_response.getStrpgPaymentStatus());
			/* 2590 */ if (updateCnt > 0 && "Y".equalsIgnoreCase(pg_payment_response.getStrpgPaymentStatus())) {
				/* 2591 */ if (pymtVO.getStrUserId() != null && pymtVO.getStrUserId().length() > 3) {
					/* 2592 */ merchantID = pymtVO.getStrUserId().substring(0, 3);
					/* 2593 */ customerID = pymtVO.getStrUserId().substring(3);
					/* 2594 */ billerID = pymtVO.getStrPayeeId();
					/* 2595 */ consumerCode = pymtVO.getStrConsumerCd();
					/*      */ }
				/* 2597 */ vmtTranId = String.valueOf(pymtVO.getStrPaymentId());
				/* 2598 */ billamount = (new StringBuilder(String.valueOf(pymtVO.getStrTxnAmt()))).toString();
				/*      */ }
			/*      */
			/* 2601 */ billamount = (new StringBuilder(String.valueOf(pymtVO.getStrTxnAmt()))).toString();
			/* 2602 */ getAppData().setStrAmount(billamount);
			/* 2603 */ getAppData().setStrPgTranid(reqTxnId);
			/* 2604 */ getAppData().setStrPgTranDesc(msg);
			/* 2605 */ getAppData().setStrpgPaymentStatus(pg_payment_response.getStrpgPaymentStatus());
			/*      */
			/* 2607 */ String InstituteId = "";
			/* 2608 */ InstituteMasterActionService service = new InstituteMasterActionService();
			/* 2609 */ InstituteId = service.getInstituteCode(getAppData().getStrBillerId());
			/* 2610 */ getAppData().setStrInstituteCode(InstituteId);
			/* 2611 */ getUserSessionMap().put("APPDATA", this.appData);
			/*      */
			/* 2613 */ getUserSessionMap().put("INSTCODE", InstituteId);
			/*      */
			/* 2615 */ String test = pg_payment_response.getPg_ResponseMessage();
			/*      */
			/*      */
			/* 2618 */ String ApplicationNo = getAppData().getStrStudentId();
			/* 2619 */ String StrpgPaymentStatus = this.appData.getStrpgPaymentStatus();
			/*      */
			/* 2621 */ Object[] params = null;
			/*      */
			/*      */
			/*      */
			/* 2625 */ List<INTLCourseFormBean> gnluList = (ArrayList) getSaveObj.getObject(reqTxnId,
					"_gnluChallanDataList");
			/* 2626 */ logger.info("Getting _gnluChallanDataList details from DB-->");
			/* 2627 */ getUserSessionMap().put("_gnluChallanDataList", gnluList);
			/* 2628 */ if (gnluList != null) {
				/* 2629 */ logger.info("_gnluChallanDataList details from DB-->" + gnluList.toString());
				/*      */ } else {
				/*      */
				/* 2632 */ logger.info("_gnluChallanDataList data from DB Blank or Null-->");
				/*      */ }
			/*      */
			/*      */
			/*      */
			/*      */
			/*      */
			/*      */
			/* 2640 */ logger.info("Getting _instituteAliasCodeConfigBean object from DB for reqTxnId-->" + reqTxnId);
			/*      */
			/*      */
			/* 2643 */ if ((InstituteAliasCodeConfigBean) getUserSessionMap()
					.get("_instituteAliasCodeConfigBean") != null) {
				/* 2644 */ logger.info("Getting _instituteAliasCodeConfigBean object from DB for reqTxnId-->" + reqTxnId
						+ "\t" + instituteAliasCodeConfigBean.toString());
				/* 2645 */ logger.info("ApplicationNo=" + ApplicationNo + "InstituteId=" + InstituteId
						+ "StrpgPaymentStatus=" + StrpgPaymentStatus);
				/* 2646 */ String[] paramsList = { ApplicationNo, InstituteId, StrpgPaymentStatus };
				/* 2647 */ String paramIndexStr = ((InstituteAliasCodeConfigBean) getUserSessionMap()
						.get("_instituteAliasCodeConfigBean")).getQuickPayGetFormDetailsMethodIndex();
				/* 2648 */ String[] indexesList = paramIndexStr.split(",");
				/* 2649 */ params = new Object[indexesList.length];
				/* 2650 */ int j = 0;
				byte b;
				int i;
				String[] arrayOfString1;
				/* 2651 */ for (i = (arrayOfString1 = indexesList).length, b = 0; b < i;) {
					String s = arrayOfString1[b];
					/* 2652 */ params[j] = paramsList[Integer.parseInt(s) - 1];
					/* 2653 */ j++;
					b++;
				}
				/*      */
				/* 2655 */ logger.info("length of the arguments--->>" + j);
				/*      */ } else {
				/*      */
				/* 2658 */ logger
						.info("_instituteAliasCodeConfigBean object is empty or null for reqTxnId-->" + reqTxnId);
				/*      */ }
			/*      */
			/*      */
			/*      */
			/* 2663 */ StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
			/* 2664 */ String urlToBeForwarded = "payment_status.jsp?msg=" + msg + "&reqTxnId=" + reqTxnId
					+ "&uniqueSessionIdentifier=" + getUserSessionMap().get("sessionKey");
			/* 2665 */ getUserSessionMap().put("INSTCODE", InstituteId);
			/*      */
			/* 2667 */ if (InstituteId.equalsIgnoreCase("RAMOL")) {
				/*      */
				/*      */
				/* 2670 */ this.ramaresponse = studentRegistrationService.getRamaStudentDetails(ApplicationNo);
				/* 2671 */ this.ramaresponse.setInstituteId(InstituteId);
				/* 2672 */ getUserSessionMap().put("RAMADATA", this.ramaresponse);
				/*      */ }
			/* 2674 */ else if (InstituteId.equalsIgnoreCase("IIITB")) {
				/*      */
				/*      */
				/* 2677 */ this.iiitbResponse = studentRegistrationService.getIIITBStudentDetails(ApplicationNo);
				/* 2678 */ this.iiitbResponse
						.setEmpHistoryList(studentRegistrationService.getIITBPostHistoryDetails(ApplicationNo));
				/* 2679 */ this.iiitbResponse
						.setAccomplishmentList(studentRegistrationService.getIITBAccomplishmentDetails(ApplicationNo));
				/* 2680 */ getUserSessionMap().put("IIITBDATA", this.iiitbResponse);
				/*      */
				/* 2682 */ if (this.appData.getStrpgPaymentStatus().equalsIgnoreCase("Y"))
				/*      */ {
					/* 2684 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
					/* 2685 */ emailEreceipt.EreceiptData();
					/*      */ }
				/*      */
				/* 2688 */ } else if (InstituteId.equalsIgnoreCase("WBUTEA")
						|| InstituteId.equalsIgnoreCase("WBUTEAN")) {
				/*      */
				/*      */
				/* 2691 */ WBUTUniversityFormBean wbutUniversityFormBean = new WBUTUniversityFormBean();
				/* 2692 */ wbutUniversityFormBean = studentRegistrationService.getWbutStudentDetails(ApplicationNo);
				/* 2693 */ getUserSessionMap().put("WBUTEAEXISTDATA", wbutUniversityFormBean);
				/*      */
				/*      */ }
			/* 2696 */ else if (InstituteId.equalsIgnoreCase("GPR")) {
				/*      */
				/*      */
				/* 2699 */ GpullaReadyFormBean gpullaReadyFormBean = new GpullaReadyFormBean();
				/* 2700 */ gpullaReadyFormBean = studentRegistrationService.getGpullaReddyStudentDetails(ApplicationNo);
				/* 2701 */ getUserSessionMap().put("GPULLAXISTDATA", gpullaReadyFormBean);
				/*      */
				/*      */
				/*      */ }
			/* 2705 */ else if (InstituteId.equalsIgnoreCase("YMCAMS") || InstituteId.equalsIgnoreCase("YMCAMT")) {
				/*      */
				/* 2707 */ YMCAOnlineFormBean ymcaOnlineFormBean = new YMCAOnlineFormBean();
				/* 2708 */ ymcaOnlineFormBean = studentRegistrationService.getYMCAStudentDetails(ApplicationNo);
				/* 2709 */ ymcaOnlineFormBean
						.setEduDetailsList(studentRegistrationService.getYMCAEducationDetails(ApplicationNo));
				/* 2710 */ getUserSessionMap().put("YMCADATA", ymcaOnlineFormBean);
				/*      */
				/* 2712 */ if (this.appData.getStrpgPaymentStatus().equalsIgnoreCase("Y"))
				/*      */ {
					/* 2714 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
					/* 2715 */ emailEreceipt.EreceiptData();
					/*      */ }
				/*      */
				/*      */ }
			/* 2719 */ else if (InstituteId.equalsIgnoreCase("UWSD") || InstituteId.equalsIgnoreCase("UWS")) {
				/*      */
				/* 2721 */ UnisonFormBean unisonFormBean = new UnisonFormBean();
				/* 2722 */ unisonFormBean = studentRegistrationService.getunisonStudentDetails(ApplicationNo,
						InstituteId);
				/* 2723 */ getUserSessionMap().put("UNISONDATA", unisonFormBean);
				/*      */
				/* 2725 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
				/* 2726 */ emailEreceipt.EreceiptData();
				/*      */
				/*      */ }
			/* 2729 */ else if (InstituteId.equalsIgnoreCase("NITMEGH")) {
				/*      */
				/* 2731 */ NITOnlineFormBean nitOnlineFormBean = new NITOnlineFormBean();
				/* 2732 */ nitOnlineFormBean = studentRegistrationService.getNITMeghStudentDetails(ApplicationNo);
				/* 2733 */ getUserSessionMap().put("NITMEGHDATA", nitOnlineFormBean);
				/*      */
				/*      */
				/*      */ }
			/* 2737 */ else if (InstituteId.equalsIgnoreCase("CHAMPIO") || InstituteId.equalsIgnoreCase("JRKG")) {
				/*      */
				/* 2739 */ CampionSchoolFormBean campionSchoolFormBean = new CampionSchoolFormBean();
				/* 2740 */ campionSchoolFormBean = studentRegistrationService.getCampionStudentDetails(ApplicationNo);
				/* 2741 */ getUserSessionMap().put("CAMPIONDATA", campionSchoolFormBean);
				/*      */
				/*      */ }
			/* 2744 */ else if (InstituteId.equalsIgnoreCase("CUOH")) {
				/*      */
				/* 2746 */ HaryanaFormBean haryanaFormBean = new HaryanaFormBean();
				/* 2747 */ haryanaFormBean = studentRegistrationService.getHaryanaStudentDetails(ApplicationNo);
				/* 2748 */ haryanaFormBean
						.setEduharyanaList(studentRegistrationService.getHaryanaEducationDetails(ApplicationNo));
				/*      */
				/* 2750 */ getUserSessionMap().put("CUOHDATA", haryanaFormBean);
				/*      */
				/*      */ }
			/* 2753 */ else if (InstituteId.equalsIgnoreCase("BCE") || InstituteId.equalsIgnoreCase("BCENEW") ||
			/* 2754 */ InstituteId.equalsIgnoreCase("BCET") || InstituteId.equalsIgnoreCase("BCETNEW") ||
			/* 2755 */ InstituteId.equalsIgnoreCase("BCPO") || InstituteId.equalsIgnoreCase("BCPONEW") ||
			/* 2756 */ InstituteId.equalsIgnoreCase("BCPSR") || InstituteId.equalsIgnoreCase("BCPSRNEW")) {
				/*      */
				/* 2758 */ BengalCollegeOnlineFormBean bengalCollegeOnlineFormBean = new BengalCollegeOnlineFormBean();
				/* 2759 */ bengalCollegeOnlineFormBean = studentRegistrationService.loadBengalData(ApplicationNo,
						InstituteId);
				/* 2760 */ getUserSessionMap().put("BENGALDATA", bengalCollegeOnlineFormBean);
				/*      */
				/* 2762 */ if (this.appData.getStrpgPaymentStatus().equalsIgnoreCase("Y")) {
					/*      */
					/* 2764 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
					/* 2765 */ emailEreceipt.EreceiptData();
					/*      */ }
				/* 2767 */ String smsBody = MessageFormat.format(PropertyReader.getProperty("online.mobile.sms.body"),
						(Object[]) new String[] { InstituteId, ApplicationNo });
				/* 2768 */ HttpsClientSMS httpsclientsms = new HttpsClientSMS();
				/* 2769 */ httpsclientsms.sendSMS(this.appData.getStrMobileNo(), smsBody);
				/*      */
				/*      */
				/*      */ }
			/* 2773 */ else if (InstituteId.equalsIgnoreCase("YMCBTL") || InstituteId.equalsIgnoreCase("YMCMBA") ||
			/* 2774 */ InstituteId.equalsIgnoreCase("YMCMCA") || InstituteId.equalsIgnoreCase("YMCMTL") ||
			/* 2775 */ InstituteId.equalsIgnoreCase("YMCABT")) {
				/*      */
				/* 2777 */ YMCAOnlineFormBean ymcaOnlineFormBean = new YMCAOnlineFormBean();
				/* 2778 */ ymcaOnlineFormBean = studentRegistrationService.getYMCAAllStudentDetails(ApplicationNo);
				/* 2779 */ ymcaOnlineFormBean
						.setEduDetailsList(studentRegistrationService.getYMCAEducationDetails(ApplicationNo));
				/* 2780 */ getUserSessionMap().put("YMCAALLDATA", ymcaOnlineFormBean);
				/*      */
				/* 2782 */ if (this.appData.getStrpgPaymentStatus().equalsIgnoreCase("Y"))
				/*      */ {
					/* 2784 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
					/* 2785 */ emailEreceipt.EreceiptData();
					/*      */ }
				/*      */
				/*      */ }
			/* 2789 */ else if (InstituteId.equalsIgnoreCase("BSEL")) {
				/*      */
				/* 2791 */ BSEFormBean bseFormBean = new BSEFormBean();
				/* 2792 */ bseFormBean = studentRegistrationService.getBseStudentDetails(ApplicationNo);
				/* 2793 */ getUserSessionMap().put("BSEDATA", bseFormBean);
				/*      */
				/*      */ }
			/* 2796 */ else if (InstituteId.equalsIgnoreCase("WBSDDN")) {
				/*      */
				/* 2798 */ WelhamSchoolFormBean welhamSchoolFormBean = new WelhamSchoolFormBean();
				/* 2799 */ welhamSchoolFormBean = studentRegistrationService.getWelhamSchoolDetails(ApplicationNo);
				/* 2800 */ getUserSessionMap().put("WELHAMDATA", welhamSchoolFormBean);
				/*      */
				/*      */
				/*      */ }
			/* 2804 */ else if (!InstituteId.equalsIgnoreCase("IITV")) {
				/*      */
				/*      */
				/*      */
				/*      */
				/*      */
				/*      */
				/*      */
				/* 2812 */ if (InstituteId.equalsIgnoreCase("NIPR") || InstituteId.equalsIgnoreCase("NIP")) {
					/*      */
					/* 2814 */ NIPROnlineFormBean niprOnlineFormBean = new NIPROnlineFormBean();
					/* 2815 */ niprOnlineFormBean = studentRegistrationService.getNIPRSchoolDetails(ApplicationNo);
					/* 2816 */ getUserSessionMap().put("NIPRDATA", niprOnlineFormBean);
					/*      */
					/*      */
					/*      */ }
				/* 2820 */ else if (InstituteId.equalsIgnoreCase("MGRU")) {
					/*      */
					/* 2822 */ MGRMedicalOnlineFormBean mgrMedicalOnlineFormBean = new MGRMedicalOnlineFormBean();
					/* 2823 */ mgrMedicalOnlineFormBean = studentRegistrationService
							.getMGRStudentDetails(ApplicationNo);
					/* 2824 */ mgrMedicalOnlineFormBean
							.setFeeHeadList(studentRegistrationService.getFeeHeadDetails(ApplicationNo));
					/* 2825 */ getUserSessionMap().put("MGRDATA", mgrMedicalOnlineFormBean);
					/*      */
					/* 2827 */ if (this.appData.getStrpgPaymentStatus().equalsIgnoreCase("Y"))
					/*      */ {
						/* 2829 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
						/* 2830 */ emailEreceipt.EreceiptData();
						/*      */ }
					/*      */
					/*      */ }
				/* 2834 */ else if (InstituteId.equalsIgnoreCase("AEMD") || InstituteId.equalsIgnoreCase("AEAM")
						|| InstituteId.equalsIgnoreCase("AEMM")) {
					/*      */
					/* 2836 */ CandEntryForm candEntryForm = new CandEntryForm();
					/* 2837 */ candEntryForm = studentRegistrationService.getAngloSchoolDetails(ApplicationNo);
					/* 2838 */ getUserSessionMap().put("ANGLODATA", candEntryForm);
					/*      */
					/*      */
					/* 2841 */ if (this.appData.getStrpgPaymentStatus().equalsIgnoreCase("Y"))
					/*      */ {
						/* 2843 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
						/* 2844 */ emailEreceipt.EreceiptData();
						/* 2845 */ String smsBody = MessageFormat.format(
								PropertyReader.getProperty("online.mobile.sms.body.anglo"),
								(Object[]) new String[] { InstituteId, ApplicationNo });
						/* 2846 */ HttpsClientSMS httpsclientsms = new HttpsClientSMS();
						/* 2847 */ httpsclientsms.sendSMS(this.appData.getStrMobileNo(), smsBody);
						/*      */ }
					/*      */
					/*      */ }
				/* 2851 */ else if (InstituteId.equalsIgnoreCase("UGI") || InstituteId.equalsIgnoreCase("UIMA") ||
				/* 2852 */ InstituteId.equalsIgnoreCase("UIEM") || InstituteId.equalsIgnoreCase("UIT") ||
				/* 2853 */ InstituteId.equalsIgnoreCase("UIP") || InstituteId.equalsIgnoreCase("UIMF") ||
				/* 2854 */ InstituteId.equalsIgnoreCase("UIOM") || InstituteId.equalsIgnoreCase("UCOE")) {
					/*      */
					/* 2856 */ UGIOnlineFormBean ugiOnlineFormBean = new UGIOnlineFormBean();
					/* 2857 */ ugiOnlineFormBean = studentRegistrationService.getUGIStudentDetails(ApplicationNo);
					/* 2858 */ getUserSessionMap().put("UGIDATA", ugiOnlineFormBean);
					/*      */
					/* 2860 */ if (this.appData.getStrpgPaymentStatus().equalsIgnoreCase("Y"))
					/*      */ {
						/* 2862 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
						/* 2863 */ emailEreceipt.EreceiptData();
						/* 2864 */ String smsBody = MessageFormat
								.format(PropertyReader.getProperty("online.ugi.mobile.sms.body"),
										(Object[]) new String[] { ugiOnlineFormBean.getTotalAmount(),
												this.appData.getStrPgTranid(),
												this.appData.getStrTransactionDateTime() });
						/* 2865 */ HttpsClientSMS httpsclientsms = new HttpsClientSMS();
						/* 2866 */ httpsclientsms.sendSMS(this.appData.getStrMobileNo(), smsBody);
						/*      */ }
					/*      */
					/* 2869 */ } else if (InstituteId.equalsIgnoreCase("PMHP")) {
					/*      */
					/* 2871 */ UGIOnlineFormBean ugiOnlineFormBean = new UGIOnlineFormBean();
					/* 2872 */ ugiOnlineFormBean = studentRegistrationService.getPMHPStudentDetails(ApplicationNo);
					/* 2873 */ getUserSessionMap().put("PMHPDATA", ugiOnlineFormBean);
					/*      */
					/*      */ }
				/* 2876 */ else if (InstituteId.equalsIgnoreCase("DSDOON") || InstituteId.equalsIgnoreCase("DOIN")) {
					/*      */
					/* 2878 */ DOONOnlineFormBean doonOnlineFormBean = new DOONOnlineFormBean();
					/* 2879 */ doonOnlineFormBean = studentRegistrationService.getDOONStudentDetails(ApplicationNo);
					/* 2880 */ getUserSessionMap().put("DOONDATA", doonOnlineFormBean);
					/*      */
					/*      */ }
				/* 2883 */ else if (InstituteId.equalsIgnoreCase("JRST")) {
					/*      */
					/* 2885 */ JRSTOnlineFormBean jrstOnlineFormBean = new JRSTOnlineFormBean();
					/* 2886 */ jrstOnlineFormBean = studentRegistrationService.getJRSTStudentDetails(ApplicationNo);
					/* 2887 */ getUserSessionMap().put("JRSTDATA", jrstOnlineFormBean);
					/*      */
					/*      */ }
				/* 2890 */ else if (InstituteId.equalsIgnoreCase("MIES") || InstituteId.equalsIgnoreCase("MESL") ||
				/* 2891 */ InstituteId.equalsIgnoreCase("MIMT") || InstituteId.equalsIgnoreCase("MCMT") ||
				/* 2892 */ InstituteId.equalsIgnoreCase("MIIT") || InstituteId.equalsIgnoreCase("MEPI")) {
					/* 2893 */ MGCOnlineFormBean mgcOnlineFormBean = new MGCOnlineFormBean();
					/* 2894 */ mgcOnlineFormBean = studentRegistrationService.getMGCStudentDetails(ApplicationNo);
					/* 2895 */ getUserSessionMap().put("MGCDATA", mgcOnlineFormBean);
					/*      */
					/*      */
					/*      */
					/*      */ }
				/* 2900 */ else if (InstituteId.equalsIgnoreCase("DOTU")) {
					/*      */
					/* 2902 */ DOTUOnlineFormBean dotuOnlineFormBean = new DOTUOnlineFormBean();
					/* 2903 */ dotuOnlineFormBean = studentRegistrationService.getDOTUStudentDetails(ApplicationNo);
					/* 2904 */ getUserSessionMap().put("DOTUDATA", dotuOnlineFormBean);
					/*      */
					/*      */ }
				/* 2907 */ else if (InstituteId.equalsIgnoreCase("RPTM")) {
					/*      */
					/* 2909 */ RPTMOnlineFormBean rptmOnlineFormBean = new RPTMOnlineFormBean();
					/* 2910 */ rptmOnlineFormBean = studentRegistrationService.getRPTMStudentDetails(ApplicationNo);
					/* 2911 */ getUserSessionMap().put("RPTMDATA", rptmOnlineFormBean);
					/*      */
					/*      */ }
				/* 2914 */ else if (InstituteId.equalsIgnoreCase("OMSA") || InstituteId.equalsIgnoreCase("GRTR")) {
					/*      */
					/* 2916 */ KaushalyaFormBean kaushalyaFormBean = new KaushalyaFormBean();
					/* 2917 */ kaushalyaFormBean = studentRegistrationService.getKAUSHStudentDetails(ApplicationNo);
					/* 2918 */ getUserSessionMap().put("KAUSHDATA", kaushalyaFormBean);
					/*      */
					/*      */
					/*      */ }
				/* 2922 */ else if (InstituteId.equalsIgnoreCase("RUEC") || InstituteId.equalsIgnoreCase("GDRU")
						|| InstituteId.equalsIgnoreCase("RUNG") || InstituteId.equalsIgnoreCase("PSAR")) {
					/*      */
					/* 2924 */ RungtanlineFormBean rungtanlineFormBean = new RungtanlineFormBean();
					/* 2925 */ rungtanlineFormBean = studentRegistrationService.getRUNGTAStudentDetails(ApplicationNo);
					/* 2926 */ getUserSessionMap().put("RUNGTADATA", rungtanlineFormBean);
					/*      */
					/*      */ }
				/* 2929 */ else if (InstituteId.equalsIgnoreCase("NISM")) {
					/*      */
					/* 2931 */ NISMOnlineFormBean nismOnlineFormBean = new NISMOnlineFormBean();
					/* 2932 */ nismOnlineFormBean = studentRegistrationService.getNismStudentDetails(ApplicationNo);
					/* 2933 */ nismOnlineFormBean
							.setParticipantList(studentRegistrationService.getNISMparticiptDetails(ApplicationNo));
					/*      */
					/* 2935 */ String[] data = nismOnlineFormBean.getPgName().split("~");
					/*      */
					/*      */
					/* 2938 */ nismOnlineFormBean.setListnote(studentRegistrationService.getnoteList(data[0]));
					/*      */
					/* 2940 */ getUserSessionMap().put("NISMDATA", nismOnlineFormBean);
					/*      */
					/* 2942 */ if (this.appData.getStrpgPaymentStatus().equalsIgnoreCase("Y")) {
						/*      */
						/* 2944 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
						/* 2945 */ emailEreceipt.EreceiptData();
						/* 2946 */ for (int i = 0; i <= nismOnlineFormBean.getParticipantList().size() - 1; i++) {
							/* 2947 */ NISMParticipantFormBean nismParticipantFormBean = nismOnlineFormBean
									.getParticipantList().get(i);
							/* 2948 */ String smsBody = MessageFormat.format(
									PropertyReader.getProperty("online.mobile.sms.body.nism"),
									(Object[]) new String[] { InstituteId, ApplicationNo });
							/* 2949 */ HttpsClientSMS httpsclientsms = new HttpsClientSMS();
							/* 2950 */ httpsclientsms.sendSMS(nismParticipantFormBean.getMobileNo(), smsBody);
							/*      */ }
						/*      */
						/*      */ }
					/* 2954 */ } else if (InstituteId.equalsIgnoreCase("CVIP")) {
					/*      */
					/* 2956 */ ChristineOnlineFormBean christineOnlineFormBean = new ChristineOnlineFormBean();
					/* 2957 */ christineOnlineFormBean = studentRegistrationService
							.getChristineStudentDetails(ApplicationNo);
					/* 2958 */ getUserSessionMap().put("CHRISTINEMDATA", christineOnlineFormBean);
					/*      */
					/*      */ }
				/* 2961 */ else if (InstituteId.equalsIgnoreCase("SEPL")) {
					/*      */
					/* 2963 */ SharpmindsOnlineFormBean sharpmindsOnlineFormBean = new SharpmindsOnlineFormBean();
					/* 2964 */ sharpmindsOnlineFormBean = studentRegistrationService
							.getSHARPStudentDetails(ApplicationNo);
					/* 2965 */ getUserSessionMap().put("SHARPDATA", sharpmindsOnlineFormBean);
					/*      */
					/*      */
					/*      */ }
				/* 2969 */ else if (InstituteId.equalsIgnoreCase("2632")) {
					/*      */
					/* 2971 */ EtoosOnlineFormBean etoosOnlineFormBean = new EtoosOnlineFormBean();
					/* 2972 */ etoosOnlineFormBean = studentRegistrationService.getEtoosStudentDetails(ApplicationNo);
					/* 2973 */ getUserSessionMap().put("ETOOSDATA", etoosOnlineFormBean);
					/*      */
					/*      */ }
				/* 2976 */ else if (InstituteId.equalsIgnoreCase("2659")) {
					/*      */
					/* 2978 */ MATSFeesForm matsFeesForm = new MATSFeesForm();
					/* 2979 */ matsFeesForm = studentRegistrationService.getMATSStudentDetails(ApplicationNo);
					/* 2980 */ getUserSessionMap().put("MATSDATA", matsFeesForm);
					/*      */
					/*      */ }
				/* 2983 */ else if (InstituteId.equalsIgnoreCase("2672")) {
					/*      */
					/* 2985 */ BSPROnlineFormBean bsprOnlineFormBean = new BSPROnlineFormBean();
					/* 2986 */ bsprOnlineFormBean = studentRegistrationService.getBSPRStudentDetails(ApplicationNo,
							this.appData.getStrpgPaymentStatus());
					/* 2987 */ getUserSessionMap().put("BSPRDATA", bsprOnlineFormBean);
					/*      */
					/*      */ }
				/* 2990 */ else if (InstituteId.equalsIgnoreCase("BKLI")) {
					/*      */
					/* 2992 */ BKLIOnlineFormBean bkliOnlineFormBean = new BKLIOnlineFormBean();
					/* 2993 */ bkliOnlineFormBean = studentRegistrationService.getBKLIStudentDetails(ApplicationNo,
							this.appData.getStrpgPaymentStatus());
					/* 2994 */ getUserSessionMap().put("BKLIDATA", bkliOnlineFormBean);
					/*      */
					/*      */
					/*      */
					/*      */ }
				/* 2999 */ else if (InstituteId.equalsIgnoreCase("2734")) {
					/*      */
					/* 3001 */ IIBMSFormBean iibmsOnlineFormBean = new IIBMSFormBean();
					/* 3002 */ iibmsOnlineFormBean = studentRegistrationService.getIibmdStudentDetails(ApplicationNo);
					/* 3003 */ getUserSessionMap().put("IIBMSDATA", iibmsOnlineFormBean);
					/*      */
					/*      */
					/*      */
					/*      */
					/*      */ }
				/* 3009 */ else if (InstituteId.equalsIgnoreCase("2754")) {
					/*      */
					/* 3011 */ PPAFormBean ppaFormBean = new PPAFormBean();
					/* 3012 */ ppaFormBean = studentRegistrationService.getPPAStudentDetails(ApplicationNo);
					/* 3013 */ getUserSessionMap().put("PPADATA", ppaFormBean);
					/*      */
					/*      */ }
				/* 3016 */ else if (InstituteId.equalsIgnoreCase("2831")) {
					/*      */
					/* 3018 */ JayotiFormBean jayotiFormBean = new JayotiFormBean();
					/* 3019 */ jayotiFormBean = studentRegistrationService.getJayotiStudentDetails(ApplicationNo);
					/* 3020 */ getUserSessionMap().put("JAYOTIDATA", jayotiFormBean);
					/*      */
					/*      */
					/*      */ }
				/* 3024 */ else if (InstituteId.equalsIgnoreCase("2846")) {
					/*      */
					/* 3026 */ PrincipalAIAFormBean principalOnlineFormBean = new PrincipalAIAFormBean();
					/* 3027 */ principalOnlineFormBean = studentRegistrationService
							.getPrincipalStudentDetails(ApplicationNo);
					/* 3028 */ getUserSessionMap().put("PRINCIPALDATA", principalOnlineFormBean);
					/*      */
					/*      */
					/*      */ }
				/* 3032 */ else if (InstituteId.equalsIgnoreCase("2872")) {
					/*      */
					/* 3034 */ INTLOnlineFormBean intlOnlineFormBean = new INTLOnlineFormBean();
					/* 3035 */ intlOnlineFormBean = studentRegistrationService.getINTLStudentDetails(ApplicationNo);
					/* 3036 */ intlOnlineFormBean
							.setCourseNameList(studentRegistrationService.getINTLCourseDetails(ApplicationNo));
					/* 3037 */ getUserSessionMap().put("INTLDATA", intlOnlineFormBean);
					/*      */
					/*      */
					/*      */ }
				/* 3041 */ else if (InstituteId.equalsIgnoreCase("2879")) {
					/*      */
					/* 3043 */ OrigenceOnlineFormBean origenceOnlineFormBean = new OrigenceOnlineFormBean();
					/* 3044 */ origenceOnlineFormBean = studentRegistrationService
							.getOrigenceStudentDetails(ApplicationNo);
					/* 3045 */ getUserSessionMap().put("ORIGENCEDATA", origenceOnlineFormBean);
					/*      */
					/*      */
					/*      */ }
				/* 3049 */ else if (InstituteId.equalsIgnoreCase("2925")) {
					/*      */
					/* 3051 */ NATLOnlineFormBean natlOnlineFormBean = new NATLOnlineFormBean();
					/* 3052 */ natlOnlineFormBean = studentRegistrationService.getNatlStudentDetails(ApplicationNo);
					/* 3053 */ getUserSessionMap().put("NATLDATA", natlOnlineFormBean);
					/*      */
					/*      */ }
				/* 3056 */ else if (InstituteId.equalsIgnoreCase("2931")) {
					/*      */
					/* 3058 */ LanOnlineFormBean lanOnlineFormBean = new LanOnlineFormBean();
					/* 3059 */ lanOnlineFormBean = studentRegistrationService.getLanStudentDetails(ApplicationNo);
					/* 3060 */ getUserSessionMap().put("LANDATA", lanOnlineFormBean);
					/*      */
					/*      */
					/*      */ }
				/* 3064 */ else if (InstituteId.equalsIgnoreCase("DIRE") || InstituteId.equalsIgnoreCase("DIRT")) {
					/*      */
					/* 3066 */ DTEFormBean dteFormBean = new DTEFormBean();
					/* 3067 */ dteFormBean = studentRegistrationService.getDTEStudentDetails(ApplicationNo,
							InstituteId);
					/* 3068 */ getUserSessionMap().put("DTEDATA", dteFormBean);
					/*      */
					/*      */ }
				/* 3071 */ else if (InstituteId.equalsIgnoreCase("2991") || InstituteId.equalsIgnoreCase("2990")
						|| InstituteId.equalsIgnoreCase("2989") || InstituteId.equalsIgnoreCase("2988")) {
					/*      */
					/* 3073 */ RungtaCollegeFormBean rungtaCollegeFormBean = new RungtaCollegeFormBean();
					/* 3074 */ rungtaCollegeFormBean = studentRegistrationService
							.getRungtaColStudentDetails(ApplicationNo, InstituteId);
					/* 3075 */ getUserSessionMap().put("RUNGTACOLDATA", rungtaCollegeFormBean);
					/*      */
					/*      */ }
				/* 3078 */ else if (InstituteId.equalsIgnoreCase("3038")) {
					/*      */
					/* 3080 */ this.ramaresponse = studentRegistrationService.getRamaStudentDetails(ApplicationNo);
					/* 3081 */ this.ramaresponse.setInstituteId(InstituteId);
					/*      */
					/* 3083 */ getUserSessionMap().put("RAMADATA", this.ramaresponse);
					/*      */ }
				/* 3085 */ else if (InstituteId.equalsIgnoreCase("3046")) {
					/*      */
					/* 3087 */ GPSOnlineFormBean gpsOnlineFormBean = new GPSOnlineFormBean();
					/* 3088 */ gpsOnlineFormBean = studentRegistrationService.getGPSStudentDetails(ApplicationNo);
					/* 3089 */ getUserSessionMap().put("GPSDATA", gpsOnlineFormBean);
					/*      */
					/*      */
					/*      */
					/*      */ }
				/* 3094 */ else if (InstituteId.equalsIgnoreCase("3106") || InstituteId.equalsIgnoreCase("3126")
						|| InstituteId.equalsIgnoreCase("3128")) {
					/* 3095 */ TOLANIFormBean tolaniFormBean = new TOLANIFormBean();
					/* 3096 */ tolaniFormBean = studentRegistrationService.getTOLANIStudentDetails(ApplicationNo);
					/* 3097 */ getUserSessionMap().put("TOLANIDATA", tolaniFormBean);
					/*      */
					/*      */
					/*      */ }
				/* 3101 */ else if (InstituteId.equalsIgnoreCase("3138")) {
					/* 3102 */ SHIVFormBean shivFormBean = new SHIVFormBean();
					/* 3103 */ shivFormBean = studentRegistrationService.getSHIVStudentDetails(ApplicationNo);
					/* 3104 */ getUserSessionMap().put("SHIVDATA", shivFormBean);
					/*      */
					/* 3106 */ if (this.appData.getStrpgPaymentStatus().equalsIgnoreCase("Y"))
					/*      */ {
						/* 3108 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
						/* 3109 */ emailEreceipt.EreceiptData();
						/*      */ }
					/*      */
					/*      */ }
				/* 3113 */ else if (InstituteId.equalsIgnoreCase("3145")) {
					/*      */
					/* 3115 */ HydroPowerOnlineFormBean hydroOnlineFormBean = new HydroPowerOnlineFormBean();
					/* 3116 */ hydroOnlineFormBean = studentRegistrationService
							.getHydroPowerStudentDetails(ApplicationNo);
					/* 3117 */ getUserSessionMap().put("HYDRODATA", hydroOnlineFormBean);
					/*      */ }
				/* 3119 */ else if (InstituteId.equalsIgnoreCase("3150")) {
					/*      */
					/* 3121 */ SWARAFormBean swaraFormBean = new SWARAFormBean();
					/* 3122 */ swaraFormBean = studentRegistrationService.getSWARAStudentDetails(ApplicationNo);
					/* 3123 */ getUserSessionMap().put("SWARADATA", swaraFormBean);
					/* 3124 */ } else if (InstituteId.equalsIgnoreCase("3377")
							|| InstituteId.equalsIgnoreCase("3378")) {
					/* 3125 */ LuciOnlineFormBean luciOnlineFormBean = new LuciOnlineFormBean();
					/* 3126 */ luciOnlineFormBean = studentRegistrationService.getLuciStudentDetails(ApplicationNo);
					/* 3127 */ getUserSessionMap().put("LUCIDATA", luciOnlineFormBean);
					/* 3128 */ if (InstituteId.equalsIgnoreCase("3377") &&
					/* 3129 */ this.appData.getStrpgPaymentStatus().equalsIgnoreCase("Y"))
					/*      */ {
						/* 3131 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
						/* 3132 */ emailEreceipt.EreceiptData();
						/*      */
						/* 3134 */ String encyptStr = EncryptDecryptString.encrypt(luciOnlineFormBean.getUniqueId());
						/* 3135 */ String url = String.valueOf(PropertyReader.getProperty("online.mobile.sms.url.luci"))
								+ "&amp;applicationNo=" + encyptStr;
						/*      */
						/* 3137 */ String smsBody = MessageFormat.format(
								PropertyReader.getProperty("online.mobile.sms.body.luci"), (Object[]) new String[] {
										luciOnlineFormBean.getTotAmount(), this.appData.getStrPgTranid(), url });
						/*      */
						/*      */
						/* 3140 */ HttpsClientSMS httpsclientsms = new HttpsClientSMS();
						/* 3141 */ httpsclientsms.sendSMS(this.appData.getStrMobileNo(), smsBody);
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
						/*      */ }
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
					/*      */ }
				/* 3164 */ else if (InstituteId.equalsIgnoreCase("5207")) {
					/* 3165 */ logger.info("---------------IEI Email Start--------------");
					/* 3166 */ IEIIndiaOnlineFormBean ieiIndiaOnlineFormBean = new IEIIndiaOnlineFormBean();
					/* 3167 */ ieiIndiaOnlineFormBean = studentRegistrationService
							.getIEIIndiaStudentDetails(ApplicationNo);
					/* 3168 */ getUserSessionMap().put("ONLINEFORMDATA", ieiIndiaOnlineFormBean);
					/* 3169 */ if (this.appData.getStrpgPaymentStatus().equalsIgnoreCase("Y")) {
						/*      */
						/* 3171 */ String toEmail = ieiIndiaOnlineFormBean.getEmialID();
						/* 3172 */ if (toEmail != null && !toEmail.trim().isEmpty()
								&& toEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
							/* 3173 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
							/* 3174 */ String fileName = String.valueOf(this.appData.getStrPgTranid()) + ".pdf";
							/* 3175 */ String path = emailEreceipt.generateIEIEreceipt(this.appData,
									ieiIndiaOnlineFormBean, fileName, this.instituteId, this.instituteConfigBean);
							/* 3176 */ logger.info("---------------MailAttachment Path--------------" + path);
							/* 3177 */ String subject = String
									.valueOf(((InstituteMasterFormBean) getUserSessionMap().get("INSTDATA"))
											.getStrInstituteName())
									+ " Challan copy.";
							/* 3178 */ String body = "Dear " + this.appData.getStrStudentName()
									+ ",<br/><br/>Please find the attached copy of challan generated for payment.";
							/* 3179 */ emailEreceipt.sendEmailAttachment("", toEmail, subject, body, path);
							/*      */ }
						/*      */ } else {
						/* 3182 */ logger.info("---------------Invalid or Empty EmailID--------------");
						/*      */ }
					/* 3184 */ logger.info("---------------IEI Email END--------------");
					/*      */ }
				/* 3186 */ else if (InstituteId.equalsIgnoreCase("4920")) {
					/* 3187 */ logger.info("---------------4920 Email SMS Start--------------");
					/* 3188 */ logger.info("---------------IES -----appData.getStrpgPaymentStatus()--"
							+ this.appData.getStrpgPaymentStatus());
					/* 3189 */ if (getAppData() != null && !getAppData().equals("")) {
						/* 3190 */ logger.info("---------------IES -----getAppData()--" + getAppData().toString());
						/*      */ } else {
						/*      */
						/* 3193 */ logger.info("---------------IES -----getAppData() is Blank or null------");
						/*      */ }
					/* 3195 */ if (getAppData().getStrPgTranid() != null && !getAppData().getStrPgTranid().equals("")) {
						/* 3196 */ logger.info("---------------IES -----getAppData().getStrPgTranid()--"
								+ getAppData().getStrPgTranid());
						/*      */ } else {
						/*      */
						/* 3199 */ logger
								.info("---------------IES -----getAppData().getStrPgTranid() is Blank or null------");
						/*      */ }
					/*      */ try {
						/* 3202 */ if (this.appData.getStrpgPaymentStatus().equalsIgnoreCase("Y")) {
							/* 3203 */ String emailId = getAppData().getStrEmailId();
							/* 3204 */ logger.info("---4920----emailId------" + emailId);
							/* 3205 */ if (emailId != null && !emailId.trim().isEmpty()
									&& emailId.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
								/* 3206 */ logger.info(
										"---4920----PropertyReader.getProperty(\"online.mobile.sms.body.laFoundation\")------"
												+ PropertyReader.getProperty("online.mobile.sms.body.laFoundation"));
								/* 3207 */ logger.info(
										"---4920---getAppData().getStudentFatherName(),getAppData().getStrStudentName(),getAppData().getStrStudentId(),getAppData().getStrAmount(),getAppData().getStrPgTranid()---"
												+ getAppData().getStudentFatherName() + "--"
												+ getAppData().getStrStudentName() + "--"
												+ getAppData().getStrStudentId() + "--" + getAppData().getStrAmount()
												+ "--" + getAppData().getStrPgTranid() + "--"
												+ this.appData.getStrCourseTerm() + "--" + this.appData.getStrCourse()
												+ "--" + this.appData.getStrCourseDetails());
								/* 3208 */ String smsBody = MessageFormat.format(
										PropertyReader.getProperty("online.mobile.sms.body.laFoundation"),
										(Object[]) new String[] { getAppData().getStudentFatherName(),
												getAppData().getStrStudentName(), getAppData().getStrStudentId(),
												this.appData.getStrCourse(), this.appData.getStrCourseDetails(),
												getAppData().getStrAmount(), getAppData().getStrPgTranid(),
												this.appData.getStrCourseTerm() });
								/* 3209 */ logger.info("---4920----smsBody------" + smsBody);
								/* 3210 */ HttpsClientSMS httpsclientsms = new HttpsClientSMS();
								/* 3211 */ logger.info(
										"---4920----appData.getStrMobileNo()------" + this.appData.getStrMobileNo());
								/* 3212 */ if (this.appData.getStrMobileNo().isEmpty()
										|| this.appData.getStrMobileNo().equals("")
										|| this.appData.getStrMobileNo() == null) {
									/*      */
									/* 3214 */ logger.info("--4920 Mobile is null---" + this.appData.getStrMobileNo());
									/* 3215 */ httpsclientsms.sendSMS("9702841468", smsBody);
									/*      */ } else {
									/* 3217 */ logger
											.info("--4920 Mobile is not null---" + this.appData.getStrMobileNo());
									/* 3218 */ httpsclientsms.sendSMS(this.appData.getStrMobileNo(), smsBody);
									/*      */ }
								/*      */
								/* 3221 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
								/* 3222 */ emailEreceipt.generateLaFoundationEmail(getAppData(),
										getAppData().getStrPgTranid());
								/*      */
								/*      */ }
							/*      */
							/*      */
							/*      */ }
						/*      */
						/*      */ }
					/* 3230 */ catch (Exception e) {
						/* 3231 */ logger.info("---------------Exception in 4920 Email SMS END--------------" + e);
						/* 3232 */ logger.error("Exception  " + e);
						/*      */ }
					/*      */
					/* 3235 */ logger
							.info("---------------4920  Email SMS END--------------" + paymentDetails.getTPSL_TXN_ID());
					/*      */ }
				/* 3237 */ else if (InstituteId.equalsIgnoreCase("2963") || InstituteId.equalsIgnoreCase("2962")
						|| InstituteId.equalsIgnoreCase("3056") || InstituteId.equalsIgnoreCase("2965")) {
					/*      */
					/* 3239 */ logger.info("---------------2963,2962,3056,2965 Email  Start--------------");
					/*      */
					/*      */ try {
						/* 3242 */ String emailId = getAppData().getStrEmailId();
						/* 3243 */ if (this.appData.getStrpgPaymentStatus().equalsIgnoreCase("Y")) {
							/*      */
							/*      */
							/* 3246 */ if (emailId != null && !emailId.trim().isEmpty()
									&& emailId.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
							/*      */ {
								/* 3248 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
								/*      */
								/* 3250 */ emailEreceipt.generateMMCOEEmail(getAppData(),
										getAppData().getStrPgTranid());
								/*      */ }
							/*      */
							/* 3253 */ } else if (emailId != null && !emailId.trim().isEmpty()
									&& emailId.equalsIgnoreCase("supriya.kharde@ingenico.com")) {
							/*      */
							/*      */
							/* 3256 */ if (emailId != null && !emailId.trim().isEmpty()
									&& emailId.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
							/*      */ {
								/* 3258 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
								/*      */
								/* 3260 */ emailEreceipt.generateMMCOEEmail(getAppData(),
										getAppData().getStrPgTranid());
								/*      */ }
							/*      */
							/*      */ }
						/*      */
						/* 3265 */ } catch (Exception e) {
						/* 3266 */ logger
								.info("---------------Exception in  2963,2962,3056,2965 Email SMS END--------------");
						/*      */ }
					/*      */
					/* 3269 */ logger.info("---------------2963,2962,3056,2965 IES Email SMS END--------------"
							+ paymentDetails.getTPSL_TXN_ID());
					/*      */
					/*      */ }
				/*      */ else {
					/*      */
					/* 3274 */ InstituteConfigBean instituteConfigBean = (InstituteConfigBean) getSaveObj
							.getObject(reqTxnId, "_instituteConfigBean");
					/* 3275 */ getUserSessionMap().put("_instituteConfigBean", instituteConfigBean);
					/* 3276 */ if (getUserSessionMap().get("_instituteConfigBean") != null) {
						/* 3277 */ logger.info("Getting paymentDetails object from DB for reqTxnId-->" + reqTxnId + "\t"
								+ instituteConfigBean.toString());
						/* 3278 */ instituteConfigBean = (InstituteConfigBean) getUserSessionMap()
								.get("_instituteConfigBean");
						/* 3279 */ logger.info("_instituteConfigBean from DB-->" + instituteConfigBean);
						/*      */
						/* 3281 */ getUserSessionMap().put("_institutecode", InstituteId);
						/* 3282 */ logger.info("InstituteId-->" + InstituteId);
						/*      */ }
					/*      */
					/*      */
					/* 3286 */ if ("SPRDSS".equalsIgnoreCase(InstituteId) || "GLA".equalsIgnoreCase(InstituteId) ||
					/* 3287 */ instituteConfigBean.getEnable_VasFlg().equalsIgnoreCase("Y")) {
						/* 3288 */ String statusone = studentRegistrationService.updateOnlineInstitutePaymentStatus(
								InstituteId, ApplicationNo, /* 3289 */ paymentDetails.getPayment_Id(),
								pg_payment_response.getTransactionDateTime(),
								pg_payment_response.getTPSLTransactionID(), /* 3290 */ this.appData.getStrPaymentType(),
								pg_payment_response.getTransactionErrorCode(),
								/* 3291 */ pg_payment_response.getTransactionErrorDescription(),
								pg_payment_response.getTransactionAmount());
						/*      */
						/* 3293 */ if ("DYPTL".equalsIgnoreCase(InstituteId)
								|| instituteConfigBean.getEnable_VasFlg().equalsIgnoreCase("Y")) {
							/* 3294 */ SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
							/* 3295 */ Date now = new Date();
							/* 3296 */ String strProcessDate = sdfDate.format(now);
							/* 3297 */ String strClearingDate = "";
							/* 3298 */ String status = "";
							/* 3299 */ if (((String) statusMap.get("txn_status")).equalsIgnoreCase("0300")) {
								/* 3300 */ strClearingDate = strProcessDate;
								/* 3301 */ status = "S";
								/* 3302 */ logger
										.info("pg_payment_response.getTransactionErrorCode() for success 0300-->"
												+ pg_payment_response.getTransactionErrorCode());
								/*      */
								/*      */ }
							/* 3305 */ else if (((String) statusMap.get("txn_status")).equalsIgnoreCase("0398")) {
								/* 3306 */ strClearingDate = "";
								/* 3307 */ status = "I";
								/* 3308 */ logger
										.info("pg_payment_response.getTransactionErrorCode() for Initiated 0398-->"
												+ pg_payment_response.getTransactionErrorCode());
								/*      */ }
							/*      */ else {
								/*      */
								/* 3312 */ strClearingDate = "";
								/* 3313 */ status = "F";
								/* 3314 */ logger
										.info("pg_payment_response.getTransactionErrorCode() for failure 0399-->"
												+ pg_payment_response.getTransactionErrorCode());
								/*      */ }
							/*      */
							/*      */
							/*      */
							/* 3319 */ URLInstituteRequestBean gLAUniversityStudentFormBean = (URLInstituteRequestBean) getSaveObj
									.getObject(reqTxnId, "glaUniversityStudentFormBean");
							/* 3320 */ getUserSessionMap().put("glaUniversityStudentFormBean",
									gLAUniversityStudentFormBean);
							/* 3321 */ if (gLAUniversityStudentFormBean != null) {
								/* 3322 */ logger
										.info("Getting VAS gLAUniversityStudentFormBean object from DB for reqTxnId-->"
												+ reqTxnId + "\t" + gLAUniversityStudentFormBean.toString());
								/*      */ }
							/*      */
							/*      */
							/*      */
							/* 3327 */ this.responseurlgla = (new InstituteURLAction()).createResponseMessage(
									(URLInstituteRequestBean) getUserSessionMap().get("glaUniversityStudentFormBean"),
									status, pg_payment_response.getTransactionErrorCode(),
									pg_payment_response.getTransactionErrorDescription(),
									pg_payment_response.getTPSLTransactionID(),
									pg_payment_response.getTransactedBankCode(), strProcessDate, strClearingDate);
							/* 3328 */ this.responseurlgla = String.valueOf(statusone) + "?" + this.responseurlgla;
							/* 3329 */ urlToBeForwarded = "responsetogla.jsp?responseurlgla=" + this.responseurlgla;
							/*      */ }
						/*      */
						/*      */ }
					/* 3333 */ else if ((InstituteAliasCodeConfigBean) getUserSessionMap()
							.get("_instituteAliasCodeConfigBean") != null) {
						/*      */
						/* 3335 */ String beanClass = ((InstituteAliasCodeConfigBean) getUserSessionMap()
								.get("_instituteAliasCodeConfigBean")).getFormBean();
						/* 3336 */ logger.info("Bean Class--->>" + beanClass);
						/* 3337 */ String methodName = ((InstituteAliasCodeConfigBean) getUserSessionMap()
								.get("_instituteAliasCodeConfigBean")).getQuickPayGetDetailsMethod();
						/* 3338 */ logger.info("Method Name--->>" + methodName);
						/*      */
						/* 3340 */ Class<?> obj = Class.forName(beanClass);
						/* 3341 */ Class<?> serviceObj = Class
								.forName("com.app.feejunction.service.StudentRegistrationService");
						/*      */
						/* 3343 */ OnlineFormBean bean = (OnlineFormBean) obj.newInstance();
						/*      */
						/* 3345 */ Class[] paramTypes = null;
///* 3346 */             Method[] meth = serviceObj.getDeclaredMethods(); byte b=0; int i; Method[] arrayOfMethod1;
///* 3347 */             for (i = (arrayOfMethod1 = meth).length; b < i; b++) { Method m = arrayOfMethod1[b];
///* 3348 */               if (methodName.equalsIgnoreCase(m.getName())) {
///* 3349 */                 paramTypes = m.getParameterTypes();
///*      */               }
///*      */                }
						Method[] meth = serviceObj.getDeclaredMethods();
						for (Method m : meth) {
							if (methodName.equalsIgnoreCase(m.getName())) {
								paramTypes = m.getParameterTypes();
							}
						}

						/*      */
						/* 3353 */ Method method = serviceObj.getMethod(methodName, paramTypes);
						/* 3354 */ bean = (OnlineFormBean) method.invoke(studentRegistrationService, params);
						/* 3355 */ if (InstituteId.equalsIgnoreCase("4816")) {
							/* 3356 */ logger
									.info("--------------Horizon Fee START------" + this.horizonOnlineFormBean);
							/* 3357 */ this.horizonOnlineFormBean = (HorizonOnlineFormBean) method
									.invoke(studentRegistrationService, params);
							/* 3358 */ if (this.horizonOnlineFormBean.getExamFee() != null) {
								/*      */
								/* 3360 */ logger.info("--------------Inside Horizon Fee Type ------");
								/* 3361 */ boolean check = false;
								/* 3362 */ String[] examOption = { "Semester End Exam", "Photocopy fee",
										"Revaluation fee", "Makeup Exam fee" };
								/* 3363 */ String[] examFeeArry = this.horizonOnlineFormBean.getExamFee().split(",");
								/* 3364 */ ArrayList<String> examlist = new ArrayList<>(Arrays.asList(examOption));
								byte b1;
								int j;
								String[] arrayOfString1;
								/* 3365 */ for (j = (arrayOfString1 = examFeeArry).length, b1 = 0; b1 < j;) {
									String checkexam = arrayOfString1[b1];
									/* 3366 */ if (examlist.contains(checkexam)) {
										/*      */
										/* 3368 */ check = true;
										/* 3369 */ this.horizonOnlineFormBean.setStatusCheck("Yes");
										/* 3370 */ logger.info("--------------Horizon Fee Type Found------");
										/*      */ } else {
										/* 3372 */ check = false;
										/* 3373 */ this.horizonOnlineFormBean.setStatusCheck("No");
										/* 3374 */ logger.info("--------------Horizon Fee Type Not Found------");
										/*      */ }
									/* 3376 */ if (check)
										/*      */ break;
									b1++;
								}
								/*      */
								/* 3379 */ if (check) {
									/*      */
									/*      */
									/*      */
									/*      */
									/* 3384 */ this.horizonOnlineFormBean
											.setTransactionDate(this.appData.getStrTransactionDateTime());
									/* 3385 */ this.horizonOnlineFormBean
											.setTransactionId(this.appData.getStrPgTranid());
									/* 3386 */ this.horizonOnlineFormBean.setPaymentAmount(this.appData.getStrAmount());
									/* 3387 */ getUserSessionMap().put("HorizonFormBean", this.horizonOnlineFormBean);
									/* 3388 */ logger.info("horizonOnlineFormBean-->" + this.horizonOnlineFormBean);
									/* 3389 */ logger.info("--------------Horizon Fee END------");
									/*      */ }
								/*      */ }
							/* 3392 */ getUserSessionMap().put("_instituteAliasCodeConfigBean",
									getUserSessionMap().get("_instituteAliasCodeConfigBean"));
							/*      */ }
						/* 3394 */ getUserSessionMap().put("ONLINEFORMDATA", bean);
						/* 3395 */ logger.info("bean-->" + bean);
						/* 3396 */ if ("Y".equalsIgnoreCase(((InstituteAliasCodeConfigBean) getUserSessionMap()
								.get("_instituteAliasCodeConfigBean")).getEmailReceiptFlg())) {
							/* 3397 */ EmailEreceipt emailEreceipt = new EmailEreceipt();
							/* 3398 */ emailEreceipt.EreceiptData();
							/*      */ }
						/*      */ }
					/*      */ }
				/*      */ }
			/* 3403 */ getUserSessionMap().put("reqTxnId", reqTxnId);
			/* 3404 */ rd = request.getRequestDispatcher(urlToBeForwarded);
			/* 3405 */ rd.forward((ServletRequest) request, (ServletResponse) response);
			/*      */
			/* 3407 */ return STATUS;
			/*      */
			/*      */
			/*      */ }
		/* 3411 */ catch (Exception ex) {
			/* 3412 */ logger.error("Exception  " + ex);
			/* 3413 */ ex.printStackTrace();
			/* 3414 */ logger.info("Exception in PaymentResponse Servlet-------->" + ex);
			/*      */ } finally {
			/* 3416 */ out.close();
			/*      */ }
		/* 3418 */ return null;
		/*      */ }

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
	/*      */ public String loadBack() {
		/* 3472 */ setAppData((PaymentRequestBean) getUserSessionMap().get("APPDATA"));
		/*      */
		/* 3474 */ if (!isValidSession()) {
			/* 3475 */ addActionError("Your session has been invalidated. Please login again.");
			/* 3476 */ return "error";
			/*      */ }
		/* 3478 */ this.studentData = null;
		/* 3479 */ String registeredUserId = ((FJBean) getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
		/* 3480 */ LoginActionService loginActionService = new LoginActionService();
		/* 3481 */ setStudentData(loginActionService.getRegisteredStudentList(registeredUserId));
		/* 3482 */ logger.info(getAppData().getStudentRegistrationId());
		/*      */
		/*      */
		/* 3485 */ return BACK;
		/*      */ }

	/*      */
	/*      */ public String directQuickPaycourse() {
		/* 3489 */ return "success";
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public PaymentRequestBean getAppData() {
		/* 3497 */ return this.appData;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public void setAppData(PaymentRequestBean appData) {
		/* 3504 */ this.appData = appData;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public CourseDetailsBean getCourseData() {
		/* 3511 */ return this.courseData;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public void setCourseData(CourseDetailsBean courseData) {
		/* 3518 */ this.courseData = courseData;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public String getStrPaymentType() {
		/* 3525 */ return this.strPaymentType;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public void setStrPaymentType(String strPaymentType) {
		/* 3532 */ this.strPaymentType = strPaymentType;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public String getStrPaymentMode() {
		/* 3539 */ return this.strPaymentMode;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public void setStrPaymentMode(String strPaymentMode) {
		/* 3546 */ this.strPaymentMode = strPaymentMode;
		/*      */ }

	/*      */
	/*      */ public String getStrChallanPath() {
		/* 3550 */ return this.strChallanPath;
		/*      */ }

	/*      */
	/*      */ public void setStrChallanPath(String strChallanPath) {
		/* 3554 */ this.strChallanPath = strChallanPath;
		/*      */ }

	/*      */
	/*      */ public InputStream getFileInputStream() {
		/* 3558 */ return this.fileInputStream;
		/*      */ }

	/*      */
	/*      */ public Map getStudentData() {
		/* 3562 */ return this.studentData;
		/*      */ }

	/*      */
	/*      */ public void setStudentData(Map studentData) {
		/* 3566 */ this.studentData = studentData;
		/*      */ }

	/*      */
	/*      */ public String getStudentRegistrationId() {
		/* 3570 */ return this.studentRegistrationId;
		/*      */ }

	/*      */
	/*      */ public void setStudentRegistrationId(String studentRegistrationId) {
		/* 3574 */ this.studentRegistrationId = studentRegistrationId;
		/*      */ }

	/*      */
	/*      */ public List<String> getFeesPayList() {
		/* 3578 */ return this.feesPayList;
		/*      */ }

	/*      */
	/*      */ public void setFeesPayList(List<String> feesPayList) {
		/* 3582 */ this.feesPayList = feesPayList;
		/*      */ }

	/*      */
	/*      */ public String getRedirectionURL() {
		/* 3586 */ return this.redirectionURL;
		/*      */ }

	/*      */
	/*      */ public void setRedirectionURL(String redirectionURL) {
		/* 3590 */ this.redirectionURL = redirectionURL;
		/*      */ }

	/*      */
	/*      */ public String getUniqueIdentificationId() {
		/* 3594 */ return this.uniqueIdentificationId;
		/*      */ }

	/*      */
	/*      */ public void setUniqueIdentificationId(String uniqueIdentificationId) {
		/* 3598 */ this.uniqueIdentificationId = uniqueIdentificationId;
		/*      */ }

	/*      */ public AddChallanChargesBean getAddChallanChargesBean() {
		/* 3601 */ return this.addChallanChargesBean;
		/*      */ }

	/*      */ public void setAddChallanChargesBean(AddChallanChargesBean addChallanChargesBean) {
		/* 3604 */ this.addChallanChargesBean = addChallanChargesBean;
		/*      */ }

	/*      */
	/*      */ public String getStudentName() {
		/* 3608 */ return this.StudentName;
		/*      */ }

	/*      */ public void setStudentName(String studentName) {
		/* 3611 */ this.StudentName = studentName;
		/*      */ }

	/*      */ public String getEmailID() {
		/* 3614 */ return this.EmailID;
		/*      */ }

	/*      */ public void setEmailID(String emailID) {
		/* 3617 */ this.EmailID = emailID;
		/*      */ }

	/*      */ public String getMobileNo() {
		/* 3620 */ return this.MobileNo;
		/*      */ }

	/*      */ public void setMobileNo(String mobileNo) {
		/* 3623 */ this.MobileNo = mobileNo;
		/*      */ }

	/*      */ public String getTotalFeesAmount() {
		/* 3626 */ return this.TotalFeesAmount;
		/*      */ }

	/*      */ public void setTotalFeesAmount(String totalFeesAmount) {
		/* 3629 */ this.TotalFeesAmount = totalFeesAmount;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public String getPayableFeeIndexes() {
		/* 3636 */ this.payableFeeIndexes = "";
		/* 3637 */ if (!Utility.isListEmpty(this.feesPayList)) {
			/* 3638 */ logger.info("feesPayList.toString()-----------------------:" + this.feesPayList.toString());
			/* 3639 */ this.payableFeeIndexes = this.feesPayList.toString().substring(1,
					this.feesPayList.toString().length() - 1);
			/*      */ }
		/* 3641 */ logger.info("payableFeeIndexes-----------------------:" + this.payableFeeIndexes);
		/*      */
		/* 3643 */ return this.payableFeeIndexes;
		/*      */ }

	/*      */
	/*      */
	/*      */
	/*      */
	/*      */ public void setPayableFeeIndexes(String payableFeeIndexes) {
		/* 3650 */ this.payableFeeIndexes = payableFeeIndexes;
		/*      */ }

	/*      */
	/*      */ public String confirmSKVTest() {
		/* 3654 */ HttpServletRequest request = ServletActionContext.getRequest();
		/* 3655 */ logger.info("Inside QuickPayAction --> confirm()" + request);
		/*      */
		/* 3657 */ if (!isValidSession()) {
			/* 3658 */ addActionError("Your session has been invalidated. Please login again.");
			/* 3659 */ return "error";
			/*      */ }
		/*      */
		/*      */
		/* 3663 */ String applicationID = (String) getUserSessionMap().get("UniqueIdentificationId");
		/*      */
		/*      */
		/*      */
		/*      */
		/* 3668 */ this.appdata1 = new StudentRegistrationFormBean();
		/* 3669 */ String registeredUserId = ((FJBean) getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
		/* 3670 */ this.appdata1.setStudentName(getStudentName());
		/* 3671 */ this.appdata1.setRemarks(getRemark());
		/* 3672 */ this.appdata1.setTotalFees(getTotalFeesAmount());
		/* 3673 */ this.appdata1.setRegistrationId(registeredUserId);
		/*      */
		/* 3675 */ PaymentService paymentService1 = new PaymentService();
		/* 3676 */ String responseString = paymentService1.insertSKVPaymentPopup(applicationID, getAppdata1());
		/* 3677 */ if (responseString != null && !"".equalsIgnoreCase(responseString)
				&& "success".equalsIgnoreCase(responseString)) {
			/*      */
			/* 3679 */ StudentRegistrationFormBean studentRegistrationFormBean = getRegisteredStudentDetails(
					getAppdata1().getStudentRegistrationId());
			/* 3680 */ studentRegistrationFormBean.setTotalPayableFees(getAppdata1().getTotalFees());
			/* 3681 */ studentRegistrationFormBean.setStudentId(applicationID);
			/*      */
			/* 3683 */ applyFees(studentRegistrationFormBean);
			/* 3684 */ this.appData = new PaymentRequestBean();
			/* 3685 */ this.appData.setStudentRegistrationId(getAppdata1().getStudentRegistrationId());
			/*      */
			/* 3687 */ setAppDataFromStudentBean(this.appData, studentRegistrationFormBean, this.feesPayList);
			/*      */
			/* 3689 */ PaymentService paymentService = new PaymentService();
			/* 3690 */ int paymentId = paymentService.insertPrePaymentDetails(this.appData);
			/*      */
			/*      */
			/* 3693 */ List<StudentFeesFormBean> studentFeesList = getAppData().getStudentFeesList();
			/* 3694 */ if (!Utility.isListEmpty(studentFeesList)) {
				/* 3695 */ for (int count = 0; count < studentFeesList.size(); count++) {
					/* 3696 */ StudentFeesFormBean studentFeesFormBean = studentFeesList.get(count);
					/* 3697 */ paymentService.insertPrePaymentFeesDetails(paymentId, studentFeesFormBean);
					/*      */ }
				/*      */ } else {
				/* 3700 */ logger.info("studentFeesList() is Empty, so not inserting data in PrePaymentFeesDetails");
				/*      */ }
			/* 3702 */ if (this.strPaymentType != null && "Challan".equalsIgnoreCase(this.strPaymentType)) {
				/* 3703 */ logger.info("User has selected challan as payment Mode");
				/* 3704 */ logger.info("Payment Mode = " + this.strPaymentMode);
				/* 3705 */ String fileName = String.valueOf(this.strPaymentMode) + "Challan_"
						+ this.appData.getStrBillerId() + "_" + this.appData.getStrStudentId() + "-"
						+ Utility.getCurrentDateTimeAsString() + ".pdf";
				/*      */
				/* 3707 */ ChallanServiceUtil challanServiceUtil = new ChallanServiceUtil();
				/* 3708 */ String filePath = null;
				/* 3709 */ logger.info("Biller ID Before Challan:" + this.appData.getStrBillerId());
				/* 3710 */ logger.info("Registration ID Before Challan:" + this.appData.getRegistrationId());
				/* 3711 */ logger.info("Payment ID Before Challan:" + this.appData.getPaymentID());
				/* 3712 */ logger.info("Pre Payment ID Before Challan:" + this.appData.getPrePaymentID());
				/*      */
				/*      */
				/* 3715 */ int insertCnt = 0;
				/* 3716 */ String strDueDate = "2011-04-01 00:00:00.000";
				/* 3717 */ String paymentID = (new Integer(paymentId)).toString();
				/* 3718 */ String InstituteCode1 = paymentService
						.getInstituteCode(((FJBean) getUserSessionMap().get("BASEDATA")).getBillerId());
				/*      */
				/* 3720 */ PaymentDetails paymentDetails = new PaymentDetails();
				/* 3721 */ paymentDetails.setStrBankCode("NA");
				/* 3722 */ paymentDetails.setStrPGAccNo("1");
				/* 3723 */ this.addChallanChargesBean = (AddChallanChargesBean) getUserSessionMap()
						.get("addChallanChargesBean");
				/*      */
				/* 3725 */ if (this.appData.getStrPaymentType().equalsIgnoreCase("Challan")) {
					/* 3726 */ paymentDetails.setStrTxnAmt(Double.parseDouble(this.appData.getStrAmount())
							+ this.addChallanChargesBean.getChallanCharges());
					/* 3727 */ double finalAmt = Double.parseDouble(this.appData.getStrAmount())
							+ this.addChallanChargesBean.getChallanCharges();
					/* 3728 */ this.appData.setStrAmount(Double.toString(finalAmt));
					/*      */ } else {
					/* 3730 */ paymentDetails.setStrTxnAmt(Double.parseDouble(this.appData.getStrAmount()));
					/*      */ }
				/* 3732 */ paymentDetails.setStrPayeeId(this.appData.getStrBillerId());
				/* 3733 */ paymentDetails.setStrUserId(
						String.valueOf(this.appData.getStrMerchantId()) + this.appData.getStrCustomerId());
				/* 3734 */ paymentDetails.setStrConsumerCd(this.appData.getStrConsumerId());
				/* 3735 */ paymentDetails.setStrCustName(this.appData.getStrStudentName());
				/* 3736 */ paymentDetails.setStrDueDate(strDueDate);
				/* 3737 */ paymentDetails.setStrBankName(this.appData.getStrBankName());
				/* 3738 */ paymentDetails.setStrPaymentMode(this.appData.getStrPaymentMode());
				/* 3739 */ paymentDetails.setStrPrepaymentID(paymentID);
				/* 3740 */ paymentDetails.setStrLoginId(this.appData.getStrLoginId());
				/*      */
				/* 3742 */ paymentDetails.setInstituteCode(InstituteCode1);
				/*      */
				/* 3744 */ insertCnt = paymentService.insertPaymentDetails(paymentDetails);
				/* 3745 */ logger.info("insertCnt---->" + insertCnt);
				/*      */
				/*      */
				/* 3748 */ this.appData.setPrePaymentID(paymentDetails.getStrPrepaymentID());
				/* 3749 */ this.appData.setPaymentID(paymentDetails.getStrPaymentId());
				/* 3750 */ logger.info("prePaymentId : - " + this.appData.getPrePaymentID());
				/* 3751 */ logger.info("paymentId : - " + this.appData.getPaymentID());
				/* 3752 */ Map<String, Object> userSessionMap = getUserSessionMap();
				/* 3753 */ if (this.strPaymentMode != null && this.strPaymentMode.equalsIgnoreCase("Cash")) {
					/* 3754 */ logger.info("In Challan Cash ");
					/* 3755 */ filePath = challanServiceUtil.generateCashChallan(userSessionMap, this.appData,
							fileName);
					/* 3756 */ } else if (this.strPaymentMode != null
							&& this.strPaymentMode.equalsIgnoreCase("Cheque")) {
					/*      */
					/* 3758 */ logger.info("In Challan Cheque ");
					/* 3759 */ filePath = challanServiceUtil.generateChequeChallan(userSessionMap, this.appData,
							fileName, this.appData.getStrBillerId(), this.appData.getRegistrationId());
					/*      */ }
				/* 3761 */ else if (this.strPaymentMode != null
						&& this.strPaymentMode.equalsIgnoreCase("Demand_Draft")) {
					/* 3762 */ logger.info("In Challan Cash ");
					/* 3763 */ filePath = challanServiceUtil.generateDDChallan(userSessionMap, this.appData, fileName,
							this.appData.getStrBillerId(), this.appData.getRegistrationId());
					/*      */ }
				/* 3765 */ else if (this.strPaymentMode != null && this.strPaymentMode.equalsIgnoreCase("NEFT_RTGS")) {
					/* 3766 */ logger.info("In Challan NEFT/RTGS ");
					/* 3767 */ filePath = challanServiceUtil.generateNEFTRTGSChallan(userSessionMap, this.appData,
							fileName);
					/*      */ }
				/*      */
				/*      */
				/* 3771 */ logger.info("Full File Path : - " + filePath);
				/* 3772 */ String strFilePath = filePath;
				/* 3773 */ String strFileName = fileName;
				/* 3774 */ if (insertCnt > 0) {
					/* 3775 */ logger.info("data successfully inserted in SJ_BillPayments");
					/* 3776 */ logger.info("loginActionFormBean.getStrLoginId() : - " + this.appData.getStrLoginId());
					/* 3777 */ logger.info("strFileName : - " + strFileName);
					/* 3778 */ logger.info("strFilePath : - " + strFilePath);
					/* 3779 */ logger.info("CHALLAN : - CHALLAN");
					/* 3780 */ logger.info("REMARKS : - REMARKS");
					/*      */
					/* 3782 */ logger
							.info("paymentDetails.getStrPrepaymentID() : - " + paymentDetails.getStrPrepaymentID());
					/* 3783 */ logger.info("paymentDetails.getStrPaymentId() : - " + paymentDetails.getStrPaymentId());
					/*      */
					/*      */
					/* 3786 */ FJBean fjBean = (FJBean) getUserSessionMap().get("BASEDATA");
					/* 3787 */ ChallanHistoryService challanHistoryService = new ChallanHistoryService();
					/* 3788 */ ChallanHistoryFormBean challanHistoryFormBean = new ChallanHistoryFormBean();
					/* 3789 */ challanHistoryFormBean.setStrBillerId(this.appData.getStrBillerId());
					/* 3790 */ challanHistoryFormBean.setStrRegistrationId(fjBean.getRegisteredUserId());
					/* 3791 */ challanHistoryFormBean.setStrLoginID(this.appData.getStrLoginId());
					/*      */
					/*      */
					/* 3794 */ challanHistoryFormBean.setStrChallanName(strFileName);
					/* 3795 */ challanHistoryFormBean.setStrChallanPath(strFilePath);
					/* 3796 */ challanHistoryFormBean.setStrChallanType("CHALLAN");
					/* 3797 */ challanHistoryFormBean.setStrRemarks("REMARK");
					/* 3798 */ challanHistoryFormBean.setStrPrePaymentId(paymentDetails.getStrPrepaymentID());
					/* 3799 */ challanHistoryFormBean.setStrPaymentId(paymentDetails.getStrPaymentId());
					/*      */
					/* 3801 */ String returnString = challanHistoryService.insertChallanDetails(challanHistoryFormBean);
					/*      */
					/* 3803 */ logger.info("Before Going Forward");
					/*      */ try {
						/* 3805 */ this.strChallanPath = strFileName;
						/* 3806 */ File f = new File(strFilePath);
						/* 3807 */ long fileLength = f.length();
						/*      */
						/* 3809 */ this.fileInputStream = new FileInputStream(f);
						/*      */
						/*      */ }
					/* 3812 */ catch (FileNotFoundException ex) {
						/*      */
						/* 3814 */ logger.info("EXCEPTION :  " + ex.getMessage());
						/* 3815 */ logger.error("Exception  " + ex);
						/*      */ }
					/* 3817 */ return DOWNLOAD;
					/*      */ }
				/*      */ }
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
			/* 3836 */ getUserSessionMap().put("APPDATA", this.appData);
			/* 3837 */ this.strPaymentType = "Online Payment";
			/* 3838 */ if (this.strPaymentType != null && this.strPaymentType.equalsIgnoreCase("Online Payment")) {
				/*      */
				/* 3840 */ this.appData.setStrPaymentMode(this.strPaymentMode);
				/* 3841 */ this.redirectionURL = pgPaymentRequest(paymentId);
				/* 3842 */ return "redirectToPG";
				/*      */ }
			/*      */ } else {
			/* 3845 */ addActionError(getText("error.occured.contact.administrator"));
			/*      */ }
		/*      */
		/*      */
		/* 3849 */ return CONFIRMSKVTEST;
		/*      */ }
	/*      */ }

/*
 * Location:
 * C:\SmartFees.war\SmartFees.war\WEB-INF\classes\!\com\app\feejunction\action\
 * QuickPayAction.class Java compiler version: 11 (55.0) JD-Core Version: 1.1.3
 */