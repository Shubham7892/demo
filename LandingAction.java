/*     */ package com.app.feejunction.action;
/*     */ 
/*     */ import com.app.feejunction.bean.FJBean;
/*     */ import com.app.feejunction.bean.FeesPayChargesFormBean;
/*     */ import com.app.feejunction.bean.InstituteAliasCodeConfigBean;
/*     */ import com.app.feejunction.bean.InstituteConfigBean;
/*     */ import com.app.feejunction.bean.LoginActionFormBean;
/*     */ import com.app.feejunction.service.InstituteMasterActionService;
/*     */ import com.app.feejunction.service.LoginActionService;
/*     */ import com.app.feejunction.service.PaymentService;
/*     */ import com.tpsl.util.ApplicationUtils;
/*     */ import com.tpsl.util.PropertyReader;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.struts2.ServletActionContext;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LandingAction
/*     */   extends FJAction
/*     */ {
/*  34 */   private static final Logger logger = LoggerFactory.getLogger(LandingAction.class);
/*  35 */   private static final Logger audit = LoggerFactory.getLogger("audit");
/*     */   
/*     */   private String instId;
/*     */   
/*     */   private String applicationNo;
/*  40 */   InstituteMasterActionService instituteMasterActionService = new InstituteMasterActionService();
/*  41 */   FeesPayChargesFormBean feesPayChargesFormBean = new FeesPayChargesFormBean();
/*     */   
/*     */   private Map studentData;
/*     */   private LoginActionFormBean appData;
/*     */   
/*     */   public String execute() throws Exception {
/*  47 */     return setInstituteData();
/*     */   }
/*     */   
/*     */   public String setInstituteData() {
/*  51 */     long startTime = System.currentTimeMillis();
/*  52 */     logger.info("**<Smartfess> setInstituteData()-START**");
/*     */ 
/*     */     
/*  55 */     createUserSessionMap();
/*  56 */     FJBean fJBean = new FJBean();
/*     */ 
/*     */     
/*  59 */     String instituteId = this.instituteMasterActionService.getInstituteId(getInstId());
/*  60 */     fJBean.setBillerId(instituteId);
/*  61 */     if (getInstId().equalsIgnoreCase("3378")) {
/*  62 */       getUserSessionMap().put("_applicationNo", getApplicationNo().replaceAll(" ", "+"));
/*     */     }
/*     */     
/*  65 */     String contextName = ServletActionContext.getServletContext().getContextPath().replace("/", "");
/*  66 */     logger.info("contextName......" + contextName);
/*  67 */     String bankWiseRedirect = "";
/*  68 */     if (contextName.equalsIgnoreCase(PropertyReader.getProperty("HDFCProjectName"))) {
/*     */       
/*  70 */       bankWiseRedirect = "HDFC";
/*     */     } else {
/*  72 */       bankWiseRedirect = "ICICI";
/*     */     } 
/*  74 */     getUserSessionMap().put("_bankWiseRedirect", bankWiseRedirect);
/*  75 */     setFJBeanDetails(fJBean, fJBean.getBillerId());
/*     */     
/*  77 */     logger.info("instId:\t" + this.instId);
/*     */     
/*  79 */     InstituteAliasCodeConfigBean instituteAliasCodeConfigBean = new InstituteAliasCodeConfigBean();
/*  80 */     instituteAliasCodeConfigBean = this.instituteMasterActionService.getInstituteAliasCodeConfig(this.instId);
/*  81 */     InstituteConfigBean instituteConfigBean = (InstituteConfigBean)getUserSessionMap().get("INSTCONFIG");
/*     */     
/*  83 */     getUserSessionMap().put("_instituteConfigBean", instituteConfigBean);
/*  84 */     getUserSessionMap().put("_instituteAliasCodeConfigBean", instituteAliasCodeConfigBean);
/*  85 */     getUserSessionMap().put("_institutecode", this.instId);
/*  86 */     if (instituteConfigBean.getExtraCharges().equals("Y")) {
/*  87 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(instituteId);
/*  88 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*     */     } 
/*  90 */     HttpServletResponse response = ServletActionContext.getResponse();
/*  91 */     response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
/*  92 */     response.setHeader("Pragma", "no-cache");
/*  93 */     response.setDateHeader("Expires", -1L);
/*  94 */     HttpServletRequest request = ServletActionContext.getRequest();
/*  95 */     String sessionid = request.getSession().getId();
/*  96 */     response.setHeader("SET-COOKIE", "JSESSIONID=" + sessionid + "; HttpOnly;");
/*     */     
/*  98 */     if (StringUtils.isBlank(instituteConfigBean.getRegistrationId())) {
/*  99 */       getUserSessionMap().put("_logoutButtonOff", "N");
/* 100 */       long l = System.currentTimeMillis();
/* 101 */       logger.info("**SmartFees- setInstituteData - EXECUTION TIME **" + (l - startTime) + "---END");
/* 102 */       return "success";
/*     */     } 
/* 104 */     if (setDefaultDataInSession(instituteConfigBean.getRegistrationId())) {
/* 105 */       long l = System.currentTimeMillis();
/* 106 */       logger.info("**SmartFees- setInstituteData - EXECUTION TIME **" + (l - startTime) + "---END");
/* 107 */       return FJAction.DIRECT_QUICK_PAY_HOME;
/*     */     } 
/* 109 */     long endTime = System.currentTimeMillis();
/* 110 */     logger.info("**SmartFees- setInstituteData - EXECUTION TIME **" + (endTime - startTime) + "---END");
/* 111 */     return "error";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setDefaultDataInSession(String defaultGuestUserID) {
/* 118 */     long startTime = System.currentTimeMillis();
/* 119 */     logger.info("**<Smartfess> setDefaultDataInSession(" + defaultGuestUserID + ")-START**");
/*     */     
/* 121 */     FJBean fjBean = (FJBean)getUserSessionMap().get("BASEDATA");
/* 122 */     LoginActionService loginActionService = new LoginActionService();
/* 123 */     LoginActionFormBean loginActionFormBean = loginActionService.getDefaultGuestUserDetails(defaultGuestUserID, fjBean.getBillerId());
/* 124 */     if (loginActionFormBean != null && loginActionFormBean.getStrID() != null) {
/* 125 */       fjBean.setLoginID(loginActionFormBean.getStrLoginId());
/* 126 */       fjBean.setRegisteredUserId(loginActionFormBean.getStrID());
/* 127 */       setUniqueSessionIdentifier(ApplicationUtils.getUniqueSessionIdentifier());
/* 128 */       getUserSessionMap().put("BASEDATA", fjBean);
/*     */       
/* 130 */       getUserSessionMap().put(loginActionFormBean.getStrID(), getTranscationDetails(fjBean.getBillerId(), loginActionFormBean.getStrID()));
/* 131 */       getUserSessionMap().put("sessionKey", getUniqueSessionIdentifier());
/* 132 */       long l = System.currentTimeMillis();
/* 133 */       logger.info("**SmartFees- setDefaultDataInSession - EXECUTION TIME **" + (l - startTime));
/* 134 */       logger.info("SmartFees - setDefaultDataInSession(" + defaultGuestUserID + ") - END");
/* 135 */       return true;
/*     */     } 
/*     */     
/* 138 */     long endTime = System.currentTimeMillis();
/* 139 */     logger.info("**SmartFees- setDefaultDataInSession - EXECUTION TIME **" + (endTime - startTime));
/* 140 */     logger.info("SmartFees - setDefaultDataInSession(" + defaultGuestUserID + ") - END");
/* 141 */     return false;
/*     */   }
/*     */   
/*     */   public String sendToMerchant() throws Exception {
/* 145 */     long startTime = System.currentTimeMillis();
/* 146 */     logger.info("**<Smartfess> sendToMerchant()-START**");
/* 147 */     if (!isValidSession()) {
/* 148 */       addActionError("Your session has been invalidated. Please login again.");
/* 149 */       long l = System.currentTimeMillis();
/* 150 */       logger.info("**SmartFees- sendToMerchant - EXECUTION TIME **" + (l - startTime));
/* 151 */       logger.info("SmartFees - sendToMerchant() - END");
/*     */       
/* 153 */       return "error";
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 161 */     InstituteConfigBean instituteConfigBean = (InstituteConfigBean)getUserSessionMap().get("INSTCONFIG");
/* 162 */     HttpServletRequest request = ServletActionContext.getRequest();
/* 163 */     setUniqueSessionIdentifier(getUserSessionMap().get("sessionKey").toString());
/*     */     
/* 165 */     FJBean fjBean = (FJBean)getUserSessionMap().get("BASEDATA");
/*     */ 
/*     */     
/* 168 */     String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 169 */     LoginActionService loginActionService = new LoginActionService();
/*     */     
/* 171 */     if (StringUtils.isBlank(instituteConfigBean.getRegistrationId())) {
/* 172 */       setStudentData(loginActionService.getRegisteredStudentList(registeredUserId));
/* 173 */       long l = System.currentTimeMillis();
/* 174 */       logger.info("**SmartFees- sendToMerchant - EXECUTION TIME **" + (l - startTime));
/* 175 */       logger.info("SmartFees - sendToMerchant() - END");
/* 176 */       return "home";
/*     */     } 
/*     */     
/* 179 */     setStudentData(loginActionService.getRegisteredStudentList(registeredUserId));
/* 180 */     long endTime = System.currentTimeMillis();
/* 181 */     logger.info("**SmartFees- getInstituteCode - EXECUTION TIME **" + (endTime - startTime));
/* 182 */     logger.info("SmartFees - sendToMerchant() - END");
/* 183 */     return FJAction.DIRECT_QUICK_PAY_HOME;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getInstId() {
/* 194 */     return this.instId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInstId(String instId) {
/* 201 */     this.instId = instId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map getStudentData() {
/* 219 */     return this.studentData;
/*     */   }
/*     */   
/*     */   public void setStudentData(Map studentData) {
/* 223 */     this.studentData = studentData;
/*     */   }
/*     */   
/*     */   public LoginActionFormBean getAppData() {
/* 227 */     return this.appData;
/*     */   }
/*     */   
/*     */   public void setAppData(LoginActionFormBean appData) {
/* 231 */     this.appData = appData;
/*     */   }
/*     */   public String getApplicationNo() {
/* 234 */     return this.applicationNo;
/*     */   }
/*     */   
/*     */   public void setApplicationNo(String applicationNo) {
/* 238 */     this.applicationNo = applicationNo;
/*     */   }
/*     */   public String sendTohorizon() {
/* 241 */     return "redirectToHorizon";
/*     */   }
/*     */ }


/* Location:              C:\SmartFees.war\SmartFees.war\WEB-INF\classes\!\com\app\feejunction\action\LandingAction.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */