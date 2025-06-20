/*      */ package com.app.feejunction.action;
/*      */ import java.io.File;
import java.io.FileInputStream;
/*      */ import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
/*      */ import java.util.List;
/*      */ import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.app.feejunction.bean.*;
import com.app.feejunction.helper.ChecksumGenerator;
/*      */ import com.app.feejunction.helper.TPSLConstants;
/*      */ import com.app.feejunction.service.CourseDetailsService;
/*      */ import com.app.feejunction.service.InstituteMasterActionService;
/*      */ import com.app.feejunction.service.LoginActionService;
/*      */ import com.app.feejunction.service.PaymentService;
/*      */ import com.app.feejunction.service.StudentDataService;
/*      */ import com.app.feejunction.service.StudentRegistrationService;
/*      */ import com.tpsl.util.ErrorPropertyReader;
/*      */ 
/*      */ public class StudentRegistrationAction extends FJAction {
/*   35 */   private static final Logger logger = LoggerFactory.getLogger(StudentRegistrationAction.class);
/*   36 */   private static final Logger audit = LoggerFactory.getLogger("audit");
/*   37 */   private StudentRegistrationFormBean appData = new StudentRegistrationFormBean();
/*   38 */   private CourseDetailsBean courseData = new CourseDetailsBean();
/*      */   private Map<String, StudentRegistrationFormBean> studentDataMap;
/*   40 */   private Map<String, String> stateMapList = null;
/*      */   private String studentId;
/*      */   private String studentRegistrationId;
/*   43 */   StudentRegistrationFormBean studentRegistrationFormBean = new StudentRegistrationFormBean();
/*   44 */   String studentName = "";
/*      */   
/*      */   private String delstudentId;
/*      */   
/*      */   private BhuLoginActionFormBean bhuData;
/*      */   
/*      */   private GNLULoginActionFormBean gnluData;
/*      */   
/*      */   private RamaCollageFormBean ramaData;
/*      */   private IITBActionFormBean iitbData;
/*      */   private IMSUniversityFormBean imsUniversityFormBean;
/*      */   private YMCAOnlineFormBean ymcaOnlineFormBean;
/*      */   private GpullaReadyFormBean gpullaReadyFormBean;
/*      */   private UnisonFormBean unisonFormBean;
/*      */   private WBUTUniversityFormBean wbutUniversityFormBean;
/*      */   private CampionSchoolFormBean campionSchoolFormBean;
/*      */   private NITOnlineFormBean nitOnlineFormBean;
/*      */   private HaryanaFormBean haryanaFormBean;
/*      */   private BengalCollegeOnlineFormBean bengalCollegeOnlineFormBean;
/*      */   private InputStream fileInputStream;
/*      */   private StringBuffer buffer;
/*      */   private BSEFormBean bseFormBean;
/*      */   private WelhamSchoolFormBean welhamSchoolFormBean;
/*      */   private NIPROnlineFormBean niprOnlineFormBean;
/*      */   private CandEntryForm candEntryForm;
/*      */   private UGIOnlineFormBean ugiOnlineFormBean;
/*      */   private MGRMedicalOnlineFormBean mgrMedicalOnlineFormBean;
/*      */   private DOONOnlineFormBean doonOnlineFormBean;
/*      */   private JRSTOnlineFormBean jrstOnlineFormBean;
/*      */   private MGCOnlineFormBean mgcOnlineFormBean;
/*      */   private NISMOnlineFormBean nismOnlineFormBean;
/*      */   private DOTUOnlineFormBean dotuOnlineFormBean;
/*      */   private RPTMOnlineFormBean rptmOnlineFormBean;
/*      */   private KaushalyaFormBean kaushalyaFormBean;
/*      */   private RungtanlineFormBean rungtanlineFormBean;
/*      */   private ChristineOnlineFormBean christineOnlineFormBean;
/*      */   private MATSFeesForm matsFeesForm;
/*      */   private SharpmindsOnlineFormBean sharpmindsOnlineFormBean;
/*      */   private BSPROnlineFormBean bsprOnlineFormBean;
/*      */   private EtoosOnlineFormBean etoosOnlineFormBean;
/*      */   private BKLIOnlineFormBean bkliOnlineFormBean;
/*      */   private IIBMSFormBean iibmsFormBean;
/*      */   private JayotiFormBean jayotiFormBean;
/*      */   private INTLOnlineFormBean intlOnlineFormBean;
/*      */   private PrincipalAIAFormBean principalOnlineFormBean;
/*      */   private OrigenceOnlineFormBean origenceOnlineFormBean;
/*      */   private NATLOnlineFormBean natlOnlineFormBean;
/*      */   private LanOnlineFormBean lanOnlineFormBean;
/*      */   private DTEFormBean dteFormBean;
/*      */   private RungtaCollegeFormBean rungtaCollegeFormBean;
/*      */   private GPSOnlineFormBean gpsOnlineFormBean;
/*      */   private TOLANIFormBean tolaniFormBean;
/*      */   private SHIVFormBean shivFormBean;
/*      */   private HydroPowerOnlineFormBean hydroPowerOnlineFormBean;
/*      */   private SWARAFormBean swaraFormBean;
/*      */   private AmbikapurOnlineFormBean ambikaPurOnlineFormBean;
/*      */   private KRISHAKFormBean krishakFormBean;
/*      */   private ShepaOnlineFormBean shepaOnlineFormBean;
/*      */   private WeidnerOnlineFormBean weidnerOnlineFormBean;
/*      */   private FinolexOnlineFormBean finolexOnlineFormBean;
/*      */   private HNBGUFormBean HNBGUFormBean;
/*      */   private ICBROnlineFormBean icbrOnlineFormBean;
/*      */   private MahadeviYadavOnlineFormBean mahadeviYadavOnlineFormBean;
/*      */   private ABHAYFormBean abhayFormBean;
/*      */   private RAJFormBean rajFormBean;
/*      */   private OERCOnlineFormBean oercOnlineFormBean;
/*      */   private OERCPOnlineFormBean oercpOnlineFormBean;
/*      */   private MicronOnlineFormBean micronOnlineFormBean;
/*      */   private SheetlaOnlineFormBean sheetlaOnlineFormBean;
/*      */   private GaharwarOnlineFormBean gaharwarOnlineFormBean;
/*      */   private LuciOnlineFormBean luciOnlineFormBean;
/*      */   private ChaudharyCollegeOnlineBean chaudharyCollegeOnlineBean;
/*      */   private GSFCOnlineFormBean gsfcOnlineFormBean;
/*      */   private ChaudharyADMISSIONOnlineBean chaudharyADMISSIONOnlineBean;
/*      */   private StandfordOnlineFormBean standfordOnlineFormBean;
/*      */   private String InstCode;
/*      */   private NLUOnlineFormBean nluOnlineFormBean;
/*      */   private DPSCOnlineFormBean dpscOnlineFormBean;
/*      */   private AmericanOnlineFormBean americanOnlineFormBean;
/*      */   private PathFinderOnlineFormBean pathFinderOnlineFormBean;
/*      */   private FeesForm feesForm;
/*      */   private CUOHaryanaOnlineFormBean cuoHaryanaOnlineFormBean;
/*      */   private ChaudharyMiscellanousOnlineBean chaudharyMiscellanousOnlineBean;
/*      */   private RoyalDentalOnlineFormBean royalDentalOnlineFormBean;
/*      */   private VishalInstOnlineFormBean vishalInstOnlineFormBean;
/*      */   private LancersOnlineFormBean lancersOnlineFormBean;
/*      */   private DpsBudgamOnlineFormBean DpsBudgamOnlineFormBean;
/*      */   private KrishnaLawOnlineFormBean KrishnaLawOnlineFormBean;
/*      */   private BiyaniOnlineFormBean biyaniOnlineFormBean;
/*      */   private KulluOnlineFormBean kulluOnlineFormBean;
/*      */   private JBCIOnlineFormBean jbciOnlineFormBean;
/*      */   private NaiminathOnlineFormBean naiminathOnlineFormBean;
/*      */   private SPHSchoolOnlineFormBean sphSchoolOnlineFormBean;
/*      */   private SSJainSubodhOnlineFormBean jainSubodhOnlineFormBean;
/*      */   private TeamworkEducationOnlineFormBean teamworkEducationOnlineFormBean;
/*      */   private GOENKAOnlineFormBean goenkaOnlineFormBean;
/*      */   private GRCosmicOnlineFormBean grCosmicOnlineFormBean;
/*      */   private VenkatEduOnlineFormBean venkatEduOnlineFormBean;
/*      */   private MahaEduOnlineFormBean mahaEduOnlineFormBean;
/*      */   private SmartrepEductionOnlineFormBean smartrepEductionOnlineFormBean;
/*      */   private AsianOnlineFormBean asianOnlineFormBean;
/*      */   private RajsthanOnlineFormBean rajsthanOnlineFormBean;
/*      */   private SuccessEaseFormBean successEaseFormBeanFormBean;
/*      */   private KashiInstituteFormBean kashiInstituteFormBean;
/*      */   private IICSEductionOnlineFormBean iicsEductionOnlineFormBean;
/*      */   private JawaharOnlineFormBean jawaharOnlineFormBean;
/*      */   private HorizonOnlineFormBean horizonOnlineFormBean;
/*      */   private BrainStormFormBean brainStormFormBean;
/*      */   private DelhiSchoolOnlineFormBean delhiSchoolOnlineFormBean;
/*      */   private SISFormBean sisFormBean;
/*      */   private IceonlineFormBean iceFormBean;
/*      */   private IEIIndiaOnlineFormBean ieiIndiaFormBean;
/*      */   private BhartiConceptFormBean bhartiConceptFormBean;
/*      */   private TrinityOnlineFormBean trinityOnlineFormBean;
/*      */   private NavJagritiOnlineFormBean navJagritiBean;
/*      */   private DpsPanipatOnlineFormBean dpsPanipatOnlineFormBean;
/*      */   private DAVSchoolOnlineFormBean davschoolOnlineFormBean;
/*      */   private NoidaApsOnlineFormBean noidaApsOnlineFormBean;
/*      */   private SriAurobindoSchoolOnlineFormBean sriAurobindoSchoolOnlineFormBean;
/*      */   private DpsBudgamRegistrationOnlineFormBean dpsBudgamRegistrationOnlineFormBean;
/*      */   private InderPrasthaOnlineFormBean inderPrasthaOnlineFormBean;
/*      */   private InderPrasthaNewOnlineFormBean inderPrasthaNewOnlineFormBean;
/*      */   private InderPrasthaExistOnlineFormBean inderPrasthaExistOnlineFormBean;
/*      */   private PPAFormBean ppaFormBean;
/*      */   private Map studentData;
/*      */   
/*      */   public InderPrasthaExistOnlineFormBean getInderPrasthaExistOnlineFormBean() {
/*  171 */     return this.inderPrasthaExistOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setInderPrasthaExistOnlineFormBean(InderPrasthaExistOnlineFormBean inderPrasthaExistOnlineFormBean) {
/*  175 */     this.inderPrasthaExistOnlineFormBean = inderPrasthaExistOnlineFormBean;
/*      */   }
/*      */   public InderPrasthaNewOnlineFormBean getInderPrasthaNewOnlineFormBean() {
/*  178 */     return this.inderPrasthaNewOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setInderPrasthaNewOnlineFormBean(InderPrasthaNewOnlineFormBean inderPrasthaNewOnlineFormBean) {
/*  182 */     this.inderPrasthaNewOnlineFormBean = inderPrasthaNewOnlineFormBean;
/*      */   }
/*      */   
/*      */   public InderPrasthaOnlineFormBean getInderPrasthaOnlineFormBean() {
/*  186 */     return this.inderPrasthaOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setInderPrasthaOnlineFormBean(InderPrasthaOnlineFormBean inderPrasthaOnlineFormBean) {
/*  190 */     this.inderPrasthaOnlineFormBean = inderPrasthaOnlineFormBean;
/*      */   }
/*      */   
/*      */   public DpsBudgamRegistrationOnlineFormBean getDpsBudgamRegistrationOnlineFormBean() {
/*  194 */     return this.dpsBudgamRegistrationOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setDpsBudgamRegistrationOnlineFormBean(DpsBudgamRegistrationOnlineFormBean dpsBudgamRegistrationOnlineFormBean) {
/*  198 */     this.dpsBudgamRegistrationOnlineFormBean = dpsBudgamRegistrationOnlineFormBean;
/*      */   }
/*      */   
/*      */   public SriAurobindoSchoolOnlineFormBean getSriAurobindoSchoolOnlineFormBean() {
/*  202 */     return this.sriAurobindoSchoolOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setSriAurobindoSchoolOnlineFormBean(SriAurobindoSchoolOnlineFormBean sriAurobindoSchoolOnlineFormBean) {
/*  206 */     this.sriAurobindoSchoolOnlineFormBean = sriAurobindoSchoolOnlineFormBean;
/*      */   }
/*      */   public NoidaApsOnlineFormBean getNoidaApsOnlineFormBean() {
/*  209 */     return this.noidaApsOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setNoidaApsOnlineFormBean(NoidaApsOnlineFormBean noidaApsOnlineFormBean) {
/*  213 */     this.noidaApsOnlineFormBean = noidaApsOnlineFormBean;
/*      */   }
/*      */   
/*      */   public DpsPanipatOnlineFormBean getDpsPanipatOnlineFormBean() {
/*  217 */     return this.dpsPanipatOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setDpsPanipatOnlineFormBean(DpsPanipatOnlineFormBean dpsPanipatOnlineFormBean) {
/*  221 */     this.dpsPanipatOnlineFormBean = dpsPanipatOnlineFormBean;
/*      */   }
/*      */   public SISFormBean getSisFormBean() {
/*  224 */     return this.sisFormBean;
/*      */   }
/*      */   public void setSisFormBean(SISFormBean sisFormBean) {
/*  227 */     this.sisFormBean = sisFormBean;
/*      */   }
/*      */   public DelhiSchoolOnlineFormBean getDelhiSchoolOnlineFormBean() {
/*  230 */     return this.delhiSchoolOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setDelhiSchoolOnlineFormBean(DelhiSchoolOnlineFormBean delhiSchoolOnlineFormBean) {
/*  234 */     this.delhiSchoolOnlineFormBean = delhiSchoolOnlineFormBean;
/*      */   }
/*      */   public BrainStormFormBean getBrainStormFormBean() {
/*  237 */     return this.brainStormFormBean;
/*      */   }
/*      */   public void setBrainStormFormBean(BrainStormFormBean brainStormFormBean) {
/*  240 */     this.brainStormFormBean = brainStormFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public HorizonOnlineFormBean getHorizonOnlineFormBean() {
/*  245 */     return this.horizonOnlineFormBean;
/*      */   }
/*      */   public void setHorizonOnlineFormBean(HorizonOnlineFormBean horizonOnlineFormBean) {
/*  248 */     this.horizonOnlineFormBean = horizonOnlineFormBean;
/*      */   }
/*      */   public JawaharOnlineFormBean getJawaharOnlineFormBean() {
/*  251 */     return this.jawaharOnlineFormBean;
/*      */   }
/*      */   public void setJawaharOnlineFormBean(JawaharOnlineFormBean jawaharOnlineFormBean) {
/*  254 */     this.jawaharOnlineFormBean = jawaharOnlineFormBean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public IICSEductionOnlineFormBean getIicsEductionOnlineFormBean() {
/*  260 */     return this.iicsEductionOnlineFormBean;
/*      */   }
/*      */   public void setIicsEductionOnlineFormBean(IICSEductionOnlineFormBean iicsEductionOnlineFormBean) {
/*  263 */     this.iicsEductionOnlineFormBean = iicsEductionOnlineFormBean;
/*      */   }
/*      */   public KashiInstituteFormBean getKashiInstituteFormBean() {
/*  266 */     return this.kashiInstituteFormBean;
/*      */   }
/*      */   
/*      */   public void setKashiInstituteFormBean(KashiInstituteFormBean kashiInstituteFormBean) {
/*  270 */     this.kashiInstituteFormBean = kashiInstituteFormBean;
/*      */   }
/*      */   public RajsthanOnlineFormBean getRajsthanOnlineFormBean() {
/*  273 */     return this.rajsthanOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setRajsthanOnlineFormBean(RajsthanOnlineFormBean rajsthanOnlineFormBean) {
/*  277 */     this.rajsthanOnlineFormBean = rajsthanOnlineFormBean;
/*      */   }
/*      */   
/*      */   public SuccessEaseFormBean getSuccessEaseFormBeanFormBean() {
/*  281 */     return this.successEaseFormBeanFormBean;
/*      */   }
/*      */   public void setSuccessEaseFormBeanFormBean(SuccessEaseFormBean successEaseFormBeanFormBean) {
/*  284 */     this.successEaseFormBeanFormBean = successEaseFormBeanFormBean;
/*      */   }
/*      */   public AsianOnlineFormBean getAsianOnlineFormBean() {
/*  287 */     return this.asianOnlineFormBean;
/*      */   }
/*      */   public void setAsianOnlineFormBean(AsianOnlineFormBean asianOnlineFormBean) {
/*  290 */     this.asianOnlineFormBean = asianOnlineFormBean;
/*      */   }
/*      */   public SmartrepEductionOnlineFormBean getSmartrepEductionOnlineFormBean() {
/*  293 */     return this.smartrepEductionOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setSmartrepEductionOnlineFormBean(SmartrepEductionOnlineFormBean smartrepEductionOnlineFormBean) {
/*  297 */     this.smartrepEductionOnlineFormBean = smartrepEductionOnlineFormBean;
/*      */   }
/*      */   public MahaEduOnlineFormBean getMahaEduOnlineFormBean() {
/*  300 */     return this.mahaEduOnlineFormBean;
/*      */   }
/*      */   public void setMahaEduOnlineFormBean(MahaEduOnlineFormBean mahaEduOnlineFormBean) {
/*  303 */     this.mahaEduOnlineFormBean = mahaEduOnlineFormBean;
/*      */   }
/*      */   public VenkatEduOnlineFormBean getVenkatEduOnlineFormBean() {
/*  306 */     return this.venkatEduOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setVenkatEduOnlineFormBean(VenkatEduOnlineFormBean venkatEduOnlineFormBean) {
/*  310 */     this.venkatEduOnlineFormBean = venkatEduOnlineFormBean;
/*      */   }
/*      */   public GRCosmicOnlineFormBean getGrCosmicOnlineFormBean() {
/*  313 */     return this.grCosmicOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setGrCosmicOnlineFormBean(GRCosmicOnlineFormBean grCosmicOnlineFormBean) {
/*  317 */     this.grCosmicOnlineFormBean = grCosmicOnlineFormBean;
/*      */   }
/*      */   
/*      */   public GOENKAOnlineFormBean getGoenkaOnlineFormBean() {
/*  321 */     return this.goenkaOnlineFormBean;
/*      */   }
/*      */   public void setGoenkaOnlineFormBean(GOENKAOnlineFormBean goenkaOnlineFormBean) {
/*  324 */     this.goenkaOnlineFormBean = goenkaOnlineFormBean;
/*      */   }
/*      */   public TeamworkEducationOnlineFormBean getTeamworkEducationOnlineFormBean() {
/*  327 */     return this.teamworkEducationOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setTeamworkEducationOnlineFormBean(TeamworkEducationOnlineFormBean teamworkEducationOnlineFormBean) {
/*  331 */     this.teamworkEducationOnlineFormBean = teamworkEducationOnlineFormBean;
/*      */   }
/*      */   public SSJainSubodhOnlineFormBean getJainSubodhOnlineFormBean() {
/*  334 */     return this.jainSubodhOnlineFormBean;
/*      */   }
/*      */   public void setJainSubodhOnlineFormBean(SSJainSubodhOnlineFormBean jainSubodhOnlineFormBean) {
/*  337 */     this.jainSubodhOnlineFormBean = jainSubodhOnlineFormBean;
/*      */   }
/*      */   public SPHSchoolOnlineFormBean getSphSchoolOnlineFormBean() {
/*  340 */     return this.sphSchoolOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setSphSchoolOnlineFormBean(SPHSchoolOnlineFormBean sphSchoolOnlineFormBean) {
/*  344 */     this.sphSchoolOnlineFormBean = sphSchoolOnlineFormBean;
/*      */   }
/*      */   public NaiminathOnlineFormBean getNaiminathOnlineFormBean() {
/*  347 */     return this.naiminathOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setNaiminathOnlineFormBean(NaiminathOnlineFormBean naiminathOnlineFormBean) {
/*  351 */     this.naiminathOnlineFormBean = naiminathOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public JBCIOnlineFormBean getJbciOnlineFormBean() {
/*  356 */     return this.jbciOnlineFormBean;
/*      */   }
/*      */   public void setJbciOnlineFormBean(JBCIOnlineFormBean jbciOnlineFormBean) {
/*  359 */     this.jbciOnlineFormBean = jbciOnlineFormBean;
/*      */   }
/*      */   public KulluOnlineFormBean getKulluOnlineFormBean() {
/*  362 */     return this.kulluOnlineFormBean;
/*      */   }
/*      */   public void setKulluOnlineFormBean(KulluOnlineFormBean kulluOnlineFormBean) {
/*  365 */     this.kulluOnlineFormBean = kulluOnlineFormBean;
/*      */   }
/*      */   public BiyaniOnlineFormBean getBiyaniOnlineFormBean() {
/*  368 */     return this.biyaniOnlineFormBean;
/*      */   }
/*      */   public void setBiyaniOnlineFormBean(BiyaniOnlineFormBean biyaniOnlineFormBean) {
/*  371 */     this.biyaniOnlineFormBean = biyaniOnlineFormBean;
/*      */   }
/*      */   public KrishnaLawOnlineFormBean getKrishnaLawOnlineFormBean() {
/*  374 */     return this.KrishnaLawOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setKrishnaLawOnlineFormBean(KrishnaLawOnlineFormBean krishnaLawOnlineFormBean) {
/*  378 */     this.KrishnaLawOnlineFormBean = krishnaLawOnlineFormBean;
/*      */   }
/*      */   public DpsBudgamOnlineFormBean getDpsBudgamOnlineFormBean() {
/*  381 */     return this.DpsBudgamOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setDpsBudgamOnlineFormBean(DpsBudgamOnlineFormBean dpsBudgamOnlineFormBean) {
/*  385 */     this.DpsBudgamOnlineFormBean = dpsBudgamOnlineFormBean;
/*      */   }
/*      */   public LancersOnlineFormBean getLancersOnlineFormBean() {
/*  388 */     return this.lancersOnlineFormBean;
/*      */   }
/*      */   public void setLancersOnlineFormBean(LancersOnlineFormBean lancersOnlineFormBean) {
/*  391 */     this.lancersOnlineFormBean = lancersOnlineFormBean;
/*      */   }
/*      */   public VishalInstOnlineFormBean getVishalInstOnlineFormBean() {
/*  394 */     return this.vishalInstOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setVishalInstOnlineFormBean(VishalInstOnlineFormBean vishalInstOnlineFormBean) {
/*  398 */     this.vishalInstOnlineFormBean = vishalInstOnlineFormBean;
/*      */   }
/*      */   public RoyalDentalOnlineFormBean getRoyalDentalOnlineFormBean() {
/*  401 */     return this.royalDentalOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setRoyalDentalOnlineFormBean(RoyalDentalOnlineFormBean royalDentalOnlineFormBean) {
/*  405 */     this.royalDentalOnlineFormBean = royalDentalOnlineFormBean;
/*      */   }
/*      */   public ChaudharyMiscellanousOnlineBean getChaudharyMiscellanousOnlineBean() {
/*  408 */     return this.chaudharyMiscellanousOnlineBean;
/*      */   }
/*      */   
/*      */   public void setChaudharyMiscellanousOnlineBean(ChaudharyMiscellanousOnlineBean chaudharyMiscellanousOnlineBean) {
/*  412 */     this.chaudharyMiscellanousOnlineBean = chaudharyMiscellanousOnlineBean;
/*      */   }
/*      */   public CUOHaryanaOnlineFormBean getCuoHaryanaOnlineFormBean() {
/*  415 */     return this.cuoHaryanaOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setCuoHaryanaOnlineFormBean(CUOHaryanaOnlineFormBean cuoHaryanaOnlineFormBean) {
/*  419 */     this.cuoHaryanaOnlineFormBean = cuoHaryanaOnlineFormBean;
/*      */   }
/*      */   public FeesForm getFeesForm() {
/*  422 */     return this.feesForm;
/*      */   }
/*      */   public void setFeesForm(FeesForm feesForm) {
/*  425 */     this.feesForm = feesForm;
/*      */   }
/*      */ 
/*      */   
/*      */   public PathFinderOnlineFormBean getPathFinderOnlineFormBean() {
/*  430 */     return this.pathFinderOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setPathFinderOnlineFormBean(PathFinderOnlineFormBean pathFinderOnlineFormBean) {
/*  434 */     this.pathFinderOnlineFormBean = pathFinderOnlineFormBean;
/*      */   }
/*      */   public AmericanOnlineFormBean getAmericanOnlineFormBean() {
/*  437 */     return this.americanOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setAmericanOnlineFormBean(AmericanOnlineFormBean americanOnlineFormBean) {
/*  441 */     this.americanOnlineFormBean = americanOnlineFormBean;
/*      */   }
/*      */   public DPSCOnlineFormBean getDpscOnlineFormBean() {
/*  444 */     return this.dpscOnlineFormBean;
/*      */   }
/*      */   public void setDpscOnlineFormBean(DPSCOnlineFormBean dpscOnlineFormBean) {
/*  447 */     this.dpscOnlineFormBean = dpscOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public NLUOnlineFormBean getNluOnlineFormBean() {
/*  452 */     return this.nluOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setNluOnlineFormBean(NLUOnlineFormBean nluOnlineFormBean) {
/*  456 */     this.nluOnlineFormBean = nluOnlineFormBean;
/*      */   }
/*      */   
/*      */   public String getInstCode() {
/*  460 */     return this.InstCode;
/*      */   }
/*      */   
/*      */   public void setInstCode(String instCode) {
/*  464 */     this.InstCode = instCode;
/*      */   }
/*      */   
/*      */   public ChaudharyADMISSIONOnlineBean getChaudharyADMISSIONOnlineBean() {
/*  468 */     return this.chaudharyADMISSIONOnlineBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setChaudharyADMISSIONOnlineBean(ChaudharyADMISSIONOnlineBean chaudharyADMISSIONOnlineBean) {
/*  473 */     this.chaudharyADMISSIONOnlineBean = chaudharyADMISSIONOnlineBean;
/*      */   }
/*      */   
/*      */   public GSFCOnlineFormBean getGsfcOnlineFormBean() {
/*  477 */     return this.gsfcOnlineFormBean;
/*      */   }
/*      */   public void setGsfcOnlineFormBean(GSFCOnlineFormBean gsfcOnlineFormBean) {
/*  480 */     this.gsfcOnlineFormBean = gsfcOnlineFormBean;
/*      */   }
/*      */   public ChaudharyCollegeOnlineBean getChaudharyCollegeOnlineBean() {
/*  483 */     return this.chaudharyCollegeOnlineBean;
/*      */   }
/*      */   
/*      */   public void setChaudharyCollegeOnlineBean(ChaudharyCollegeOnlineBean chaudharyCollegeOnlineBean) {
/*  487 */     this.chaudharyCollegeOnlineBean = chaudharyCollegeOnlineBean;
/*      */   }
/*      */   public LuciOnlineFormBean getLuciOnlineFormBean() {
/*  490 */     return this.luciOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setLuciOnlineFormBean(LuciOnlineFormBean luciOnlineFormBean) {
/*  494 */     this.luciOnlineFormBean = luciOnlineFormBean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public GaharwarOnlineFormBean getGaharwarOnlineFormBean() {
/*  500 */     return this.gaharwarOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setGaharwarOnlineFormBean(GaharwarOnlineFormBean gaharwarOnlineFormBean) {
/*  505 */     this.gaharwarOnlineFormBean = gaharwarOnlineFormBean;
/*      */   }
/*      */   
/*      */   public SheetlaOnlineFormBean getSheetlaOnlineFormBean() {
/*  509 */     return this.sheetlaOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setSheetlaOnlineFormBean(SheetlaOnlineFormBean sheetlaOnlineFormBean) {
/*  513 */     this.sheetlaOnlineFormBean = sheetlaOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public StandfordOnlineFormBean getStandfordOnlineFormBean() {
/*  518 */     return this.standfordOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setStandfordOnlineFormBean(StandfordOnlineFormBean standfordOnlineFormBean) {
/*  523 */     this.standfordOnlineFormBean = standfordOnlineFormBean;
/*      */   }
/*      */   public MicronOnlineFormBean getMicronOnlineFormBean() {
/*  526 */     return this.micronOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setMicronOnlineFormBean(MicronOnlineFormBean micronOnlineFormBean) {
/*  530 */     this.micronOnlineFormBean = micronOnlineFormBean;
/*      */   }
/*      */   public OERCPOnlineFormBean getOercpOnlineFormBean() {
/*  533 */     return this.oercpOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setOercpOnlineFormBean(OERCPOnlineFormBean oercpOnlineFormBean) {
/*  537 */     this.oercpOnlineFormBean = oercpOnlineFormBean;
/*      */   }
/*      */   
/*      */   public OERCOnlineFormBean getOercOnlineFormBean() {
/*  541 */     return this.oercOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setOercOnlineFormBean(OERCOnlineFormBean oercOnlineFormBean) {
/*  545 */     this.oercOnlineFormBean = oercOnlineFormBean;
/*      */   }
/*      */   
/*      */   public RAJFormBean getRajFormBean() {
/*  549 */     return this.rajFormBean;
/*      */   }
/*      */   
/*      */   public void setRajFormBean(RAJFormBean rajFormBean) {
/*  553 */     this.rajFormBean = rajFormBean;
/*      */   }
/*      */   
/*      */   public ABHAYFormBean getAbhayFormBean() {
/*  557 */     return this.abhayFormBean;
/*      */   }
/*      */   
/*      */   public void setAbhayFormBean(ABHAYFormBean abhayFormBean) {
/*  561 */     this.abhayFormBean = abhayFormBean;
/*      */   }
/*      */   
/*      */   public MahadeviYadavOnlineFormBean getMahadeviYadavOnlineFormBean() {
/*  565 */     return this.mahadeviYadavOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setMahadeviYadavOnlineFormBean(MahadeviYadavOnlineFormBean mahadeviYadavOnlineFormBean) {
/*  570 */     this.mahadeviYadavOnlineFormBean = mahadeviYadavOnlineFormBean;
/*      */   }
/*      */   
/*      */   public ICBROnlineFormBean getIcbrOnlineFormBean() {
/*  574 */     return this.icbrOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setIcbrOnlineFormBean(ICBROnlineFormBean icbrOnlineFormBean) {
/*  578 */     this.icbrOnlineFormBean = icbrOnlineFormBean;
/*      */   }
/*      */   
/*      */   public FinolexOnlineFormBean getFinolexOnlineFormBean() {
/*  582 */     return this.finolexOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setFinolexOnlineFormBean(FinolexOnlineFormBean finolexOnlineFormBean) {
/*  586 */     this.finolexOnlineFormBean = finolexOnlineFormBean;
/*      */   }
/*      */   
/*      */   public WeidnerOnlineFormBean getWeidnerOnlineFormBean() {
/*  590 */     return this.weidnerOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setWeidnerOnlineFormBean(WeidnerOnlineFormBean weidnerOnlineFormBean) {
/*  594 */     this.weidnerOnlineFormBean = weidnerOnlineFormBean;
/*      */   }
/*      */   
/*      */   public KRISHAKFormBean getKrishakFormBean() {
/*  598 */     return this.krishakFormBean;
/*      */   }
/*      */   
/*      */   public void setKrishakFormBean(KRISHAKFormBean krishakFormBean) {
/*  602 */     this.krishakFormBean = krishakFormBean;
/*      */   }
/*      */   public ShepaOnlineFormBean getShepaOnlineFormBean() {
/*  605 */     return this.shepaOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setShepaOnlineFormBean(ShepaOnlineFormBean shepaOnlineFormBean) {
/*  609 */     this.shepaOnlineFormBean = shepaOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public AmbikapurOnlineFormBean getAmbikaPurOnlineFormBean() {
/*  614 */     return this.ambikaPurOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAmbikaPurOnlineFormBean(AmbikapurOnlineFormBean ambikaPurOnlineFormBean) {
/*  619 */     this.ambikaPurOnlineFormBean = ambikaPurOnlineFormBean;
/*      */   }
/*      */   
/*      */   public SWARAFormBean getSwaraFormBean() {
/*  623 */     return this.swaraFormBean;
/*      */   }
/*      */   
/*      */   public void setSwaraFormBean(SWARAFormBean swaraFormBean) {
/*  627 */     this.swaraFormBean = swaraFormBean;
/*      */   }
/*      */   public HydroPowerOnlineFormBean getHydroPowerOnlineFormBean() {
/*  630 */     return this.hydroPowerOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setHydroPowerOnlineFormBean(HydroPowerOnlineFormBean hydroPowerOnlineFormBean) {
/*  635 */     this.hydroPowerOnlineFormBean = hydroPowerOnlineFormBean;
/*      */   }
/*      */   
/*      */   public SHIVFormBean getShivFormBean() {
/*  639 */     return this.shivFormBean;
/*      */   }
/*      */   
/*      */   public void setShivFormBean(SHIVFormBean shivFormBean) {
/*  643 */     this.shivFormBean = shivFormBean;
/*      */   }
/*      */   public TOLANIFormBean getTolaniFormBean() {
/*  646 */     return this.tolaniFormBean;
/*      */   }
/*      */   
/*      */   public void setTolaniFormBean(TOLANIFormBean tolaniFormBean) {
/*  650 */     this.tolaniFormBean = tolaniFormBean;
/*      */   }
/*      */   public GPSOnlineFormBean getGpsOnlineFormBean() {
/*  653 */     return this.gpsOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setGpsOnlineFormBean(GPSOnlineFormBean gpsOnlineFormBean) {
/*  657 */     this.gpsOnlineFormBean = gpsOnlineFormBean;
/*      */   }
/*      */   
/*      */   public RungtaCollegeFormBean getRungtaCollegeFormBean() {
/*  661 */     return this.rungtaCollegeFormBean;
/*      */   }
/*      */   
/*      */   public void setRungtaCollegeFormBean(RungtaCollegeFormBean rungtaCollegeFormBean) {
/*  665 */     this.rungtaCollegeFormBean = rungtaCollegeFormBean;
/*      */   }
/*      */   
/*      */   public DTEFormBean getDteFormBean() {
/*  669 */     return this.dteFormBean;
/*      */   }
/*      */   
/*      */   public void setDteFormBean(DTEFormBean dteFormBean) {
/*  673 */     this.dteFormBean = dteFormBean;
/*      */   }
/*      */   
/*      */   public LanOnlineFormBean getLanOnlineFormBean() {
/*  677 */     return this.lanOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setLanOnlineFormBean(LanOnlineFormBean lanOnlineFormBean) {
/*  681 */     this.lanOnlineFormBean = lanOnlineFormBean;
/*      */   }
/*      */   public NATLOnlineFormBean getNatlOnlineFormBean() {
/*  684 */     return this.natlOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setNatlOnlineFormBean(NATLOnlineFormBean natlOnlineFormBean) {
/*  688 */     this.natlOnlineFormBean = natlOnlineFormBean;
/*      */   }
/*      */   public OrigenceOnlineFormBean getOrigenceOnlineFormBean() {
/*  691 */     return this.origenceOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setOrigenceOnlineFormBean(OrigenceOnlineFormBean origenceOnlineFormBean) {
/*  696 */     this.origenceOnlineFormBean = origenceOnlineFormBean;
/*      */   }
/*      */   public INTLOnlineFormBean getIntlOnlineFormBean() {
/*  699 */     return this.intlOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setIntlOnlineFormBean(INTLOnlineFormBean intlOnlineFormBean) {
/*  703 */     this.intlOnlineFormBean = intlOnlineFormBean;
/*      */   }
/*      */   
/*      */   public PrincipalAIAFormBean getPrincipalOnlineFormBean() {
/*  707 */     return this.principalOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPrincipalOnlineFormBean(PrincipalAIAFormBean principalOnlineFormBean) {
/*  712 */     this.principalOnlineFormBean = principalOnlineFormBean;
/*      */   }
/*      */   
/*      */   public JayotiFormBean getJayotiFormBean() {
/*  716 */     return this.jayotiFormBean;
/*      */   }
/*      */   
/*      */   public void setJayotiFormBean(JayotiFormBean jayotiFormBean) {
/*  720 */     this.jayotiFormBean = jayotiFormBean;
/*      */   }
/*      */   public PPAFormBean getPpaFormBean() {
/*  723 */     return this.ppaFormBean;
/*      */   }
/*      */   
/*      */   public void setPpaFormBean(PPAFormBean ppaFormBean) {
/*  727 */     this.ppaFormBean = ppaFormBean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public IIBMSFormBean getIibmsFormBean() {
/*  733 */     return this.iibmsFormBean;
/*      */   }
/*      */   
/*      */   public void setIibmsFormBean(IIBMSFormBean iibmsFormBean) {
/*  737 */     this.iibmsFormBean = iibmsFormBean;
/*      */   }
/*      */   
/*      */   public BKLIOnlineFormBean getBkliOnlineFormBean() {
/*  741 */     return this.bkliOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setBkliOnlineFormBean(BKLIOnlineFormBean bkliOnlineFormBean) {
/*  745 */     this.bkliOnlineFormBean = bkliOnlineFormBean;
/*      */   }
/*      */   public BSPROnlineFormBean getBsprOnlineFormBean() {
/*  748 */     return this.bsprOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setBsprOnlineFormBean(BSPROnlineFormBean bsprOnlineFormBean) {
/*  752 */     this.bsprOnlineFormBean = bsprOnlineFormBean;
/*      */   }
/*      */   
/*      */   public SharpmindsOnlineFormBean getSharpmindsOnlineFormBean() {
/*  756 */     return this.sharpmindsOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSharpmindsOnlineFormBean(SharpmindsOnlineFormBean sharpmindsOnlineFormBean) {
/*  761 */     this.sharpmindsOnlineFormBean = sharpmindsOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public MATSFeesForm getMatsFeesForm() {
/*  766 */     return this.matsFeesForm;
/*      */   }
/*      */   
/*      */   public void setMatsFeesForm(MATSFeesForm matsFeesForm) {
/*  770 */     this.matsFeesForm = matsFeesForm;
/*      */   }
/*      */   
/*      */   public ChristineOnlineFormBean getChristineOnlineFormBean() {
/*  774 */     return this.christineOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setChristineOnlineFormBean(ChristineOnlineFormBean christineOnlineFormBean) {
/*  779 */     this.christineOnlineFormBean = christineOnlineFormBean;
/*      */   }
/*      */   public RungtanlineFormBean getRungtanlineFormBean() {
/*  782 */     return this.rungtanlineFormBean;
/*      */   }
/*      */   
/*      */   public void setRungtanlineFormBean(RungtanlineFormBean rungtanlineFormBean) {
/*  786 */     this.rungtanlineFormBean = rungtanlineFormBean;
/*      */   }
/*      */   
/*      */   public KaushalyaFormBean getKaushalyaFormBean() {
/*  790 */     return this.kaushalyaFormBean;
/*      */   }
/*      */   
/*      */   public void setKaushalyaFormBean(KaushalyaFormBean kaushalyaFormBean) {
/*  794 */     this.kaushalyaFormBean = kaushalyaFormBean;
/*      */   }
/*      */   
/*      */   public RPTMOnlineFormBean getRptmOnlineFormBean() {
/*  798 */     return this.rptmOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setRptmOnlineFormBean(RPTMOnlineFormBean rptmOnlineFormBean) {
/*  802 */     this.rptmOnlineFormBean = rptmOnlineFormBean;
/*      */   }
/*      */   public DOTUOnlineFormBean getDotuOnlineFormBean() {
/*  805 */     return this.dotuOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setDotuOnlineFormBean(DOTUOnlineFormBean dotuOnlineFormBean) {
/*  809 */     this.dotuOnlineFormBean = dotuOnlineFormBean;
/*      */   }
/*      */   public NISMOnlineFormBean getNismOnlineFormBean() {
/*  812 */     return this.nismOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setNismOnlineFormBean(NISMOnlineFormBean nismOnlineFormBean) {
/*  816 */     this.nismOnlineFormBean = nismOnlineFormBean;
/*      */   }
/*      */   public MGCOnlineFormBean getMgcOnlineFormBean() {
/*  819 */     return this.mgcOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setMgcOnlineFormBean(MGCOnlineFormBean mgcOnlineFormBean) {
/*  823 */     this.mgcOnlineFormBean = mgcOnlineFormBean;
/*      */   }
/*      */   
/*      */   public JRSTOnlineFormBean getJrstOnlineFormBean() {
/*  827 */     return this.jrstOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setJrstOnlineFormBean(JRSTOnlineFormBean jrstOnlineFormBean) {
/*  831 */     this.jrstOnlineFormBean = jrstOnlineFormBean;
/*      */   }
/*      */   public DOONOnlineFormBean getDoonOnlineFormBean() {
/*  834 */     return this.doonOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setDoonOnlineFormBean(DOONOnlineFormBean doonOnlineFormBean) {
/*  838 */     this.doonOnlineFormBean = doonOnlineFormBean;
/*      */   }
/*      */   
/*      */   public UGIOnlineFormBean getUgiOnlineFormBean() {
/*  842 */     return this.ugiOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setUgiOnlineFormBean(UGIOnlineFormBean ugiOnlineFormBean) {
/*  846 */     this.ugiOnlineFormBean = ugiOnlineFormBean;
/*      */   }
/*      */   public BSEFormBean getBseFormBean() {
/*  849 */     return this.bseFormBean;
/*      */   }
/*      */   public CandEntryForm getCandEntryForm() {
/*  852 */     return this.candEntryForm;
/*      */   }
/*      */   
/*      */   public void setCandEntryForm(CandEntryForm candEntryForm) {
/*  856 */     this.candEntryForm = candEntryForm;
/*      */   }
/*      */   public void setBseFormBean(BSEFormBean bseFormBean) {
/*  859 */     this.bseFormBean = bseFormBean;
/*      */   }
/*      */   public MGRMedicalOnlineFormBean getMgrMedicalOnlineFormBean() {
/*  862 */     return this.mgrMedicalOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setMgrMedicalOnlineFormBean(MGRMedicalOnlineFormBean mgrMedicalOnlineFormBean) {
/*  867 */     this.mgrMedicalOnlineFormBean = mgrMedicalOnlineFormBean;
/*      */   }
/*      */   public NIPROnlineFormBean getNiprOnlineFormBean() {
/*  870 */     return this.niprOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setNiprOnlineFormBean(NIPROnlineFormBean niprOnlineFormBean) {
/*  874 */     this.niprOnlineFormBean = niprOnlineFormBean;
/*      */   }
/*      */   
/*      */   public WelhamSchoolFormBean getWelhamSchoolFormBean() {
/*  878 */     return this.welhamSchoolFormBean;
/*      */   }
/*      */   
/*      */   public void setWelhamSchoolFormBean(WelhamSchoolFormBean welhamSchoolFormBean) {
/*  882 */     this.welhamSchoolFormBean = welhamSchoolFormBean;
/*      */   }
/*      */   
/*      */   public InputStream getFileInputStream() {
/*  886 */     return this.fileInputStream;
/*      */   }
/*      */   
/*      */   public void setFileInputStream(InputStream fileInputStream) {
/*  890 */     this.fileInputStream = fileInputStream;
/*      */   }
/*      */   
/*      */   public StringBuffer getBuffer() {
/*  894 */     return this.buffer;
/*      */   }
/*      */   
/*      */   public void setBuffer(StringBuffer buffer) {
/*  898 */     this.buffer = buffer;
/*      */   }
/*      */   public Map<String, String> getStateMapList() {
/*  901 */     return this.stateMapList;
/*      */   }
/*      */   
/*      */   public void setStateMapList(Map<String, String> stateMapList) {
/*  905 */     this.stateMapList = stateMapList;
/*      */   }
/*      */   public BengalCollegeOnlineFormBean getBengalCollegeOnlineFormBean() {
/*  908 */     return this.bengalCollegeOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setBengalCollegeOnlineFormBean(BengalCollegeOnlineFormBean bengalCollegeOnlineFormBean) {
/*  913 */     this.bengalCollegeOnlineFormBean = bengalCollegeOnlineFormBean;
/*      */   }
/*      */   public HaryanaFormBean getHaryanaFormBean() {
/*  916 */     return this.haryanaFormBean;
/*      */   }
/*      */   public void setHaryanaFormBean(HaryanaFormBean haryanaFormBean) {
/*  919 */     this.haryanaFormBean = haryanaFormBean;
/*      */   }
/*      */   public CampionSchoolFormBean getCampionSchoolFormBean() {
/*  922 */     return this.campionSchoolFormBean;
/*      */   }
/*      */   
/*      */   public void setCampionSchoolFormBean(CampionSchoolFormBean campionSchoolFormBean) {
/*  926 */     this.campionSchoolFormBean = campionSchoolFormBean;
/*      */   }
/*      */   public NITOnlineFormBean getNitOnlineFormBean() {
/*  929 */     return this.nitOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setNitOnlineFormBean(NITOnlineFormBean nitOnlineFormBean) {
/*  933 */     this.nitOnlineFormBean = nitOnlineFormBean;
/*      */   }
/*      */   public GpullaReadyFormBean getGpullaReadyFormBean() {
/*  936 */     return this.gpullaReadyFormBean;
/*      */   }
/*      */   public YMCAOnlineFormBean getYmcaOnlineFormBean() {
/*  939 */     return this.ymcaOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setYmcaOnlineFormBean(YMCAOnlineFormBean ymcaOnlineFormBean) {
/*  943 */     this.ymcaOnlineFormBean = ymcaOnlineFormBean;
/*      */   }
/*      */   public void setGpullaReadyFormBean(GpullaReadyFormBean gpullaReadyFormBean) {
/*  946 */     this.gpullaReadyFormBean = gpullaReadyFormBean;
/*      */   }
/*      */   public WBUTUniversityFormBean getWbutUniversityFormBean() {
/*  949 */     return this.wbutUniversityFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setWbutUniversityFormBean(WBUTUniversityFormBean wbutUniversityFormBean) {
/*  954 */     this.wbutUniversityFormBean = wbutUniversityFormBean;
/*      */   }
/*      */   
/*      */   public IMSUniversityFormBean getImsUniversityFormBean() {
/*  958 */     return this.imsUniversityFormBean;
/*      */   }
/*      */   
/*      */   public void setImsUniversityFormBean(IMSUniversityFormBean imsUniversityFormBean) {
/*  962 */     this.imsUniversityFormBean = imsUniversityFormBean;
/*      */   }
/*      */   public IITBActionFormBean getIitbData() {
/*  965 */     return this.iitbData;
/*      */   }
/*      */   
/*      */   public void setIitbData(IITBActionFormBean iitbData) {
/*  969 */     this.iitbData = iitbData;
/*      */   }
/*      */   
/*      */   public RamaCollageFormBean getRamaData() {
/*  973 */     return this.ramaData;
/*      */   }
/*      */   
/*      */   public void setRamaData(RamaCollageFormBean ramaData) {
/*  977 */     this.ramaData = ramaData;
/*      */   }
/*      */   public UnisonFormBean getUnisonFormBean() {
/*  980 */     return this.unisonFormBean;
/*      */   }
/*      */   
/*      */   public void setUnisonFormBean(UnisonFormBean unisonFormBean) {
/*  984 */     this.unisonFormBean = unisonFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public EtoosOnlineFormBean getEtoosOnlineFormBean() {
/*  989 */     return this.etoosOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setEtoosOnlineFormBean(EtoosOnlineFormBean etoosOnlineFormBean) {
/*  993 */     this.etoosOnlineFormBean = etoosOnlineFormBean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Map getStudentData() {
/*  999 */     return this.studentData;
/*      */   }
/*      */   
/*      */   public void setStudentData(Map studentData) {
/* 1003 */     this.studentData = studentData;
/*      */   }
/*      */   
/*      */   public GNLULoginActionFormBean getGnluData() {
/* 1007 */     return this.gnluData;
/*      */   }
/*      */   
/*      */   public void setGnluData(GNLULoginActionFormBean gnluData) {
/* 1011 */     this.gnluData = gnluData;
/*      */   }
/*      */   
/*      */   public DAVSchoolOnlineFormBean getDavschoolOnlineFormBean() {
/* 1015 */     return this.davschoolOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setDavschoolOnlineFormBean(DAVSchoolOnlineFormBean davschoolOnlineFormBean) {
/* 1019 */     this.davschoolOnlineFormBean = davschoolOnlineFormBean;
/*      */   }
/*      */ 
/*      */   
/* 1023 */   private InstituteConfigBean instituteConfigBean = new InstituteConfigBean();
/* 1024 */   FeesPayChargesFormBean feesPayChargesFormBean = new FeesPayChargesFormBean(); private List<String> feesPayList; private PaymentRequestBean appData1; private String strPaymentType; private DronacharyaOnlineFormBean dronacharyaOnlineFormBean;
/*      */   private DronacharyaGOIOnlineFormBean dronacharyaGOIOnlineFormBean;
/*      */   private AlmAcademyOnlineFormBean almAcademyOnlineFormBean;
/*      */   private HisarSchoolOnlineFormBean hisarSchoolOnlineFormBean;
/*      */   
/*      */   public String getStrPaymentType() {
/* 1030 */     return this.strPaymentType;
/*      */   }
/*      */   
/*      */   public void setStrPaymentType(String strPaymentType) {
/* 1034 */     this.strPaymentType = strPaymentType;
/*      */   }
/*      */   
/*      */   public PaymentRequestBean getAppData1() {
/* 1038 */     return this.appData1;
/*      */   }
/*      */   
/*      */   public void setAppData1(PaymentRequestBean appData1) {
/* 1042 */     this.appData1 = appData1;
/*      */   }
/*      */   
/*      */   public List<String> getFeesPayList() {
/* 1046 */     return this.feesPayList;
/*      */   }
/*      */   
/*      */   public void setFeesPayList(List<String> feesPayList) {
/* 1050 */     this.feesPayList = feesPayList;
/*      */   }
/*      */   
/*      */   public InstituteConfigBean getInstituteConfigBean() {
/* 1054 */     return this.instituteConfigBean;
/*      */   }
/*      */   
/*      */   public void setInstituteConfigBean(InstituteConfigBean instituteConfigBean) {
/* 1058 */     this.instituteConfigBean = instituteConfigBean;
/*      */   }
/*      */   
/*      */   public BhuLoginActionFormBean getBhuData() {
/* 1062 */     return this.bhuData;
/*      */   }
/*      */   
/*      */   public void setBhuData(BhuLoginActionFormBean bhuData) {
/* 1066 */     this.bhuData = bhuData;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDelstudentId() {
/* 1072 */     return this.delstudentId;
/*      */   }
/*      */   
/*      */   public void setDelstudentId(String delstudentId) {
/* 1076 */     this.delstudentId = delstudentId;
/*      */   }
/*      */   
/*      */   public String getStudentName() {
/* 1080 */     return this.studentName;
/*      */   }
/*      */   
/*      */   public void setStudentName(String studentName) {
/* 1084 */     this.studentName = studentName;
/*      */   }
/*      */   
/*      */   public StudentRegistrationFormBean getStudentRegistrationFormBean() {
/* 1088 */     return this.studentRegistrationFormBean;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setStudentRegistrationFormBean(StudentRegistrationFormBean studentRegistrationFormBean) {
/* 1093 */     this.studentRegistrationFormBean = studentRegistrationFormBean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, StudentRegistrationFormBean> getStudentDataMap() {
/* 1100 */     return this.studentDataMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setStudentDataMap(Map<String, StudentRegistrationFormBean> studentDataMap) {
/* 1107 */     this.studentDataMap = studentDataMap;
/*      */   }
/*      */   
/*      */   public StudentRegistrationFormBean getAppData() {
/* 1111 */     return this.appData;
/*      */   }
/*      */   
/*      */   public void setAppData(StudentRegistrationFormBean appData) {
/* 1115 */     this.appData = appData;
/*      */   }
/*      */   
/*      */   public CourseDetailsBean getCourseData() {
/* 1119 */     return this.courseData;
/*      */   }
/*      */   
/*      */   public String getStudentId() {
/* 1123 */     return this.studentId;
/*      */   }
/*      */   
/*      */   public void setStudentId(String studentId) {
/* 1127 */     this.studentId = studentId;
/*      */   }
/*      */   
/*      */   public void setCourseData(CourseDetailsBean courseData) {
/* 1131 */     this.courseData = courseData;
/*      */   }
/*      */   public String getStudentRegistrationId() {
/* 1134 */     return this.studentRegistrationId;
/*      */   }
/*      */   
/*      */   public void setStudentRegistrationId(String studentRegistrationId) {
/* 1138 */     this.studentRegistrationId = studentRegistrationId;
/*      */   }
/*      */   public HNBGUFormBean getHNBGUFormBean() {
/* 1141 */     return this.HNBGUFormBean;
/*      */   }
/*      */   
/*      */   public void setHNBGUFormBean(HNBGUFormBean hNBGUFormBean) {
/* 1145 */     this.HNBGUFormBean = hNBGUFormBean;
/*      */   }
/*      */   
/*      */   public IceonlineFormBean getIceFormBean() {
/* 1149 */     return this.iceFormBean;
/*      */   }
/*      */   public void setIceFormBean(IceonlineFormBean iceFormBean) {
/* 1152 */     this.iceFormBean = iceFormBean;
/*      */   }
/*      */   
/*      */   public IEIIndiaOnlineFormBean getIeiIndiaFormBean() {
/* 1156 */     return this.ieiIndiaFormBean;
/*      */   }
/*      */   public void setIeiIndiaFormBean(IEIIndiaOnlineFormBean ieiIndiaFormBean) {
/* 1159 */     this.ieiIndiaFormBean = ieiIndiaFormBean;
/*      */   }
/*      */   
/*      */   public BhartiConceptFormBean getBhartiConceptFormBean() {
/* 1163 */     return this.bhartiConceptFormBean;
/*      */   }
/*      */   public void setBhartiConceptFormBean(BhartiConceptFormBean bhartiConceptFormBean) {
/* 1166 */     this.bhartiConceptFormBean = bhartiConceptFormBean;
/*      */   }
/*      */   public TrinityOnlineFormBean getTrinityOnlineFormBean() {
/* 1169 */     return this.trinityOnlineFormBean;
/*      */   }
/*      */   public void setTrinityOnlineFormBean(TrinityOnlineFormBean trinityOnlineFormBean) {
/* 1172 */     this.trinityOnlineFormBean = trinityOnlineFormBean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NavJagritiOnlineFormBean getNavJagritiBean() {
/* 1182 */     return this.navJagritiBean;
/*      */   }
/*      */   public void setNavJagritiBean(NavJagritiOnlineFormBean navJagritiBean) {
/* 1185 */     this.navJagritiBean = navJagritiBean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String loadStudentDetails() {
/* 1191 */     setStudentDataMap(fetchRegStudents());
/* 1192 */     logger.info("getStudentDataMap():\t" + getStudentDataMap().size());
/* 1193 */     return EDIT_STUDENT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String editStudentDetails() {
/* 1201 */     logger.info("~~~~~~~~~ " + getStudentId() + " ~~~~~~~~~~");
/* 1202 */     logger.info("studentId():\t" + this.studentId);
/* 1203 */     StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 1204 */     getAppData().setStrID(getStudentId());
/* 1205 */     String responseString = studentRegistrationService.editStudentDetails(getAppData());
/* 1206 */     if (responseString != null && !"".equalsIgnoreCase(responseString)) {
/* 1207 */       addActionMessage(ErrorPropertyReader.getProperty("student.data.updated.successfully"));
/*      */     } else {
/* 1209 */       addActionError(ErrorPropertyReader.getProperty("failed.to.update.student.data"));
/* 1210 */       return "success";
/*      */     } 
/* 1212 */     setStudentDataMap(fetchRegStudents());
/* 1213 */     logger.info("getStudentDataMap():\t" + getStudentDataMap().size());
/*      */     
/* 1215 */     setAppData((StudentRegistrationFormBean)null);
/* 1216 */     setStudentId("");
/* 1217 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String load() {
/* 1225 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1226 */     CourseDetailsService courseDetailsService = new CourseDetailsService();
/* 1227 */     Map instituteBranchMap = courseDetailsService.getBillerBranchList(billerId);
/* 1228 */     if (instituteBranchMap != null && !instituteBranchMap.isEmpty()) {
/*      */ 
/*      */       
/* 1231 */       getCourseData().setMapInstituteBranchList(instituteBranchMap);
/* 1232 */       if (instituteBranchMap.size() == 1) {
/* 1233 */         logger.info("Institute Branch Size is 1 ...so taking default branch");
/* 1234 */         getCourseData().setMapCourseList(courseDetailsService.getCourseList(billerId, "Q"));
/*      */       } 
/*      */     } else {
/* 1237 */       logger.info("branch MAP is empty");
/*      */     } 
/* 1239 */     getUserSessionMap().put("COURSEDATA", getCourseData());
/* 1240 */     return REGISTER_STUDENT;
/*      */   }
/*      */ 
/*      */   
/*      */   public String loadAddStudent() {
/* 1245 */     InstituteMasterFormBean instituteMasterFormBean = (InstituteMasterFormBean)getUserSessionMap().get("INSTDATA");
/* 1246 */     if ("true".equalsIgnoreCase("true")) {
/* 1247 */       return FJAction.ASSOCIATE_STUDENT;
/*      */     }
/* 1249 */     logger.info("Am Inside Add new Student");
/* 1250 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1251 */     CourseDetailsService courseDetailsService = new CourseDetailsService();
/* 1252 */     Map instituteBranchMap = courseDetailsService.getBillerBranchList(billerId);
/* 1253 */     if (instituteBranchMap != null && !instituteBranchMap.isEmpty()) {
/*      */ 
/*      */       
/* 1256 */       getCourseData().setMapInstituteBranchList(instituteBranchMap);
/* 1257 */       if (instituteBranchMap.size() == 1) {
/* 1258 */         logger.info("Institute Branch Size is 1 ...so taking default branch");
/* 1259 */         getCourseData().setMapCourseList(courseDetailsService.getCourseList(billerId, "Q"));
/*      */       } 
/*      */     } else {
/* 1262 */       logger.info("branch MAP is empty");
/*      */     } 
/* 1264 */     getUserSessionMap().put("COURSEDATA", getCourseData());
/* 1265 */     return ADD_STUDENT;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String studentRegistration() {
/* 1271 */     if (!isValidSession()) {
/* 1272 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 1275 */       logger.info("---------------------------------------------------------");
/* 1276 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 1277 */       logger.info("---------------------------------------------------------");
/* 1278 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1279 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1280 */       getAppData().setStudentRegistrationId(registeredUserId);
/* 1281 */       getAppData().setStudentAlias(getAppData().getStudentName());
/* 1282 */       setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/* 1283 */       getUserSessionMap().put("APPDATA", getAppData());
/* 1284 */       getAppData();
/* 1285 */       logger.info("AppData:\t" + getCourseData().getMapCourseList());
/*      */       
/* 1287 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 1289 */       String responseString = studentRegistrationService.insertStudentDetails(getAppData());
/* 1290 */       if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 1291 */       { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 1292 */       else { if ("NA".equalsIgnoreCase(responseString)) {
/* 1293 */           addActionError(ErrorPropertyReader.getProperty("no.course.configured.select.another.combination"));
/* 1294 */           return "failure";
/*      */         } 
/* 1296 */         addActionError(ErrorPropertyReader.getProperty("failed.to.add.student.data"));
/* 1297 */         return "failure"; }
/*      */       
/* 1299 */       return "success";
/*      */     }
/* 1301 */     catch (Exception e) {
/* 1302 */       logger.error("Exception  " + e);
/* 1303 */       return "error";
/*      */     } 
/*      */   }
/*      */   
/*      */   public String loadViewStudentDetails1() {
/* 1308 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1309 */     CourseDetailsService courseDetailsService = new CourseDetailsService();
/* 1310 */     Map instituteBranchMap = courseDetailsService.getBillerBranchList(billerId);
/* 1311 */     if (instituteBranchMap != null && !instituteBranchMap.isEmpty()) {
/*      */       
/* 1313 */       getCourseData().setMapInstituteBranchList(instituteBranchMap);
/* 1314 */       if (instituteBranchMap.size() == 1) {
/* 1315 */         logger.info("Institute Branch Size is 1 ...so taking default branch");
/* 1316 */         getCourseData().setMapCourseList(courseDetailsService.getCourseList(billerId, "Q"));
/*      */       } 
/* 1318 */       getUserSessionMap().put("COURSEDATA", getCourseData());
/* 1319 */       setStudentDataMap(fetchRegStudents());
/* 1320 */       getUserSessionMap().put("_studentDataMap", getStudentDataMap());
/* 1321 */       return "success";
/*      */     } 
/* 1323 */     logger.info("branch MAP is empty");
/* 1324 */     addActionError("There is no configuration available");
/*      */     
/* 1326 */     return "success";
/*      */   }
/*      */   
/*      */   public String deleteStudentRegistration() throws Exception {
/* 1330 */     logger.info("@@@@@@@@@Before Going to Delete###############");
/* 1331 */     StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 1332 */     String key = studentRegistrationService.deleteStudentDetails(getStudentId());
/*      */     
/* 1334 */     if (key != null && key.equalsIgnoreCase("Successfully Deleted")) {
/* 1335 */       addActionMessage(ErrorPropertyReader.getProperty("student.data.deleted.successfully"));
/*      */     } else {
/* 1337 */       addActionError(ErrorPropertyReader.getProperty("failed.to.delete.student.data"));
/*      */       
/* 1339 */       return "success";
/*      */     } 
/* 1341 */     setStudentDataMap(fetchRegStudents());
/*      */     
/* 1343 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String cancel() {
/* 1348 */     InstituteMasterFormBean instituteMasterFormBean = (InstituteMasterFormBean)getUserSessionMap().get("INSTDATA");
/* 1349 */     if ("true".equalsIgnoreCase("true")) {
/* 1350 */       return FJAction.ASSOCIATE_STUDENT;
/*      */     }
/* 1352 */     return FJAction.ADD_STUDENT;
/*      */   }
/*      */ 
/*      */   
/*      */   public String studentAssociation() {
/* 1357 */     logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/* 1358 */     logger.info("this.getStudentRegistrationId() : - " + getStudentRegistrationId());
/* 1359 */     logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/* 1360 */     FJBean fjBean = (FJBean)getUserSessionMap().get("BASEDATA");
/* 1361 */     logger.info("fjBean.getRegisteredUserId() : - " + fjBean.getRegisteredUserId());
/* 1362 */     logger.info("fjBean.getLoginID() : - " + fjBean.getLoginID());
/* 1363 */     logger.info("fjBean.getBillerId() : - " + fjBean.getBillerId());
/* 1364 */     StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */     
/* 1366 */     String statusUpdate = "success";
/* 1367 */     if ("success".equalsIgnoreCase(statusUpdate)) {
/* 1368 */       addActionMessage("Student Associated successfully...");
/*      */     } else {
/* 1370 */       addActionError("failure while associating the student");
/*      */     } 
/* 1372 */     return FJAction.ASSOCIATE_STUDENT;
/*      */   }
/*      */   
/*      */   public String studentAssociation1() {
/* 1376 */     logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/* 1377 */     logger.info("this.getStudentRegistrationId() : - " + getStudentRegistrationId());
/* 1378 */     logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
/* 1379 */     FJBean fjBean = (FJBean)getUserSessionMap().get("BASEDATA");
/* 1380 */     logger.info("fjBean.getRegisteredUserId() : - " + fjBean.getRegisteredUserId());
/* 1381 */     logger.info("fjBean.getLoginID() : - " + fjBean.getLoginID());
/* 1382 */     logger.info("fjBean.getBillerId() : - " + fjBean.getBillerId());
/* 1383 */     StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 1384 */     String statusUpdate = studentRegistrationService.associateStudent(getStudentRegistrationId(), fjBean.getRegisteredUserId(), fjBean.getLoginID());
/*      */ 
/*      */     
/* 1387 */     setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/*      */     
/* 1389 */     this.studentRegistrationFormBean = getRegisteredStudentDetails(getStudentRegistrationId());
/* 1390 */     this.studentName = this.studentRegistrationFormBean.getStudentFirstName();
/*      */     
/* 1392 */     if ("success".equalsIgnoreCase(statusUpdate)) {
/* 1393 */       addActionMessage("Student Associated successfully...");
/*      */     } else {
/* 1395 */       addActionError("failure while associating the student");
/*      */     } 
/* 1397 */     return "success";
/*      */   }
/*      */   
/*      */   public String memberRegistration() {
/* 1401 */     if (!isValidSession()) {
/* 1402 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 1405 */       logger.info("ParticipantName : - " + getBhuData().getParticipantName());
/* 1406 */       logger.info("---------------------------------------------------------");
/* 1407 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 1408 */       logger.info("---------------------------------------------------------");
/* 1409 */       this.instituteConfigBean = (InstituteConfigBean)getUserSessionMap().get("INSTCONFIG");
/* 1410 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1411 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1412 */       getBhuData().setRegisteredUserId(registeredUserId);
/* 1413 */       setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/* 1414 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 1415 */       String responseString = studentRegistrationService.insertMemberRegDetails(getBhuData());
/*      */       
/* 1417 */       if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 1418 */         addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/*      */       } else {
/* 1420 */         if (responseString.equalsIgnoreCase("AE")) {
/* 1421 */           LoginActionService loginActionService = new LoginActionService();
/* 1422 */           this.studentData = null;
/* 1423 */           setStudentData(loginActionService.getMember_Flag());
/* 1424 */           addActionError(getText("member.id.already.exist"));
/* 1425 */           return FJAction.BHUHOME;
/*      */         } 
/* 1427 */         addActionError(getText("error.occured.contact.administrator"));
/*      */       } 
/*      */       
/* 1430 */       this.studentRegistrationFormBean = getRegisteredStudentDetails(getBhuData().getStudentRegistrationId());
/* 1431 */       this.studentRegistrationFormBean.setTotalPayableFees(getBhuData().getTot_Amt1());
/* 1432 */       this.studentRegistrationFormBean.setStudentId(getBhuData().getParticipantIOSNo());
/*      */       
/* 1434 */       applyFees(this.studentRegistrationFormBean);
/*      */       
/* 1436 */       QuickPayAction quickPayAction = new QuickPayAction();
/* 1437 */       this.appData1 = new PaymentRequestBean();
/* 1438 */       this.appData1.setStudentRegistrationId(getBhuData().getStudentRegistrationId());
/*      */       
/* 1440 */       quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */       
/* 1442 */       getUserSessionMap().put("APPDATA", getAppData1());
/*      */     
/*      */     }
/* 1445 */     catch (Exception e) {
/* 1446 */       logger.error("Exception  " + e);
/* 1447 */       return "error";
/*      */     } 
/* 1449 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1450 */     this.strPaymentType = "Online Payment";
/*      */     
/* 1452 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 1453 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 1455 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 1457 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 1459 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 1461 */     return FJAction.MEMSUCCESS;
/*      */   }
/*      */   
/*      */   public String gnluRegistration() {
/* 1465 */     if (!isValidSession()) {
/* 1466 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 1469 */       logger.info("---------------------------------------------------------");
/* 1470 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 1471 */       logger.info("---------------------------------------------------------");
/* 1472 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1473 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1474 */       getGnluData().setRegisteredUserId(registeredUserId);
/* 1475 */       setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/* 1476 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 1478 */       addStudentPhotos();
/* 1479 */       String responseString = studentRegistrationService.insertGNLUStudentDetails(getGnluData());
/*      */       
/* 1481 */       if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 1482 */         addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/*      */       } else {
/* 1484 */         if (responseString.equalsIgnoreCase("AE")) {
/* 1485 */           LoginActionService loginActionService = new LoginActionService();
/* 1486 */           this.studentData = null;
/* 1487 */           setStudentData(loginActionService.getGnlu_category());
/* 1488 */           addActionError(getText("member.id.already.exist"));
/* 1489 */           return FJAction.GNLUHOME;
/*      */         } 
/* 1491 */         addActionError(getText("error.occured.contact.administrator"));
/*      */       } 
/*      */       
/* 1494 */       this.studentRegistrationFormBean = getRegisteredStudentDetails(getGnluData().getStudentRegistrationId());
/* 1495 */       this.studentRegistrationFormBean.setTotalPayableFees(getGnluData().getAmt1());
/* 1496 */       this.studentRegistrationFormBean.setStudentId(getGnluData().getRegistrationNo());
/* 1497 */       applyFees(this.studentRegistrationFormBean);
/*      */       
/* 1499 */       QuickPayAction quickPayAction = new QuickPayAction();
/* 1500 */       this.appData1 = new PaymentRequestBean();
/* 1501 */       this.appData1.setStudentRegistrationId(getGnluData().getStudentRegistrationId());
/*      */       
/* 1503 */       quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */       
/* 1505 */       getUserSessionMap().put("APPDATA", getAppData1());
/*      */ 
/*      */     
/*      */     }
/* 1509 */     catch (Exception e) {
/* 1510 */       logger.error("Exception  " + e);
/* 1511 */       return "error";
/*      */     } 
/* 1513 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1514 */     this.strPaymentType = "Online Payment";
/*      */     
/* 1516 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 1517 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 1519 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 1521 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 1523 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 1525 */     return FJAction.GNLUSUCCESS;
/*      */   }
/*      */ 
/*      */   
/*      */   public String addStudentPhotos() throws IOException {
/* 1530 */     boolean flag = false;
/* 1531 */     String headerImg = "";
/* 1532 */     String logoImg_FJG = "";
/* 1533 */     String logoImg_FJGA = "";
/* 1534 */     String destination = "";
/* 1535 */     String osName = System.getProperty("os.name");
/* 1536 */     if ("LINUX".equalsIgnoreCase(osName.trim())) {
/* 1537 */       destination = "/opt/jboss-eap-6.0/standalone/deployments/XJunction.war/StudentPhotos";
/*      */     } else {
/* 1539 */       destination = "C:/WorkSpace_for_UploadPhotos/StudentUploadPhotos/WebContent/StudentPhotos";
/*      */     } 
/*      */     
/* 1542 */     if (getGnluData().getHeaderImagfile() != null) {
/*      */       
/* 1544 */       getGnluData().setStoreHeaderFile(saveUploadedFile(getGnluData().getHeaderImagfile(), 
/* 1545 */             getGnluData().getHeaderImagfileFileName(), 
/* 1546 */             getGnluData().getRegistrationNo(), 
/* 1547 */             "SI_" + getGnluData().getStdFirstName(), 
/* 1548 */             TPSLConstants.FJA_STATIC_IMAGE_CONTENT_PATH));
/*      */       
/* 1550 */       saveUploadedFile(getGnluData().getHeaderImagfile(), 
/* 1551 */           getGnluData().getHeaderImagfileFileName(), 
/* 1552 */           getGnluData().getRegistrationNo(), 
/* 1553 */           "SI_" + getGnluData().getStdFirstName(), 
/* 1554 */           destination);
/* 1555 */       getGnluData().setPhoto_Self(getGnluData().getStoreHeaderFile().getName());
/* 1556 */     }  if (getGnluData().getPassportImagfile() != null) {
/*      */       
/* 1558 */       getGnluData().setStoreHeaderFile(saveUploadedFile(getGnluData().getPassportImagfile(), 
/* 1559 */             getGnluData().getPassportImagfileFileName(), 
/* 1560 */             getGnluData().getRegistrationNo(), 
/* 1561 */             "PI_" + getGnluData().getStdFirstName(), 
/* 1562 */             TPSLConstants.FJA_STATIC_IMAGE_CONTENT_PATH));
/*      */       
/* 1564 */       saveUploadedFile(getGnluData().getPassportImagfile(), 
/* 1565 */           getGnluData().getPassportImagfileFileName(), 
/* 1566 */           getGnluData().getRegistrationNo(), 
/* 1567 */           "PI_" + getGnluData().getStdFirstName(), 
/* 1568 */           destination);
/* 1569 */       getGnluData().setPhoto_Proof(getGnluData().getStoreHeaderFile().getName());
/*      */     } 
/* 1571 */     return "success";
/*      */   }
/*      */   
/*      */   public String addStudentPhotosForIIITB(String billerId) throws IOException {
/* 1575 */     boolean flag = false;
/* 1576 */     String destination = "";
/* 1577 */     long uniqueTime = System.currentTimeMillis();
/* 1578 */     String osName = System.getProperty("os.name");
/* 1579 */     if ("LINUX".equalsIgnoreCase(osName.trim())) {
/* 1580 */       destination = "/opt/jboss-eap-6.0/standalone/deployments/XJunction.war/StudentPhotos";
/*      */     } else {
/* 1582 */       destination = "C:/WorkSpace_for_UploadPhotos/StudentUploadPhotos/WebContent/StudentPhotos";
/*      */     } 
/* 1584 */     if (getIitbData().getPassportImagfile() != null) {
/*      */       
/* 1586 */       getIitbData().setStoreHeaderFile(saveUploadedFile(getIitbData().getPassportImagfile(), 
/* 1587 */             getIitbData().getPassportImagfileFileName(), 
/* 1588 */             billerId, 
/* 1589 */             "IIITB_" + uniqueTime, 
/* 1590 */             TPSLConstants.FJA_STATIC_IMAGE_CONTENT_PATH));
/*      */       
/* 1592 */       saveUploadedFile(getIitbData().getPassportImagfile(), 
/* 1593 */           getIitbData().getPassportImagfileFileName(), 
/* 1594 */           billerId, 
/* 1595 */           "IIITB_" + uniqueTime, 
/* 1596 */           destination);
/* 1597 */       getIitbData().setPhoto_Proof(getIitbData().getStoreHeaderFile().getName());
/*      */     } 
/* 1599 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String addStudentPhotosForYMCA(String billerId) throws IOException {
/* 1604 */     String destination = "";
/* 1605 */     String osName = System.getProperty("os.name");
/* 1606 */     if ("LINUX".equalsIgnoreCase(osName.trim())) {
/* 1607 */       destination = "/opt/jboss-eap-6.0/standalone/deployments/XJunction.war/StudentPhotos";
/*      */     } else {
/* 1609 */       destination = "C:/WorkSpace_for_UploadPhotos/StudentUploadPhotos/WebContent/StudentPhotos";
/*      */     } 
/*      */     
/* 1612 */     if (getYmcaOnlineFormBean().getPassportImagfile() != null) {
/*      */       
/* 1614 */       long uniqueTime = System.currentTimeMillis();
/* 1615 */       getYmcaOnlineFormBean().setStoreHeaderFile(saveUploadedFile(getYmcaOnlineFormBean().getPassportImagfile(), 
/* 1616 */             getYmcaOnlineFormBean().getPassportImagfileFileName(), 
/* 1617 */             billerId, 
/* 1618 */             "YMCAP_" + uniqueTime, 
/* 1619 */             TPSLConstants.FJA_STATIC_IMAGE_CONTENT_PATH));
/*      */       
/* 1621 */       saveUploadedFile(getYmcaOnlineFormBean().getPassportImagfile(), 
/* 1622 */           getYmcaOnlineFormBean().getPassportImagfileFileName(), 
/* 1623 */           billerId, 
/* 1624 */           "YMCAP_" + uniqueTime, 
/* 1625 */           destination);
/* 1626 */       getYmcaOnlineFormBean().setPhoto_Proof(getYmcaOnlineFormBean().getStoreHeaderFile().getName());
/*      */     } 
/* 1628 */     if (getYmcaOnlineFormBean().getCastCertImagfile() != null) {
/*      */       
/* 1630 */       long uniqueTime1 = System.currentTimeMillis();
/* 1631 */       getYmcaOnlineFormBean().setStoreHeaderFile(saveUploadedFile(getYmcaOnlineFormBean().getCastCertImagfile(), 
/* 1632 */             getYmcaOnlineFormBean().getCastCertImagfileFileName(), 
/* 1633 */             billerId, 
/* 1634 */             "CAST_" + uniqueTime1, 
/* 1635 */             TPSLConstants.FJA_STATIC_IMAGE_CONTENT_PATH));
/*      */       
/* 1637 */       saveUploadedFile(getYmcaOnlineFormBean().getCastCertImagfile(), 
/* 1638 */           getYmcaOnlineFormBean().getCastCertImagfileFileName(), 
/* 1639 */           billerId, 
/* 1640 */           "CAST_" + uniqueTime1, 
/* 1641 */           destination);
/* 1642 */       getYmcaOnlineFormBean().setCastCert_Proof(getYmcaOnlineFormBean().getStoreHeaderFile().getName());
/*      */     } 
/* 1644 */     if (getYmcaOnlineFormBean().getSignImagfile() != null) {
/*      */       
/* 1646 */       long uniqueTime1 = System.currentTimeMillis();
/* 1647 */       getYmcaOnlineFormBean().setStoreHeaderFile(saveUploadedFile(getYmcaOnlineFormBean().getSignImagfile(), 
/* 1648 */             getYmcaOnlineFormBean().getSignImagfileFileName(), 
/* 1649 */             billerId, 
/* 1650 */             "Sign_" + uniqueTime1, 
/* 1651 */             TPSLConstants.FJA_STATIC_IMAGE_CONTENT_PATH));
/*      */       
/* 1653 */       saveUploadedFile(getYmcaOnlineFormBean().getSignImagfile(), 
/* 1654 */           getYmcaOnlineFormBean().getSignImagfileFileName(), 
/* 1655 */           billerId, 
/* 1656 */           "Sign_" + uniqueTime1, 
/* 1657 */           destination);
/* 1658 */       getYmcaOnlineFormBean().setSign_Proof(getYmcaOnlineFormBean().getStoreHeaderFile().getName());
/*      */     } 
/* 1660 */     return "success";
/*      */   }
/*      */   
/*      */   public String addStudentPhotosForHARYANA(String billerId) throws IOException {
/* 1664 */     String destination = "";
/* 1665 */     String osName = System.getProperty("os.name");
/* 1666 */     if ("LINUX".equalsIgnoreCase(osName.trim())) {
/* 1667 */       destination = "/opt/jboss-eap-6.0/standalone/deployments/XJunction.war/StudentPhotos";
/*      */     } else {
/* 1669 */       destination = "C:/WorkSpace_for_UploadPhotos/StudentUploadPhotos/WebContent/StudentPhotos";
/*      */     } 
/* 1671 */     if (getHaryanaFormBean().getPassportImagfile() != null) {
/*      */       
/* 1673 */       long uniqueTime1 = System.currentTimeMillis();
/* 1674 */       getHaryanaFormBean().setStoreHeaderFile(saveUploadedFile(getHaryanaFormBean().getPassportImagfile(), 
/* 1675 */             getHaryanaFormBean().getPassportImagfileFileName(), 
/* 1676 */             billerId, 
/* 1677 */             "Cuoh_" + uniqueTime1, 
/* 1678 */             TPSLConstants.FJA_STATIC_IMAGE_CONTENT_PATH));
/*      */       
/* 1680 */       saveUploadedFile(getHaryanaFormBean().getPassportImagfile(), 
/* 1681 */           getHaryanaFormBean().getPassportImagfileFileName(), 
/* 1682 */           billerId, 
/* 1683 */           "Cuoh_" + uniqueTime1, 
/* 1684 */           destination);
/* 1685 */       getHaryanaFormBean().setPhoto_upload(getHaryanaFormBean().getStoreHeaderFile().getName());
/*      */     } 
/* 1687 */     if (getHaryanaFormBean().getSignImagfile() != null) {
/*      */       
/* 1689 */       long uniqueTime1 = System.currentTimeMillis();
/* 1690 */       getHaryanaFormBean().setStoreHeaderFile(saveUploadedFile(getHaryanaFormBean().getSignImagfile(), 
/* 1691 */             getHaryanaFormBean().getSignImagfileFileName(), 
/* 1692 */             billerId, 
/* 1693 */             "Sign_" + uniqueTime1, 
/* 1694 */             TPSLConstants.FJA_STATIC_IMAGE_CONTENT_PATH));
/*      */       
/* 1696 */       saveUploadedFile(getHaryanaFormBean().getSignImagfile(), 
/* 1697 */           getHaryanaFormBean().getSignImagfileFileName(), 
/* 1698 */           billerId, 
/* 1699 */           "Sign_" + uniqueTime1, 
/* 1700 */           destination);
/* 1701 */       getHaryanaFormBean().setSignature_upload(getHaryanaFormBean().getStoreHeaderFile().getName());
/*      */     } 
/* 1703 */     if (getHaryanaFormBean().getEsmCertImagfile() != null) {
/*      */       
/* 1705 */       long uniqueTime1 = System.currentTimeMillis();
/* 1706 */       getHaryanaFormBean().setStoreHeaderFile(saveUploadedFile(getHaryanaFormBean().getEsmCertImagfile(), 
/* 1707 */             getHaryanaFormBean().getEsmCertImagfileFileName(), 
/* 1708 */             billerId, 
/* 1709 */             "Marks_" + uniqueTime1, 
/* 1710 */             TPSLConstants.FJA_STATIC_IMAGE_CONTENT_PATH));
/*      */       
/* 1712 */       saveUploadedFile(getHaryanaFormBean().getEsmCertImagfile(), 
/* 1713 */           getHaryanaFormBean().getEsmCertImagfileFileName(), 
/* 1714 */           billerId, 
/* 1715 */           "Marks_" + uniqueTime1, 
/* 1716 */           destination);
/* 1717 */       getHaryanaFormBean().setMarksheet_upload(getHaryanaFormBean().getStoreHeaderFile().getName());
/*      */     } 
/*      */     
/* 1720 */     return "success";
/*      */   }
/*      */   
/*      */   public String addStudentPhotosForBengal(String billerId) throws IOException {
/* 1724 */     String destination = "";
/* 1725 */     String osName = System.getProperty("os.name");
/* 1726 */     if ("LINUX".equalsIgnoreCase(osName.trim())) {
/* 1727 */       destination = "/opt/jboss-eap-6.0/standalone/deployments/XJunction.war/StudentPhotos";
/*      */     } else {
/* 1729 */       destination = "C:/WorkSpace_for_UploadPhotos/StudentUploadPhotos/WebContent/StudentPhotos";
/*      */     } 
/*      */     
/* 1732 */     if (getBengalCollegeOnlineFormBean().getPassportImagfile() != null) {
/*      */       
/* 1734 */       long uniqueTime = System.currentTimeMillis();
/* 1735 */       getBengalCollegeOnlineFormBean().setStoreHeaderFile(saveUploadedFile(getBengalCollegeOnlineFormBean().getPassportImagfile(), 
/* 1736 */             getBengalCollegeOnlineFormBean().getPassportImagfileFileName(), 
/* 1737 */             billerId, 
/* 1738 */             "BCP_" + uniqueTime, 
/* 1739 */             TPSLConstants.FJA_STATIC_IMAGE_CONTENT_PATH));
/*      */       
/* 1741 */       saveUploadedFile(getBengalCollegeOnlineFormBean().getPassportImagfile(), 
/* 1742 */           getBengalCollegeOnlineFormBean().getPassportImagfileFileName(), 
/* 1743 */           billerId, 
/* 1744 */           "BCP_" + uniqueTime, 
/* 1745 */           destination);
/* 1746 */       getBengalCollegeOnlineFormBean().setPhotoProof(getBengalCollegeOnlineFormBean().getStoreHeaderFile().getName());
/*      */     } 
/* 1748 */     if (getBengalCollegeOnlineFormBean().getDocImagfile() != null) {
/*      */       
/* 1750 */       long uniqueTime = System.currentTimeMillis();
/* 1751 */       getBengalCollegeOnlineFormBean().setStoreHeaderFile(saveUploadedFile(getBengalCollegeOnlineFormBean().getDocImagfile(), 
/* 1752 */             getBengalCollegeOnlineFormBean().getDocImagfileFileName(), 
/* 1753 */             billerId, 
/* 1754 */             "BCD_" + uniqueTime, 
/* 1755 */             TPSLConstants.FJA_STATIC_IMAGE_CONTENT_PATH));
/*      */       
/* 1757 */       saveUploadedFile(getBengalCollegeOnlineFormBean().getDocImagfile(), 
/* 1758 */           getBengalCollegeOnlineFormBean().getDocImagfileFileName(), 
/* 1759 */           billerId, 
/* 1760 */           "BCD_" + uniqueTime, 
/* 1761 */           destination);
/* 1762 */       getBengalCollegeOnlineFormBean().setDocProof(getBengalCollegeOnlineFormBean().getStoreHeaderFile().getName());
/*      */     } 
/*      */     
/* 1765 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private File saveUploadedFile(File uploadfile, String uploadfile_name, String imageSection, String inst_name, String destinationDir) throws IOException {
/* 1774 */     String[] image_extension = uploadfile_name.split("\\.");
/* 1775 */     String file_path = String.valueOf(destinationDir) + File.separator + inst_name + "_" + imageSection + "." + image_extension[image_extension.length - 1];
/* 1776 */     File newFile = new File(file_path);
/* 1777 */     FileUtils.copyFile(uploadfile, newFile);
/* 1778 */     return newFile;
/*      */   }
/*      */   public String ramaRegistration() {
/* 1781 */     if (!isValidSession()) {
/* 1782 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 1785 */       logger.info("---------------------------------------------------------");
/* 1786 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 1787 */       logger.info("---------------------------------------------------------");
/* 1788 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1789 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1790 */       getRamaData().setRegisteredUserId(registeredUserId);
/* 1791 */       setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/* 1792 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 1793 */       String responseString = "";
/* 1794 */       String inst_code = (String)getUserSessionMap().get("_institutecode");
/* 1795 */       if ("3038".equalsIgnoreCase(inst_code)) {
/*      */         
/* 1797 */         responseString = studentRegistrationService.insertIITMStudentDetails(getRamaData(), str1);
/*      */       }
/*      */       else {
/*      */         
/* 1801 */         responseString = studentRegistrationService.insertRamaStudentDetails(getRamaData());
/*      */       } 
/* 1803 */       if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 1804 */         addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/*      */       } else {
/* 1806 */         if (responseString.equalsIgnoreCase("AE")) {
/* 1807 */           LoginActionService loginActionService = new LoginActionService();
/* 1808 */           this.studentData = null;
/* 1809 */           setStudentData(loginActionService.getRamaCollage_category());
/* 1810 */           addActionError(getText("member.id.already.exist"));
/* 1811 */           if ("3038".equalsIgnoreCase(inst_code))
/*      */           {
/* 1813 */             return "ramhome2";
/*      */           }
/*      */ 
/*      */           
/* 1817 */           return FJAction.RAMHOME;
/*      */         } 
/*      */         
/* 1820 */         addActionError(getText("error.occured.contact.administrator"));
/*      */       } 
/*      */       
/* 1823 */       this.studentRegistrationFormBean = getRegisteredStudentDetails(getRamaData().getStudentRegistrationId());
/* 1824 */       this.studentRegistrationFormBean.setTotalPayableFees(getRamaData().getAmt1());
/* 1825 */       this.studentRegistrationFormBean.setStudentId(getRamaData().getApplicationNo());
/* 1826 */       applyFees(this.studentRegistrationFormBean);
/*      */       
/* 1828 */       QuickPayAction quickPayAction = new QuickPayAction();
/* 1829 */       this.appData1 = new PaymentRequestBean();
/* 1830 */       this.appData1.setStudentRegistrationId(getRamaData().getStudentRegistrationId());
/*      */       
/* 1832 */       quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */       
/* 1834 */       getUserSessionMap().put("APPDATA", getAppData1());
/*      */ 
/*      */     
/*      */     }
/* 1838 */     catch (Exception e) {
/* 1839 */       logger.error("Exception  " + e);
/* 1840 */       return "error";
/*      */     } 
/* 1842 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1843 */     this.strPaymentType = "Online Payment";
/*      */     
/* 1845 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 1846 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 1848 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 1850 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 1852 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 1854 */     return FJAction.RAMASUCCESS;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String imsRegistration() {
/* 1860 */     if (!isValidSession()) {
/* 1861 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 1864 */       logger.info("---------------------------------------------------------");
/* 1865 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 1866 */       logger.info("---------------------------------------------------------");
/* 1867 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1868 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1869 */       getImsUniversityFormBean().setRegisteredUserId(registeredUserId);
/* 1870 */       setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/* 1871 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 1873 */       String responseString = studentRegistrationService.insertIMSStudentDetails(getImsUniversityFormBean());
/*      */       
/* 1875 */       if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 1876 */         addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/*      */       } else {
/*      */         
/* 1879 */         addActionError(getText("error.occured.contact.administrator"));
/*      */       } 
/*      */       
/* 1882 */       this.studentRegistrationFormBean = getRegisteredStudentDetails(getImsUniversityFormBean().getStudentRegistrationId());
/* 1883 */       this.studentRegistrationFormBean.setTotalPayableFees(getImsUniversityFormBean().getImsAppFee());
/* 1884 */       this.studentRegistrationFormBean.setStudentId(getImsUniversityFormBean().getApplicationNo());
/* 1885 */       applyFees(this.studentRegistrationFormBean);
/*      */       
/* 1887 */       QuickPayAction quickPayAction = new QuickPayAction();
/* 1888 */       this.appData1 = new PaymentRequestBean();
/* 1889 */       this.appData1.setStudentRegistrationId(getImsUniversityFormBean().getStudentRegistrationId());
/*      */       
/* 1891 */       quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */       
/* 1893 */       getUserSessionMap().put("APPDATA", getAppData1());
/*      */ 
/*      */     
/*      */     }
/* 1897 */     catch (Exception e) {
/* 1898 */       logger.error("Exception  " + e);
/* 1899 */       return "error";
/*      */     } 
/* 1901 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1902 */     this.strPaymentType = "Online Payment";
/*      */     
/* 1904 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 1905 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 1907 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 1909 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 1911 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 1913 */     return FJAction.IMSSUCCESS;
/*      */   }
/*      */   public String iitbRegistration() {
/* 1916 */     if (!isValidSession()) {
/* 1917 */       return INVALID_SESSION;
/*      */     }
/*      */     
/*      */     try {
/* 1921 */       logger.info("---------------------------------------------------------");
/* 1922 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 1923 */       logger.info("---------------------------------------------------------");
/* 1924 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1925 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 1926 */       getIitbData().setRegisteredUserId(registeredUserId);
/* 1927 */       setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/* 1928 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 1929 */       getAppData().setStrID("TEST");
/* 1930 */       addStudentPhotosForIIITB(str1);
/* 1931 */       String responseString = studentRegistrationService.insertIITBStudentDetails(getIitbData());
/*      */       
/* 1933 */       if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 1934 */         addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/* 1935 */       } else if ("NA".equalsIgnoreCase(responseString)) {
/* 1936 */         addActionError(ErrorPropertyReader.getProperty("failed.to.add.student.data"));
/*      */       } else {
/* 1938 */         addActionError(getText("error.occured.contact.administrator"));
/*      */       } 
/* 1940 */       String autoGenRegisterId = getIitbData().getAutoGenRegisterId();
/* 1941 */       List<IITBPostEmpHistoryFormBean> EmpHistoryList = getIitbData().getEmpHistoryList();
/* 1942 */       int emphistoryListLength = EmpHistoryList.size();
/* 1943 */       for (int i = 0; i < emphistoryListLength; i++) {
/*      */         
/* 1945 */         IITBPostEmpHistoryFormBean iitbPostEmpHistoryFormBean = EmpHistoryList.get(i);
/* 1946 */         if (!"".equalsIgnoreCase(iitbPostEmpHistoryFormBean.getEmplyname()) || 
/* 1947 */           !"".equalsIgnoreCase(iitbPostEmpHistoryFormBean.getDesignation()) || 
/* 1948 */           !"".equalsIgnoreCase(iitbPostEmpHistoryFormBean.getCuremp()) || 
/* 1949 */           !"".equalsIgnoreCase(iitbPostEmpHistoryFormBean.getEmpstdt()) || 
/* 1950 */           !"".equalsIgnoreCase(iitbPostEmpHistoryFormBean.getEmpenddate()) || 
/* 1951 */           !"".equalsIgnoreCase(iitbPostEmpHistoryFormBean.getEmpphn()) || 
/* 1952 */           !"".equalsIgnoreCase(iitbPostEmpHistoryFormBean.getEmpadd())) {
/* 1953 */           studentRegistrationService.insertIITBPostHistoryDetails(iitbPostEmpHistoryFormBean, autoGenRegisterId);
/*      */         }
/*      */       } 
/* 1956 */       List<IITBAccomplishmentFormBean> accomplishmentList = getIitbData().getAccomplishmentList();
/* 1957 */       int accomplishmentListLength = accomplishmentList.size();
/* 1958 */       for (int j = 0; j < accomplishmentListLength; j++) {
/*      */         
/* 1960 */         IITBAccomplishmentFormBean iitbAccomplishmentFormBean = accomplishmentList.get(j);
/* 1961 */         if (!"".equalsIgnoreCase(iitbAccomplishmentFormBean.getAccomplishtype()) || 
/* 1962 */           !"".equalsIgnoreCase(iitbAccomplishmentFormBean.getAccomplishment()) || 
/* 1963 */           !"".equalsIgnoreCase(iitbAccomplishmentFormBean.getAccompdate()) || 
/* 1964 */           !"".equalsIgnoreCase(iitbAccomplishmentFormBean.getAccompdsctn()) || 
/* 1965 */           !"".equalsIgnoreCase(iitbAccomplishmentFormBean.getAward()) || 
/* 1966 */           !"".equalsIgnoreCase(iitbAccomplishmentFormBean.getComments())) {
/* 1967 */           studentRegistrationService.insertIITBAccomplishmentDetails(iitbAccomplishmentFormBean, autoGenRegisterId);
/*      */         }
/*      */       } 
/*      */       
/* 1971 */       this.studentRegistrationFormBean = getRegisteredStudentDetails(getIitbData().getStudentRegistrationId());
/* 1972 */       this.studentRegistrationFormBean.setTotalPayableFees(getIitbData().getAmount());
/* 1973 */       this.studentRegistrationFormBean.setStudentId(getIitbData().getCandidateId());
/* 1974 */       this.studentRegistrationFormBean.setStudentName(getIitbData().getStdtName());
/* 1975 */       this.studentRegistrationFormBean.setStudentEmailId(getIitbData().getStdEmailId());
/* 1976 */       applyFees(this.studentRegistrationFormBean);
/*      */       
/* 1978 */       QuickPayAction quickPayAction = new QuickPayAction();
/* 1979 */       this.appData1 = new PaymentRequestBean();
/* 1980 */       this.appData1.setStudentRegistrationId(getIitbData().getStudentRegistrationId());
/*      */       
/* 1982 */       quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */       
/* 1984 */       getUserSessionMap().put("APPDATA", getAppData1());
/* 1985 */     } catch (Exception e) {
/* 1986 */       logger.error("Exception  " + e);
/* 1987 */       return "error";
/*      */     } 
/*      */     
/* 1990 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 1991 */     this.strPaymentType = "Online Payment";
/*      */     
/* 1993 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 1994 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 1996 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 1998 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 2000 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 2002 */     return FJAction.IITBSUCCESS;
/*      */   }
/*      */   
/*      */   public String unisonRegistration() {
/* 2006 */     if (!isValidSession()) {
/* 2007 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 2010 */       logger.info("---------------------------------------------------------");
/* 2011 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 2012 */       logger.info("---------------------------------------------------------");
/* 2013 */       String str = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/*      */       
/* 2015 */       if (getUnisonFormBean().getTotalAmount().equals("0") && getUnisonFormBean().getConvertedAmount().equals("0")) {
/* 2016 */         addActionError("Please Enter Amount");
/* 2017 */         return "unifailure";
/*      */       } 
/*      */       
/* 2020 */       if (AmountValidation(getUnisonFormBean().getTotalAmount(), getUnisonFormBean().getPayment()).booleanValue() && 
/* 2021 */         AmountValidation(getUnisonFormBean().getConvertedAmount(), getUnisonFormBean().getPaymentConverted()).booleanValue()) {
/*      */         
/* 2023 */         StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */ 
/*      */         
/* 2026 */         String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 2027 */         getUnisonFormBean().setRegisteredUserId(registeredUserId);
/* 2028 */         setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/*      */         
/* 2030 */         mappingUnison(getUnisonFormBean());
/* 2031 */         String responseString = studentRegistrationService.insertUnisonStudentDetails(getUnisonFormBean(), str);
/*      */         
/* 2033 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 2034 */           addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/*      */         } else {
/*      */           
/* 2037 */           addActionError(getText("error.occured.contact.administrator"));
/*      */         } 
/*      */         
/* 2040 */         String amount = "0";
/* 2041 */         if ("0".equalsIgnoreCase(getUnisonFormBean().getAmntdDepositINR())) {
/* 2042 */           amount = getUnisonFormBean().getConvertedAmount();
/* 2043 */         } else if ("0".equalsIgnoreCase(getUnisonFormBean().getAmntdDepositUSD())) {
/* 2044 */           amount = getUnisonFormBean().getTotalAmount();
/*      */         } else {
/* 2046 */           amount = "0";
/*      */         } 
/* 2048 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getUnisonFormBean().getStudentRegistrationId());
/* 2049 */         this.studentRegistrationFormBean.setTotalPayableFees(amount);
/* 2050 */         this.studentRegistrationFormBean.setStudentId(getUnisonFormBean().getApplicationNo());
/* 2051 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 2053 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 2054 */         this.appData1 = new PaymentRequestBean();
/* 2055 */         this.appData1.setStudentRegistrationId(getUnisonFormBean().getStudentRegistrationId());
/*      */         
/* 2057 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 2059 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 2062 */         return "unifailure";
/*      */ 
/*      */       
/*      */       }
/*      */ 
/*      */     
/*      */     }
/* 2069 */     catch (Exception e) {
/* 2070 */       logger.error("Exception  " + e);
/* 2071 */       return "error";
/*      */     } 
/* 2073 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2074 */     this.strPaymentType = "Online Payment";
/*      */     
/* 2076 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 2077 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 2079 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 2081 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 2083 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/* 2084 */     getUserSessionMap().put("unisonformbean", getUnisonFormBean());
/* 2085 */     return "unisuccess";
/*      */   }
/*      */   
/*      */   private void mappingUnison(UnisonFormBean unisonFormBean2) {
/* 2089 */     if ("on".equalsIgnoreCase(unisonFormBean2.getNewStudent())) {
/* 2090 */       unisonFormBean2.setNewStudent("Y");
/*      */     } else {
/*      */       
/* 2093 */       unisonFormBean2.setNewStudent("N");
/*      */     } 
/* 2095 */     if ("on".equalsIgnoreCase(unisonFormBean2.getExistingStudent())) {
/* 2096 */       unisonFormBean2.setExistingStudent("Y");
/*      */     } else {
/*      */       
/* 2099 */       unisonFormBean2.setExistingStudent("N");
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2104 */     if ("CISCEIndianNationalStudents".equalsIgnoreCase(unisonFormBean2.getCurriculum()) || 
/* 2105 */       "UniversityofCambridgeIndianNationalStudents".equalsIgnoreCase(unisonFormBean2.getCurriculum())) {
/* 2106 */       if ("admissionFee".equalsIgnoreCase(unisonFormBean2.getAdmissionFee())) {
/* 2107 */         unisonFormBean2.setAdmissionFee("80000");
/*      */       } else {
/*      */         
/* 2110 */         unisonFormBean2.setAdmissionFee("0");
/*      */       } 
/* 2112 */       if ("joiningKitFees".equalsIgnoreCase(unisonFormBean2.getJoiningKitFees())) {
/* 2113 */         unisonFormBean2.setJoiningKitFees("50000");
/*      */       } else {
/*      */         
/* 2116 */         unisonFormBean2.setJoiningKitFees("0");
/*      */       } 
/* 2118 */       if ("securityDeposit".equalsIgnoreCase(unisonFormBean2.getSecurityDeposit())) {
/* 2119 */         unisonFormBean2.setSecurityDeposit("337500");
/*      */       } else {
/*      */         
/* 2122 */         unisonFormBean2.setSecurityDeposit("0");
/*      */       } 
/* 2124 */       if ("schoolFee".equalsIgnoreCase(unisonFormBean2.getSchoolFee())) {
/* 2125 */         if ("CISCEIndianNationalStudents".equalsIgnoreCase(unisonFormBean2.getCurriculum())) {
/* 2126 */           if ("No".equalsIgnoreCase(unisonFormBean2.getSibling())) {
/* 2127 */             if ("I Term".equalsIgnoreCase(unisonFormBean2.getYear()) || "II Term".equalsIgnoreCase(unisonFormBean2.getYear())) {
/* 2128 */               unisonFormBean2.setSchoolFee("337500");
/*      */             }
/* 2130 */             if ("Full Year".equalsIgnoreCase(unisonFormBean2.getYear())) {
/* 2131 */               unisonFormBean2.setSchoolFee("665000");
/*      */             }
/*      */           } 
/* 2134 */           if ("Yes".equalsIgnoreCase(unisonFormBean2.getSibling())) {
/* 2135 */             if ("I Term".equalsIgnoreCase(unisonFormBean2.getYear()) || "II Term".equalsIgnoreCase(unisonFormBean2.getYear())) {
/* 2136 */               unisonFormBean2.setSchoolFee("303750");
/*      */             }
/* 2138 */             if ("Full Year".equalsIgnoreCase(unisonFormBean2.getYear())) {
/* 2139 */               unisonFormBean2.setSchoolFee("598500");
/*      */             }
/*      */           } 
/*      */         } 
/* 2143 */         if ("UniversityofCambridgeIndianNationalStudents".equalsIgnoreCase(unisonFormBean2.getCurriculum())) {
/* 2144 */           if ("No".equalsIgnoreCase(unisonFormBean2.getSibling())) {
/* 2145 */             if ("I Term".equalsIgnoreCase(unisonFormBean2.getYear())) {
/* 2146 */               unisonFormBean2.setSchoolFee("387500");
/*      */             }
/* 2148 */             if ("II Term".equalsIgnoreCase(unisonFormBean2.getYear())) {
/* 2149 */               unisonFormBean2.setSchoolFee("337500");
/*      */             }
/* 2151 */             if ("Full Year".equalsIgnoreCase(unisonFormBean2.getYear())) {
/* 2152 */               unisonFormBean2.setSchoolFee("715000");
/*      */             }
/*      */           } 
/* 2155 */           if ("Yes".equalsIgnoreCase(unisonFormBean2.getSibling())) {
/* 2156 */             if ("I Term".equalsIgnoreCase(unisonFormBean2.getYear()) || "II Term".equalsIgnoreCase(unisonFormBean2.getYear())) {
/* 2157 */               unisonFormBean2.setSchoolFee("353750");
/*      */             }
/* 2159 */             if ("Full Year".equalsIgnoreCase(unisonFormBean2.getYear())) {
/* 2160 */               unisonFormBean2.setSchoolFee("648500");
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } else {
/*      */         
/* 2166 */         unisonFormBean2.setSchoolFee("0");
/*      */       } 
/* 2168 */       if ("registerationFees".equalsIgnoreCase(unisonFormBean2.getRegisterationFees())) {
/* 2169 */         unisonFormBean2.setRegisterationFees("20000");
/*      */       } else {
/*      */         
/* 2172 */         unisonFormBean2.setRegisterationFees("0");
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2178 */     if ("CISCEForeignNationalStudents".equalsIgnoreCase(unisonFormBean2.getCurriculum()) || 
/* 2179 */       "UniversityofCambridgeForeignNationalStudents".equalsIgnoreCase(unisonFormBean2.getCurriculum())) {
/* 2180 */       if (unisonFormBean2.getImprestDeposit().equals("50000")) {
/* 2181 */         unisonFormBean2.setImprestDeposit("1500");
/*      */       }
/* 2183 */       if ("admissionFee".equalsIgnoreCase(unisonFormBean2.getAdmissionFee())) {
/* 2184 */         unisonFormBean2.setAdmissionFee("1500");
/*      */       } else {
/*      */         
/* 2187 */         unisonFormBean2.setAdmissionFee("0");
/*      */       } 
/* 2189 */       if ("joiningKitFees".equalsIgnoreCase(unisonFormBean2.getJoiningKitFees())) {
/* 2190 */         unisonFormBean2.setJoiningKitFees("1000");
/*      */       } else {
/*      */         
/* 2193 */         unisonFormBean2.setJoiningKitFees("0");
/*      */       } 
/* 2195 */       if ("securityDeposit".equalsIgnoreCase(unisonFormBean2.getSecurityDeposit())) {
/* 2196 */         unisonFormBean2.setSecurityDeposit("3000");
/*      */       } else {
/*      */         
/* 2199 */         unisonFormBean2.setSecurityDeposit("0");
/*      */       } 
/* 2201 */       if ("schoolFee".equalsIgnoreCase(unisonFormBean2.getSchoolFee())) {
/* 2202 */         if ("No".equalsIgnoreCase(unisonFormBean2.getSibling())) {
/* 2203 */           unisonFormBean2.setSchoolFee("10600");
/*      */         }
/* 2205 */         if ("Yes".equalsIgnoreCase(unisonFormBean2.getSibling())) {
/* 2206 */           unisonFormBean2.setSchoolFee("9540");
/*      */         }
/*      */       } else {
/*      */         
/* 2210 */         unisonFormBean2.setSchoolFee("0");
/*      */       } 
/* 2212 */       if ("registerationFees".equalsIgnoreCase(unisonFormBean2.getRegisterationFees())) {
/* 2213 */         unisonFormBean2.setRegisterationFees("500");
/*      */       } else {
/*      */         
/* 2216 */         unisonFormBean2.setRegisterationFees("0");
/*      */       } 
/*      */     } 
/*      */     
/* 2220 */     String instCode = (String)getUserSessionMap().get("_institutecode");
/*      */     
/* 2222 */     if ("CISCEIndianNationalStudents".equalsIgnoreCase(unisonFormBean2.getCurriculum())) {
/* 2223 */       if ("UWSD".equalsIgnoreCase(instCode)) {
/* 2224 */         unisonFormBean2.setNationality("Indian");
/* 2225 */         unisonFormBean2.setCurriculum("");
/*      */       } else {
/*      */         
/* 2228 */         unisonFormBean2.setCurriculum("Indian Curriculum-CISCE");
/*      */       }
/*      */     
/* 2231 */     } else if ("UniversityofCambridgeIndianNationalStudents".equalsIgnoreCase(unisonFormBean2.getCurriculum())) {
/* 2232 */       unisonFormBean2.setCurriculum("International Curriculum-IGCSE/A level");
/*      */     }
/* 2234 */     else if ("CISCEForeignNationalStudents".equalsIgnoreCase(unisonFormBean2.getCurriculum())) {
/* 2235 */       if ("UWSD".equalsIgnoreCase(instCode)) {
/* 2236 */         unisonFormBean2.setNationality("Overseas");
/* 2237 */         unisonFormBean2.setCurriculum("");
/*      */       } else {
/*      */         
/* 2240 */         unisonFormBean2.setCurriculum("CISCE-Foreign National Students");
/*      */       } 
/*      */     } else {
/* 2243 */       unisonFormBean2.setCurriculum("University of Cambridge-Foreign National Students");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Boolean AmountValidation(String amount, String validator) {
/* 2251 */     String fin = ChecksumGenerator.hmacSha1GLA(amount, "1989083233a696819f2623039a9f8adf");
/* 2252 */     if (fin.equals(validator)) {
/* 2253 */       return Boolean.valueOf(true);
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
/* 2279 */     return Boolean.valueOf(false);
/*      */   }
/*      */   public String wbutRegistration() {
/* 2282 */     if (!isValidSession()) {
/* 2283 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 2286 */       List<String> amountList = new ArrayList<>();
/* 2287 */       logger.info("---------------------------------------------------------");
/* 2288 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 2289 */       logger.info("---------------------------------------------------------");
/* 2290 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2291 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 2292 */       getWbutUniversityFormBean().setRegisteredUserId(registeredUserId);
/* 2293 */       setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/* 2294 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 2296 */       amountList = studentRegistrationService.getOnlineInstituteAmountList(str1);
/* 2297 */       if ((amountList.size() > 0 && amountList.contains(getWbutUniversityFormBean().getFees())) || !amountList.contains(getWbutUniversityFormBean().getFees())) {
/*      */         
/* 2299 */         String registeredUserId1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 2300 */         getWbutUniversityFormBean().setRegisteredUserId(registeredUserId1);
/* 2301 */         setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/*      */ 
/*      */         
/* 2304 */         String responseString = studentRegistrationService.insertWbuteaStudentDetails(getWbutUniversityFormBean(), str1);
/*      */         
/* 2306 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 2307 */           addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/*      */         }
/* 2309 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getWbutUniversityFormBean().getStudentRegistrationId());
/* 2310 */         this.studentRegistrationFormBean.setTotalPayableFees(getWbutUniversityFormBean().getFees());
/* 2311 */         this.studentRegistrationFormBean.setStudentId(getWbutUniversityFormBean().getApplicationNo());
/*      */         
/* 2313 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 2315 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 2316 */         this.appData1 = new PaymentRequestBean();
/* 2317 */         this.appData1.setStudentRegistrationId(getWbutUniversityFormBean().getStudentRegistrationId());
/*      */         
/* 2319 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 2321 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 2324 */         return "wbutfailure";
/*      */       }
/*      */     
/* 2327 */     } catch (Exception e) {
/* 2328 */       logger.error("Exception  " + e);
/* 2329 */       return "error";
/*      */     } 
/* 2331 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2332 */     this.strPaymentType = "Online Payment";
/*      */     
/* 2334 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 2335 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 2337 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 2339 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 2341 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 2343 */     return FJAction.WBUTSUCCESS;
/*      */   }
/*      */ 
/*      */   
/*      */   public String gpullaReadyRegistration() {
/* 2348 */     if (!isValidSession()) {
/* 2349 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 2352 */       List<String> amountList = new ArrayList<>();
/* 2353 */       logger.info("---------------------------------------------------------");
/* 2354 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 2355 */       logger.info("---------------------------------------------------------");
/* 2356 */       String str = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2357 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 2359 */       amountList = studentRegistrationService.getOnlineInstituteAmountList(str);
/* 2360 */       if (amountList.size() > 0 && amountList.contains(getGpullaReadyFormBean().getStdHostelFee())) {
/*      */         
/* 2362 */         String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 2363 */         getGpullaReadyFormBean().setRegisteredUserId(registeredUserId);
/* 2364 */         setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/*      */         
/* 2366 */         String responseString = studentRegistrationService.insertgpullaReadyStudentDetails(getGpullaReadyFormBean(), str);
/* 2367 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 2368 */           addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/*      */         }
/* 2370 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getGpullaReadyFormBean().getStudentRegistrationId());
/* 2371 */         this.studentRegistrationFormBean.setTotalPayableFees(getGpullaReadyFormBean().getStdHostelFee());
/* 2372 */         this.studentRegistrationFormBean.setStudentId(getGpullaReadyFormBean().getApplicationNo());
/* 2373 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 2375 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 2376 */         this.appData1 = new PaymentRequestBean();
/* 2377 */         this.appData1.setStudentRegistrationId(getGpullaReadyFormBean().getStudentRegistrationId());
/*      */         
/* 2379 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 2381 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 2384 */         return "gpullareadyfailure";
/*      */       } 
/* 2386 */     } catch (Exception e) {
/* 2387 */       logger.error("Exception  " + e);
/* 2388 */       return "error";
/*      */     } 
/*      */     
/* 2391 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2392 */     this.strPaymentType = "Online Payment";
/*      */     
/* 2394 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 2395 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 2397 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 2399 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 2401 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 2403 */     return FJAction.GPULLAREADYSUCCESS;
/*      */   }
/*      */   
/*      */   public String YMCARegistration() {
/* 2407 */     if (!isValidSession()) {
/* 2408 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 2411 */       List<String> amountList = new ArrayList<>();
/* 2412 */       logger.info("---------------------------------------------------------");
/* 2413 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 2414 */       logger.info("---------------------------------------------------------");
/* 2415 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2416 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 2417 */       getYmcaOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 2418 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 2419 */       getAppData().setStrID("TEST");
/* 2420 */       amountList = studentRegistrationService.getOnlineInstituteAmountList(str1);
/* 2421 */       if (amountList.size() > 0 && amountList.contains(getYmcaOnlineFormBean().getAmount())) {
/*      */         
/* 2423 */         addStudentPhotosForYMCA(str1);
/* 2424 */         String responseString = studentRegistrationService.insertYMCAStudentDetails(getYmcaOnlineFormBean(), str1);
/*      */         
/* 2426 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 2427 */           addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/* 2428 */         } else if ("NA".equalsIgnoreCase(responseString)) {
/* 2429 */           addActionError(ErrorPropertyReader.getProperty("failed.to.add.student.data"));
/*      */         } else {
/* 2431 */           addActionError(getText("error.occured.contact.administrator"));
/*      */         } 
/* 2433 */         List<EducationDetailsFormbean> eduDetailsList = getYmcaOnlineFormBean().getEduDetailsList();
/* 2434 */         int eduListLength = eduDetailsList.size();
/* 2435 */         for (int i = 0; i < eduListLength; i++) {
/*      */           
/* 2437 */           EducationDetailsFormbean educationDetailsFormbean = eduDetailsList.get(i);
/* 2438 */           if (!"".equalsIgnoreCase(educationDetailsFormbean.getQualName())) {
/* 2439 */             studentRegistrationService.insertYMCAEducationDetails(educationDetailsFormbean, getYmcaOnlineFormBean().getApplicationNo());
/*      */           }
/*      */         } 
/* 2442 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getYmcaOnlineFormBean().getStudentRegistrationId());
/* 2443 */         this.studentRegistrationFormBean.setTotalPayableFees(getYmcaOnlineFormBean().getAmount());
/* 2444 */         this.studentRegistrationFormBean.setStudentId(getYmcaOnlineFormBean().getApplicationNo());
/* 2445 */         this.studentRegistrationFormBean.setStudentName(getYmcaOnlineFormBean().getApplicantName());
/* 2446 */         this.studentRegistrationFormBean.setStudentEmailId(getYmcaOnlineFormBean().getEmailId());
/* 2447 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 2449 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 2450 */         this.appData1 = new PaymentRequestBean();
/* 2451 */         this.appData1.setStudentRegistrationId(getYmcaOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 2453 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 2455 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 2458 */         return "ymcafailure";
/*      */       } 
/* 2460 */     } catch (Exception e) {
/* 2461 */       logger.error("Exception  " + e);
/* 2462 */       return "error";
/*      */     } 
/*      */     
/* 2465 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2466 */     this.strPaymentType = "Online Payment";
/*      */     
/* 2468 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 2469 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 2471 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 2473 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 2475 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 2477 */     return FJAction.YMCASUCCESS;
/*      */   }
/*      */   
/*      */   public String NITMeghRegistration() {
/* 2481 */     if (!isValidSession()) {
/* 2482 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 2485 */       logger.info("---------------------------------------------------------");
/* 2486 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 2487 */       logger.info("---------------------------------------------------------");
/* 2488 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2489 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 2490 */       logger.info("registeredUserId.." + registeredUserId);
/* 2491 */       getNitOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 2492 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 2493 */       getAppData().setStrID("TEST");
/* 2494 */       if (AmountValidation(getNitOnlineFormBean().getAmount(), getNitOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 2496 */         String responseString = studentRegistrationService.insertNITMeghStudentDetails(getNitOnlineFormBean(), str1);
/*      */         
/* 2498 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 2499 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 2500 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 2501 */             addActionError(ErrorPropertyReader.getProperty("failed.to.add.student.data"));
/* 2502 */             return "nitfailure";
/*      */           } 
/* 2504 */           addActionError(getText("error.occured.contact.administrator"));
/* 2505 */           return "nitfailure"; }
/*      */         
/* 2507 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getNitOnlineFormBean().getStudentRegistrationId());
/* 2508 */         this.studentRegistrationFormBean.setTotalPayableFees(getNitOnlineFormBean().getAmount());
/* 2509 */         this.studentRegistrationFormBean.setStudentId(getNitOnlineFormBean().getApplicationNo());
/* 2510 */         this.studentRegistrationFormBean.setStudentName(getNitOnlineFormBean().getStdName());
/* 2511 */         this.studentRegistrationFormBean.setStudentEmailId(getNitOnlineFormBean().getEmail());
/* 2512 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 2514 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 2515 */         this.appData1 = new PaymentRequestBean();
/* 2516 */         this.appData1.setStudentRegistrationId(getNitOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 2518 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 2520 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 2522 */         return "nitfailure";
/*      */       } 
/* 2524 */     } catch (Exception e) {
/* 2525 */       logger.error("Exception  " + e);
/* 2526 */       return "error";
/*      */     } 
/*      */     
/* 2529 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2530 */     this.strPaymentType = "Online Payment";
/*      */     
/* 2532 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 2533 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 2535 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 2537 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 2539 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 2541 */     return FJAction.NITMEGHSUCCESS;
/*      */   }
/*      */   public String CampionRegistration() {
/* 2544 */     if (!isValidSession())
/* 2545 */       return INVALID_SESSION; 
/*      */     try {
/*      */       boolean champio;
/* 2548 */       logger.info("---------------------------------------------------------");
/* 2549 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 2550 */       logger.info("---------------------------------------------------------");
/* 2551 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2552 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 2553 */       logger.info("registeredUserId.." + registeredUserId);
/* 2554 */       String instCode = (String)getUserSessionMap().get("_institutecode");
/* 2555 */       getCampionSchoolFormBean().setRegisteredUserId(registeredUserId);
/* 2556 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 2557 */       getAppData().setStrID("TEST");
/*      */       
/* 2559 */       if (instCode.equalsIgnoreCase("CHAMPIO")) {
/* 2560 */         champio = (AmountValidation(getCampionSchoolFormBean().getTutionFee(), getCampionSchoolFormBean().getTutionPayment()).booleanValue() && AmountValidation(getCampionSchoolFormBean().getTermFee(), getCampionSchoolFormBean().getTermPayment()).booleanValue() && AmountValidation(getCampionSchoolFormBean().getPtaFee(), getCampionSchoolFormBean().getPtaPayment()).booleanValue() && AmountValidation(getCampionSchoolFormBean().getComputerFee(), getCampionSchoolFormBean().getComputerPayment()).booleanValue());
/*      */       } else {
/* 2562 */         champio = (AmountValidation(getCampionSchoolFormBean().getTutionFee(), getCampionSchoolFormBean().getTutionPayment()).booleanValue() && AmountValidation(getCampionSchoolFormBean().getTermFee(), getCampionSchoolFormBean().getTermPayment()).booleanValue() && AmountValidation(getCampionSchoolFormBean().getPtaFee(), getCampionSchoolFormBean().getPtaPayment()).booleanValue());
/*      */       } 
/* 2564 */       if (champio) {
/*      */         Double amt;
/*      */         
/* 2567 */         if (instCode.equalsIgnoreCase("CHAMPIO")) {
/* 2568 */           amt = Double.valueOf(Double.parseDouble(getCampionSchoolFormBean().getTutionFee()) + Double.parseDouble(getCampionSchoolFormBean().getTermFee()) + Double.parseDouble(getCampionSchoolFormBean().getPtaFee()) + Double.parseDouble(getCampionSchoolFormBean().getComputerFee()));
/*      */         } else {
/* 2570 */           amt = Double.valueOf(Double.parseDouble(getCampionSchoolFormBean().getTutionFee()) + Double.parseDouble(getCampionSchoolFormBean().getTermFee()) + Double.parseDouble(getCampionSchoolFormBean().getPtaFee()));
/*      */         } 
/* 2572 */         getCampionSchoolFormBean().setAmount(amt.toString());
/* 2573 */         String responseString = studentRegistrationService.insertCampionSchoolDetails(getCampionSchoolFormBean(), str1);
/*      */         
/* 2575 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 2576 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 2577 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 2578 */             addActionError(ErrorPropertyReader.getProperty("failed.to.add.student.data"));
/* 2579 */             return "campionfailure";
/*      */           } 
/* 2581 */           addActionError(getText("error.occured.contact.administrator"));
/* 2582 */           return "campionfailure"; }
/*      */         
/* 2584 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getCampionSchoolFormBean().getStudentRegistrationId());
/* 2585 */         this.studentRegistrationFormBean.setTotalPayableFees(getCampionSchoolFormBean().getAmount());
/* 2586 */         this.studentRegistrationFormBean.setStudentId(getCampionSchoolFormBean().getApplicationNo());
/* 2587 */         this.studentRegistrationFormBean.setStudentName(getCampionSchoolFormBean().getStdName());
/* 2588 */         this.studentRegistrationFormBean.setStudentEmailId(getCampionSchoolFormBean().getStdEmailId());
/* 2589 */         StudentDataService studentDataService = new StudentDataService();
/* 2590 */         List<StudentFeesFormBean> studentFeesList = studentDataService.getStudentFeesDetails(this.studentRegistrationFormBean.getBillerBranchId(), 
/* 2591 */             this.studentRegistrationFormBean.getStrCourse(), this.studentRegistrationFormBean.getStrCourseDetails(), 
/* 2592 */             this.studentRegistrationFormBean.getStrCourseType(), this.studentRegistrationFormBean.getStrCoursePattern(), 
/* 2593 */             this.studentRegistrationFormBean.getStrCourseTerm(), this.studentRegistrationFormBean.getStudentId(), 
/* 2594 */             str1);
/* 2595 */         this.studentRegistrationFormBean.setStudentFeesList(studentFeesList);
/* 2596 */         applyFees(this.studentRegistrationFormBean);
/* 2597 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 2598 */         this.appData1 = new PaymentRequestBean();
/* 2599 */         this.appData1.setStudentRegistrationId(getCampionSchoolFormBean().getStudentRegistrationId());
/*      */         
/* 2601 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 2603 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 2605 */         return "campionfailure";
/*      */       } 
/* 2607 */     } catch (Exception e) {
/* 2608 */       logger.error("Exception  " + e);
/* 2609 */       return "error";
/*      */     } 
/*      */     
/* 2612 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2613 */     this.strPaymentType = "Online Payment";
/*      */     
/* 2615 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 2616 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 2618 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 2620 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 2622 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 2624 */     return FJAction.CAMPIONSUCCESS;
/*      */   }
/*      */   public String haryanaRegistration() {
/* 2627 */     if (!isValidSession())
/* 2628 */       return INVALID_SESSION; 
/*      */     try {
/*      */       boolean Appfee;
/* 2631 */       logger.info("---------------------------------------------------------");
/* 2632 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 2633 */       logger.info("---------------------------------------------------------");
/* 2634 */       String str = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/*      */       
/* 2636 */       if (getHaryanaFormBean().getApplicationFee() != null && !"".equalsIgnoreCase(getHaryanaFormBean().getApplicationFee())) {
/*      */         
/* 2638 */         Appfee = AmountValidation(getHaryanaFormBean().getApplicationFee(), getHaryanaFormBean().getApplicationFeecharges()).booleanValue();
/*      */       }
/*      */       else {
/*      */         
/* 2642 */         getHaryanaFormBean().setApplicationFee("0");
/* 2643 */         Appfee = true;
/*      */       } 
/* 2645 */       if (Appfee) {
/*      */         
/* 2647 */         StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 2648 */         String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 2649 */         getHaryanaFormBean().setRegisteredUserId(registeredUserId);
/* 2650 */         setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/* 2651 */         getAppData().setStrID("TEST");
/* 2652 */         addStudentPhotosForHARYANA(str);
/* 2653 */         String responseString = studentRegistrationService.insertHaryanaStudentDetails(getHaryanaFormBean(), str);
/* 2654 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 2655 */           addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/*      */         }
/* 2657 */         List<EducationHaryanaFormBean> eduDetailsList = getHaryanaFormBean().getEduharyanaList();
/* 2658 */         int eduListLength = eduDetailsList.size();
/* 2659 */         for (int i = 0; i < eduListLength; i++) {
/*      */           
/* 2661 */           EducationHaryanaFormBean educationHaryanaFormBean = eduDetailsList.get(i);
/* 2662 */           studentRegistrationService.insertHaryanaEducationDetails(educationHaryanaFormBean, getHaryanaFormBean().getApplicationNo());
/*      */         } 
/*      */         
/* 2665 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getHaryanaFormBean().getStudentRegistrationId());
/* 2666 */         this.studentRegistrationFormBean.setTotalPayableFees(getHaryanaFormBean().getApplicationFee());
/* 2667 */         this.studentRegistrationFormBean.setStudentId(getHaryanaFormBean().getApplicationNo());
/*      */         
/* 2669 */         applyFees(this.studentRegistrationFormBean);
/* 2670 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 2671 */         this.appData1 = new PaymentRequestBean();
/* 2672 */         this.appData1.setStudentRegistrationId(getHaryanaFormBean().getStudentRegistrationId());
/*      */         
/* 2674 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 2676 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 2680 */         return "haryanafailure";
/*      */       } 
/* 2682 */     } catch (Exception e) {
/* 2683 */       logger.error("Exception  " + e);
/* 2684 */       return "error";
/*      */     } 
/* 2686 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2687 */     this.strPaymentType = "Online Payment";
/*      */     
/* 2689 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 2690 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 2692 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 2694 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 2696 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 2698 */     return FJAction.HARYANASUCCESS;
/*      */   }
/*      */   public String BengalCollegeRegistration() {
/* 2701 */     if (!isValidSession()) {
/* 2702 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 2705 */       logger.info("---------------------------------------------------------");
/* 2706 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 2707 */       logger.info("---------------------------------------------------------");
/* 2708 */       LoginActionService loginActionService = new LoginActionService();
/* 2709 */       String instCode = (String)getUserSessionMap().get("_institutecode");
/* 2710 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2711 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 2712 */       logger.info("registeredUserId.." + registeredUserId);
/* 2713 */       getBengalCollegeOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 2714 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 2715 */       getAppData().setStrID("TEST");
/* 2716 */       boolean validAmt = false, hostelAmt = false, academicAmt = false;
/* 2717 */       if (instCode.equalsIgnoreCase("BCE") || instCode.equalsIgnoreCase("BCET") || 
/* 2718 */         instCode.equalsIgnoreCase("BCPO") || instCode.equalsIgnoreCase("BCPSR")) {
/* 2719 */         validAmt = AmountValidation(getBengalCollegeOnlineFormBean().getAmount(), getBengalCollegeOnlineFormBean().getPayment()).booleanValue();
/*      */       } else {
/* 2721 */         if (getBengalCollegeOnlineFormBean().getAcademicAmount() != null && !"".equalsIgnoreCase(getBengalCollegeOnlineFormBean().getAcademicAmount())) {
/*      */           
/* 2723 */           academicAmt = AmountValidation(getBengalCollegeOnlineFormBean().getAcademicAmount(), getBengalCollegeOnlineFormBean().getAcademicPayment()).booleanValue();
/*      */         }
/*      */         else {
/*      */           
/* 2727 */           getBengalCollegeOnlineFormBean().setAcademicAmount("0");
/* 2728 */           academicAmt = true;
/*      */         } 
/* 2730 */         if (getBengalCollegeOnlineFormBean().getHostelAmount() != null && !"".equalsIgnoreCase(getBengalCollegeOnlineFormBean().getHostelAmount())) {
/*      */           
/* 2732 */           hostelAmt = AmountValidation(getBengalCollegeOnlineFormBean().getHostelAmount(), getBengalCollegeOnlineFormBean().getHostelPayment()).booleanValue();
/*      */         }
/*      */         else {
/*      */           
/* 2736 */           getBengalCollegeOnlineFormBean().setHostelAmount("0");
/* 2737 */           hostelAmt = true;
/*      */         } 
/* 2739 */         validAmt = (academicAmt && hostelAmt);
/*      */       } 
/*      */       
/* 2742 */       if (validAmt) {
/*      */         Double amt;
/*      */         
/* 2745 */         if (instCode.equalsIgnoreCase("BCE") || instCode.equalsIgnoreCase("BCET") || 
/* 2746 */           instCode.equalsIgnoreCase("BCPO") || instCode.equalsIgnoreCase("BCPSR")) {
/* 2747 */           amt = Double.valueOf(Double.parseDouble(getBengalCollegeOnlineFormBean().getAmount()));
/*      */         } else {
/* 2749 */           amt = Double.valueOf(Double.parseDouble(getBengalCollegeOnlineFormBean().getAcademicAmount()) + Double.parseDouble(getBengalCollegeOnlineFormBean().getHostelAmount()));
/*      */         } 
/* 2751 */         getBengalCollegeOnlineFormBean().setAmount(amt.toString());
/* 2752 */         addStudentPhotosForBengal(str1);
/* 2753 */         String responseString = studentRegistrationService.insertBengalCollegeDetails(getBengalCollegeOnlineFormBean(), str1);
/*      */         
/* 2755 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 2756 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 2757 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 2758 */             addActionError(ErrorPropertyReader.getProperty("failed.to.add.student.data"));
/* 2759 */             setStateMapList(loginActionService.getStateMapList());
/* 2760 */             return "bengalfailure";
/*      */           } 
/* 2762 */           addActionError(getText("error.occured.contact.administrator"));
/* 2763 */           setStateMapList(loginActionService.getStateMapList());
/* 2764 */           return "bengalfailure"; }
/*      */         
/* 2766 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getBengalCollegeOnlineFormBean().getStudentRegistrationId());
/* 2767 */         this.studentRegistrationFormBean.setTotalPayableFees(getBengalCollegeOnlineFormBean().getAmount());
/* 2768 */         this.studentRegistrationFormBean.setStudentId(getBengalCollegeOnlineFormBean().getApplicationNo());
/* 2769 */         this.studentRegistrationFormBean.setStudentName(getBengalCollegeOnlineFormBean().getStdName());
/* 2770 */         this.studentRegistrationFormBean.setStudentEmailId(getBengalCollegeOnlineFormBean().getStdEmailId());
/* 2771 */         this.studentRegistrationFormBean.setStudentMobileNumber(getBengalCollegeOnlineFormBean().getStdMobile());
/* 2772 */         StudentDataService studentDataService = new StudentDataService();
/* 2773 */         List<StudentFeesFormBean> studentFeesList = studentDataService.getStudentFeesDetails(this.studentRegistrationFormBean.getBillerBranchId(), 
/* 2774 */             this.studentRegistrationFormBean.getStrCourse(), this.studentRegistrationFormBean.getStrCourseDetails(), 
/* 2775 */             this.studentRegistrationFormBean.getStrCourseType(), this.studentRegistrationFormBean.getStrCoursePattern(), 
/* 2776 */             this.studentRegistrationFormBean.getStrCourseTerm(), this.studentRegistrationFormBean.getStudentId(), 
/* 2777 */             str1);
/* 2778 */         this.studentRegistrationFormBean.setStudentFeesList(studentFeesList);
/* 2779 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 2781 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 2782 */         this.appData1 = new PaymentRequestBean();
/* 2783 */         this.appData1.setStudentRegistrationId(getBengalCollegeOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 2785 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 2787 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 2789 */         setStateMapList(loginActionService.getStateMapList());
/* 2790 */         return "bengalfailure";
/*      */       } 
/* 2792 */     } catch (Exception e) {
/* 2793 */       logger.error("Exception  " + e);
/* 2794 */       return "error";
/*      */     } 
/*      */     
/* 2797 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2798 */     this.strPaymentType = "Online Payment";
/*      */     
/* 2800 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 2801 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 2803 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 2805 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 2807 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 2809 */     return FJAction.BENGALCSUCCESS;
/*      */   }
/*      */ 
/*      */   
/*      */   public String loadBengalData() {
/* 2814 */     if (getBengalCollegeOnlineFormBean().getApplicationNo() != null && !"".equalsIgnoreCase(getBengalCollegeOnlineFormBean().getApplicationNo())) {
/*      */       
/* 2816 */       BengalCollegeOnlineFormBean bengalCollegeOnlineFormBean = new BengalCollegeOnlineFormBean();
/* 2817 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 2818 */       bengalCollegeOnlineFormBean = studentRegistrationService.loadBengalData(getBengalCollegeOnlineFormBean().getApplicationNo(), (String)getUserSessionMap().get("_institutecode"));
/* 2819 */       LoginActionService loginActionService = new LoginActionService();
/* 2820 */       setStateMapList(loginActionService.getStateMapList());
/* 2821 */       setBengalCollegeOnlineFormBean(bengalCollegeOnlineFormBean);
/*      */     } else {
/* 2823 */       addActionMessage("Please enter valid application number.");
/* 2824 */       return "bengalfailure";
/*      */     } 
/* 2826 */     return FJAction.BCHOME;
/*      */   }
/*      */   public String photo_Proof() throws Exception {
/*      */     try {
/* 2830 */       HttpServletRequest request = ServletActionContext.getRequest();
/* 2831 */       String downloadPath = "";
/* 2832 */       String photo_Proof = request.getParameter("photo_Proof");
/* 2833 */       String osName = System.getProperty("os.name");
/* 2834 */       if (photo_Proof != null && !photo_Proof.equals("")) {
/*      */         
/* 2836 */         if ("LINUX".equalsIgnoreCase(osName.trim())) {
/* 2837 */           downloadPath = "/opt/jboss-eap-6.0/standalone/deployments/XJunction.war/StudentPhotos/" + photo_Proof;
/*      */         } else {
/* 2839 */           downloadPath = "C:/WorkSpace_for_UploadPhotos/StudentUploadPhotos/WebContent/StudentPhotos/" + photo_Proof;
/*      */         } 
/*      */       } else {
/* 2842 */         addActionMessage("download file not generated.");
/* 2843 */         return "bengalfailure";
/*      */       } 
/* 2845 */       File downloadFile = new File(downloadPath);
/* 2846 */       if (downloadFile.exists()) {
/* 2847 */         this.fileInputStream = new FileInputStream(new File(downloadPath));
/* 2848 */         this.buffer = new StringBuffer();
/* 2849 */         getBuffer().append(photo_Proof);
/*      */       } else {
/* 2851 */         addActionMessage("download file not generated.");
/* 2852 */         return "bengalfailure";
/*      */       }
/*      */     
/* 2855 */     } catch (Exception e) {
/* 2856 */       logger.error("Exception  " + e);
/* 2857 */       addActionError("error.occured.please.contact.administrator");
/*      */     } 
/* 2859 */     return "bcphoto";
/*      */   }
/*      */   public String YMCAALLRegistration() {
/* 2862 */     if (!isValidSession()) {
/* 2863 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 2866 */       logger.info("---------------------------------------------------------");
/* 2867 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 2868 */       logger.info("---------------------------------------------------------");
/* 2869 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2870 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 2871 */       getYmcaOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 2872 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 2873 */       getAppData().setStrID("TEST");
/* 2874 */       if (AmountValidation(getYmcaOnlineFormBean().getAmount(), getYmcaOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 2876 */         addStudentPhotosForYMCA(str1);
/* 2877 */         String responseString = studentRegistrationService.insertYMCAAllStudentDetails(getYmcaOnlineFormBean(), str1);
/*      */         
/* 2879 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 2880 */           addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/* 2881 */         } else if ("NA".equalsIgnoreCase(responseString)) {
/* 2882 */           addActionError(ErrorPropertyReader.getProperty("failed.to.add.student.data"));
/*      */         } else {
/* 2884 */           addActionError(getText("error.occured.contact.administrator"));
/*      */         } 
/* 2886 */         List<EducationDetailsFormbean> eduDetailsList = getYmcaOnlineFormBean().getEduDetailsList();
/* 2887 */         int eduListLength = eduDetailsList.size();
/* 2888 */         for (int i = 0; i < eduListLength; i++) {
/*      */           
/* 2890 */           EducationDetailsFormbean educationDetailsFormbean = eduDetailsList.get(i);
/* 2891 */           if (!"".equalsIgnoreCase(educationDetailsFormbean.getQualName())) {
/* 2892 */             studentRegistrationService.insertYMCAEducationDetails(educationDetailsFormbean, getYmcaOnlineFormBean().getApplicationNo());
/*      */           }
/*      */         } 
/* 2895 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getYmcaOnlineFormBean().getStudentRegistrationId());
/* 2896 */         this.studentRegistrationFormBean.setTotalPayableFees(getYmcaOnlineFormBean().getAmount());
/* 2897 */         this.studentRegistrationFormBean.setStudentId(getYmcaOnlineFormBean().getApplicationNo());
/* 2898 */         this.studentRegistrationFormBean.setStudentName(getYmcaOnlineFormBean().getApplicantName());
/* 2899 */         this.studentRegistrationFormBean.setStudentEmailId(getYmcaOnlineFormBean().getEmailId());
/* 2900 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 2902 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 2903 */         this.appData1 = new PaymentRequestBean();
/* 2904 */         this.appData1.setStudentRegistrationId(getYmcaOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 2906 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 2908 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 2911 */         addActionMessage("Amount Mismatched..");
/* 2912 */         return "ymcaallfailure";
/*      */       } 
/* 2914 */     } catch (Exception e) {
/* 2915 */       logger.error("Exception  " + e);
/* 2916 */       return "error";
/*      */     } 
/*      */     
/* 2919 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2920 */     this.strPaymentType = "Online Payment";
/*      */     
/* 2922 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 2923 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 2925 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 2927 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 2929 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 2931 */     return FJAction.YMCASUCCESS;
/*      */   }
/*      */   public String bseRegistration() {
/* 2934 */     if (!isValidSession())
/* 2935 */       return INVALID_SESSION; 
/*      */     try {
/*      */       boolean Appfee;
/* 2938 */       logger.info("---------------------------------------------------------");
/* 2939 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 2940 */       logger.info("---------------------------------------------------------");
/* 2941 */       String str = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/*      */       
/* 2943 */       if (getBseFormBean().getFeepayable() != null && !"".equalsIgnoreCase(getBseFormBean().getFeepayable())) {
/*      */         
/* 2945 */         Appfee = AmountValidation(getBseFormBean().getFeepayable(), getBseFormBean().getFeepayablecharges()).booleanValue();
/*      */       }
/*      */       else {
/*      */         
/* 2949 */         getBseFormBean().setFeepayable("0");
/* 2950 */         Appfee = true;
/*      */       } 
/* 2952 */       if (Appfee) {
/*      */         
/* 2954 */         StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 2955 */         String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 2956 */         getBseFormBean().setRegisteredUserId(registeredUserId);
/* 2957 */         setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/*      */         
/* 2959 */         String responseString = studentRegistrationService.insertBSEStudentDetails(getBseFormBean(), str);
/* 2960 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 2961 */           addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/*      */         }
/* 2963 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getBseFormBean().getStudentRegistrationId());
/* 2964 */         this.studentRegistrationFormBean.setTotalPayableFees(getBseFormBean().getFeepayable());
/* 2965 */         this.studentRegistrationFormBean.setStudentId(getBseFormBean().getApplicationNo());
/* 2966 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 2968 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 2969 */         this.appData1 = new PaymentRequestBean();
/* 2970 */         this.appData1.setStudentRegistrationId(getBseFormBean().getStudentRegistrationId());
/*      */         
/* 2972 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 2974 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 2978 */         return "bsefailure";
/*      */       } 
/* 2980 */     } catch (Exception e) {
/* 2981 */       logger.error("Exception  " + e);
/* 2982 */       return "error";
/*      */     } 
/* 2984 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 2985 */     this.strPaymentType = "Online Payment";
/*      */     
/* 2987 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 2988 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 2990 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 2992 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 2994 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 2996 */     return FJAction.BSESUCCESS;
/*      */   }
/*      */   public String WelhamRegistration() {
/* 2999 */     if (!isValidSession()) {
/* 3000 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 3003 */       logger.info("---------------------------------------------------------");
/* 3004 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 3005 */       logger.info("---------------------------------------------------------");
/* 3006 */       LoginActionService loginActionService = new LoginActionService();
/* 3007 */       String instCode = (String)getUserSessionMap().get("_institutecode");
/* 3008 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3009 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 3010 */       logger.info("registeredUserId.." + registeredUserId);
/* 3011 */       getWelhamSchoolFormBean().setRegisteredUserId(registeredUserId);
/* 3012 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 3013 */       getAppData().setStrID("TEST");
/* 3014 */       boolean validAmt = false, miscAmt = false, termAmt = false;
/*      */       
/* 3016 */       if (getWelhamSchoolFormBean().getTermFees() != null && !"".equalsIgnoreCase(getWelhamSchoolFormBean().getTermFees())) {
/*      */         
/* 3018 */         termAmt = AmountValidation(getWelhamSchoolFormBean().getTermFees(), getWelhamSchoolFormBean().getTermPayment()).booleanValue();
/*      */       }
/*      */       else {
/*      */         
/* 3022 */         getWelhamSchoolFormBean().setTermFees("0");
/* 3023 */         termAmt = true;
/*      */       } 
/* 3025 */       if (getWelhamSchoolFormBean().getMiscFees() != null && !"".equalsIgnoreCase(getWelhamSchoolFormBean().getMiscFees())) {
/*      */         
/* 3027 */         miscAmt = AmountValidation(getWelhamSchoolFormBean().getMiscFees(), getWelhamSchoolFormBean().getMiscPayment()).booleanValue();
/*      */       }
/*      */       else {
/*      */         
/* 3031 */         getWelhamSchoolFormBean().setMiscPayment("0");
/* 3032 */         miscAmt = true;
/*      */       } 
/* 3034 */       validAmt = (termAmt && miscAmt);
/*      */       
/* 3036 */       if (validAmt) {
/*      */         
/* 3038 */         String responseString = studentRegistrationService.insertWelhamSchoolDetails(getWelhamSchoolFormBean(), str1);
/*      */         
/* 3040 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 3041 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 3042 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 3043 */             addActionError(ErrorPropertyReader.getProperty("failed.to.add.student.data"));
/* 3044 */             return "welhamfailure";
/*      */           } 
/* 3046 */           addActionError(getText("error.occured.contact.administrator"));
/* 3047 */           return "welhamfailure"; }
/*      */         
/* 3049 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getWelhamSchoolFormBean().getStudentRegistrationId());
/* 3050 */         this.studentRegistrationFormBean.setTotalPayableFees(getWelhamSchoolFormBean().getTotalFees());
/* 3051 */         this.studentRegistrationFormBean.setStudentId(getWelhamSchoolFormBean().getApplicationNo());
/* 3052 */         this.studentRegistrationFormBean.setStudentName(getWelhamSchoolFormBean().getStdName());
/* 3053 */         this.studentRegistrationFormBean.setStudentEmailId(getWelhamSchoolFormBean().getStdEmailId());
/* 3054 */         this.studentRegistrationFormBean.setStudentMobileNumber(getWelhamSchoolFormBean().getStdMobile());
/* 3055 */         StudentDataService studentDataService = new StudentDataService();
/* 3056 */         List<StudentFeesFormBean> studentFeesList = studentDataService.getStudentFeesDetails(this.studentRegistrationFormBean.getBillerBranchId(), 
/* 3057 */             this.studentRegistrationFormBean.getStrCourse(), this.studentRegistrationFormBean.getStrCourseDetails(), 
/* 3058 */             this.studentRegistrationFormBean.getStrCourseType(), this.studentRegistrationFormBean.getStrCoursePattern(), 
/* 3059 */             this.studentRegistrationFormBean.getStrCourseTerm(), this.studentRegistrationFormBean.getStudentId(), 
/* 3060 */             str1);
/* 3061 */         this.studentRegistrationFormBean.setStudentFeesList(studentFeesList);
/* 3062 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 3064 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 3065 */         this.appData1 = new PaymentRequestBean();
/* 3066 */         this.appData1.setStudentRegistrationId(getWelhamSchoolFormBean().getStudentRegistrationId());
/*      */         
/* 3068 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 3070 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 3072 */         return "welhamfailure";
/*      */       } 
/* 3074 */     } catch (Exception e) {
/* 3075 */       logger.error("Exception  " + e);
/* 3076 */       return "error";
/*      */     } 
/*      */     
/* 3079 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3080 */     this.strPaymentType = "Online Payment";
/*      */     
/* 3082 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 3083 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 3085 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 3087 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 3089 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 3091 */     return FJAction.WELHAMSUCCESS;
/*      */   }
/*      */   public String NIPRRegistration() {
/* 3094 */     if (!isValidSession()) {
/* 3095 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 3098 */       logger.info("---------------------------------------------------------");
/* 3099 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 3100 */       logger.info("---------------------------------------------------------");
/* 3101 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3102 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 3103 */       logger.info("registeredUserId.." + registeredUserId);
/* 3104 */       getNiprOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 3105 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 3106 */       getAppData().setStrID("TEST");
/* 3107 */       String actualAmt = studentRegistrationService.getNIPRAmount(getNiprOnlineFormBean().getSelectDivision(), getNiprOnlineFormBean().getSelectPayCurrency(), "20-08-2016");
/*      */       
/* 3109 */       if (AmountValidation(getNiprOnlineFormBean().getAmount(), getNiprOnlineFormBean().getPayment()).booleanValue() && AmountValidation(actualAmt, getNiprOnlineFormBean().getPayment()).booleanValue() && 
/* 3110 */         actualAmt.equalsIgnoreCase(getNiprOnlineFormBean().getAmount())) {
/*      */         
/* 3112 */         String responseString = studentRegistrationService.insertNIPRStudentDetails(getNiprOnlineFormBean(), str1);
/*      */         
/* 3114 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 3115 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 3116 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 3117 */             addActionMessage("Failed to add student data.");
/* 3118 */             return "niprFailure";
/*      */           } 
/* 3120 */           addActionMessage("Error occured contact administrator.");
/* 3121 */           return "niprFailure"; }
/*      */         
/* 3123 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getNiprOnlineFormBean().getStudentRegistrationId());
/* 3124 */         this.studentRegistrationFormBean.setTotalPayableFees(getNiprOnlineFormBean().getAmount());
/* 3125 */         this.studentRegistrationFormBean.setStudentId(getNiprOnlineFormBean().getApplicationNo());
/* 3126 */         this.studentRegistrationFormBean.setStudentName(getNiprOnlineFormBean().getStdName());
/* 3127 */         this.studentRegistrationFormBean.setStudentEmailId(getNiprOnlineFormBean().getStdEmailId());
/* 3128 */         this.studentRegistrationFormBean.setCurrency(getNiprOnlineFormBean().getSelectPayCurrency());
/* 3129 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 3131 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 3132 */         this.appData1 = new PaymentRequestBean();
/* 3133 */         this.appData1.setStudentRegistrationId(getNiprOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 3135 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 3137 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 3139 */         addActionMessage("Amount Mismatched.");
/* 3140 */         return "niprFailure";
/*      */       } 
/* 3142 */     } catch (Exception e) {
/* 3143 */       logger.error("Exception  " + e);
/* 3144 */       return "error";
/*      */     } 
/*      */     
/* 3147 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3148 */     this.strPaymentType = "Online Payment";
/*      */     
/* 3150 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 3151 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 3153 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 3155 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 3157 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 3159 */     return "niprSuccess";
/*      */   }
/*      */   public String algoRegistration() {
/* 3162 */     if (!isValidSession())
/* 3163 */       return INVALID_SESSION; 
/*      */     try {
/*      */       boolean Appfee, CourseFee, ServiceTax, SBC, KKC, SGST, CGST;
/* 3166 */       logger.info("---------------------------------------------------------");
/* 3167 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 3168 */       logger.info("---------------------------------------------------------");
/* 3169 */       String str = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/*      */       
/* 3171 */       if (getCandEntryForm().getAmount() != null && !"".equalsIgnoreCase(getCandEntryForm().getAmount())) {
/*      */         
/* 3173 */         Appfee = AmountValidation(getCandEntryForm().getAmount(), getCandEntryForm().getPayment()).booleanValue();
/*      */       } else {
/*      */         
/* 3176 */         getCandEntryForm().setAmount("0");
/* 3177 */         Appfee = true;
/*      */       } 
/* 3179 */       if (getCandEntryForm().getCourseFeesAmt() != null && !"".equalsIgnoreCase(getCandEntryForm().getCourseFeesAmt())) {
/*      */         
/* 3181 */         CourseFee = AmountValidation(getCandEntryForm().getCourseFeesAmt(), getCandEntryForm().getCourseFees()).booleanValue();
/*      */       }
/*      */       else {
/*      */         
/* 3185 */         getCandEntryForm().setCourseFeesAmt("0");
/* 3186 */         CourseFee = true;
/*      */       } 
/* 3188 */       if (getCandEntryForm().getServiceTaxAmt() != null && !"".equalsIgnoreCase(getCandEntryForm().getServiceTaxAmt())) {
/*      */         
/* 3190 */         ServiceTax = AmountValidation(getCandEntryForm().getServiceTaxAmt(), getCandEntryForm().getServiceTax()).booleanValue();
/*      */       }
/*      */       else {
/*      */         
/* 3194 */         getCandEntryForm().setServiceTaxAmt("0");
/* 3195 */         ServiceTax = true;
/*      */       } 
/* 3197 */       if (getCandEntryForm().getSBCAmt() != null && !"".equalsIgnoreCase(getCandEntryForm().getSBCAmt())) {
/*      */         
/* 3199 */         SBC = AmountValidation(getCandEntryForm().getSBCAmt(), getCandEntryForm().getSBC()).booleanValue();
/*      */       }
/*      */       else {
/*      */         
/* 3203 */         getCandEntryForm().setSBCAmt("0");
/* 3204 */         SBC = true;
/*      */       } 
/* 3206 */       if (getCandEntryForm().getKKCAmt() != null && !"".equalsIgnoreCase(getCandEntryForm().getKKCAmt())) {
/*      */         
/* 3208 */         KKC = AmountValidation(getCandEntryForm().getKKCAmt(), getCandEntryForm().getKKC()).booleanValue();
/*      */       }
/*      */       else {
/*      */         
/* 3212 */         getCandEntryForm().setKKC("0");
/* 3213 */         KKC = true;
/*      */       } 
/* 3215 */       if (getCandEntryForm().getSgstTaxAmt() != null && !"".equalsIgnoreCase(getCandEntryForm().getSgstTaxAmt())) {
/*      */         
/* 3217 */         SGST = AmountValidation(getCandEntryForm().getSgstTaxAmt(), getCandEntryForm().getSgst()).booleanValue();
/*      */       }
/*      */       else {
/*      */         
/* 3221 */         getCandEntryForm().setSgst("0");
/* 3222 */         SGST = true;
/*      */       } 
/* 3224 */       if (getCandEntryForm().getCgstTaxAmt() != null && !"".equalsIgnoreCase(getCandEntryForm().getCgstTaxAmt())) {
/*      */         
/* 3226 */         CGST = AmountValidation(getCandEntryForm().getCgstTaxAmt(), getCandEntryForm().getCgst()).booleanValue();
/*      */       }
/*      */       else {
/*      */         
/* 3230 */         getCandEntryForm().setCgst("0");
/* 3231 */         CGST = true;
/*      */       } 
/*      */       
/* 3234 */       if (Appfee && CourseFee && ServiceTax && SBC && KKC && SGST && CGST) {
/*      */         
/* 3236 */         StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 3237 */         String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 3238 */         getCandEntryForm().setRegisteredUserId(registeredUserId);
/* 3239 */         setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/* 3240 */         getAppData().setStrID("TEST");
/* 3241 */         String responseString = studentRegistrationService.insertAlgotudentDetails(getCandEntryForm(), str);
/* 3242 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 3243 */           addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/*      */         }
/* 3245 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getCandEntryForm().getStudentRegistrationId());
/* 3246 */         this.studentRegistrationFormBean.setTotalPayableFees(getCandEntryForm().getAmount());
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 3251 */         this.studentRegistrationFormBean.setStudentId(getCandEntryForm().getApplicationNo());
/* 3252 */         this.studentRegistrationFormBean.setStudentEmailId(getCandEntryForm().getEmailId());
/* 3253 */         this.studentRegistrationFormBean.setStudentMobileNumber(getCandEntryForm().getMobileNo());
/* 3254 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 3256 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 3257 */         this.appData1 = new PaymentRequestBean();
/* 3258 */         this.appData1.setStudentRegistrationId(getCandEntryForm().getStudentRegistrationId());
/*      */         
/* 3260 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 3262 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 3266 */         return "angloFailure";
/*      */       } 
/* 3268 */     } catch (Exception e) {
/* 3269 */       logger.error("Exception  " + e);
/* 3270 */       return "error";
/*      */     } 
/*      */     
/* 3273 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3274 */     this.strPaymentType = "Online Payment";
/*      */     
/* 3276 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 3277 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 3279 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 3281 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 3283 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 3285 */     return "angloSuccess";
/*      */   }
/*      */   public String MGRRegistration() {
/* 3288 */     if (!isValidSession()) {
/* 3289 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 3292 */       logger.info("---------------------------------------------------------");
/* 3293 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 3294 */       logger.info("---------------------------------------------------------");
/* 3295 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3296 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 3297 */       logger.info("registeredUserId.." + registeredUserId);
/* 3298 */       getMgrMedicalOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 3299 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 3300 */       getAppData().setStrID("TEST");
/* 3301 */       if (AmountValidation(getMgrMedicalOnlineFormBean().getTotalAmount(), getMgrMedicalOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 3303 */         String responseString = studentRegistrationService.insertMGRStudentDetails(getMgrMedicalOnlineFormBean(), str1);
/* 3304 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 3305 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 3306 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 3307 */             addActionMessage("Failed to add student data.");
/* 3308 */             return "mgrFailure";
/*      */           } 
/* 3310 */           addActionMessage("Error occured contact administrator.");
/* 3311 */           return "mgrFailure"; }
/*      */         
/* 3313 */         getMgrMedicalOnlineFormBean().getFeeHeadList().removeAll(Collections.singleton(null));
/* 3314 */         int feeHeadListLength = getMgrMedicalOnlineFormBean().getFeeHeadList().size();
/* 3315 */         for (int i = 0; i < feeHeadListLength; i++) {
/*      */           
/* 3317 */           FeeHeadFormbean feeHeadFormbean = getMgrMedicalOnlineFormBean().getFeeHeadList().get(i);
/* 3318 */           if (feeHeadFormbean != null && 
/* 3319 */             !feeHeadFormbean.getStdFeeName().equalsIgnoreCase("") && !feeHeadFormbean.getStdtotalAmt().equalsIgnoreCase("") && 
/* 3320 */             !feeHeadFormbean.getNumberOfCopies().equalsIgnoreCase("") && !feeHeadFormbean.getEachStdAmt().equalsIgnoreCase("")) {
/* 3321 */             studentRegistrationService.insertFeeHeadDetails(feeHeadFormbean, getMgrMedicalOnlineFormBean().getApplicationNo());
/*      */           }
/*      */         } 
/*      */         
/* 3325 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getMgrMedicalOnlineFormBean().getStudentRegistrationId());
/* 3326 */         this.studentRegistrationFormBean.setTotalPayableFees(getMgrMedicalOnlineFormBean().getTotalAmount());
/* 3327 */         this.studentRegistrationFormBean.setStudentId(getMgrMedicalOnlineFormBean().getApplicationNo());
/* 3328 */         this.studentRegistrationFormBean.setStudentName(getMgrMedicalOnlineFormBean().getStdName());
/* 3329 */         this.studentRegistrationFormBean.setStudentEmailId(getMgrMedicalOnlineFormBean().getStdEmailId());
/* 3330 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 3332 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 3333 */         this.appData1 = new PaymentRequestBean();
/* 3334 */         this.appData1.setStudentRegistrationId(getMgrMedicalOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 3336 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 3338 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 3340 */         addActionMessage("Amount Mismatched.");
/* 3341 */         return "mgrFailure";
/*      */       } 
/* 3343 */     } catch (Exception e) {
/* 3344 */       logger.error("Exception  " + e);
/* 3345 */       return "error";
/*      */     } 
/*      */     
/* 3348 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3349 */     this.strPaymentType = "Online Payment";
/*      */     
/* 3351 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 3352 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 3354 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 3356 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 3358 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 3360 */     return "mgrSuccess";
/*      */   }
/*      */   public String UGIRegistration() {
/* 3363 */     if (!isValidSession()) {
/* 3364 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 3367 */       logger.info("---------------------------------------------------------");
/* 3368 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 3369 */       logger.info("---------------------------------------------------------");
/* 3370 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3371 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 3372 */       logger.info("registeredUserId.." + registeredUserId);
/* 3373 */       getUgiOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 3374 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 3375 */       getAppData().setStrID("TEST");
/* 3376 */       if (AmountValidation(getUgiOnlineFormBean().getTotalAmount(), getUgiOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 3378 */         String responseString = studentRegistrationService.insertUGIStudentDetails(getUgiOnlineFormBean(), str1);
/* 3379 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 3380 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 3381 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 3382 */             addActionMessage("Failed to add student data.");
/* 3383 */             return "ugiFailure";
/*      */           } 
/* 3385 */           addActionMessage("Error occured contact administrator.");
/* 3386 */           return "ugiFailure"; }
/*      */         
/* 3388 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getUgiOnlineFormBean().getStudentRegistrationId());
/* 3389 */         this.studentRegistrationFormBean.setTotalPayableFees(getUgiOnlineFormBean().getTotalAmount());
/* 3390 */         this.studentRegistrationFormBean.setStudentId(getUgiOnlineFormBean().getApplicationNo());
/* 3391 */         this.studentRegistrationFormBean.setStudentName(getUgiOnlineFormBean().getStudentName());
/* 3392 */         this.studentRegistrationFormBean.setStudentEmailId(getUgiOnlineFormBean().getEmailId());
/* 3393 */         this.studentRegistrationFormBean.setStudentMobileNumber(getUgiOnlineFormBean().getStdMobileNo());
/* 3394 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 3396 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 3397 */         this.appData1 = new PaymentRequestBean();
/* 3398 */         this.appData1.setStudentRegistrationId(getUgiOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 3400 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 3402 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 3404 */         addActionMessage("Amount Mismatched.");
/* 3405 */         return "ugiFailure";
/*      */       } 
/* 3407 */     } catch (Exception e) {
/* 3408 */       logger.error("Exception  " + e);
/* 3409 */       return "error";
/*      */     } 
/*      */     
/* 3412 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3413 */     this.strPaymentType = "Online Payment";
/*      */     
/* 3415 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 3416 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 3418 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 3420 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 3422 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 3424 */     return "ugiSuccess";
/*      */   }
/*      */   public String PMHPRegistration() {
/* 3427 */     if (!isValidSession()) {
/* 3428 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 3431 */       logger.info("---------------------------------------------------------");
/* 3432 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 3433 */       logger.info("---------------------------------------------------------");
/* 3434 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3435 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 3436 */       logger.info("registeredUserId.." + registeredUserId);
/* 3437 */       getUgiOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 3438 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 3439 */       getAppData().setStrID("TEST");
/* 3440 */       if (AmountValidation(getUgiOnlineFormBean().getTotalAmount(), getUgiOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 3442 */         String responseString = studentRegistrationService.insertPMHPStudentDetails(getUgiOnlineFormBean(), str1);
/* 3443 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 3444 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 3445 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 3446 */             addActionMessage("Failed to add student data.");
/* 3447 */             return "pmhpFailure";
/*      */           } 
/* 3449 */           addActionMessage("Error occured contact administrator.");
/* 3450 */           return "pmhpFailure"; }
/*      */         
/* 3452 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getUgiOnlineFormBean().getStudentRegistrationId());
/* 3453 */         this.studentRegistrationFormBean.setTotalPayableFees(getUgiOnlineFormBean().getTotalAmount());
/* 3454 */         this.studentRegistrationFormBean.setStudentId(getUgiOnlineFormBean().getApplicationNo());
/* 3455 */         this.studentRegistrationFormBean.setStudentName(getUgiOnlineFormBean().getStudentName());
/* 3456 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 3458 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 3459 */         this.appData1 = new PaymentRequestBean();
/* 3460 */         this.appData1.setStudentRegistrationId(getUgiOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 3462 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 3464 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 3466 */         addActionMessage("Amount Mismatched.");
/* 3467 */         return "pmhpFailure";
/*      */       } 
/* 3469 */     } catch (Exception e) {
/* 3470 */       logger.error("Exception  " + e);
/* 3471 */       return "error";
/*      */     } 
/*      */     
/* 3474 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3475 */     this.strPaymentType = "Online Payment";
/*      */     
/* 3477 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 3478 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 3480 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 3482 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 3484 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 3486 */     return "pmhpSuccess";
/*      */   }
/*      */ 
/*      */   
/*      */   public String DOONRegistration() {
/* 3491 */     if (!isValidSession()) {
/* 3492 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 3495 */       logger.info("---------------------------------------------------------");
/* 3496 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 3497 */       logger.info("---------------------------------------------------------");
/* 3498 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3499 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 3500 */       logger.info("registeredUserId.." + registeredUserId);
/* 3501 */       getDoonOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 3502 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 3503 */       getAppData().setStrID("TEST");
/* 3504 */       if (AmountValidation(getDoonOnlineFormBean().getDonateAmount(), getDoonOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 3506 */         String responseString = studentRegistrationService.insertDOONStudentDetails(getDoonOnlineFormBean(), str1);
/*      */         
/* 3508 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 3509 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 3510 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 3511 */             addActionMessage("Failed to add student data.");
/* 3512 */             return "doonFailure";
/*      */           } 
/* 3514 */           addActionMessage("Error occured contact administrator.");
/* 3515 */           return "doonFailure"; }
/*      */         
/* 3517 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getDoonOnlineFormBean().getStudentRegistrationId());
/* 3518 */         this.studentRegistrationFormBean.setTotalPayableFees(getDoonOnlineFormBean().getDonateAmount());
/* 3519 */         this.studentRegistrationFormBean.setStudentId(getDoonOnlineFormBean().getApplicationNo());
/* 3520 */         String studIDandName = "";
/* 3521 */         logger.info("StudentName:------------**StudentName***------------------------" + studIDandName);
/* 3522 */         this.studentRegistrationFormBean.setStudentName(studIDandName);
/* 3523 */         this.studentRegistrationFormBean.setStudentEmailId(getDoonOnlineFormBean().getEmailId());
/* 3524 */         this.studentRegistrationFormBean.setCurrency(getDoonOnlineFormBean().getCurrency());
/* 3525 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 3527 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 3528 */         this.appData1 = new PaymentRequestBean();
/* 3529 */         this.appData1.setStudentRegistrationId(getDoonOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 3531 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 3533 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 3535 */         addActionMessage("Amount Mismatched.");
/* 3536 */         return "doonFailure";
/*      */       } 
/* 3538 */     } catch (Exception e) {
/* 3539 */       logger.error("Exception  " + e);
/* 3540 */       return "error";
/*      */     } 
/*      */     
/* 3543 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3544 */     this.strPaymentType = "Online Payment";
/*      */     
/* 3546 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 3547 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 3549 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 3551 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 3553 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 3555 */     return "doonSuccess";
/*      */   }
/*      */   
/*      */   public String JRSTRegistration() {
/* 3559 */     if (!isValidSession()) {
/* 3560 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 3563 */       logger.info("---------------------------------------------------------");
/* 3564 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 3565 */       logger.info("---------------------------------------------------------");
/* 3566 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3567 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 3568 */       logger.info("registeredUserId.." + registeredUserId);
/* 3569 */       getJrstOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 3570 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 3571 */       getAppData().setStrID("TEST");
/* 3572 */       if (AmountValidation(getJrstOnlineFormBean().getAmount(), getJrstOnlineFormBean().getPaymentAmount()).booleanValue()) {
/*      */         
/* 3574 */         String responseString = studentRegistrationService.insertJRSTStudentDetails(getJrstOnlineFormBean(), str1);
/*      */         
/* 3576 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 3577 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 3578 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 3579 */             addActionMessage("Failed to add student data.");
/* 3580 */             return "jrstFailure";
/*      */           } 
/* 3582 */           addActionMessage("Error occured contact administrator.");
/* 3583 */           return "jrstFailure"; }
/*      */         
/* 3585 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getJrstOnlineFormBean().getStudentRegistrationId());
/* 3586 */         this.studentRegistrationFormBean.setTotalPayableFees(getJrstOnlineFormBean().getAmount());
/* 3587 */         this.studentRegistrationFormBean.setStudentId(getJrstOnlineFormBean().getApplicationNo());
/* 3588 */         this.studentRegistrationFormBean.setStudentName(getJrstOnlineFormBean().getStdName());
/* 3589 */         this.studentRegistrationFormBean.setStudentEmailId(getJrstOnlineFormBean().getEmailId());
/* 3590 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 3592 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 3593 */         this.appData1 = new PaymentRequestBean();
/* 3594 */         this.appData1.setStudentRegistrationId(getJrstOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 3596 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 3598 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 3600 */         addActionMessage("Amount Mismatched.");
/* 3601 */         return "jrstFailure";
/*      */       } 
/* 3603 */     } catch (Exception e) {
/* 3604 */       logger.error("Exception  " + e);
/* 3605 */       return "error";
/*      */     } 
/*      */     
/* 3608 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3609 */     this.strPaymentType = "Online Payment";
/*      */     
/* 3611 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 3612 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 3614 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 3616 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 3618 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 3620 */     return "jrstSuccess";
/*      */   }
/*      */   public String MGCRegistration() {
/* 3623 */     if (!isValidSession()) {
/* 3624 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 3627 */       logger.info("---------------------------------------------------------");
/* 3628 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 3629 */       logger.info("---------------------------------------------------------");
/* 3630 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3631 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 3632 */       logger.info("registeredUserId.." + registeredUserId);
/* 3633 */       getMgcOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 3634 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 3635 */       getAppData().setStrID("TEST");
/* 3636 */       if (AmountValidation(getMgcOnlineFormBean().getTotalAmount(), getMgcOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 3638 */         String responseString = studentRegistrationService.insertMGCStudentDetails(getMgcOnlineFormBean(), str1);
/* 3639 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 3640 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 3641 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 3642 */             addActionMessage("Failed to add student data.");
/* 3643 */             return "mgcFailure";
/*      */           } 
/* 3645 */           addActionMessage("Error occured contact administrator.");
/* 3646 */           return "mgcFailure"; }
/*      */         
/* 3648 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getMgcOnlineFormBean().getStudentRegistrationId());
/* 3649 */         this.studentRegistrationFormBean.setTotalPayableFees(getMgcOnlineFormBean().getTotalAmount());
/* 3650 */         this.studentRegistrationFormBean.setStudentId(getMgcOnlineFormBean().getApplicationNo());
/* 3651 */         this.studentRegistrationFormBean.setStudentName(getMgcOnlineFormBean().getStudentName());
/* 3652 */         this.studentRegistrationFormBean.setStudentEmailId(getMgcOnlineFormBean().getEmailId());
/* 3653 */         this.studentRegistrationFormBean.setStudentMobileNumber(getMgcOnlineFormBean().getStdMobileNo());
/* 3654 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 3656 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 3657 */         this.appData1 = new PaymentRequestBean();
/* 3658 */         this.appData1.setStudentRegistrationId(getMgcOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 3660 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 3662 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 3664 */         addActionMessage("Amount Mismatched.");
/* 3665 */         return "mgcFailure";
/*      */       } 
/* 3667 */     } catch (Exception e) {
/* 3668 */       logger.error("Exception  " + e);
/* 3669 */       return "error";
/*      */     } 
/*      */     
/* 3672 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3673 */     this.strPaymentType = "Online Payment";
/*      */     
/* 3675 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 3676 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 3678 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 3680 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 3682 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 3684 */     return "mgcSuccess";
/*      */   }
/*      */   public String DOTURegistration() {
/* 3687 */     if (!isValidSession()) {
/* 3688 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 3691 */       logger.info("--------------Inside DOTURegistration() START-------------------------------");
/* 3692 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 3693 */       logger.info("---------------------------------------------------------");
/* 3694 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3695 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 3696 */       logger.info("registeredUserId.." + registeredUserId);
/* 3697 */       getDotuOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 3698 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 3699 */       getAppData().setStrID("TEST");
/* 3700 */       if (getDotuOnlineFormBean().getChk().equalsIgnoreCase("Y")) {
/*      */         
/* 3702 */         if (AmountValidation(getDotuOnlineFormBean().getAmount(), getDotuOnlineFormBean().getPayment()).booleanValue()) {
/*      */           
/* 3704 */           String responseString = studentRegistrationService.insertDOTUStudentDetails(getDotuOnlineFormBean(), str1);
/*      */           
/* 3706 */           if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 3707 */           { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 3708 */           else { if ("NA".equalsIgnoreCase(responseString)) {
/* 3709 */               addActionMessage("Failed to add student data.");
/* 3710 */               return "dotuFailure";
/*      */             } 
/* 3712 */             addActionMessage("Error occured contact administrator.");
/* 3713 */             return "dotuFailure"; }
/*      */           
/* 3715 */           this.studentRegistrationFormBean = getRegisteredStudentDetails(getDotuOnlineFormBean().getStudentRegistrationId());
/* 3716 */           this.studentRegistrationFormBean.setTotalPayableFees(getDotuOnlineFormBean().getAmount());
/* 3717 */           this.studentRegistrationFormBean.setStudentId(getDotuOnlineFormBean().getApplicationNo());
/* 3718 */           String studIDandName = String.valueOf(getDotuOnlineFormBean().getStudentName()) + "::" + getDotuOnlineFormBean().getStudentId();
/* 3719 */           logger.info("StudentName:------------**StudentName***------------------------");
/* 3720 */           this.studentRegistrationFormBean.setStudentName(studIDandName);
/*      */           
/* 3722 */           this.studentRegistrationFormBean.setStudentEmailId(getDotuOnlineFormBean().getEmailId());
/* 3723 */           applyFees(this.studentRegistrationFormBean);
/*      */ 
/*      */           
/* 3726 */           getUserSessionMap().put("dotuSchoolNumber", getDotuOnlineFormBean().getSchoolNumber());
/* 3727 */           logger.info("Inside DOTURegistration School Number-->" + getDotuOnlineFormBean().getSchoolNumber());
/*      */ 
/*      */           
/* 3730 */           QuickPayAction quickPayAction = new QuickPayAction();
/* 3731 */           this.appData1 = new PaymentRequestBean();
/* 3732 */           this.appData1.setStudentRegistrationId(getDotuOnlineFormBean().getStudentRegistrationId());
/*      */           
/* 3734 */           quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */           
/* 3736 */           getUserSessionMap().put("APPDATA", getAppData1());
/*      */         } else {
/* 3738 */           addActionMessage("Amount Mismatched.");
/* 3739 */           return "dotuFailure";
/*      */         } 
/*      */       } else {
/* 3742 */         addActionMessage("Please select checkbox.");
/* 3743 */         return "dotuFailure";
/*      */       } 
/* 3745 */     } catch (Exception e) {
/* 3746 */       logger.error("Exception  " + e);
/* 3747 */       return "error";
/*      */     } 
/*      */     
/* 3750 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3751 */     this.strPaymentType = "Online Payment";
/*      */     
/* 3753 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 3754 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 3756 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 3758 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 3760 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/* 3761 */     getUserSessionMap().put("_feetype", getDotuOnlineFormBean().getFeeType());
/* 3762 */     getUserSessionMap().put("dotuOnlineFormBean", getDotuOnlineFormBean());
/*      */     
/* 3764 */     return "dotuSuccess";
/*      */   }
/*      */   public String NISMRegistration() {
/* 3767 */     if (!isValidSession())
/* 3768 */       return INVALID_SESSION; 
/*      */     try {
/*      */       boolean appdetails, CourseFeedetails;
/* 3771 */       logger.info("---------------------------------------------------------");
/* 3772 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 3773 */       logger.info("---------------------------------------------------------");
/* 3774 */       String str = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3781 */       if (getNismOnlineFormBean().getTotalfeeAmt() != null && !"".equalsIgnoreCase(getNismOnlineFormBean().getTotalfeeAmt())) {
/*      */         
/* 3783 */         appdetails = AmountValidation(getNismOnlineFormBean().getTotalfeeAmt(), getNismOnlineFormBean().getPaymentAmount()).booleanValue();
/*      */       } else {
/*      */         
/* 3786 */         getNismOnlineFormBean().setTotalfeeAmt("0");
/* 3787 */         appdetails = true;
/*      */       } 
/* 3789 */       if (getNismOnlineFormBean().getFeeAmt() != null && !"".equalsIgnoreCase(getNismOnlineFormBean().getFeeAmt())) {
/*      */         
/* 3791 */         CourseFeedetails = AmountValidation(getNismOnlineFormBean().getFeeAmt(), getNismOnlineFormBean().getPaymentAmountapp()).booleanValue();
/*      */       }
/*      */       else {
/*      */         
/* 3795 */         getNismOnlineFormBean().setFeeAmt("0");
/* 3796 */         CourseFeedetails = true;
/*      */       } 
/* 3798 */       if (appdetails && CourseFeedetails) {
/*      */ 
/*      */         
/* 3801 */         if (getNismOnlineFormBean().getPgName().toLowerCase().indexOf("Programme Fee".toLowerCase()) > 0) {
/* 3802 */           getNismOnlineFormBean().setFeeIndicator("PROG");
/*      */         }
/* 3804 */         else if (getNismOnlineFormBean().getPgName().toLowerCase().indexOf("Application Fee".toLowerCase()) > 0) {
/* 3805 */           getNismOnlineFormBean().setFeeIndicator("APP");
/*      */           
/* 3807 */           getNismOnlineFormBean().setTotalfeeAmt(getNismOnlineFormBean().getFeeAmt());
/*      */         } 
/*      */         
/* 3810 */         StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 3811 */         String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 3812 */         getNismOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 3813 */         setCourseData((CourseDetailsBean)getUserSessionMap().get("COURSEDATA"));
/* 3814 */         getAppData().setStrID("TEST");
/* 3815 */         String responseString = studentRegistrationService.insertNISMStudentDetails(getNismOnlineFormBean(), str);
/*      */         
/* 3817 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 3818 */           addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/*      */         }
/* 3820 */         List<NISMParticipantFormBean> partDetailsList = getNismOnlineFormBean().getParticipantList();
/* 3821 */         int partListLength = partDetailsList.size(); int i;
/* 3822 */         for (i = 0; i < partListLength; i++) {
/*      */           
/* 3824 */           NISMParticipantFormBean nismParticipantFormBean = partDetailsList.get(i);
/* 3825 */           studentRegistrationService.insertNISMParticipantDetails(nismParticipantFormBean, getNismOnlineFormBean().getApplicationNo());
/*      */         } 
/*      */         
/* 3828 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getNismOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 3830 */         if ("PROG".equalsIgnoreCase(getNismOnlineFormBean().getFeeIndicator())) {
/* 3831 */           this.studentRegistrationFormBean.setTotalPayableFees(getNismOnlineFormBean().getTotalfeeAmt());
/*      */         }
/* 3833 */         if ("APP".equalsIgnoreCase(getNismOnlineFormBean().getFeeIndicator())) {
/* 3834 */           this.studentRegistrationFormBean.setTotalPayableFees(getNismOnlineFormBean().getFeeAmt());
/*      */         }
/*      */ 
/*      */         
/* 3838 */         for (i = 0; i <= this.nismOnlineFormBean.getParticipantList().size() - 1; i++) {
/* 3839 */           NISMParticipantFormBean nismParticipantFormBean = this.nismOnlineFormBean.getParticipantList().get(i);
/* 3840 */           this.studentRegistrationFormBean.setStudentEmailId(nismParticipantFormBean.getEmailId());
/* 3841 */           this.studentRegistrationFormBean.setStudentMobileNumber(nismParticipantFormBean.getMobileNo());
/*      */         } 
/* 3843 */         this.studentRegistrationFormBean.setStudentId(getNismOnlineFormBean().getApplicationNo());
/*      */         
/* 3845 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 3847 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 3848 */         this.appData1 = new PaymentRequestBean();
/* 3849 */         this.appData1.setStudentRegistrationId(getNismOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 3851 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 3853 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 3855 */         addActionMessage("Amount Mismatched.");
/* 3856 */         return "nismFailure";
/*      */       
/*      */       }
/*      */ 
/*      */     
/*      */     }
/* 3862 */     catch (Exception e) {
/* 3863 */       logger.error("Exception  " + e);
/* 3864 */       return "error";
/*      */     } 
/*      */     
/* 3867 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3868 */     this.strPaymentType = "Online Payment";
/*      */     
/* 3870 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 3871 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 3873 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 3875 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 3877 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 3879 */     return "nismSuccess";
/*      */   }
/*      */   
/*      */   public String RPTMRegistration() {
/* 3883 */     if (!isValidSession()) {
/* 3884 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 3887 */       logger.info("---------------------------------------------------------");
/* 3888 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 3889 */       logger.info("---------------------------------------------------------");
/* 3890 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3891 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 3892 */       logger.info("registeredUserId.." + registeredUserId);
/* 3893 */       getRptmOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 3894 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 3895 */       getAppData().setStrID("TEST");
/* 3896 */       if (AmountValidation(getRptmOnlineFormBean().getStdTotalFee(), getRptmOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 3898 */         String responseString = studentRegistrationService.insertRPTMStudentDetails(getRptmOnlineFormBean(), str1);
/*      */         
/* 3900 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 3901 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 3902 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 3903 */             addActionMessage("Failed to add student data.");
/* 3904 */             return "rptmFailure";
/*      */           } 
/* 3906 */           addActionMessage("Error occured contact administrator.");
/* 3907 */           return "rptmFailure"; }
/*      */         
/* 3909 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getRptmOnlineFormBean().getStudentRegistrationId());
/* 3910 */         this.studentRegistrationFormBean.setTotalPayableFees(getRptmOnlineFormBean().getStdTotalFee());
/* 3911 */         this.studentRegistrationFormBean.setStudentId(getRptmOnlineFormBean().getApplicationNo());
/* 3912 */         this.studentRegistrationFormBean.setStudentName(getRptmOnlineFormBean().getStdName());
/* 3913 */         this.studentRegistrationFormBean.setStudentEmailId(getRptmOnlineFormBean().getStdEmailId());
/* 3914 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 3916 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 3917 */         this.appData1 = new PaymentRequestBean();
/* 3918 */         this.appData1.setStudentRegistrationId(getRptmOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 3920 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 3922 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 3924 */         addActionMessage("Amount Mismatched.");
/* 3925 */         return "rptmFailure";
/*      */       } 
/* 3927 */     } catch (Exception e) {
/* 3928 */       logger.error("Exception  " + e);
/* 3929 */       return "error";
/*      */     } 
/*      */     
/* 3932 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3933 */     this.strPaymentType = "Online Payment";
/*      */     
/* 3935 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 3936 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 3938 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 3940 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 3942 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 3944 */     return "rptmSuccess";
/*      */   }
/*      */   public String KaushalyaRegistration() {
/* 3947 */     if (!isValidSession()) {
/* 3948 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 3951 */       logger.info("---------------------------------------------------------");
/* 3952 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 3953 */       logger.info("---------------------------------------------------------");
/* 3954 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3955 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 3956 */       logger.info("registeredUserId.." + registeredUserId);
/* 3957 */       getKaushalyaFormBean().setRegisteredUserId(registeredUserId);
/* 3958 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 3959 */       getAppData().setStrID("TEST");
/* 3960 */       if (AmountValidation(getKaushalyaFormBean().getAmount(), getKaushalyaFormBean().getPayment()).booleanValue()) {
/*      */         
/* 3962 */         String responseString = studentRegistrationService.insertKaushalyaStudentDetails(getKaushalyaFormBean(), str1);
/*      */         
/* 3964 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 3965 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 3966 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 3967 */             addActionMessage("Failed to add student data.");
/* 3968 */             return "kaushFailure";
/*      */           } 
/* 3970 */           addActionMessage("Error occured contact administrator.");
/* 3971 */           return "kaushFailure"; }
/*      */         
/* 3973 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getKaushalyaFormBean().getStudentRegistrationId());
/* 3974 */         this.studentRegistrationFormBean.setTotalPayableFees(getKaushalyaFormBean().getAmount());
/* 3975 */         this.studentRegistrationFormBean.setStudentId(getKaushalyaFormBean().getApplicationNo());
/* 3976 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 3978 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 3979 */         this.appData1 = new PaymentRequestBean();
/* 3980 */         this.appData1.setStudentRegistrationId(getKaushalyaFormBean().getStudentRegistrationId());
/*      */         
/* 3982 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 3984 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 3986 */         addActionMessage("Amount Mismatched.");
/* 3987 */         return "kaushFailure";
/*      */       } 
/* 3989 */     } catch (Exception e) {
/* 3990 */       logger.error("Exception  " + e);
/* 3991 */       return "error";
/*      */     } 
/*      */     
/* 3994 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 3995 */     this.strPaymentType = "Online Payment";
/*      */     
/* 3997 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 3998 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 4000 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 4002 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 4004 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 4006 */     return "kaushSuccess";
/*      */   }
/*      */   public String RUNGTARegistration() {
/* 4009 */     if (!isValidSession()) {
/* 4010 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4013 */       logger.info("---------------------------------------------------------");
/* 4014 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4015 */       logger.info("---------------------------------------------------------");
/* 4016 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4017 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4018 */       logger.info("registeredUserId.." + registeredUserId);
/* 4019 */       getRungtanlineFormBean().setRegisteredUserId(registeredUserId);
/* 4020 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4021 */       getAppData().setStrID("TEST");
/* 4022 */       if (AmountValidation(getRungtanlineFormBean().getTotal(), getRungtanlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4024 */         String responseString = studentRegistrationService.insertRUNGTAStudentDetails(getRungtanlineFormBean(), str1);
/* 4025 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 4026 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 4027 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 4028 */             addActionMessage("Failed to add student data.");
/* 4029 */             return "rungtaFailure";
/*      */           } 
/* 4031 */           addActionMessage("Error occured contact administrator.");
/* 4032 */           return "rungtaFailure"; }
/*      */         
/* 4034 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getRungtanlineFormBean().getStudentRegistrationId());
/* 4035 */         this.studentRegistrationFormBean.setTotalPayableFees(getRungtanlineFormBean().getTotal());
/* 4036 */         this.studentRegistrationFormBean.setStudentId(getRungtanlineFormBean().getApplicationNo());
/*      */ 
/*      */ 
/*      */         
/* 4040 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4042 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4043 */         this.appData1 = new PaymentRequestBean();
/* 4044 */         this.appData1.setStudentRegistrationId(getRungtanlineFormBean().getStudentRegistrationId());
/*      */         
/* 4046 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 4048 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 4050 */         addActionMessage("Amount Mismatched.");
/* 4051 */         return "rungtaFailure";
/*      */       } 
/* 4053 */     } catch (Exception e) {
/* 4054 */       logger.error("Exception  " + e);
/* 4055 */       return "error";
/*      */     } 
/*      */     
/* 4058 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4059 */     this.strPaymentType = "Online Payment";
/*      */     
/* 4061 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 4062 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 4064 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 4066 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 4068 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 4070 */     return "rungtaSuccess";
/*      */   }
/*      */   public String ChristineRegistration() {
/* 4073 */     if (!isValidSession()) {
/* 4074 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4077 */       logger.info("---------------------------------------------------------");
/* 4078 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4079 */       logger.info("---------------------------------------------------------");
/* 4080 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4081 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4082 */       logger.info("registeredUserId.." + registeredUserId);
/* 4083 */       getChristineOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 4084 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4085 */       getAppData().setStrID("TEST");
/* 4086 */       if (AmountValidation(getChristineOnlineFormBean().getTotalAmount(), getChristineOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4088 */         String responseString = studentRegistrationService.insertChristineStudentDetails(getChristineOnlineFormBean(), str1);
/*      */         
/* 4090 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 4091 */           addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/*      */         }
/* 4093 */         List<form> feeDetailsList = getChristineOnlineFormBean().getFeeList();
/* 4094 */         int partListLength = feeDetailsList.size();
/* 4095 */         for (int i = 1; i < partListLength; i++) {
/*      */           
/* 4097 */           form form1 = feeDetailsList.get(i);
/* 4098 */           studentRegistrationService.insertchristinefeeDetails(form1, getChristineOnlineFormBean().getApplicationNo());
/*      */         } 
/*      */         
/* 4101 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getChristineOnlineFormBean().getStudentRegistrationId());
/* 4102 */         this.studentRegistrationFormBean.setTotalPayableFees(getChristineOnlineFormBean().getTotalAmount());
/* 4103 */         this.studentRegistrationFormBean.setStudentId(getChristineOnlineFormBean().getApplicationNo());
/*      */ 
/*      */         
/* 4106 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4108 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4109 */         this.appData1 = new PaymentRequestBean();
/* 4110 */         this.appData1.setStudentRegistrationId(getChristineOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 4112 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 4114 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 4116 */         addActionMessage("Amount Mismatched.");
/* 4117 */         return "christineFailure";
/*      */       } 
/* 4119 */     } catch (Exception e) {
/* 4120 */       logger.error("Exception  " + e);
/* 4121 */       return "error";
/*      */     } 
/*      */     
/* 4124 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4125 */     this.strPaymentType = "Online Payment";
/*      */     
/* 4127 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 4128 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 4130 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 4132 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 4134 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 4136 */     return "christineSuccess";
/*      */   }
/*      */   public String SharpRegistration() {
/* 4139 */     if (!isValidSession()) {
/* 4140 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4143 */       logger.info("---------------------------------------------------------");
/* 4144 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4145 */       logger.info("---------------------------------------------------------");
/* 4146 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4147 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4148 */       logger.info("registeredUserId.." + registeredUserId);
/* 4149 */       getSharpmindsOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 4150 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4151 */       getAppData().setStrID("TEST");
/* 4152 */       if (AmountValidation(getSharpmindsOnlineFormBean().getTotalAmount(), getSharpmindsOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4154 */         String responseString = studentRegistrationService.insertSHARPStudentDetails(getSharpmindsOnlineFormBean(), str1);
/*      */         
/* 4156 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 4157 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 4158 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 4159 */             addActionMessage("Failed to add student data.");
/* 4160 */             return "sharpFailure";
/*      */           } 
/* 4162 */           addActionMessage("Error occured contact administrator.");
/* 4163 */           return "sharpFailure"; }
/*      */         
/* 4165 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getSharpmindsOnlineFormBean().getStudentRegistrationId());
/* 4166 */         this.studentRegistrationFormBean.setTotalPayableFees(getSharpmindsOnlineFormBean().getTotalAmount());
/* 4167 */         this.studentRegistrationFormBean.setStudentId(getSharpmindsOnlineFormBean().getApplicationNo());
/* 4168 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4170 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4171 */         this.appData1 = new PaymentRequestBean();
/* 4172 */         this.appData1.setStudentRegistrationId(getSharpmindsOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 4174 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 4176 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 4178 */         addActionMessage("Amount Mismatched.");
/* 4179 */         return "sharpFailure";
/*      */       } 
/* 4181 */     } catch (Exception e) {
/* 4182 */       logger.error("Exception  " + e);
/* 4183 */       return "error";
/*      */     } 
/*      */     
/* 4186 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4187 */     this.strPaymentType = "Online Payment";
/*      */     
/* 4189 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 4190 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 4192 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 4194 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 4196 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 4198 */     return "sharpSuccess";
/*      */   }
/*      */   public String MATSRegistration() {
/* 4201 */     if (!isValidSession()) {
/* 4202 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4205 */       logger.info("---------------------------------------------------------");
/* 4206 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4207 */       logger.info("---------------------------------------------------------");
/* 4208 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4209 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4210 */       logger.info("registeredUserId.." + registeredUserId);
/* 4211 */       getMatsFeesForm().setRegisteredUserId(registeredUserId);
/* 4212 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4213 */       getAppData().setStrID("TEST");
/* 4214 */       if (AmountValidation(getMatsFeesForm().getTotalAmount(), getMatsFeesForm().getPayment()).booleanValue()) {
/*      */         
/* 4216 */         String responseString = studentRegistrationService.insertMATSStudentDetails(getMatsFeesForm(), str1);
/*      */         
/* 4218 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 4219 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 4220 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 4221 */             addActionMessage("Failed to add student data.");
/* 4222 */             return "matsFailure";
/*      */           } 
/* 4224 */           addActionMessage("Error occured contact administrator.");
/* 4225 */           return "matsFailure"; }
/*      */         
/* 4227 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getMatsFeesForm().getStudentRegistrationId());
/* 4228 */         this.studentRegistrationFormBean.setTotalPayableFees(getMatsFeesForm().getTotalAmount());
/* 4229 */         this.studentRegistrationFormBean.setStudentId(getMatsFeesForm().getApplicationNo());
/*      */ 
/*      */ 
/*      */         
/* 4233 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4235 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4236 */         this.appData1 = new PaymentRequestBean();
/* 4237 */         this.appData1.setStudentRegistrationId(getMatsFeesForm().getStudentRegistrationId());
/*      */         
/* 4239 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 4241 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 4243 */         addActionMessage("Amount Mismatched.");
/* 4244 */         return "matsFailure";
/*      */       } 
/* 4246 */     } catch (Exception e) {
/* 4247 */       logger.error("Exception  " + e);
/* 4248 */       return "error";
/*      */     } 
/*      */     
/* 4251 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4252 */     this.strPaymentType = "Online Payment";
/*      */     
/* 4254 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 4255 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 4257 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 4259 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 4261 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 4263 */     return "matsSuccess";
/*      */   }
/*      */   public String etoosRegistration() {
/* 4266 */     if (!isValidSession()) {
/* 4267 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4270 */       logger.info("---------------------------------------------------------");
/* 4271 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4272 */       logger.info("---------------------------------------------------------");
/* 4273 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4274 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4275 */       logger.info("registeredUserId.." + registeredUserId);
/* 4276 */       getEtoosOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 4277 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4278 */       getAppData().setStrID("TEST");
/* 4279 */       if (AmountValidation(getEtoosOnlineFormBean().getSalesAmount(), getEtoosOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4281 */         String responseString = studentRegistrationService.insertEtoosStudentDetails(getEtoosOnlineFormBean(), str1);
/*      */         
/* 4283 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 4284 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 4285 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 4286 */             addActionMessage("Failed to add student data.");
/* 4287 */             return "etoosFailure";
/*      */           } 
/* 4289 */           addActionMessage("Error occured contact administrator.");
/* 4290 */           return "etoosFailure"; }
/*      */         
/* 4292 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getEtoosOnlineFormBean().getStudentRegistrationId());
/* 4293 */         this.studentRegistrationFormBean.setTotalPayableFees(getEtoosOnlineFormBean().getSalesAmount());
/* 4294 */         this.studentRegistrationFormBean.setStudentId(getEtoosOnlineFormBean().getApplicationNo());
/* 4295 */         this.studentRegistrationFormBean.setStudentName(getEtoosOnlineFormBean().getName());
/* 4296 */         this.studentRegistrationFormBean.setStudentEmailId(getEtoosOnlineFormBean().getEmailId());
/* 4297 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4299 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4300 */         this.appData1 = new PaymentRequestBean();
/* 4301 */         this.appData1.setStudentRegistrationId(getEtoosOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 4303 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 4305 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 4307 */         addActionMessage("Amount Mismatched.");
/* 4308 */         return "etoosFailure";
/*      */       } 
/* 4310 */     } catch (Exception e) {
/* 4311 */       logger.error("Exception  " + e);
/* 4312 */       return "error";
/*      */     } 
/*      */     
/* 4315 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4316 */     this.strPaymentType = "Online Payment";
/*      */     
/* 4318 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 4319 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 4321 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 4323 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 4325 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 4327 */     return "etoossuccess";
/*      */   }
/*      */   public String BSPRRegistration() {
/* 4330 */     if (!isValidSession()) {
/* 4331 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4334 */       logger.info("---------------------------------------------------------");
/* 4335 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4336 */       logger.info("---------------------------------------------------------");
/* 4337 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4338 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4339 */       logger.info("registeredUserId.." + registeredUserId);
/* 4340 */       getBsprOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 4341 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4342 */       getAppData().setStrID("TEST");
/* 4343 */       if (AmountValidation(getBsprOnlineFormBean().getTotalFees(), getBsprOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4345 */         String responseString = studentRegistrationService.insertBSPRStudentDetails(getBsprOnlineFormBean(), str1);
/*      */         
/* 4347 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 4348 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 4349 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 4350 */             addActionMessage("Failed to add student data.");
/* 4351 */             return "bsprFailure";
/*      */           } 
/* 4353 */           addActionMessage("Error occured contact administrator.");
/* 4354 */           return "bsprFailure"; }
/*      */         
/* 4356 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getBsprOnlineFormBean().getStudentRegistrationId());
/* 4357 */         this.studentRegistrationFormBean.setTotalPayableFees(getBsprOnlineFormBean().getTotalFees());
/* 4358 */         this.studentRegistrationFormBean.setStudentId(getBsprOnlineFormBean().getApplicationNo());
/* 4359 */         this.studentRegistrationFormBean.setStudentName(getBsprOnlineFormBean().getTxtName());
/* 4360 */         this.studentRegistrationFormBean.setStudentEmailId(getBsprOnlineFormBean().getTxtEmailID());
/* 4361 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4363 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4364 */         this.appData1 = new PaymentRequestBean();
/* 4365 */         this.appData1.setStudentRegistrationId(getBsprOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 4367 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 4369 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 4371 */         addActionMessage("Amount Mismatched.");
/* 4372 */         return "bsprFailure";
/*      */       } 
/* 4374 */     } catch (Exception e) {
/* 4375 */       logger.error("Exception  " + e);
/* 4376 */       return "error";
/*      */     } 
/*      */     
/* 4379 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4380 */     this.strPaymentType = "Online Payment";
/*      */     
/* 4382 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 4383 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 4385 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 4387 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 4389 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 4391 */     return "bsprSuccess";
/*      */   }
/*      */   public String BKLIRegistration() {
/* 4394 */     if (!isValidSession()) {
/* 4395 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4398 */       logger.info("---------------------------------------------------------");
/* 4399 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4400 */       logger.info("---------------------------------------------------------");
/* 4401 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4402 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4403 */       logger.info("registeredUserId.." + registeredUserId);
/* 4404 */       getBkliOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 4405 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4406 */       getAppData().setStrID("TEST");
/* 4407 */       if (AmountValidation(getBkliOnlineFormBean().getAmount(), getBkliOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4409 */         String responseString = studentRegistrationService.insertBKLIStudentDetails(getBkliOnlineFormBean(), str1);
/*      */         
/* 4411 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 4412 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 4413 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 4414 */             addActionMessage("Failed to add student data.");
/* 4415 */             return "bkliFailure";
/*      */           } 
/* 4417 */           addActionMessage("Error occured contact administrator.");
/* 4418 */           return "bkliFailure"; }
/*      */         
/* 4420 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getBkliOnlineFormBean().getStudentRegistrationId());
/* 4421 */         this.studentRegistrationFormBean.setTotalPayableFees(getBkliOnlineFormBean().getAmount());
/* 4422 */         this.studentRegistrationFormBean.setStudentId(getBkliOnlineFormBean().getApplicationNo());
/* 4423 */         this.studentRegistrationFormBean.setStudentName(getBkliOnlineFormBean().getFirstName());
/* 4424 */         this.studentRegistrationFormBean.setStudentEmailId(getBkliOnlineFormBean().getEmailId());
/* 4425 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4427 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4428 */         this.appData1 = new PaymentRequestBean();
/* 4429 */         this.appData1.setStudentRegistrationId(getBkliOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 4431 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 4433 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 4435 */         addActionMessage("Amount Mismatched.");
/* 4436 */         return "bkliFailure";
/*      */       } 
/* 4438 */     } catch (Exception e) {
/* 4439 */       logger.error("Exception  " + e);
/* 4440 */       return "error";
/*      */     } 
/*      */     
/* 4443 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4444 */     this.strPaymentType = "Online Payment";
/*      */     
/* 4446 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 4447 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 4449 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 4451 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 4453 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 4455 */     return "bkliSuccess";
/*      */   }
/*      */   public String BKLIAdminRegistration() {
/* 4458 */     if (!isValidSession()) {
/* 4459 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4462 */       logger.info("---------------------------------------------------------");
/* 4463 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4464 */       logger.info("---------------------------------------------------------");
/* 4465 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4466 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4467 */       logger.info("registeredUserId.." + registeredUserId);
/* 4468 */       getBkliOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 4469 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4470 */       getAppData().setStrID("TEST");
/* 4471 */       LoginActionService loginActionService = new LoginActionService();
/* 4472 */       String response = loginActionService.validateBKLIAdmin(getBkliOnlineFormBean().getUsername(), getBkliOnlineFormBean().getPassword());
/* 4473 */       if (response != null && response.equalsIgnoreCase("failure")) {
/* 4474 */         addActionError(ErrorPropertyReader.getProperty("invalid.credentials"));
/* 4475 */         return "bkliFailure";
/*      */       } 
/* 4477 */       if (AmountValidation(getBkliOnlineFormBean().getAmount(), getBkliOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4479 */         String responseString = studentRegistrationService.insertBKLIAdminData(getBkliOnlineFormBean(), billerId);
/*      */         
/* 4481 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 4482 */           addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/* 4483 */           return "bkliFailure";
/* 4484 */         }  if ("NA".equalsIgnoreCase(responseString)) {
/* 4485 */           addActionMessage("Failed to add student data.");
/* 4486 */           return "bkliFailure";
/*      */         } 
/* 4488 */         addActionMessage("Error occured contact administrator.");
/* 4489 */         return "bkliFailure";
/*      */       } 
/*      */       
/* 4492 */       addActionMessage("Amount Mismatched.");
/* 4493 */       return "bkliFailure";
/*      */     
/*      */     }
/* 4496 */     catch (Exception e) {
/* 4497 */       logger.error("Exception  " + e);
/* 4498 */       return "error";
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String IIBMSRegistration() {
/* 4505 */     if (!isValidSession()) {
/* 4506 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4509 */       logger.info("---------------------------------------------------------");
/* 4510 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4511 */       logger.info("---------------------------------------------------------");
/* 4512 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4513 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4514 */       logger.info("registeredUserId.." + registeredUserId);
/* 4515 */       getIibmsFormBean().setRegisteredUserId(registeredUserId);
/* 4516 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4517 */       getAppData().setStrID("TEST");
/* 4518 */       if (AmountValidation(getIibmsFormBean().getPayAmount(), getIibmsFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4520 */         String responseString = studentRegistrationService.insertIibmsStudentDetails(getIibmsFormBean(), billerId);
/* 4521 */         logger.info("IIBMSRegistration: " + responseString);
/* 4522 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 4523 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 4524 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 4525 */             addActionMessage("Failed to add student data.");
/* 4526 */             return "iibmsFailure";
/*      */           } 
/* 4528 */           addActionMessage("Error occured contact administrator.");
/* 4529 */           return "iibmsFailure"; }
/*      */ 
/*      */ 
/*      */         
/* 4533 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getIibmsFormBean().getStudentRegistrationId());
/* 4534 */         this.studentRegistrationFormBean.setTotalPayableFees(getIibmsFormBean().getPayAmount());
/* 4535 */         this.studentRegistrationFormBean.setStudentId(getIibmsFormBean().getApplicationNo());
/* 4536 */         this.studentRegistrationFormBean.setStudentName(getIibmsFormBean().getName());
/* 4537 */         this.studentRegistrationFormBean.setStudentEmailId(getIibmsFormBean().getEmail());
/* 4538 */         this.studentRegistrationFormBean.setCurrency(getIibmsFormBean().getCurrencyType());
/* 4539 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4541 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4542 */         this.appData1 = new PaymentRequestBean();
/* 4543 */         this.appData1.setStudentRegistrationId(getIibmsFormBean().getStudentRegistrationId());
/* 4544 */         logger.info(" IIBMSRegistration--feesPayList :: " + this.feesPayList);
/* 4545 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 4547 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 4551 */         addActionMessage("Amount Mismatched.");
/* 4552 */         return "iibmsFailure";
/*      */       } 
/* 4554 */     } catch (Exception e) {
/*      */       
/* 4556 */       logger.error("Exception  " + e);
/* 4557 */       return "error";
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 4562 */     return "iibmsSuccess";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String PPARegistration() {
/* 4568 */     if (!isValidSession()) {
/* 4569 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4572 */       logger.info("---------------------------------------------------------");
/* 4573 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4574 */       logger.info("---------------------------------------------------------");
/* 4575 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4576 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4577 */       logger.info("registeredUserId.." + registeredUserId);
/* 4578 */       getPpaFormBean().setRegisteredUserId(registeredUserId);
/* 4579 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4580 */       getAppData().setStrID("TEST");
/* 4581 */       if (AmountValidation(getPpaFormBean().getPayAmount(), getPpaFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4583 */         String responseString = studentRegistrationService.insertPPAStudentDetails(getPpaFormBean(), billerId);
/* 4584 */         logger.info("PPARegistration: " + responseString);
/*      */         
/* 4586 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 4587 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 4588 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 4589 */             addActionMessage("Failed to add student data.");
/* 4590 */             return "ppaFailure";
/*      */           } 
/* 4592 */           addActionMessage("Error occured contact administrator.");
/* 4593 */           return "ppaFailure"; }
/*      */ 
/*      */ 
/*      */         
/* 4597 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getPpaFormBean().getStudentRegistrationId());
/* 4598 */         this.studentRegistrationFormBean.setTotalPayableFees(getPpaFormBean().getPayAmount());
/* 4599 */         this.studentRegistrationFormBean.setStudentId(getPpaFormBean().getApplicationNo());
/* 4600 */         this.studentRegistrationFormBean.setStudentName(getPpaFormBean().getName());
/* 4601 */         this.studentRegistrationFormBean.setStudentEmailId(getPpaFormBean().getEmailId());
/* 4602 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4604 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4605 */         this.appData1 = new PaymentRequestBean();
/* 4606 */         this.appData1.setStudentRegistrationId(getPpaFormBean().getStudentRegistrationId());
/* 4607 */         logger.info("PPARegistration--feesPayList :: " + this.feesPayList);
/* 4608 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 4610 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 4614 */         addActionMessage("Amount Mismatched.");
/* 4615 */         return "ppaFailure";
/*      */       } 
/* 4617 */     } catch (Exception e) {
/*      */       
/* 4619 */       logger.error("Exception  " + e);
/* 4620 */       return "error";
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4627 */     return "ppaSuccess";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String JayotiRegistration() {
/* 4633 */     if (!isValidSession()) {
/* 4634 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4637 */       logger.info("---------------------------------------------------------");
/* 4638 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4639 */       logger.info("---------------------------------------------------------");
/* 4640 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4641 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4642 */       logger.info("registeredUserId.." + registeredUserId);
/* 4643 */       getJayotiFormBean().setRegisteredUserId(registeredUserId);
/* 4644 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4645 */       getAppData().setStrID("TEST");
/* 4646 */       if (AmountValidation(getJayotiFormBean().getAmount(), getJayotiFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4648 */         String responseString = studentRegistrationService.insertJayotiStudentDetails(getJayotiFormBean(), str1);
/* 4649 */         logger.info("PrincipalRegistration: " + responseString);
/* 4650 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 4651 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 4652 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 4653 */             addActionMessage("Failed to add student data.");
/* 4654 */             return "jayotiFailure";
/*      */           } 
/* 4656 */           addActionMessage("Error occured contact administrator.");
/* 4657 */           return "jayotiFailure"; }
/*      */         
/* 4659 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getJayotiFormBean().getStudentRegistrationId());
/* 4660 */         this.studentRegistrationFormBean.setTotalPayableFees(getJayotiFormBean().getAmount());
/* 4661 */         this.studentRegistrationFormBean.setStudentId(getJayotiFormBean().getApplicationNo());
/* 4662 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4664 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4665 */         this.appData1 = new PaymentRequestBean();
/* 4666 */         this.appData1.setStudentRegistrationId(getJayotiFormBean().getStudentRegistrationId());
/* 4667 */         logger.info(" PrincipalRegistration--feesPayList :: " + this.feesPayList);
/* 4668 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 4670 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 4673 */         addActionMessage("Amount Mismatched.");
/* 4674 */         return "jayotiFailure";
/*      */       } 
/* 4676 */     } catch (Exception e) {
/*      */       
/* 4678 */       logger.error("Exception  " + e);
/* 4679 */       return "error";
/*      */     } 
/*      */     
/* 4682 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4683 */     this.strPaymentType = "Online Payment";
/*      */     
/* 4685 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 4686 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 4688 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 4690 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 4692 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 4694 */     return "jayotisuccess";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String PrincipalRegistration() {
/* 4700 */     if (!isValidSession()) {
/* 4701 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4704 */       logger.info("---------------------------------------------------------");
/* 4705 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4706 */       logger.info("---------------------------------------------------------");
/* 4707 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4708 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4709 */       logger.info("registeredUserId.." + registeredUserId);
/* 4710 */       getPrincipalOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 4711 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4712 */       getAppData().setStrID("TEST");
/* 4713 */       if (AmountValidation(getPrincipalOnlineFormBean().getAmount(), getPrincipalOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4715 */         String responseString = studentRegistrationService.insertPrincipalStudentDetails(getPrincipalOnlineFormBean(), billerId);
/* 4716 */         logger.info("PrincipalRegistration: " + responseString);
/* 4717 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 4718 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 4719 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 4720 */             addActionMessage("Failed to add student data.");
/* 4721 */             return "principalFailure";
/*      */           } 
/* 4723 */           addActionMessage("Error occured contact administrator.");
/* 4724 */           return "principalFailure"; }
/*      */         
/* 4726 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getPrincipalOnlineFormBean().getStudentRegistrationId());
/* 4727 */         this.studentRegistrationFormBean.setTotalPayableFees(getPrincipalOnlineFormBean().getAmount());
/* 4728 */         this.studentRegistrationFormBean.setStudentId(getPrincipalOnlineFormBean().getApplicationNo());
/* 4729 */         this.studentRegistrationFormBean.setStudentName(getPrincipalOnlineFormBean().getName());
/* 4730 */         this.studentRegistrationFormBean.setStudentEmailId(getPrincipalOnlineFormBean().getEmailId());
/* 4731 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4733 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4734 */         this.appData1 = new PaymentRequestBean();
/* 4735 */         this.appData1.setStudentRegistrationId(getPrincipalOnlineFormBean().getStudentRegistrationId());
/* 4736 */         logger.info(" PrincipalRegistration--feesPayList :: " + this.feesPayList);
/* 4737 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 4739 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 4742 */         addActionMessage("Amount Mismatched.");
/* 4743 */         return "principalFailure";
/*      */       } 
/* 4745 */     } catch (Exception e) {
/*      */       
/* 4747 */       logger.error("Exception  " + e);
/* 4748 */       return "error";
/*      */     } 
/*      */     
/* 4751 */     return "principalsuccess";
/*      */   }
/*      */   public String INITRegistration() {
/* 4754 */     if (!isValidSession()) {
/* 4755 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4758 */       logger.info("---------------------------------------------------------");
/* 4759 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4760 */       logger.info("---------------------------------------------------------");
/* 4761 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4762 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4763 */       logger.info("registeredUserId.." + registeredUserId);
/* 4764 */       getIntlOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 4765 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4766 */       getAppData().setStrID("TEST");
/* 4767 */       if (AmountValidation(getIntlOnlineFormBean().getTotalAmount(), getIntlOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4769 */         String responseString = studentRegistrationService.insertINTLStudentDetails(getIntlOnlineFormBean(), str1);
/* 4770 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 4771 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 4772 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 4773 */             addActionMessage("Failed to add student data.");
/* 4774 */             List<INTLCourseFormBean> list = studentRegistrationService.fetchINTLCourseDetails();
/* 4775 */             if (list != null && list.size() > 0) {
/* 4776 */               getUserSessionMap().put("_gnluChallanDataList", list);
/*      */             }
/* 4778 */             return "intlFailure";
/*      */           } 
/* 4780 */           List<INTLCourseFormBean> courseDataList = studentRegistrationService.fetchINTLCourseDetails();
/* 4781 */           if (courseDataList != null && courseDataList.size() > 0) {
/* 4782 */             getUserSessionMap().put("_gnluChallanDataList", courseDataList);
/*      */           }
/* 4784 */           addActionMessage("Error occured contact administrator.");
/* 4785 */           return "intlFailure"; }
/*      */         
/* 4787 */         getIntlOnlineFormBean().getCourseNameList().removeAll(Collections.singleton(null));
/* 4788 */         int courseListLength = getIntlOnlineFormBean().getCourseNameList().size();
/* 4789 */         for (int i = 0; i < courseListLength; i++) {
/*      */           
/* 4791 */           INTLCourseFormBean intlCourseFormBean = getIntlOnlineFormBean().getCourseNameList().get(i);
/* 4792 */           if (intlCourseFormBean != null && 
/* 4793 */             !intlCourseFormBean.getCourseName().equalsIgnoreCase("") && 
/* 4794 */             !intlCourseFormBean.getCourseAmount().equalsIgnoreCase("")) {
/* 4795 */             studentRegistrationService.insertINTLCourseDetails(intlCourseFormBean, getIntlOnlineFormBean().getApplicationNo());
/*      */           }
/*      */         } 
/*      */         
/* 4799 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getIntlOnlineFormBean().getStudentRegistrationId());
/* 4800 */         this.studentRegistrationFormBean.setTotalPayableFees(getIntlOnlineFormBean().getTotalAmount());
/* 4801 */         this.studentRegistrationFormBean.setStudentId(getIntlOnlineFormBean().getApplicationNo());
/* 4802 */         this.studentRegistrationFormBean.setStudentName(getIntlOnlineFormBean().getStudentName());
/* 4803 */         this.studentRegistrationFormBean.setStudentEmailId(getIntlOnlineFormBean().getEmailId());
/* 4804 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4806 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4807 */         this.appData1 = new PaymentRequestBean();
/* 4808 */         this.appData1.setStudentRegistrationId(getIntlOnlineFormBean().getStudentRegistrationId());
/*      */         
/* 4810 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 4812 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/* 4814 */         List<INTLCourseFormBean> courseDataList = studentRegistrationService.fetchINTLCourseDetails();
/* 4815 */         if (courseDataList != null && courseDataList.size() > 0) {
/* 4816 */           getUserSessionMap().put("_gnluChallanDataList", courseDataList);
/*      */         }
/* 4818 */         addActionMessage("Amount Mismatched.");
/* 4819 */         return "intlFailure";
/*      */       } 
/* 4821 */     } catch (Exception e) {
/* 4822 */       logger.error("Exception  " + e);
/* 4823 */       return "error";
/*      */     } 
/*      */     
/* 4826 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4827 */     this.strPaymentType = "Online Payment";
/*      */     
/* 4829 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 4830 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 4832 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 4834 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 4836 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 4838 */     return "intliitSuccess";
/*      */   }
/*      */   
/*      */   public String OrigenceRegistration() {
/* 4842 */     if (!isValidSession()) {
/* 4843 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4846 */       logger.info("---------------------------------------------------------");
/* 4847 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4848 */       logger.info("---------------------------------------------------------");
/* 4849 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4850 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4851 */       logger.info("registeredUserId.." + registeredUserId);
/* 4852 */       getOrigenceOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 4853 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4854 */       getAppData().setStrID("TEST");
/* 4855 */       if (AmountValidation(getOrigenceOnlineFormBean().getTotAmount(), getOrigenceOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4857 */         String responseString = studentRegistrationService.insertOrigenceStudentDetails(getOrigenceOnlineFormBean(), billerId);
/* 4858 */         logger.info("origence Registration: " + responseString);
/*      */         
/* 4860 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 4861 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 4862 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 4863 */             addActionMessage("Failed to add student data.");
/* 4864 */             return "origenceFailure";
/*      */           } 
/* 4866 */           addActionMessage("Error occured contact administrator.");
/* 4867 */           return "origenceFailure"; }
/*      */ 
/*      */ 
/*      */         
/* 4871 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getOrigenceOnlineFormBean().getStudentRegistrationId());
/* 4872 */         this.studentRegistrationFormBean.setTotalPayableFees(getOrigenceOnlineFormBean().getTotAmount());
/* 4873 */         this.studentRegistrationFormBean.setStudentId(getOrigenceOnlineFormBean().getApplicationNo());
/* 4874 */         this.studentRegistrationFormBean.setStudentName(getOrigenceOnlineFormBean().getStdName());
/* 4875 */         this.studentRegistrationFormBean.setStudentEmailId(getOrigenceOnlineFormBean().getEmail());
/* 4876 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4878 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4879 */         this.appData1 = new PaymentRequestBean();
/* 4880 */         this.appData1.setStudentRegistrationId(getOrigenceOnlineFormBean().getStudentRegistrationId());
/* 4881 */         logger.info("origence Registration--feesPayList :: " + this.feesPayList);
/* 4882 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 4884 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 4888 */         addActionMessage("Amount Mismatched.");
/* 4889 */         return "origenceFailure";
/*      */       } 
/* 4891 */     } catch (Exception e) {
/*      */       
/* 4893 */       logger.error("Exception  " + e);
/* 4894 */       return "error";
/*      */     } 
/*      */     
/* 4897 */     return "origenceSuccess";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String NATLRegistration() {
/* 4903 */     if (!isValidSession()) {
/* 4904 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4907 */       logger.info("---------------------------------------------------------");
/* 4908 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4909 */       logger.info("---------------------------------------------------------");
/* 4910 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4911 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4912 */       logger.info("registeredUserId.." + registeredUserId);
/* 4913 */       getNatlOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 4914 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4915 */       getAppData().setStrID("TEST");
/* 4916 */       if (AmountValidation(getNatlOnlineFormBean().getFeeAmount(), getNatlOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4918 */         String responseString = studentRegistrationService.insertNatlStudentDetails(getNatlOnlineFormBean(), billerId);
/* 4919 */         logger.info("NATL Registration: " + responseString);
/*      */         
/* 4921 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 4922 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 4923 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 4924 */             addActionMessage("Failed to add student data.");
/* 4925 */             return "natlFailure";
/*      */           } 
/* 4927 */           addActionMessage("Error occured contact administrator.");
/* 4928 */           return "natlFailure"; }
/*      */ 
/*      */ 
/*      */         
/* 4932 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getNatlOnlineFormBean().getStudentRegistrationId());
/* 4933 */         this.studentRegistrationFormBean.setTotalPayableFees(getNatlOnlineFormBean().getFeeAmount());
/* 4934 */         this.studentRegistrationFormBean.setStudentId(getNatlOnlineFormBean().getApplicationNo());
/* 4935 */         this.studentRegistrationFormBean.setStudentName(getNatlOnlineFormBean().getStdName());
/* 4936 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4938 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4939 */         this.appData1 = new PaymentRequestBean();
/* 4940 */         this.appData1.setStudentRegistrationId(getNatlOnlineFormBean().getStudentRegistrationId());
/* 4941 */         logger.info("NATL Registration--feesPayList :: " + this.feesPayList);
/* 4942 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 4944 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 4948 */         addActionMessage("Amount Mismatched.");
/* 4949 */         return "natlFailure";
/*      */       } 
/* 4951 */     } catch (Exception e) {
/*      */       
/* 4953 */       logger.error("Exception  " + e);
/* 4954 */       return "error";
/*      */     } 
/*      */     
/* 4957 */     return "natlSuccess";
/*      */   }
/*      */   
/*      */   public String LanRegistration() {
/* 4961 */     if (!isValidSession()) {
/* 4962 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 4965 */       logger.info("---------------------------------------------------------");
/* 4966 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 4967 */       logger.info("---------------------------------------------------------");
/* 4968 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 4969 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 4970 */       logger.info("registeredUserId.." + registeredUserId);
/* 4971 */       getLanOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 4972 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 4973 */       getAppData().setStrID("TEST");
/* 4974 */       if (AmountValidation(getLanOnlineFormBean().getTotAmount(), getLanOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 4976 */         String responseString = studentRegistrationService.insertLanStudentDetails(getLanOnlineFormBean(), billerId);
/* 4977 */         logger.info("Lan Registration: " + responseString);
/*      */         
/* 4979 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 4980 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 4981 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 4982 */             addActionMessage("Failed to add student data.");
/* 4983 */             return "lanFailure";
/*      */           } 
/* 4985 */           addActionMessage("Error occured contact administrator.");
/* 4986 */           return "lanFailure"; }
/*      */ 
/*      */ 
/*      */         
/* 4990 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getLanOnlineFormBean().getStudentRegistrationId());
/* 4991 */         this.studentRegistrationFormBean.setTotalPayableFees(getLanOnlineFormBean().getTotAmount());
/* 4992 */         this.studentRegistrationFormBean.setStudentId(getLanOnlineFormBean().getApplicationNo());
/* 4993 */         this.studentRegistrationFormBean.setStudentName(getLanOnlineFormBean().getStdName());
/* 4994 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 4996 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 4997 */         this.appData1 = new PaymentRequestBean();
/* 4998 */         this.appData1.setStudentRegistrationId(getLanOnlineFormBean().getStudentRegistrationId());
/* 4999 */         logger.info("Lan Registration--feesPayList :: " + this.feesPayList);
/* 5000 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 5002 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 5006 */         addActionMessage("Amount Mismatched.");
/* 5007 */         return "lanFailure";
/*      */       } 
/* 5009 */     } catch (Exception e) {
/*      */       
/* 5011 */       logger.error("Exception  " + e);
/* 5012 */       return "error";
/*      */     } 
/*      */     
/* 5015 */     return "lanSuccess";
/*      */   }
/*      */ 
/*      */   
/*      */   public String DTERegistration() {
/* 5020 */     HttpServletRequest request = ServletActionContext.getRequest();
/* 5021 */     HttpServletResponse response = ServletActionContext.getResponse();
/* 5022 */     RequestDispatcher rd = null;
/* 5023 */     String msg = "";
/* 5024 */     if (!isValidSession()) {
/* 5025 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 5028 */       logger.info("---------------------------------------------------------");
/* 5029 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 5030 */       logger.info("---------------------------------------------------------");
/* 5031 */       String instituteID = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5032 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5033 */       logger.info("registeredUserId.." + registeredUserId);
/* 5034 */       getDteFormBean().setRegisteredUserId(registeredUserId);
/* 5035 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5036 */       getAppData().setStrID("TEST");
/* 5037 */       getDteFormBean().setFreshAdmissionType(this.dteFormBean.getFreshAdmissionTypeName());
/* 5038 */       getDteFormBean().setFreshCourse(this.dteFormBean.getFreshCourseName());
/* 5039 */       getDteFormBean().setFreshCollege(this.dteFormBean.getFreshCollegeName());
/* 5040 */       getDteFormBean().setFreshBranch(this.dteFormBean.getFreshBranchNAme());
/* 5041 */       getDteFormBean().setFreshCategory(this.dteFormBean.getFreshCategoryName());
/*      */       
/* 5043 */       getDteFormBean().setRepeatAdmissionType(this.dteFormBean.getRepeatAdmissionTypeName());
/* 5044 */       getDteFormBean().setRepeatCourse(this.dteFormBean.getRepeatCourseName());
/* 5045 */       getDteFormBean().setRepeatCollege(this.dteFormBean.getRepeatCollegeNmae());
/* 5046 */       getDteFormBean().setRepeatBranch(this.dteFormBean.getRepeatBranchName());
/* 5047 */       getDteFormBean().setRepeatCategory(this.dteFormBean.getRepeatCategoryName());
/*      */       
/* 5049 */       String pmtMode = getDteFormBean().getDtePaymentMode();
/* 5050 */       if (pmtMode.equalsIgnoreCase("Over the Counter")) {
/*      */         
/* 5052 */         String responseStr = studentRegistrationService.validateDTEAdmin(getDteFormBean().getUserName(), getDteFormBean().getPassword());
/* 5053 */         if (responseStr != null && responseStr.equalsIgnoreCase("FAIL")) {
/*      */           
/* 5055 */           addActionError(ErrorPropertyReader.getProperty("invalid.credentials"));
/* 5056 */           return "dteFailure";
/*      */         } 
/*      */ 
/*      */         
/* 5060 */         if (AmountValidation(getDteFormBean().getTotalAmount(), getDteFormBean().getPayment()).booleanValue()) {
/*      */           
/* 5062 */           String responseString = studentRegistrationService.insertDTEStudentDetails(getDteFormBean(), instituteID);
/* 5063 */           logger.info("DTE Registration: " + responseString);
/*      */           
/* 5065 */           if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 5066 */             addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/* 5067 */             msg = "Successfully Added Data";
/* 5068 */             this.studentRegistrationFormBean = getRegisteredStudentDetails(getDteFormBean().getStudentRegistrationId());
/* 5069 */             this.studentRegistrationFormBean.setTotalPayableFees(getDteFormBean().getTotalAmount());
/* 5070 */             this.studentRegistrationFormBean.setStudentId(getDteFormBean().getApplicationNo());
/* 5071 */             this.studentRegistrationFormBean.setStudentName(getDteFormBean().getStdName());
/* 5072 */             this.appData1 = new PaymentRequestBean();
/* 5073 */             this.appData1.setStudentRegistrationId(getDteFormBean().getStudentRegistrationId());
/* 5074 */             Date date = new Date();
/* 5075 */             this.appData1.setStrTransactionDateTime(date.toString());
/* 5076 */             getUserSessionMap().put("APPDATA", getAppData1());
/* 5077 */             getUserSessionMap().put("DTEDATA", this.dteFormBean);
/* 5078 */             getUserSessionMap().put("INSTCODE", instituteID);
/* 5079 */             setUniqueSessionIdentifier(getUserSessionMap().get("sessionKey").toString());
/*      */           }
/*      */           else {
/*      */             
/* 5083 */             if ("NA".equalsIgnoreCase(responseString)) {
/* 5084 */               addActionMessage("Failed to add student data.");
/* 5085 */               return "dteFailure";
/*      */             } 
/* 5087 */             addActionMessage("Error occured contact administrator.");
/* 5088 */             return "dteFailure";
/*      */           }
/*      */         
/*      */         } else {
/*      */           
/* 5093 */           addActionMessage("Amount Mismatched.");
/* 5094 */           return "dteFailure";
/*      */         } 
/*      */         
/* 5097 */         return "OverTheCountert";
/*      */       } 
/*      */ 
/*      */       
/* 5101 */       if (AmountValidation(getDteFormBean().getTotalAmount(), getDteFormBean().getPayment()).booleanValue())
/*      */       {
/* 5103 */         String responseString = studentRegistrationService.insertDTEStudentDetails(getDteFormBean(), instituteID);
/* 5104 */         logger.info("DTE Registration: " + responseString);
/*      */         
/* 5106 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 5107 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 5108 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 5109 */             addActionMessage("Failed to add student data.");
/* 5110 */             return "dteFailure";
/*      */           } 
/* 5112 */           addActionMessage("Error occured contact administrator.");
/* 5113 */           return "dteFailure"; }
/*      */ 
/*      */ 
/*      */         
/* 5117 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getDteFormBean().getStudentRegistrationId());
/* 5118 */         this.studentRegistrationFormBean.setTotalPayableFees(getDteFormBean().getTotalAmount());
/* 5119 */         this.studentRegistrationFormBean.setStudentId(getDteFormBean().getApplicationNo());
/* 5120 */         this.studentRegistrationFormBean.setStudentName(getDteFormBean().getStdName());
/* 5121 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 5123 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 5124 */         this.appData1 = new PaymentRequestBean();
/* 5125 */         this.appData1.setStudentRegistrationId(getDteFormBean().getStudentRegistrationId());
/* 5126 */         logger.info("DTE Registration--feesPayList :: " + this.feesPayList);
/* 5127 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 5129 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else
/*      */       {
/* 5133 */         addActionMessage("Amount Mismatched.");
/* 5134 */         return "dteFailure";
/*      */       }
/*      */     
/* 5137 */     } catch (Exception e) {
/*      */       
/* 5139 */       logger.error("Exception  " + e);
/* 5140 */       return "error";
/*      */     } 
/*      */     
/* 5143 */     return "dteSuccess";
/*      */   }
/*      */   
/*      */   public String RUNGTAColRegistration() {
/* 5147 */     if (!isValidSession()) {
/* 5148 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 5151 */       logger.info("---------------------------------------------------------");
/* 5152 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 5153 */       logger.info("---------------------------------------------------------");
/* 5154 */       String instituteID = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5155 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5156 */       logger.info("registeredUserId.." + registeredUserId);
/* 5157 */       getRungtaCollegeFormBean().setRegisteredUserId(registeredUserId);
/* 5158 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5159 */       getAppData().setStrID("TEST");
/* 5160 */       if (AmountValidation(getRungtaCollegeFormBean().getTotalAmount(), getRungtaCollegeFormBean().getPayment()).booleanValue()) {
/*      */         
/* 5162 */         String responseString = studentRegistrationService.insertRungtaColStudentDetails(getRungtaCollegeFormBean(), instituteID);
/* 5163 */         logger.info("RungtaCol Registration: " + responseString);
/*      */         
/* 5165 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 5166 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 5167 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 5168 */             addActionMessage("Failed to add student data.");
/* 5169 */             return "rungtaColFailure";
/*      */           } 
/* 5171 */           addActionMessage("Error occured contact administrator.");
/* 5172 */           return "rungtaColFailure"; }
/*      */ 
/*      */ 
/*      */         
/* 5176 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getRungtaCollegeFormBean().getStudentRegistrationId());
/* 5177 */         this.studentRegistrationFormBean.setTotalPayableFees(getRungtaCollegeFormBean().getTotalAmount());
/* 5178 */         this.studentRegistrationFormBean.setStudentId(getRungtaCollegeFormBean().getApplicationNo());
/* 5179 */         this.studentRegistrationFormBean.setStudentName(getRungtaCollegeFormBean().getStdName());
/* 5180 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 5182 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 5183 */         this.appData1 = new PaymentRequestBean();
/* 5184 */         this.appData1.setStudentRegistrationId(getRungtaCollegeFormBean().getStudentRegistrationId());
/* 5185 */         logger.info("RungtaCol Registration--feesPayList :: " + this.feesPayList);
/* 5186 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 5188 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 5192 */         addActionMessage("Amount Mismatched.");
/* 5193 */         return "rungtaColFailure";
/*      */       } 
/* 5195 */     } catch (Exception e) {
/*      */       
/* 5197 */       logger.error("Exception  " + e);
/* 5198 */       return "error";
/*      */     } 
/*      */     
/* 5201 */     return "rungtaColSuccess";
/*      */   }
/*      */   
/*      */   public String addStudentPhotosForGPS(String billerId) throws IOException {
/* 5205 */     String destination = "";
/* 5206 */     String osName = System.getProperty("os.name");
/* 5207 */     if ("LINUX".equalsIgnoreCase(osName.trim())) {
/* 5208 */       destination = "/opt/jboss-eap-6.0/standalone/deployments/XJunction.war/StudentPhotos";
/*      */     } else {
/* 5210 */       destination = "H:/WorkSpace_for_UploadPhotos/StudentUploadPhotos/WebContent/StudentPhotos";
/*      */     } 
/*      */     
/* 5213 */     if (getGpsOnlineFormBean().getPassportImagfile() != null) {
/*      */       
/* 5215 */       long uniqueTime = System.currentTimeMillis();
/* 5216 */       getGpsOnlineFormBean().setStoreHeaderFile(saveUploadedFile(getGpsOnlineFormBean().getPassportImagfile(), 
/* 5217 */             getGpsOnlineFormBean().getPassportImagfileFileName(), 
/* 5218 */             billerId, 
/* 5219 */             "GPS_" + uniqueTime, 
/* 5220 */             TPSLConstants.FJA_STATIC_IMAGE_CONTENT_PATH));
/*      */       
/* 5222 */       saveUploadedFile(getGpsOnlineFormBean().getPassportImagfile(), 
/* 5223 */           getGpsOnlineFormBean().getPassportImagfileFileName(), 
/* 5224 */           billerId, 
/* 5225 */           "GPS_" + uniqueTime, 
/* 5226 */           destination);
/* 5227 */       getGpsOnlineFormBean().setPhotoProof(getGpsOnlineFormBean().getStoreHeaderFile().getName());
/*      */     } 
/*      */     
/* 5230 */     return "success";
/*      */   }
/*      */   public String GPSRegistration() {
/* 5233 */     if (!isValidSession()) {
/* 5234 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 5237 */       logger.info("---------------------------------------------------------");
/* 5238 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 5239 */       logger.info("---------------------------------------------------------");
/* 5240 */       String str1 = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5241 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5242 */       getGpsOnlineFormBean();
/*      */       
/* 5244 */       getGpsOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 5245 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5246 */       getAppData().setStrID("TEST");
/* 5247 */       addStudentPhotosForGPS(str1);
/* 5248 */       String responseString = studentRegistrationService.insertGPSStudentDetails(getGpsOnlineFormBean(), str1);
/*      */       
/* 5250 */       if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString)) {
/* 5251 */         addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully"));
/* 5252 */       } else if ("NA".equalsIgnoreCase(responseString)) {
/* 5253 */         addActionError(ErrorPropertyReader.getProperty("failed.to.add.student.data"));
/*      */       } else {
/* 5255 */         addActionError(getText("error.occured.contact.administrator"));
/*      */       } 
/* 5257 */       this.studentRegistrationFormBean = getRegisteredStudentDetails(getGpsOnlineFormBean().getStudentRegistrationId());
/* 5258 */       this.studentRegistrationFormBean.setTotalPayableFees(getGpsOnlineFormBean().getAmount());
/* 5259 */       this.studentRegistrationFormBean.setStudentId(getGpsOnlineFormBean().getApplicationNo());
/* 5260 */       applyFees(this.studentRegistrationFormBean);
/*      */       
/* 5262 */       QuickPayAction quickPayAction = new QuickPayAction();
/* 5263 */       this.appData1 = new PaymentRequestBean();
/* 5264 */       this.appData1.setStudentRegistrationId(getGpsOnlineFormBean().getStudentRegistrationId());
/*      */       
/* 5266 */       quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */       
/* 5268 */       getUserSessionMap().put("APPDATA", getAppData1());
/*      */     }
/* 5270 */     catch (Exception e) {
/* 5271 */       logger.error("Exception  " + e);
/* 5272 */       return "error";
/*      */     } 
/*      */     
/* 5275 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5276 */     this.strPaymentType = "Online Payment";
/*      */     
/* 5278 */     this.instituteConfigBean = (new InstituteMasterActionService()).getInstituteConfigDetails(billerId);
/* 5279 */     if (this.instituteConfigBean.getExtraCharges().equals("Y")) {
/*      */       
/* 5281 */       this.feesPayChargesFormBean = (new PaymentService()).getPaymentCharges(billerId);
/*      */       
/* 5283 */       getUserSessionMap().put("_feesPayChargesFormBean", this.feesPayChargesFormBean);
/*      */     } 
/* 5285 */     getUserSessionMap().put("_instituteConfigBean", this.instituteConfigBean);
/*      */     
/* 5287 */     return FJAction.GPSSUCCESS;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String TOLANIRegistration() {
/* 5293 */     if (!isValidSession()) {
/* 5294 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 5297 */       logger.info("---------------------------------------------------------");
/* 5298 */       logger.info("StudentRegistrationId : - " + 
/* 5299 */           getAppData().getStudentRegistrationId());
/* 5300 */       logger.info("---------------------------------------------------------");
/* 5301 */       String instituteID = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5302 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5303 */       logger.info("registeredUserId.." + registeredUserId);
/* 5304 */       getTolaniFormBean().setRegisteredUserId(registeredUserId);
/* 5305 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5306 */       getAppData().setStrID("TEST");
/*      */       
/* 5308 */       String responseString = studentRegistrationService.insertTOLANIStudentDetails(getTolaniFormBean(), instituteID);
/* 5309 */       logger.info("TOLANI Registration: " + responseString);
/*      */       
/* 5311 */       if (responseString != null && !"".equalsIgnoreCase(responseString) && 
/* 5312 */         "success".equalsIgnoreCase(responseString))
/* 5313 */       { addActionMessage(
/* 5314 */             ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 5315 */       else { if ("NA".equalsIgnoreCase(responseString)) {
/* 5316 */           addActionMessage("Failed to add student data.");
/* 5317 */           return "tolaniFailure";
/*      */         } 
/* 5319 */         addActionMessage("Error occured contact administrator.");
/* 5320 */         return "tolaniFailure"; }
/*      */ 
/*      */       
/* 5323 */       this.studentRegistrationFormBean = getRegisteredStudentDetails(getTolaniFormBean().getStudentRegistrationId());
/* 5324 */       this.studentRegistrationFormBean.setTotalPayableFees(getTolaniFormBean().getTotalFee());
/* 5325 */       this.studentRegistrationFormBean.setStudentId(getTolaniFormBean().getApplicationNo());
/* 5326 */       this.studentRegistrationFormBean.setStudentName(getTolaniFormBean().getStdName());
/* 5327 */       applyFees(this.studentRegistrationFormBean);
/*      */       
/* 5329 */       QuickPayAction quickPayAction = new QuickPayAction();
/* 5330 */       this.appData1 = new PaymentRequestBean();
/* 5331 */       this.appData1.setStudentRegistrationId(getTolaniFormBean().getStudentRegistrationId());
/* 5332 */       logger.info("TOLANI Registration--feesPayList :: " + this.feesPayList);
/* 5333 */       quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */       
/* 5335 */       getUserSessionMap().put("APPDATA", getAppData1());
/*      */     }
/* 5337 */     catch (Exception e) {
/* 5338 */       logger.error("Exception  " + e);
/* 5339 */       return "error";
/*      */     } 
/*      */     
/* 5342 */     return "tolaniSuccess";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String SHIVRegistration() {
/* 5350 */     if (!isValidSession()) {
/* 5351 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 5354 */       logger.info("---------------------------------------------------------");
/* 5355 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 5356 */       logger.info("---------------------------------------------------------");
/* 5357 */       String instituteID = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5358 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5359 */       logger.info("registeredUserId.." + registeredUserId);
/* 5360 */       getShivFormBean().setRegisteredUserId(registeredUserId);
/* 5361 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5362 */       getAppData().setStrID("TEST");
/* 5363 */       if (AmountValidation(getShivFormBean().getAmount(), getShivFormBean().getPayment()).booleanValue()) {
/*      */         
/* 5365 */         addStudentPhotosForGPS(instituteID);
/* 5366 */         getShivFormBean().setPhotoProof(getGpsOnlineFormBean().getStoreHeaderFile().getName());
/* 5367 */         String responseString = studentRegistrationService.insertSHIVStudentDetails(getShivFormBean(), instituteID);
/* 5368 */         logger.info("SHIV Registration: " + responseString);
/*      */         
/* 5370 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 5371 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 5372 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 5373 */             addActionMessage("Failed to add student data.");
/* 5374 */             return "shivFailure";
/*      */           } 
/* 5376 */           addActionMessage("Error occured contact administrator.");
/* 5377 */           return "shivFailure"; }
/*      */ 
/*      */ 
/*      */         
/* 5381 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getShivFormBean().getStudentRegistrationId());
/* 5382 */         this.studentRegistrationFormBean.setTotalPayableFees(getShivFormBean().getAmount());
/* 5383 */         this.studentRegistrationFormBean.setStudentId(getShivFormBean().getApplicationNo());
/* 5384 */         this.studentRegistrationFormBean.setStudentName(getShivFormBean().getApplicantName());
/* 5385 */         this.studentRegistrationFormBean.setStudentEmailId(getShivFormBean().getEmailId());
/* 5386 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 5388 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 5389 */         this.appData1 = new PaymentRequestBean();
/* 5390 */         this.appData1.setStudentRegistrationId(getShivFormBean().getStudentRegistrationId());
/* 5391 */         logger.info("SHIV Registration--feesPayList :: " + this.feesPayList);
/* 5392 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 5394 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 5398 */         addActionMessage("Amount Mismatched.");
/* 5399 */         return "shivFailure";
/*      */       } 
/* 5401 */     } catch (Exception e) {
/*      */       
/* 5403 */       logger.error("Exception  " + e);
/* 5404 */       return "error";
/*      */     } 
/*      */     
/* 5407 */     return "shivSuccess";
/*      */   }
/*      */   
/*      */   public String hydroPowerRegistration() {
/* 5411 */     if (!isValidSession()) {
/* 5412 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 5415 */       logger.info("---------------------------------------------------------");
/* 5416 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 5417 */       logger.info("---------------------------------------------------------");
/* 5418 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5419 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5420 */       logger.info("registeredUserId.." + registeredUserId);
/* 5421 */       getHydroPowerOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 5422 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5423 */       getAppData().setStrID("TEST");
/* 5424 */       if (AmountValidation(getHydroPowerOnlineFormBean().getTotAmount(), getHydroPowerOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 5426 */         String responseString = studentRegistrationService.insertHydroPowerStudentDetails(getHydroPowerOnlineFormBean(), billerId);
/* 5427 */         logger.info("Hydro Power Registration: " + responseString);
/*      */         
/* 5429 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 5430 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 5431 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 5432 */             addActionMessage("Failed to add student data.");
/* 5433 */             return "hydroPowerfailure";
/*      */           } 
/* 5435 */           addActionMessage("Error occured contact administrator.");
/* 5436 */           return "hydroPowerfailure"; }
/*      */ 
/*      */         
/* 5439 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getHydroPowerOnlineFormBean().getStudentRegistrationId());
/* 5440 */         this.studentRegistrationFormBean.setTotalPayableFees(getHydroPowerOnlineFormBean().getTotAmount());
/* 5441 */         this.studentRegistrationFormBean.setStudentId(getHydroPowerOnlineFormBean().getApplicationNo());
/* 5442 */         this.studentRegistrationFormBean.setStudentName(getHydroPowerOnlineFormBean().getStdName());
/* 5443 */         this.studentRegistrationFormBean.setStudentEmailId(getHydroPowerOnlineFormBean().getMobile());
/* 5444 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 5446 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 5447 */         this.appData1 = new PaymentRequestBean();
/* 5448 */         this.appData1.setStudentRegistrationId(getHydroPowerOnlineFormBean().getStudentRegistrationId());
/* 5449 */         logger.info("Hydro Power Registration--feesPayList :: " + this.feesPayList);
/* 5450 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 5452 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 5456 */         addActionMessage("Amount Mismatched.");
/* 5457 */         return "hydroPowerfailure";
/*      */       } 
/* 5459 */     } catch (Exception e) {
/*      */       
/* 5461 */       logger.error("Exception  " + e);
/* 5462 */       return "error";
/*      */     } 
/*      */     
/* 5465 */     return "hydroSuccess";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String SWARARegistration() {
/* 5471 */     if (!isValidSession()) {
/* 5472 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 5475 */       logger.info("---------------------------------------------------------");
/* 5476 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 5477 */       logger.info("---------------------------------------------------------");
/* 5478 */       String instituteID = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5479 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5480 */       logger.info("registeredUserId.." + registeredUserId);
/* 5481 */       getSwaraFormBean().setRegisteredUserId(registeredUserId);
/* 5482 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5483 */       getAppData().setStrID("TEST");
/* 5484 */       if (AmountValidation(getSwaraFormBean().getAmount(), getSwaraFormBean().getPayment()).booleanValue()) {
/*      */         
/* 5486 */         String responseString = studentRegistrationService.insertSWARAStudentDetails(getSwaraFormBean(), instituteID);
/* 5487 */         logger.info("SAWRA Registration: " + responseString);
/*      */         
/* 5489 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 5490 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 5491 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 5492 */             addActionMessage("Failed to add student data.");
/* 5493 */             return "swaraFailure";
/*      */           } 
/* 5495 */           addActionMessage("Error occured contact administrator.");
/* 5496 */           return "swaraFailure"; }
/*      */ 
/*      */ 
/*      */         
/* 5500 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getSwaraFormBean().getStudentRegistrationId());
/* 5501 */         this.studentRegistrationFormBean.setTotalPayableFees(getSwaraFormBean().getAmount());
/* 5502 */         this.studentRegistrationFormBean.setStudentId(getSwaraFormBean().getApplicationNo());
/* 5503 */         this.studentRegistrationFormBean.setStudentName(getSwaraFormBean().getStdName());
/* 5504 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 5506 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 5507 */         this.appData1 = new PaymentRequestBean();
/* 5508 */         this.appData1.setStudentRegistrationId(getSwaraFormBean().getStudentRegistrationId());
/* 5509 */         logger.info("SWARA Registration--feesPayList :: " + this.feesPayList);
/* 5510 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 5512 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 5516 */         addActionMessage("Amount Mismatched.");
/* 5517 */         return "swaraFailure";
/*      */       } 
/* 5519 */     } catch (Exception e) {
/*      */       
/* 5521 */       logger.error("Exception  " + e);
/* 5522 */       return "error";
/*      */     } 
/*      */     
/* 5525 */     return "swaraSuccess";
/*      */   }
/*      */   
/*      */   public String ambikaPurRegistration() {
/* 5529 */     if (!isValidSession()) {
/* 5530 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 5533 */       logger.info("---------------------------------------------------------");
/* 5534 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 5535 */       logger.info("---------------------------------------------------------");
/* 5536 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5537 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5538 */       logger.info("registeredUserId.." + registeredUserId);
/* 5539 */       getAmbikaPurOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 5540 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5541 */       getAppData().setStrID("TEST");
/* 5542 */       if (AmountValidation(getAmbikaPurOnlineFormBean().getTotAmount(), getAmbikaPurOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 5545 */         String responseString = studentRegistrationService.insertAmbikaPurStudentDetails(getAmbikaPurOnlineFormBean(), billerId);
/* 5546 */         logger.info("AmbikaPur Registration: " + responseString);
/*      */         
/* 5548 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 5549 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 5550 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 5551 */             addActionMessage("Failed to add student data.");
/* 5552 */             return "ambikafailure";
/*      */           } 
/* 5554 */           addActionMessage("Error occured contact administrator.");
/* 5555 */           return "ambikafailure"; }
/*      */ 
/*      */         
/* 5558 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getAmbikaPurOnlineFormBean().getStudentRegistrationId());
/* 5559 */         this.studentRegistrationFormBean.setTotalPayableFees(getAmbikaPurOnlineFormBean().getTotAmount());
/* 5560 */         this.studentRegistrationFormBean.setStudentId(getAmbikaPurOnlineFormBean().getApplicationNo());
/* 5561 */         this.studentRegistrationFormBean.setStudentName(getAmbikaPurOnlineFormBean().getStudentName());
/* 5562 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 5564 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 5565 */         this.appData1 = new PaymentRequestBean();
/* 5566 */         this.appData1.setStudentRegistrationId(getAmbikaPurOnlineFormBean().getStudentRegistrationId());
/* 5567 */         logger.info("Hydro Power Registration--feesPayList :: " + this.feesPayList);
/* 5568 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 5570 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 5574 */         addActionMessage("Amount Mismatched.");
/* 5575 */         return "ambikafailure";
/*      */       } 
/* 5577 */     } catch (Exception e) {
/*      */       
/* 5579 */       logger.error("Exception  " + e);
/* 5580 */       return "error";
/*      */     } 
/* 5582 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String shepaRegistration() {
/* 5587 */     if (!isValidSession()) {
/* 5588 */       return INVALID_SESSION;
/*      */     }
/*      */     
/*      */     try {
/* 5592 */       logger.info("---------------------------------------------------------");
/* 5593 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 5594 */       logger.info("---------------------------------------------------------");
/* 5595 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5596 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5597 */       logger.info("registeredUserId.." + registeredUserId);
/*      */       
/* 5599 */       getShepaOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 5600 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5601 */       getAppData().setStrID("TEST");
/*      */ 
/*      */       
/* 5604 */       String responseString = studentRegistrationService.insertShepaStudentDetails(getShepaOnlineFormBean(), billerId);
/* 5605 */       logger.info("Shepa Registration: " + responseString);
/*      */       
/* 5607 */       if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 5608 */       { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 5609 */       else { if ("NA".equalsIgnoreCase(responseString)) {
/* 5610 */           addActionMessage("Failed to add student data.");
/* 5611 */           return "shapafailure";
/*      */         } 
/* 5613 */         addActionMessage("Error occured contact administrator.");
/* 5614 */         return "shapafailure"; }
/*      */ 
/*      */       
/* 5617 */       this.studentRegistrationFormBean = getRegisteredStudentDetails(getShepaOnlineFormBean().getStudentRegistrationId());
/* 5618 */       this.studentRegistrationFormBean.setTotalPayableFees(getShepaOnlineFormBean().getTotalFee());
/* 5619 */       this.studentRegistrationFormBean.setStudentId(getShepaOnlineFormBean().getApplicationNo());
/* 5620 */       this.studentRegistrationFormBean.setStudentName(getShepaOnlineFormBean().getStudentName());
/* 5621 */       this.studentRegistrationFormBean.setStudentEmailId(getShepaOnlineFormBean().getMobileNumber());
/* 5622 */       applyFees(this.studentRegistrationFormBean);
/*      */       
/* 5624 */       QuickPayAction quickPayAction = new QuickPayAction();
/* 5625 */       this.appData1 = new PaymentRequestBean();
/* 5626 */       this.appData1.setStudentRegistrationId(getShepaOnlineFormBean().getStudentRegistrationId());
/* 5627 */       logger.info("shepaRegistration--feesPayList :: " + this.feesPayList);
/* 5628 */       quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */       
/* 5630 */       getUserSessionMap().put("APPDATA", getAppData1());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 5637 */     catch (Exception e) {
/*      */       
/* 5639 */       logger.error("Exception  " + e);
/* 5640 */       return "error";
/*      */     } 
/*      */     
/* 5643 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String krishakRegistration() {
/* 5650 */     if (!isValidSession()) {
/* 5651 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 5654 */       logger.info("---------------------------------------------------------");
/* 5655 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 5656 */       logger.info("---------------------------------------------------------");
/* 5657 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5658 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5659 */       logger.info("registeredUserId.." + registeredUserId);
/* 5660 */       getKrishakFormBean().setRegisteredUserId(registeredUserId);
/* 5661 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5662 */       getAppData().setStrID("TEST");
/* 5663 */       if (AmountValidation(getKrishakFormBean().getFeesAmount(), getKrishakFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 5666 */         String responseString = studentRegistrationService.insertKrishakStudentDetails(getKrishakFormBean(), billerId);
/* 5667 */         logger.info("AmbikaPur Registration: " + responseString);
/*      */         
/* 5669 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 5670 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 5671 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 5672 */             addActionMessage("Failed to add student data.");
/* 5673 */             return "krishakfailure";
/*      */           } 
/* 5675 */           addActionMessage("Error occured contact administrator.");
/* 5676 */           return "krishakfailure"; }
/*      */ 
/*      */         
/* 5679 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getKrishakFormBean().getStudentRegistrationId());
/* 5680 */         this.studentRegistrationFormBean.setTotalPayableFees(getKrishakFormBean().getFeesAmount());
/* 5681 */         this.studentRegistrationFormBean.setStudentId(getKrishakFormBean().getApplicationNo());
/* 5682 */         this.studentRegistrationFormBean.setStudentName(getKrishakFormBean().getName());
/* 5683 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 5685 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 5686 */         this.appData1 = new PaymentRequestBean();
/* 5687 */         this.appData1.setStudentRegistrationId(getKrishakFormBean().getStudentRegistrationId());
/* 5688 */         logger.info("Krishak PG--feesPayList :: " + this.feesPayList);
/* 5689 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 5691 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 5695 */         addActionMessage("Amount Mismatched.");
/* 5696 */         return "krishakfailure";
/*      */       } 
/* 5698 */     } catch (Exception e) {
/*      */       
/* 5700 */       logger.error("Exception  " + e);
/* 5701 */       return "error";
/*      */     } 
/*      */     
/* 5704 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String weidnerRegistration() {
/* 5709 */     if (!isValidSession()) {
/* 5710 */       return INVALID_SESSION;
/*      */     }
/*      */     
/*      */     try {
/* 5714 */       logger.info("---------------------------------------------------------");
/* 5715 */       logger.info("weidnerRegistration StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 5716 */       logger.info("---------------------------------------------------------");
/* 5717 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5718 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5719 */       logger.info("weidnerRegistration registeredUserId.." + registeredUserId);
/*      */       
/* 5721 */       getWeidnerOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 5722 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5723 */       getAppData().setStrID("TEST");
/*      */ 
/*      */       
/* 5726 */       String responseString = studentRegistrationService.insertWeinderStudentDetails(getWeidnerOnlineFormBean(), billerId);
/* 5727 */       logger.info("Weinder Registration: " + responseString);
/*      */       
/* 5729 */       if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 5730 */       { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 5731 */       else { if ("NA".equalsIgnoreCase(responseString)) {
/* 5732 */           addActionMessage("Failed to add student data.");
/* 5733 */           return "weinderfailure";
/*      */         } 
/* 5735 */         addActionMessage("Error occured contact administrator.");
/* 5736 */         return "weinderfailure"; }
/*      */ 
/*      */       
/* 5739 */       this.studentRegistrationFormBean = getRegisteredStudentDetails(getWeidnerOnlineFormBean().getStudentRegistrationId());
/* 5740 */       this.studentRegistrationFormBean.setTotalPayableFees(getWeidnerOnlineFormBean().getFeesAmount());
/* 5741 */       this.studentRegistrationFormBean.setStudentId(getWeidnerOnlineFormBean().getApplicationNo());
/* 5742 */       this.studentRegistrationFormBean.setStudentName(getWeidnerOnlineFormBean().getStudentName());
/* 5743 */       applyFees(this.studentRegistrationFormBean);
/*      */       
/* 5745 */       QuickPayAction quickPayAction = new QuickPayAction();
/* 5746 */       this.appData1 = new PaymentRequestBean();
/* 5747 */       this.appData1.setStudentRegistrationId(getWeidnerOnlineFormBean().getStudentRegistrationId());
/* 5748 */       logger.info("weinderRegistration--feesPayList :: " + this.feesPayList);
/* 5749 */       quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */       
/* 5751 */       getUserSessionMap().put("APPDATA", getAppData1());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 5758 */     catch (Exception e) {
/*      */       
/* 5760 */       logger.error("Exception  " + e);
/* 5761 */       return "error";
/*      */     } 
/*      */     
/* 5764 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String finolexRegistration() {
/* 5769 */     if (!isValidSession()) {
/* 5770 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 5773 */       logger.info("---------------------------------------------------------");
/* 5774 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 5775 */       logger.info("---------------------------------------------------------");
/* 5776 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5777 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5778 */       logger.info("registeredUserId.." + registeredUserId);
/* 5779 */       getFinolexOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 5780 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5781 */       getAppData().setStrID("TEST");
/* 5782 */       if (AmountValidation(getFinolexOnlineFormBean().getTotAmount(), getFinolexOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 5785 */         String responseString = studentRegistrationService.insertFinolexStudentDetails(getFinolexOnlineFormBean(), billerId);
/* 5786 */         logger.info("AmbikaPur Registration: " + responseString);
/*      */         
/* 5788 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 5789 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 5790 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 5791 */             addActionMessage("Failed to add student data.");
/* 5792 */             return "finolexfailure";
/*      */           } 
/* 5794 */           addActionMessage("Error occured contact administrator.");
/* 5795 */           return "finolexfailure"; }
/*      */ 
/*      */         
/* 5798 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getFinolexOnlineFormBean().getStudentRegistrationId());
/* 5799 */         this.studentRegistrationFormBean.setTotalPayableFees(getFinolexOnlineFormBean().getTotAmount());
/* 5800 */         this.studentRegistrationFormBean.setStudentId(getFinolexOnlineFormBean().getApplicationNo());
/* 5801 */         this.studentRegistrationFormBean.setStudentName(getFinolexOnlineFormBean().getStudentName());
/* 5802 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 5804 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 5805 */         this.appData1 = new PaymentRequestBean();
/* 5806 */         this.appData1.setStudentRegistrationId(getFinolexOnlineFormBean().getStudentRegistrationId());
/* 5807 */         logger.info("FinolexOnline Registration--feesPayList :: " + this.feesPayList);
/* 5808 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 5810 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 5814 */         addActionMessage("Amount Mismatched.");
/* 5815 */         return "finolexfailure";
/*      */       } 
/* 5817 */     } catch (Exception e) {
/*      */       
/* 5819 */       logger.error("Exception  " + e);
/* 5820 */       return "error";
/*      */     } 
/*      */     
/* 5823 */     return "success";
/*      */   }
/*      */   
/*      */   public String yugantarRegistration() {
/* 5827 */     if (!isValidSession()) {
/* 5828 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 5831 */       logger.info("---------------------------------------------------------");
/* 5832 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 5833 */       logger.info("---------------------------------------------------------");
/* 5834 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5835 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5836 */       logger.info("registeredUserId.." + registeredUserId);
/* 5837 */       getShepaOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 5838 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5839 */       getAppData().setStrID("TEST");
/*      */ 
/*      */ 
/*      */       
/* 5843 */       String responseString = studentRegistrationService.insertYugantarStudentDetails(getShepaOnlineFormBean(), billerId);
/* 5844 */       logger.info("Yugantar Registration: " + responseString);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 5849 */       if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 5850 */       { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 5851 */       else { if ("NA".equalsIgnoreCase(responseString)) {
/* 5852 */           addActionMessage("Failed to add student data.");
/* 5853 */           return "yugantarfailure";
/*      */         } 
/* 5855 */         addActionMessage("Error occured contact administrator.");
/* 5856 */         return "yugantarfailure"; }
/*      */ 
/*      */       
/* 5859 */       this.studentRegistrationFormBean = getRegisteredStudentDetails(getShepaOnlineFormBean().getStudentRegistrationId());
/* 5860 */       this.studentRegistrationFormBean.setTotalPayableFees(getShepaOnlineFormBean().getFees());
/* 5861 */       this.studentRegistrationFormBean.setStudentId(getShepaOnlineFormBean().getApplicationNo());
/* 5862 */       this.studentRegistrationFormBean.setStudentName(getShepaOnlineFormBean().getStudentName());
/* 5863 */       applyFees(this.studentRegistrationFormBean);
/*      */       
/* 5865 */       QuickPayAction quickPayAction = new QuickPayAction();
/* 5866 */       this.appData1 = new PaymentRequestBean();
/* 5867 */       this.appData1.setStudentRegistrationId(getShepaOnlineFormBean().getStudentRegistrationId());
/* 5868 */       logger.info("Yugantar Registration--feesPayList :: " + this.feesPayList);
/* 5869 */       quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */       
/* 5871 */       getUserSessionMap().put("APPDATA", getAppData1());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 5878 */     catch (Exception e) {
/*      */       
/* 5880 */       logger.error("Exception  " + e);
/* 5881 */       return "error";
/*      */     } 
/*      */     
/* 5884 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String HNBGURegistration() {
/* 5890 */     if (!isValidSession()) {
/* 5891 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 5894 */       logger.info("---------------------------------------------------------");
/* 5895 */       logger.info("StudentRegistrationId : -HNBGURegistration " + getAppData().getStudentRegistrationId());
/* 5896 */       logger.info("---------------------------------------------------------");
/* 5897 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5898 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5899 */       logger.info("registeredUserId..HNBGURegistration" + registeredUserId);
/*      */       
/* 5901 */       getHNBGUFormBean().setRegisteredUserId(registeredUserId);
/* 5902 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5903 */       getAppData().setStrID("TEST");
/*      */ 
/*      */ 
/*      */       
/* 5907 */       String responseString = studentRegistrationService.insertHnbguStudentDetails(getHNBGUFormBean(), billerId);
/* 5908 */       logger.info("HNBGURegistration Registration: " + responseString);
/*      */       
/* 5910 */       if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 5911 */       { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 5912 */       else { if ("NA".equalsIgnoreCase(responseString)) {
/* 5913 */           addActionMessage("Failed to add student data.");
/* 5914 */           return "HNBGUfailure";
/*      */         } 
/* 5916 */         addActionMessage("Error occured contact administrator.");
/* 5917 */         return "HNBGUfailure"; }
/*      */ 
/*      */       
/* 5920 */       this.studentRegistrationFormBean = getRegisteredStudentDetails(getHNBGUFormBean().getStudentRegistrationId());
/* 5921 */       this.studentRegistrationFormBean.setTotalPayableFees(getHNBGUFormBean().getTotalFee());
/* 5922 */       this.studentRegistrationFormBean.setStudentId(getHNBGUFormBean().getApplicationNo());
/* 5923 */       this.studentRegistrationFormBean.setStudentName(getHNBGUFormBean().getName());
/* 5924 */       this.studentRegistrationFormBean.setStudentEmailId(getHNBGUFormBean().getEmailId());
/* 5925 */       applyFees(this.studentRegistrationFormBean);
/*      */       
/* 5927 */       QuickPayAction quickPayAction = new QuickPayAction();
/* 5928 */       this.appData1 = new PaymentRequestBean();
/* 5929 */       this.appData1.setStudentRegistrationId(getHNBGUFormBean().getStudentRegistrationId());
/* 5930 */       logger.info("HNBGU PG--feesPayList :: " + this.feesPayList);
/* 5931 */       quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */       
/* 5933 */       getUserSessionMap().put("APPDATA", getAppData1());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 5940 */     catch (Exception e) {
/*      */       
/* 5942 */       logger.error("Exception  " + e);
/* 5943 */       return "error";
/*      */     } 
/*      */     
/* 5946 */     return "success";
/*      */   }
/*      */   
/*      */   public String icbrRegistration() {
/* 5950 */     if (!isValidSession()) {
/* 5951 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 5954 */       logger.info("---------------------------------------------------------");
/* 5955 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 5956 */       logger.info("---------------------------------------------------------");
/* 5957 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 5958 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 5959 */       logger.info("registeredUserId.." + registeredUserId);
/* 5960 */       getIcbrOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 5961 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 5962 */       getAppData().setStrID("TEST");
/* 5963 */       if (AmountValidation(getIcbrOnlineFormBean().getTotalAmount(), getIcbrOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 5965 */         String responseString = studentRegistrationService.insertICBRStudentDetails(getIcbrOnlineFormBean(), billerId);
/* 5966 */         logger.info("ICBR Registration: " + responseString);
/*      */         
/* 5968 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 5969 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 5970 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 5971 */             addActionMessage("Failed to add student data.");
/* 5972 */             return "icbrfailure";
/*      */           } 
/* 5974 */           addActionMessage("Error occured contact administrator.");
/* 5975 */           return "icbrfailure"; }
/*      */ 
/*      */         
/* 5978 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getIcbrOnlineFormBean().getStudentRegistrationId());
/* 5979 */         this.studentRegistrationFormBean.setTotalPayableFees(getIcbrOnlineFormBean().getTotalAmount());
/* 5980 */         this.studentRegistrationFormBean.setStudentId(getIcbrOnlineFormBean().getApplicationNo());
/* 5981 */         this.studentRegistrationFormBean.setStudentName(getIcbrOnlineFormBean().getNameofApplicant());
/* 5982 */         this.studentRegistrationFormBean.setStudentEmailId(getIcbrOnlineFormBean().getMobileNo());
/* 5983 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 5985 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 5986 */         this.appData1 = new PaymentRequestBean();
/* 5987 */         this.appData1.setStudentRegistrationId(getIcbrOnlineFormBean().getStudentRegistrationId());
/* 5988 */         logger.info("ICBRRegistration--feesPayList :: " + this.feesPayList);
/* 5989 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 5991 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 5995 */         addActionMessage("Amount Mismatched.");
/* 5996 */         return "icbrfailure";
/*      */       } 
/* 5998 */     } catch (Exception e) {
/*      */       
/* 6000 */       logger.error("Exception  " + e);
/* 6001 */       return "error";
/*      */     } 
/*      */     
/* 6004 */     return "success";
/*      */   }
/*      */   
/*      */   public String mahadeviyadavRegistration() {
/* 6008 */     if (!isValidSession()) {
/* 6009 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6012 */       logger.info("---------------------------------------------------------");
/* 6013 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6014 */       logger.info("---------------------------------------------------------");
/* 6015 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6016 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6017 */       logger.info("registeredUserId.." + registeredUserId);
/* 6018 */       getMahadeviYadavOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 6019 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6020 */       getAppData().setStrID("TEST");
/* 6021 */       if (AmountValidation(getMahadeviYadavOnlineFormBean().getTotalFees(), getMahadeviYadavOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 6024 */         String responseString = studentRegistrationService.insertMahadeviYadavStudentDetails(getMahadeviYadavOnlineFormBean(), billerId);
/* 6025 */         logger.info("MahadeviYadav Registration: " + responseString);
/*      */         
/* 6027 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6028 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6029 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6030 */             addActionMessage("Failed to add student data.");
/* 6031 */             return "mahadeviyadavfailure";
/*      */           } 
/* 6033 */           addActionMessage("Error occured contact administrator.");
/* 6034 */           return "mahadeviyadavfailure"; }
/*      */ 
/*      */         
/* 6037 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getMahadeviYadavOnlineFormBean().getStudentRegistrationId());
/* 6038 */         this.studentRegistrationFormBean.setTotalPayableFees(getMahadeviYadavOnlineFormBean().getTotalFees());
/* 6039 */         this.studentRegistrationFormBean.setStudentId(getMahadeviYadavOnlineFormBean().getApplicationNo());
/* 6040 */         this.studentRegistrationFormBean.setStudentName(getMahadeviYadavOnlineFormBean().getStdName());
/* 6041 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6043 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6044 */         this.appData1 = new PaymentRequestBean();
/* 6045 */         this.appData1.setStudentRegistrationId(getMahadeviYadavOnlineFormBean().getStudentRegistrationId());
/* 6046 */         logger.info("Mahadevi yadav PG--feesPayList :: " + this.feesPayList);
/* 6047 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 6049 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 6053 */         addActionMessage("Amount Mismatched.");
/* 6054 */         return "mahadeviyadavfailure";
/*      */       } 
/* 6056 */     } catch (Exception e) {
/*      */       
/* 6058 */       logger.error("Exception  " + e);
/* 6059 */       return "error";
/*      */     } 
/*      */     
/* 6062 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String abhayRegistration() {
/* 6068 */     if (!isValidSession()) {
/* 6069 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6072 */       logger.info("---------------------------------------------------------");
/* 6073 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6074 */       logger.info("---------------------------------------------------------");
/* 6075 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6076 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6077 */       logger.info("registeredUserId.." + registeredUserId);
/* 6078 */       getAbhayFormBean().setRegisteredUserId(registeredUserId);
/*      */       
/* 6080 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6081 */       getAppData().setStrID("TEST");
/* 6082 */       if (AmountValidation(getAbhayFormBean().getTotalfees(), getAbhayFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 6085 */         String responseString = studentRegistrationService.insertAbhayStudentDetails(getAbhayFormBean(), billerId);
/* 6086 */         logger.info("Abhay Registration: " + responseString);
/*      */         
/* 6088 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6089 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6090 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6091 */             addActionMessage("Failed to add student data.");
/* 6092 */             return "abhayfailure";
/*      */           } 
/* 6094 */           addActionMessage("Error occured contact administrator.");
/* 6095 */           return "abhayfailure"; }
/*      */ 
/*      */         
/* 6098 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getAbhayFormBean().getStudentRegistrationId());
/* 6099 */         this.studentRegistrationFormBean.setTotalPayableFees(getAbhayFormBean().getTotalfees());
/* 6100 */         this.studentRegistrationFormBean.setStudentId(getAbhayFormBean().getApplicationNo());
/* 6101 */         this.studentRegistrationFormBean.setStudentName(getAbhayFormBean().getName());
/* 6102 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6104 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6105 */         this.appData1 = new PaymentRequestBean();
/* 6106 */         this.appData1.setStudentRegistrationId(getAbhayFormBean().getStudentRegistrationId());
/* 6107 */         logger.info("Abhay --feesPayList :: " + this.feesPayList);
/* 6108 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 6110 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 6114 */         addActionMessage("Amount Mismatched.");
/* 6115 */         return "abhayfailure";
/*      */       } 
/* 6117 */     } catch (Exception e) {
/*      */       
/* 6119 */       logger.error("Exception  " + e);
/* 6120 */       return "error";
/*      */     } 
/*      */     
/* 6123 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String rajRegistration() {
/* 6129 */     if (!isValidSession()) {
/* 6130 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6133 */       logger.info("---------------------------------------------------------");
/* 6134 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6135 */       logger.info("---------------------------------------------------------");
/* 6136 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6137 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6138 */       logger.info("registeredUserId.." + registeredUserId);
/* 6139 */       getRajFormBean().setRegisteredUserId(registeredUserId);
/*      */       
/* 6141 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6142 */       getAppData().setStrID("TEST");
/* 6143 */       if (AmountValidation(getRajFormBean().getTotalfees(), getRajFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 6146 */         String responseString = studentRegistrationService.insertRajStudentDetails(getRajFormBean(), billerId);
/* 6147 */         logger.info("Raj Registration: " + responseString);
/*      */         
/* 6149 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6150 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6151 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6152 */             addActionMessage("Failed to add student data.");
/* 6153 */             return "rajfailure";
/*      */           } 
/* 6155 */           addActionMessage("Error occured contact administrator.");
/* 6156 */           return "rajfailure"; }
/*      */ 
/*      */         
/* 6159 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getRajFormBean().getStudentRegistrationId());
/* 6160 */         this.studentRegistrationFormBean.setTotalPayableFees(getRajFormBean().getTotalfees());
/* 6161 */         this.studentRegistrationFormBean.setStudentId(getRajFormBean().getApplicationNo());
/* 6162 */         this.studentRegistrationFormBean.setStudentName(getRajFormBean().getName());
/* 6163 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6165 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6166 */         this.appData1 = new PaymentRequestBean();
/* 6167 */         this.appData1.setStudentRegistrationId(getRajFormBean().getStudentRegistrationId());
/* 6168 */         logger.info("Raj --feesPayList :: " + this.feesPayList);
/* 6169 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 6171 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 6175 */         addActionMessage("Amount Mismatched.");
/* 6176 */         return "rajfailure";
/*      */       } 
/* 6178 */     } catch (Exception e) {
/*      */       
/* 6180 */       logger.error("Exception  " + e);
/* 6181 */       return "error";
/*      */     } 
/*      */     
/* 6184 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String oercRegistration() {
/* 6189 */     if (!isValidSession()) {
/* 6190 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6193 */       logger.info("---------------------------------------------------------");
/* 6194 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6195 */       logger.info("---------------------------------------------------------");
/* 6196 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6197 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6198 */       logger.info("registeredUserId.." + registeredUserId);
/* 6199 */       getOercOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 6200 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6201 */       getAppData().setStrID("TEST");
/* 6202 */       if (AmountValidation(getOercOnlineFormBean().getTotAmount(), getOercOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 6204 */         String responseString = studentRegistrationService.insertOercStudentDetails(getOercOnlineFormBean(), billerId);
/* 6205 */         logger.info("OERC Registration: " + responseString);
/*      */         
/* 6207 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6208 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6209 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6210 */             addActionMessage("Failed to add student data.");
/* 6211 */             return "oercfailure";
/*      */           } 
/* 6213 */           addActionMessage("Error occured contact administrator.");
/* 6214 */           return "oercfailure"; }
/*      */ 
/*      */         
/* 6217 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getOercOnlineFormBean().getStudentRegistrationId());
/* 6218 */         this.studentRegistrationFormBean.setTotalPayableFees(getOercOnlineFormBean().getTotAmount());
/* 6219 */         this.studentRegistrationFormBean.setStudentId(getOercOnlineFormBean().getApplicationNo());
/* 6220 */         this.studentRegistrationFormBean.setStudentName(getOercOnlineFormBean().getStdName());
/* 6221 */         this.studentRegistrationFormBean.setStudentEmailId(getOercOnlineFormBean().getEmailId());
/* 6222 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6224 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6225 */         this.appData1 = new PaymentRequestBean();
/* 6226 */         this.appData1.setStudentRegistrationId(getOercOnlineFormBean().getStudentRegistrationId());
/* 6227 */         logger.info("OERC Registration--feesPayList :: " + this.feesPayList);
/* 6228 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 6230 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 6234 */         addActionMessage("Amount Mismatched.");
/* 6235 */         return "oercfailure";
/*      */       } 
/* 6237 */     } catch (Exception e) {
/*      */       
/* 6239 */       logger.error("Exception  " + e);
/* 6240 */       return "error";
/*      */     } 
/*      */     
/* 6243 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String oercpRegistration() {
/* 6249 */     if (!isValidSession()) {
/* 6250 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6253 */       logger.info("---------------------------------------------------------");
/* 6254 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6255 */       logger.info("---------------------------------------------------------");
/* 6256 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6257 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6258 */       logger.info("registeredUserId.." + registeredUserId);
/* 6259 */       getOercpOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 6260 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6261 */       getAppData().setStrID("TEST");
/* 6262 */       if (AmountValidation(getOercpOnlineFormBean().getTotAmount(), getOercpOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 6264 */         String responseString = studentRegistrationService.insertOercpStudentDetails(getOercpOnlineFormBean(), billerId);
/* 6265 */         logger.info("OERCP Registration: " + responseString);
/*      */         
/* 6267 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6268 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6269 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6270 */             addActionMessage("Failed to add student data.");
/* 6271 */             return "oercpfailure";
/*      */           } 
/* 6273 */           addActionMessage("Error occured contact administrator.");
/* 6274 */           return "oercpfailure"; }
/*      */ 
/*      */         
/* 6277 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getOercpOnlineFormBean().getStudentRegistrationId());
/* 6278 */         this.studentRegistrationFormBean.setTotalPayableFees(getOercpOnlineFormBean().getTotAmount());
/* 6279 */         this.studentRegistrationFormBean.setStudentId(getOercpOnlineFormBean().getApplicationNo());
/* 6280 */         this.studentRegistrationFormBean.setStudentName(getOercpOnlineFormBean().getStdName());
/* 6281 */         this.studentRegistrationFormBean.setStudentEmailId(getOercpOnlineFormBean().getEmailId());
/* 6282 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6284 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6285 */         this.appData1 = new PaymentRequestBean();
/* 6286 */         this.appData1.setStudentRegistrationId(getOercpOnlineFormBean().getStudentRegistrationId());
/* 6287 */         logger.info("OERCP Registration--feesPayList :: " + this.feesPayList);
/* 6288 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 6290 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 6294 */         addActionMessage("Amount Mismatched.");
/* 6295 */         return "oercpfailure";
/*      */       } 
/* 6297 */     } catch (Exception e) {
/*      */       
/* 6299 */       logger.error("Exception  " + e);
/* 6300 */       return "error";
/*      */     } 
/*      */     
/* 6303 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String micronRegistration() {
/* 6308 */     if (!isValidSession()) {
/* 6309 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6312 */       logger.info("---------------------------------------------------------");
/* 6313 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6314 */       logger.info("---------------------------------------------------------");
/* 6315 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6316 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6317 */       logger.info("registeredUserId.." + registeredUserId);
/* 6318 */       getMicronOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 6319 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6320 */       getAppData().setStrID("TEST");
/* 6321 */       if (AmountValidation(getMicronOnlineFormBean().getTotalFeesAmount(), getMicronOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 6323 */         String responseString = studentRegistrationService.insertMicronStudentDetails(getMicronOnlineFormBean(), billerId);
/* 6324 */         logger.info("micron Registration: " + responseString);
/*      */         
/* 6326 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6327 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6328 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6329 */             addActionMessage("Failed to add student data.");
/* 6330 */             return "micronfailure";
/*      */           } 
/* 6332 */           addActionMessage("Error occured contact administrator.");
/* 6333 */           return "micronfailure"; }
/*      */ 
/*      */         
/* 6336 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getMicronOnlineFormBean().getStudentRegistrationId());
/* 6337 */         this.studentRegistrationFormBean.setTotalPayableFees(getMicronOnlineFormBean().getTotalFeesAmount());
/* 6338 */         this.studentRegistrationFormBean.setStudentId(getMicronOnlineFormBean().getApplicationNo());
/* 6339 */         this.studentRegistrationFormBean.setStudentName(getMicronOnlineFormBean().getCandidateName());
/* 6340 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6342 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6343 */         this.appData1 = new PaymentRequestBean();
/* 6344 */         this.appData1.setStudentRegistrationId(getMicronOnlineFormBean().getStudentRegistrationId());
/* 6345 */         logger.info("micronRegistration Registration--feesPayList :: " + this.feesPayList);
/* 6346 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 6348 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 6352 */         addActionMessage("Amount Mismatched.");
/* 6353 */         return "micronfailure";
/*      */       } 
/* 6355 */     } catch (Exception e) {
/*      */       
/* 6357 */       logger.error("Exception  " + e);
/* 6358 */       return "error";
/*      */     } 
/*      */     
/* 6361 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String sheetlaRegistration() {
/* 6366 */     if (!isValidSession()) {
/* 6367 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6370 */       logger.info("---------------------------------------------------------");
/* 6371 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6372 */       logger.info("---------------------------------------------------------");
/* 6373 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6374 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6375 */       logger.info("registeredUserId.." + registeredUserId);
/* 6376 */       getSheetlaOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 6377 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6378 */       getAppData().setStrID("TEST");
/* 6379 */       if (AmountValidation(getSheetlaOnlineFormBean().getTotAmount(), getSheetlaOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 6381 */         String responseString = studentRegistrationService.insertSheetlaStudentDetails(getSheetlaOnlineFormBean(), billerId);
/* 6382 */         logger.info("Sheetla Registration: " + responseString);
/*      */         
/* 6384 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6385 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6386 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6387 */             addActionMessage("Failed to add student data.");
/* 6388 */             return "sheetlaFailure";
/*      */           } 
/* 6390 */           addActionMessage("Error occured contact administrator.");
/* 6391 */           return "sheetlaFailure"; }
/*      */ 
/*      */         
/* 6394 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getSheetlaOnlineFormBean().getStudentRegistrationId());
/* 6395 */         this.studentRegistrationFormBean.setTotalPayableFees(getSheetlaOnlineFormBean().getTotAmount());
/* 6396 */         this.studentRegistrationFormBean.setStudentId(getSheetlaOnlineFormBean().getApplicationNo());
/* 6397 */         this.studentRegistrationFormBean.setStudentName(getSheetlaOnlineFormBean().getStdName());
/* 6398 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6400 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6401 */         this.appData1 = new PaymentRequestBean();
/* 6402 */         this.appData1.setStudentRegistrationId(getSheetlaOnlineFormBean().getStudentRegistrationId());
/* 6403 */         logger.info("Sheetla Registration--feesPayList :: " + this.feesPayList);
/* 6404 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 6406 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 6410 */         addActionMessage("Amount Mismatched.");
/* 6411 */         return "sheetlaFailure";
/*      */       } 
/* 6413 */     } catch (Exception e) {
/*      */       
/* 6415 */       logger.error("Exception  " + e);
/* 6416 */       return "error";
/*      */     } 
/*      */     
/* 6419 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String gaharwarRegistration() {
/* 6424 */     if (!isValidSession()) {
/* 6425 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6428 */       logger.info("---------------------------------------------------------");
/* 6429 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6430 */       logger.info("---------------------------------------------------------");
/* 6431 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6432 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6433 */       logger.info("registeredUserId.." + registeredUserId);
/* 6434 */       getGaharwarOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 6435 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6436 */       getAppData().setStrID("TEST");
/* 6437 */       if (AmountValidation(getGaharwarOnlineFormBean().getTotal(), getGaharwarOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 6439 */         String responseString = studentRegistrationService.insertGarawarStudentDetails(getGaharwarOnlineFormBean(), billerId);
/* 6440 */         logger.info("gaharwarRegistration() Registration: " + responseString);
/*      */         
/* 6442 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6443 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6444 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6445 */             addActionMessage("Failed to add student data.");
/* 6446 */             return "gaharwarfailure";
/*      */           } 
/* 6448 */           addActionMessage("Error occured contact administrator.");
/* 6449 */           return "gaharwarfailure"; }
/*      */ 
/*      */         
/* 6452 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getGaharwarOnlineFormBean().getStudentRegistrationId());
/* 6453 */         this.studentRegistrationFormBean.setTotalPayableFees(getGaharwarOnlineFormBean().getTotal());
/* 6454 */         this.studentRegistrationFormBean.setStudentId(getGaharwarOnlineFormBean().getApplicationNo());
/* 6455 */         this.studentRegistrationFormBean.setStudentName(getGaharwarOnlineFormBean().getName());
/* 6456 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6458 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6459 */         this.appData1 = new PaymentRequestBean();
/* 6460 */         this.appData1.setStudentRegistrationId(getGaharwarOnlineFormBean().getStudentRegistrationId());
/* 6461 */         logger.info("micronRegistration Registration--feesPayList :: " + this.feesPayList);
/* 6462 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 6464 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 6468 */         addActionMessage("Amount Mismatched.");
/* 6469 */         return "gaharwarfailure";
/*      */       } 
/* 6471 */     } catch (Exception e) {
/*      */       
/* 6473 */       logger.error("Exception  " + e);
/* 6474 */       return "error";
/*      */     } 
/*      */     
/* 6477 */     return "success";
/*      */   }
/*      */   
/*      */   public String luciRegistration() {
/* 6481 */     if (!isValidSession()) {
/* 6482 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6485 */       logger.info("---------------------------------------------------------");
/* 6486 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6487 */       logger.info("---------------------------------------------------------");
/* 6488 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6489 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6490 */       logger.info("registeredUserId.." + registeredUserId);
/* 6491 */       getLuciOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 6492 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6493 */       LoginActionService loginActionService = new LoginActionService();
/* 6494 */       getAppData().setStrID("TEST");
/* 6495 */       if (AmountValidation(getLuciOnlineFormBean().getTotAmount(), getLuciOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 6497 */         getLuciOnlineFormBean().setTotAmount(loginActionService.getLuciCourseAmt(getLuciOnlineFormBean().getSelectCourse()));
/* 6498 */         String responseString = studentRegistrationService.insertLuciStudentDetails(getLuciOnlineFormBean(), billerId);
/* 6499 */         logger.info("Luci Registration: " + responseString);
/*      */         
/* 6501 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6502 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6503 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6504 */             addActionMessage("Failed to add student data.");
/* 6505 */             return "luciFailure";
/*      */           } 
/* 6507 */           addActionMessage("Error occured contact administrator.");
/* 6508 */           return "luciFailure"; }
/*      */ 
/*      */         
/* 6511 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getLuciOnlineFormBean().getStudentRegistrationId());
/* 6512 */         this.studentRegistrationFormBean.setTotalPayableFees(getLuciOnlineFormBean().getTotAmount());
/* 6513 */         this.studentRegistrationFormBean.setStudentId(getLuciOnlineFormBean().getApplicationNo());
/* 6514 */         this.studentRegistrationFormBean.setStudentName(getLuciOnlineFormBean().getStdName());
/* 6515 */         this.studentRegistrationFormBean.setStudentEmailId(getLuciOnlineFormBean().getEmail());
/* 6516 */         this.studentRegistrationFormBean.setStudentMobileNumber(getLuciOnlineFormBean().getMobile());
/*      */         
/* 6518 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6520 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6521 */         this.appData1 = new PaymentRequestBean();
/* 6522 */         this.appData1.setStudentRegistrationId(getLuciOnlineFormBean().getStudentRegistrationId());
/* 6523 */         logger.info("Luci Registration--feesPayList :: " + this.feesPayList);
/* 6524 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/* 6525 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 6528 */         addActionMessage("Amount Mismatched.");
/* 6529 */         return "luciFailure";
/*      */       } 
/* 6531 */     } catch (Exception e) {
/*      */       
/* 6533 */       logger.error("Exception  " + e);
/* 6534 */       return "error";
/*      */     } 
/*      */     
/* 6537 */     return "success";
/*      */   }
/*      */   
/*      */   public String ChaduryCollegeRegistration() {
/* 6541 */     if (!isValidSession()) {
/* 6542 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6545 */       logger.info("---------------------------------------------------------");
/* 6546 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6547 */       logger.info("---------------------------------------------------------");
/* 6548 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6549 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6550 */       logger.info("registeredUserId.." + registeredUserId);
/* 6551 */       getChaudharyCollegeOnlineBean().setRegisteredUserId(registeredUserId);
/* 6552 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6553 */       getAppData().setStrID("TEST");
/* 6554 */       if (AmountValidation(getChaudharyCollegeOnlineBean().getTotalfees(), getChaudharyCollegeOnlineBean().getPayment()).booleanValue()) {
/*      */         
/* 6556 */         String responseString = studentRegistrationService.insertChaudharyCollegeStudentDetails(getChaudharyCollegeOnlineBean(), billerId);
/* 6557 */         logger.info("ChaduryCollegeRegistration Registration: " + responseString);
/*      */         
/* 6559 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6560 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6561 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6562 */             addActionMessage("Failed to add student data.");
/* 6563 */             return "Chaduryfailure";
/*      */           } 
/* 6565 */           addActionMessage("Error occured contact administrator.");
/* 6566 */           return "Chaduryfailure"; }
/*      */ 
/*      */         
/* 6569 */         List<ChaudharyCollegeOnlineBeanGrid> feeDetailsList = getChaudharyCollegeOnlineBean().getFeeDetailsList();
/* 6570 */         int feeListLength = feeDetailsList.size(); int i;
/* 6571 */         for (i = 0; i < feeListLength; i++) {
/*      */           
/* 6573 */           ChaudharyCollegeOnlineBeanGrid chaudharyCollegeOnlineBeanGrid = feeDetailsList.get(i);
/* 6574 */           studentRegistrationService.insertChauFeeDetails(chaudharyCollegeOnlineBeanGrid, getChaudharyCollegeOnlineBean().getApplicationNo());
/*      */         } 
/*      */         
/* 6577 */         for (i = 0; i <= this.chaudharyCollegeOnlineBean.getFeeDetailsList().size() - 1; i++) {
/* 6578 */           ChaudharyCollegeOnlineBeanGrid chaudharyCollegeOnlineBeanGrid = this.chaudharyCollegeOnlineBean.getFeeDetailsList().get(i);
/*      */         }
/*      */ 
/*      */         
/* 6582 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getChaudharyCollegeOnlineBean().getStudentRegistrationId());
/* 6583 */         this.studentRegistrationFormBean.setTotalPayableFees(getChaudharyCollegeOnlineBean().getTotalfees());
/* 6584 */         this.studentRegistrationFormBean.setStudentId(getChaudharyCollegeOnlineBean().getApplicationNo());
/*      */         
/* 6586 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6588 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6589 */         this.appData1 = new PaymentRequestBean();
/* 6590 */         this.appData1.setStudentRegistrationId(getChaudharyCollegeOnlineBean().getStudentRegistrationId());
/* 6591 */         logger.info("ChaduryCollegeRegistration--feesPayList :: " + this.feesPayList);
/* 6592 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/* 6593 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 6596 */         addActionMessage("Amount Mismatched.");
/* 6597 */         return "Chaduryfailure";
/*      */       } 
/* 6599 */     } catch (Exception e) {
/*      */       
/* 6601 */       logger.error("Exception  " + e);
/* 6602 */       return "error";
/*      */     } 
/*      */     
/* 6605 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String GSFCRegistration() {
/* 6610 */     if (!isValidSession()) {
/* 6611 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6614 */       logger.info("---------------------------------------------------------");
/* 6615 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6616 */       logger.info("---------------------------------------------------------");
/* 6617 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6618 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6619 */       logger.info("registeredUserId.." + registeredUserId);
/* 6620 */       getGsfcOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 6621 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6622 */       getAppData().setStrID("TEST");
/* 6623 */       if (AmountValidation(getGsfcOnlineFormBean().getTotAmount(), getGsfcOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 6625 */         String responseString = studentRegistrationService.insertGSFCStudentDetails(getGsfcOnlineFormBean(), billerId);
/* 6626 */         logger.info("Gsfc Registration: " + responseString);
/*      */         
/* 6628 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6629 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6630 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6631 */             addActionMessage("Failed to add student data.");
/* 6632 */             return "GSFCFailure";
/*      */           } 
/* 6634 */           addActionMessage("Error occured contact administrator.");
/* 6635 */           return "GSFCFailure"; }
/*      */ 
/*      */         
/* 6638 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getGsfcOnlineFormBean().getStudentRegistrationId());
/* 6639 */         this.studentRegistrationFormBean.setTotalPayableFees(getGsfcOnlineFormBean().getTotAmount());
/* 6640 */         this.studentRegistrationFormBean.setStudentId(getGsfcOnlineFormBean().getApplicationNo());
/* 6641 */         this.studentRegistrationFormBean.setStudentName(getGsfcOnlineFormBean().getStudentName());
/* 6642 */         this.studentRegistrationFormBean.setStudentEmailId(getGsfcOnlineFormBean().getEmailId());
/* 6643 */         this.studentRegistrationFormBean.setStudentMobileNumber(getGsfcOnlineFormBean().getMobileNo());
/*      */         
/* 6645 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6647 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6648 */         this.appData1 = new PaymentRequestBean();
/* 6649 */         this.appData1.setStudentRegistrationId(getGsfcOnlineFormBean().getStudentRegistrationId());
/* 6650 */         logger.info("GSFC Registration--feesPayList :: " + this.feesPayList);
/* 6651 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/* 6652 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 6655 */         addActionMessage("Amount Mismatched.");
/* 6656 */         return "GSFCFailure";
/*      */       } 
/* 6658 */     } catch (Exception e) {
/*      */       
/* 6660 */       logger.error("Exception  " + e);
/* 6661 */       return "error";
/*      */     } 
/*      */     
/* 6664 */     return "GSFCSuccess";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String chaduryAdmissionRegistration() {
/* 6670 */     if (!isValidSession()) {
/* 6671 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6674 */       logger.info("---------------------------------------------------------");
/* 6675 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6676 */       logger.info("---------------------------------------------------------");
/* 6677 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6678 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6679 */       logger.info("registeredUserId.." + registeredUserId);
/* 6680 */       getChaudharyADMISSIONOnlineBean().setRegisteredUserId(registeredUserId);
/* 6681 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6682 */       getAppData().setStrID("TEST");
/* 6683 */       if (AmountValidation(getChaudharyADMISSIONOnlineBean().getTotalfees(), getChaudharyADMISSIONOnlineBean().getPayment()).booleanValue()) {
/*      */         
/* 6685 */         String responseString = studentRegistrationService.insertChaudharyAdmisionStudentDetails(getChaudharyADMISSIONOnlineBean(), billerId);
/* 6686 */         logger.info("Luci Registration: " + responseString);
/*      */         
/* 6688 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6689 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6690 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6691 */             addActionMessage("Failed to add student data.");
/* 6692 */             return "ChaduryAdmisionfailure";
/*      */           } 
/* 6694 */           addActionMessage("Error occured contact administrator.");
/* 6695 */           return "ChaduryAdmisionfailure"; }
/*      */ 
/*      */         
/* 6698 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getChaudharyADMISSIONOnlineBean().getStudentRegistrationId());
/* 6699 */         this.studentRegistrationFormBean.setTotalPayableFees(getChaudharyADMISSIONOnlineBean().getTotalfees());
/* 6700 */         this.studentRegistrationFormBean.setStudentId(getChaudharyADMISSIONOnlineBean().getApplicationNo());
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 6705 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6707 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6708 */         this.appData1 = new PaymentRequestBean();
/* 6709 */         this.appData1.setStudentRegistrationId(getChaudharyADMISSIONOnlineBean().getStudentRegistrationId());
/* 6710 */         logger.info("Luci Registration--feesPayList :: " + this.feesPayList);
/* 6711 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/* 6712 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 6715 */         addActionMessage("Amount Mismatched.");
/* 6716 */         return "ChaduryAdmisionfailure";
/*      */       } 
/* 6718 */     } catch (Exception e) {
/*      */       
/* 6720 */       logger.error("Exception  " + e);
/* 6721 */       return "error";
/*      */     } 
/*      */     
/* 6724 */     return "success";
/*      */   }
/*      */   
/*      */   public String standardInternationalRegistration() {
/* 6728 */     if (!isValidSession()) {
/* 6729 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6732 */       logger.info("---------------------------------------------------------");
/* 6733 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6734 */       logger.info("---------------------------------------------------------");
/* 6735 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6736 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6737 */       logger.info("registeredUserId.." + registeredUserId);
/* 6738 */       getStandfordOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 6739 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6740 */       getAppData().setStrID("TEST");
/* 6741 */       if (AmountValidation(getStandfordOnlineFormBean().getTotalAmount(), getStandfordOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 6743 */         String responseString = studentRegistrationService.insertStandStudentDetails(getStandfordOnlineFormBean(), billerId, this.InstCode);
/* 6744 */         logger.info("standardInternationalRegistration Registration: " + responseString);
/*      */         
/* 6746 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6747 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6748 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6749 */             addActionMessage("Failed to add student data.");
/* 6750 */             return "standardfailure";
/*      */           } 
/* 6752 */           addActionMessage("Error occured contact administrator.");
/* 6753 */           return "standardfailure"; }
/*      */ 
/*      */         
/* 6756 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getStandfordOnlineFormBean().getStudentRegistrationId());
/* 6757 */         this.studentRegistrationFormBean.setTotalPayableFees(getStandfordOnlineFormBean().getTotalAmount());
/* 6758 */         this.studentRegistrationFormBean.setStudentId(getStandfordOnlineFormBean().getApplicationNo());
/* 6759 */         this.studentRegistrationFormBean.setStudentName(getStandfordOnlineFormBean().getStudentName());
/* 6760 */         this.studentRegistrationFormBean.setTotalPayableFees(getStandfordOnlineFormBean().getTotalAmount());
/* 6761 */         this.studentRegistrationFormBean.setStudentId(getStandfordOnlineFormBean().getApplicationNo());
/*      */ 
/*      */         
/* 6764 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6766 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6767 */         this.appData1 = new PaymentRequestBean();
/* 6768 */         this.appData1.setStudentRegistrationId(getStandfordOnlineFormBean().getStudentRegistrationId());
/* 6769 */         logger.info("Standard Registration--feesPayList :: " + this.feesPayList);
/* 6770 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 6772 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 6776 */         addActionMessage("Amount Mismatched.");
/* 6777 */         return "standardfailure";
/*      */       } 
/* 6779 */     } catch (Exception e) {
/*      */       
/* 6781 */       logger.error("Exception  " + e);
/* 6782 */       return "error";
/*      */     } 
/*      */     
/* 6785 */     return "success";
/*      */   }
/*      */   
/*      */   public String nluRegistration() {
/* 6789 */     if (!isValidSession()) {
/* 6790 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6793 */       logger.info("---------------------------------------------------------");
/* 6794 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6795 */       logger.info("---------------------------------------------------------");
/* 6796 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6797 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6798 */       logger.info("registeredUserId.." + registeredUserId);
/* 6799 */       getNluOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 6800 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6801 */       getAppData().setStrID("TEST");
/* 6802 */       if (AmountValidation(getNluOnlineFormBean().getTotAmount(), getNluOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 6804 */         String responseString = studentRegistrationService.insertNLUStudentDetails(getNluOnlineFormBean(), billerId);
/* 6805 */         logger.info("NLU Registration: " + responseString);
/*      */         
/* 6807 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6808 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6809 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6810 */             addActionMessage("Failed to add student data.");
/* 6811 */             return "nlufailure";
/*      */           } 
/* 6813 */           addActionMessage("Error occured contact administrator.");
/* 6814 */           return "nlufailure"; }
/*      */ 
/*      */         
/* 6817 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getNluOnlineFormBean().getStudentRegistrationId());
/* 6818 */         this.studentRegistrationFormBean.setTotalPayableFees(getNluOnlineFormBean().getTotAmount());
/* 6819 */         this.studentRegistrationFormBean.setStudentId(getNluOnlineFormBean().getApplicationNo());
/* 6820 */         this.studentRegistrationFormBean.setStudentName(getNluOnlineFormBean().getStdName());
/* 6821 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6823 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6824 */         this.appData1 = new PaymentRequestBean();
/* 6825 */         this.appData1.setStudentRegistrationId(getNluOnlineFormBean().getStudentRegistrationId());
/* 6826 */         logger.info("NLU Registration--feesPayList :: " + this.feesPayList);
/* 6827 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/* 6828 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 6831 */         addActionMessage("Amount Mismatched.");
/* 6832 */         return "nlufailure";
/*      */       } 
/* 6834 */     } catch (Exception e) {
/*      */       
/* 6836 */       logger.error("Exception  " + e);
/* 6837 */       return "error";
/*      */     } 
/*      */     
/* 6840 */     return "success";
/*      */   }
/*      */   
/*      */   public String dpscRegistration() {
/* 6844 */     if (!isValidSession()) {
/* 6845 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6848 */       logger.info("---------------------------------------------------------");
/* 6849 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6850 */       logger.info("---------------------------------------------------------");
/* 6851 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6852 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6853 */       logger.info("registeredUserId.." + registeredUserId);
/* 6854 */       getDpscOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 6855 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6856 */       getAppData().setStrID("TEST");
/* 6857 */       if (AmountValidation(getDpscOnlineFormBean().getTotAmount(), getDpscOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 6859 */         String responseString = studentRegistrationService.insertDPSCStudentDetails(getDpscOnlineFormBean(), billerId);
/* 6860 */         logger.info("Delhi Public school Registration: " + responseString);
/*      */         
/* 6862 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6863 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6864 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6865 */             addActionMessage("Failed to add student data.");
/* 6866 */             return "dpscfailure";
/*      */           } 
/* 6868 */           addActionMessage("Error occured contact administrator.");
/* 6869 */           return "dpscfailure"; }
/*      */ 
/*      */         
/* 6872 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getDpscOnlineFormBean().getStudentRegistrationId());
/* 6873 */         this.studentRegistrationFormBean.setTotalPayableFees(getDpscOnlineFormBean().getTotAmount());
/* 6874 */         this.studentRegistrationFormBean.setStudentId(getDpscOnlineFormBean().getApplicationNo());
/* 6875 */         this.studentRegistrationFormBean.setStudentName(getDpscOnlineFormBean().getStdName());
/* 6876 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6878 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6879 */         this.appData1 = new PaymentRequestBean();
/* 6880 */         this.appData1.setStudentRegistrationId(getDpscOnlineFormBean().getStudentRegistrationId());
/* 6881 */         logger.info("Delhi Public school--feesPayList :: " + this.feesPayList);
/* 6882 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/* 6883 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 6886 */         addActionMessage("Amount Mismatched.");
/* 6887 */         return "dpscfailure";
/*      */       } 
/* 6889 */     } catch (Exception e) {
/*      */       
/* 6891 */       logger.error("Exception  " + e);
/* 6892 */       return "error";
/*      */     } 
/*      */     
/* 6895 */     return "success";
/*      */   }
/*      */   
/*      */   public String nlu1Registration() {
/* 6899 */     if (!isValidSession()) {
/* 6900 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6903 */       logger.info("---------------------------------------------------------");
/* 6904 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6905 */       logger.info("---------------------------------------------------------");
/* 6906 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6907 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6908 */       logger.info("registeredUserId.." + registeredUserId);
/* 6909 */       getNluOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 6910 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6911 */       getAppData().setStrID("TEST");
/* 6912 */       if (AmountValidation(getNluOnlineFormBean().getTotAmount(), getNluOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 6914 */         String responseString = studentRegistrationService.insertNLU1StudentDetails(getNluOnlineFormBean(), billerId);
/* 6915 */         logger.info("NLU 1 Registration: " + responseString);
/*      */         
/* 6917 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6918 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6919 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6920 */             addActionMessage("Failed to add student data.");
/* 6921 */             return "nlufailure";
/*      */           } 
/* 6923 */           addActionMessage("Error occured contact administrator.");
/* 6924 */           return "nlufailure"; }
/*      */ 
/*      */         
/* 6927 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getNluOnlineFormBean().getStudentRegistrationId());
/* 6928 */         this.studentRegistrationFormBean.setTotalPayableFees(getNluOnlineFormBean().getTotAmount());
/* 6929 */         this.studentRegistrationFormBean.setStudentId(getNluOnlineFormBean().getApplicationNo());
/* 6930 */         this.studentRegistrationFormBean.setStudentName(getNluOnlineFormBean().getStdName());
/* 6931 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6933 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6934 */         this.appData1 = new PaymentRequestBean();
/* 6935 */         this.appData1.setStudentRegistrationId(getNluOnlineFormBean().getStudentRegistrationId());
/* 6936 */         logger.info("NLU 1 Registration--feesPayList :: " + this.feesPayList);
/* 6937 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/* 6938 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 6941 */         addActionMessage("Amount Mismatched.");
/* 6942 */         return "nlufailure";
/*      */       } 
/* 6944 */     } catch (Exception e) {
/*      */       
/* 6946 */       logger.error("Exception  " + e);
/* 6947 */       return "error";
/*      */     } 
/*      */     
/* 6950 */     return "success";
/*      */   }
/*      */   
/*      */   public String americanRegistration() {
/* 6954 */     if (!isValidSession()) {
/* 6955 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 6958 */       logger.info("---------------------------------------------------------");
/* 6959 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 6960 */       logger.info("---------------------------------------------------------");
/* 6961 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 6962 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 6963 */       logger.info("registeredUserId.." + registeredUserId);
/* 6964 */       getAmericanOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 6965 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 6966 */       getAppData().setStrID("TEST");
/* 6967 */       if (AmountValidation(getAmericanOnlineFormBean().getTotalFee(), getAmericanOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 6969 */         String responseString = studentRegistrationService.insertAmricanStudentDetails(getAmericanOnlineFormBean(), billerId);
/* 6970 */         logger.info("Delhi Public school Registration: " + responseString);
/*      */         
/* 6972 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 6973 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 6974 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 6975 */             addActionMessage("Failed to add student data.");
/* 6976 */             return "americanfailure";
/*      */           } 
/* 6978 */           addActionMessage("Error occured contact administrator.");
/* 6979 */           return "americanfailure"; }
/*      */ 
/*      */         
/* 6982 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getAmericanOnlineFormBean().getStudentRegistrationId());
/* 6983 */         this.studentRegistrationFormBean.setTotalPayableFees(getAmericanOnlineFormBean().getTotalFee());
/* 6984 */         this.studentRegistrationFormBean.setStudentId(getAmericanOnlineFormBean().getApplicationNo());
/* 6985 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 6987 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 6988 */         this.appData1 = new PaymentRequestBean();
/* 6989 */         this.appData1.setStudentRegistrationId(getAmericanOnlineFormBean().getStudentRegistrationId());
/* 6990 */         logger.info("Amrican school--feesPayList :: " + this.feesPayList);
/* 6991 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/* 6992 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 6995 */         addActionMessage("Amount Mismatched.");
/* 6996 */         return "americanfailure";
/*      */       } 
/* 6998 */     } catch (Exception e) {
/*      */       
/* 7000 */       logger.error("Exception  " + e);
/* 7001 */       return "error";
/*      */     } 
/*      */     
/* 7004 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String pathFinderRegistration() {
/* 7009 */     if (!isValidSession()) {
/* 7010 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7013 */       logger.info("---------------------------------------------------------");
/* 7014 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7015 */       logger.info("---------------------------------------------------------");
/* 7016 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7017 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7018 */       logger.info("registeredUserId.." + registeredUserId);
/* 7019 */       getPathFinderOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7020 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 7021 */       getAppData().setStrID("TEST");
/* 7022 */       if (AmountValidation(getPathFinderOnlineFormBean().getTotalAmount(), getPathFinderOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 7024 */         String responseString = studentRegistrationService.insertPathFinderStudentDetails(getPathFinderOnlineFormBean(), billerId);
/* 7025 */         logger.info("Delhi Public school Registration: " + responseString);
/*      */         
/* 7027 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7028 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7029 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7030 */             addActionMessage("Failed to add student data.");
/* 7031 */             return "pathfinderfailure";
/*      */           } 
/* 7033 */           addActionMessage("Error occured contact administrator.");
/* 7034 */           return "pathfinderfailure"; }
/*      */ 
/*      */         
/* 7037 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getPathFinderOnlineFormBean().getStudentRegistrationId());
/* 7038 */         this.studentRegistrationFormBean.setTotalPayableFees(getPathFinderOnlineFormBean().getTotalAmount());
/* 7039 */         this.studentRegistrationFormBean.setStudentId(getPathFinderOnlineFormBean().getApplicationNo());
/* 7040 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7042 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7043 */         this.appData1 = new PaymentRequestBean();
/* 7044 */         this.appData1.setStudentRegistrationId(getPathFinderOnlineFormBean().getStudentRegistrationId());
/* 7045 */         logger.info("Amrican school--feesPayList :: " + this.feesPayList);
/* 7046 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/* 7047 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 7050 */         addActionMessage("Amount Mismatched.");
/* 7051 */         return "pathfinderfailure";
/*      */       } 
/* 7053 */     } catch (Exception e) {
/*      */       
/* 7055 */       logger.error("Exception  " + e);
/* 7056 */       return "error";
/*      */     } 
/*      */     
/* 7059 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String kashiTechnologyRegistration() {
/* 7064 */     if (!isValidSession()) {
/* 7065 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7068 */       logger.info("---------------------------------------------------------");
/* 7069 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7070 */       logger.info("---------------------------------------------------------");
/* 7071 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7072 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7073 */       logger.info("registeredUserId.." + registeredUserId);
/* 7074 */       getFeesForm().setRegisteredUserId(registeredUserId);
/* 7075 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 7076 */       getAppData().setStrID("TEST");
/* 7077 */       if (AmountValidation(getFeesForm().getTotalFee(), getFeesForm().getPayment()).booleanValue()) {
/*      */         
/* 7079 */         String responseString = studentRegistrationService.insertKashiTechnologyStudentDetails(getFeesForm(), billerId);
/* 7080 */         logger.info("Delhi Public school Registration: " + responseString);
/*      */         
/* 7082 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7083 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7084 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7085 */             addActionMessage("Failed to add student data.");
/* 7086 */             return "kashiTechnologyfailure";
/*      */           } 
/* 7088 */           addActionMessage("Error occured contact administrator.");
/* 7089 */           return "kashiTechnologyfailure"; }
/*      */ 
/*      */         
/* 7092 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getFeesForm().getStudentRegistrationId());
/* 7093 */         this.studentRegistrationFormBean.setTotalPayableFees(getFeesForm().getTotalFee());
/* 7094 */         this.studentRegistrationFormBean.setStudentId(getFeesForm().getApplicationNo());
/* 7095 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7097 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7098 */         this.appData1 = new PaymentRequestBean();
/* 7099 */         this.appData1.setStudentRegistrationId(getFeesForm().getStudentRegistrationId());
/* 7100 */         logger.info("Amrican school--feesPayList :: " + this.feesPayList);
/* 7101 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/* 7102 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 7105 */         addActionMessage("Amount Mismatched.");
/* 7106 */         return "kashiTechnologyfailure";
/*      */       } 
/* 7108 */     } catch (Exception e) {
/*      */       
/* 7110 */       logger.error("Exception  " + e);
/* 7111 */       return "error";
/*      */     } 
/*      */     
/* 7114 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String COUHaryanaRegistration() {
/* 7120 */     if (!isValidSession()) {
/* 7121 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7124 */       logger.info("---------------------------------------------------------");
/* 7125 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7126 */       logger.info("---------------------------------------------------------");
/* 7127 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7128 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7129 */       logger.info("registeredUserId.." + registeredUserId);
/*      */       
/* 7131 */       getCuoHaryanaOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7132 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 7133 */       getAppData().setStrID("TEST");
/* 7134 */       if (AmountValidation(getCuoHaryanaOnlineFormBean().getRegistrationFee(), getCuoHaryanaOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 7136 */         addStudentPhotosForCUOHaryana(billerId);
/*      */ 
/*      */         
/* 7139 */         String responseString = studentRegistrationService.insertCUOHaryanaStudentDetails(getCuoHaryanaOnlineFormBean(), billerId);
/* 7140 */         logger.info("CUOHaryana responseString: " + responseString);
/*      */         
/* 7142 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7143 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7144 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7145 */             addActionMessage("Failed to add student data.");
/* 7146 */             return "CUOHaryanafailure";
/*      */           } 
/* 7148 */           addActionMessage("Error occured contact administrator.");
/* 7149 */           return "CUOHaryanafailure"; }
/*      */ 
/*      */         
/* 7152 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getCuoHaryanaOnlineFormBean().getStudentRegistrationId());
/* 7153 */         this.studentRegistrationFormBean.setTotalPayableFees(getCuoHaryanaOnlineFormBean().getRegistrationFee());
/* 7154 */         this.studentRegistrationFormBean.setStudentId(getCuoHaryanaOnlineFormBean().getApplicationNo());
/* 7155 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7157 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7158 */         this.appData1 = new PaymentRequestBean();
/* 7159 */         this.appData1.setStudentRegistrationId(getCuoHaryanaOnlineFormBean().getStudentRegistrationId());
/* 7160 */         logger.info("CUOHaryana Registration--feesPayList :: " + this.feesPayList);
/* 7161 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 7163 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 7167 */         addActionMessage("Amount Mismatched.");
/* 7168 */         return "CUOHaryanafailure";
/*      */       } 
/* 7170 */     } catch (Exception e) {
/*      */       
/* 7172 */       logger.error("Exception  " + e);
/* 7173 */       return "error";
/*      */     } 
/*      */     
/* 7176 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String addStudentPhotosForCUOHaryana(String billerId) throws IOException {
/* 7183 */     String destination = "";
/* 7184 */     String osName = System.getProperty("os.name");
/* 7185 */     if ("LINUX".equalsIgnoreCase(osName.trim())) {
/* 7186 */       destination = "/opt/jboss-eap-6.0/standalone/deployments/XJunction.war/StudentPhotos";
/*      */     } else {
/* 7188 */       destination = "H:/WorkSpace_for_UploadPhotos/StudentUploadPhotos/WebContent/StudentPhotos";
/*      */     } 
/*      */     
/* 7191 */     if (getCuoHaryanaOnlineFormBean().getPassportImagfile() != null) {
/*      */       
/* 7193 */       long uniqueTime = System.currentTimeMillis();
/* 7194 */       getCuoHaryanaOnlineFormBean().setStoreHeaderFile(saveUploadedFile(getCuoHaryanaOnlineFormBean().getPassportImagfile(), 
/* 7195 */             getCuoHaryanaOnlineFormBean().getPassportImagfileFileName(), 
/* 7196 */             billerId, 
/* 7197 */             "PHOTO_" + uniqueTime, 
/* 7198 */             TPSLConstants.FJA_STATIC_IMAGE_CONTENT_PATH));
/*      */       
/* 7200 */       saveUploadedFile(getCuoHaryanaOnlineFormBean().getPassportImagfile(), 
/* 7201 */           getCuoHaryanaOnlineFormBean().getPassportImagfileFileName(), 
/* 7202 */           billerId, 
/* 7203 */           "PHOTO_" + uniqueTime, 
/* 7204 */           destination);
/* 7205 */       getCuoHaryanaOnlineFormBean().setPhotoProof(getCuoHaryanaOnlineFormBean().getStoreHeaderFile().getName());
/*      */     } 
/*      */     
/* 7208 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String chaduryMiscellanousRegistration() {
/* 7215 */     if (!isValidSession()) {
/* 7216 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7219 */       logger.info("---------------------------------------------------------");
/* 7220 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7221 */       logger.info("---------------------------------------------------------");
/* 7222 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7223 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7224 */       logger.info("registeredUserId.." + registeredUserId);
/* 7225 */       getChaudharyMiscellanousOnlineBean().setRegisteredUserId(registeredUserId);
/* 7226 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 7227 */       getAppData().setStrID("TEST");
/* 7228 */       if (AmountValidation(getChaudharyMiscellanousOnlineBean().getTotalfees(), getChaudharyMiscellanousOnlineBean().getPayment()).booleanValue()) {
/*      */         
/* 7230 */         String responseString = studentRegistrationService.insertChaudharyMiscellanouStudentDetails(getChaudharyMiscellanousOnlineBean(), billerId);
/* 7231 */         logger.info("Luci Registration: " + responseString);
/*      */         
/* 7233 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7234 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7235 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7236 */             addActionMessage("Failed to add student data.");
/* 7237 */             return "ChaduryMiscellanousfailure";
/*      */           } 
/* 7239 */           addActionMessage("Error occured contact administrator.");
/* 7240 */           return "ChaduryMiscellanousfailure"; }
/*      */ 
/*      */         
/* 7243 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getChaudharyMiscellanousOnlineBean().getStudentRegistrationId());
/* 7244 */         this.studentRegistrationFormBean.setTotalPayableFees(getChaudharyMiscellanousOnlineBean().getTotalfees());
/* 7245 */         this.studentRegistrationFormBean.setStudentId(getChaudharyMiscellanousOnlineBean().getApplicationNo());
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 7250 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7252 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7253 */         this.appData1 = new PaymentRequestBean();
/* 7254 */         this.appData1.setStudentRegistrationId(getChaudharyMiscellanousOnlineBean().getStudentRegistrationId());
/* 7255 */         logger.info("Luci Registration--feesPayList :: " + this.feesPayList);
/* 7256 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/* 7257 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       } else {
/*      */         
/* 7260 */         addActionMessage("Amount Mismatched.");
/* 7261 */         return "ChaduryMiscellanousfailure";
/*      */       } 
/* 7263 */     } catch (Exception e) {
/*      */       
/* 7265 */       logger.error("Exception  " + e);
/* 7266 */       return "error";
/*      */     } 
/*      */     
/* 7269 */     return "success";
/*      */   }
/*      */   
/*      */   public String royalDentalRegistration() {
/* 7273 */     if (!isValidSession()) {
/* 7274 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7277 */       logger.info("---------------------------------------------------------");
/* 7278 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7279 */       logger.info("---------------------------------------------------------");
/* 7280 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7281 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7282 */       logger.info("registeredUserId.." + registeredUserId);
/* 7283 */       getRoyalDentalOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7284 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 7285 */       getAppData().setStrID("TEST");
/* 7286 */       if (AmountValidation(getRoyalDentalOnlineFormBean().getTotalAmount(), getRoyalDentalOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 7288 */         String responseString = studentRegistrationService.insertRoyalDentalStudentDetails(getRoyalDentalOnlineFormBean(), billerId);
/* 7289 */         logger.info("Royal Dental: " + responseString);
/*      */         
/* 7291 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7292 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7293 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7294 */             addActionMessage("Failed to add student data.");
/* 7295 */             return "royalDentalfailure";
/*      */           } 
/* 7297 */           addActionMessage("Error occured contact administrator.");
/* 7298 */           return "royalDentalfailure"; }
/*      */ 
/*      */         
/* 7301 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getRoyalDentalOnlineFormBean().getStudentRegistrationId());
/* 7302 */         this.studentRegistrationFormBean.setTotalPayableFees(getRoyalDentalOnlineFormBean().getTotalAmount());
/* 7303 */         this.studentRegistrationFormBean.setStudentId(getRoyalDentalOnlineFormBean().getApplicationNo());
/* 7304 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7306 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7307 */         this.appData1 = new PaymentRequestBean();
/* 7308 */         this.appData1.setStudentRegistrationId(getRoyalDentalOnlineFormBean().getStudentRegistrationId());
/* 7309 */         logger.info("Royal Dental Registration--feesPayList :: " + this.feesPayList);
/* 7310 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 7312 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 7316 */         addActionMessage("Amount Mismatched.");
/* 7317 */         return "royalDentalfailure";
/*      */       } 
/* 7319 */     } catch (Exception e) {
/*      */       
/* 7321 */       logger.error("Exception  " + e);
/* 7322 */       return "error";
/*      */     } 
/*      */     
/* 7325 */     return "success";
/*      */   } public String vishalInstitueRegistration() {
/* 7327 */     if (!isValidSession()) {
/* 7328 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7331 */       logger.info("---------------------------------------------------------");
/* 7332 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7333 */       logger.info("---------------------------------------------------------");
/* 7334 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7335 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7336 */       logger.info("registeredUserId.." + registeredUserId);
/* 7337 */       getVishalInstOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7338 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 7339 */       getAppData().setStrID("TEST");
/* 7340 */       if (AmountValidation(getVishalInstOnlineFormBean().getTotalFee(), getVishalInstOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 7342 */         String responseString = studentRegistrationService.insertVishalInstituteStudentDetails(getVishalInstOnlineFormBean(), billerId);
/* 7343 */         logger.info("Vishal Institute: " + responseString);
/*      */         
/* 7345 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7346 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7347 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7348 */             addActionMessage("Failed to add student data.");
/* 7349 */             return "vishalInstitutefaliure";
/*      */           } 
/* 7351 */           addActionMessage("Error occured contact administrator.");
/* 7352 */           return "vishalInstitutefaliure"; }
/*      */ 
/*      */         
/* 7355 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getVishalInstOnlineFormBean().getStudentRegistrationId());
/* 7356 */         this.studentRegistrationFormBean.setTotalPayableFees(getVishalInstOnlineFormBean().getTotalFee());
/* 7357 */         this.studentRegistrationFormBean.setStudentId(getVishalInstOnlineFormBean().getApplicationNo());
/* 7358 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7360 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7361 */         this.appData1 = new PaymentRequestBean();
/* 7362 */         this.appData1.setStudentRegistrationId(getVishalInstOnlineFormBean().getStudentRegistrationId());
/* 7363 */         logger.info("Vishal Institute Registration--feesPayList :: " + this.feesPayList);
/* 7364 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 7366 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 7370 */         addActionMessage("Amount Mismatched.");
/* 7371 */         return "vishalInstitutefaliure";
/*      */       } 
/* 7373 */     } catch (Exception e) {
/*      */       
/* 7375 */       logger.error("Exception  " + e);
/* 7376 */       return "error";
/*      */     } 
/*      */     
/* 7379 */     return "success";
/*      */   }
/*      */   public String lancersSchoolRegistration() {
/* 7382 */     if (!isValidSession()) {
/* 7383 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7386 */       logger.info("---------------------------------------------------------");
/* 7387 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7388 */       logger.info("---------------------------------------------------------");
/* 7389 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7390 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7391 */       logger.info("registeredUserId.." + registeredUserId);
/* 7392 */       getLancersOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7393 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 7395 */       if (AmountValidation(getLancersOnlineFormBean().getAmount(), getLancersOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 7397 */         String responseString = studentRegistrationService.insertLancersSchoolStudentDetails(getLancersOnlineFormBean(), billerId);
/* 7398 */         logger.info("Lancers International School Registration: " + responseString);
/*      */         
/* 7400 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7401 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7402 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7403 */             addActionMessage("Failed to add student data.");
/* 7404 */             return "lancersSchoolfaliure";
/*      */           } 
/* 7406 */           addActionMessage("Error occured contact administrator.");
/* 7407 */           return "lancersSchoolfaliure"; }
/*      */ 
/*      */         
/* 7410 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getLancersOnlineFormBean().getStudentRegistrationId());
/* 7411 */         this.studentRegistrationFormBean.setTotalPayableFees(getLancersOnlineFormBean().getAmount());
/* 7412 */         this.studentRegistrationFormBean.setStudentId(getLancersOnlineFormBean().getApplicationNo());
/* 7413 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7415 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7416 */         this.appData1 = new PaymentRequestBean();
/* 7417 */         this.appData1.setStudentRegistrationId(getLancersOnlineFormBean().getStudentRegistrationId());
/* 7418 */         logger.info("Lancers International School Registration--feesPayList :: " + this.feesPayList);
/* 7419 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 7421 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 7425 */         addActionMessage("Amount Mismatched.");
/* 7426 */         return "lancersSchoolfaliure";
/*      */       } 
/* 7428 */     } catch (Exception e) {
/*      */       
/* 7430 */       logger.error("Exception  " + e);
/* 7431 */       return "error";
/*      */     } 
/*      */     
/* 7434 */     return "success";
/*      */   }
/*      */   public String dpsBudgamRegistration() {
/* 7437 */     if (!isValidSession()) {
/* 7438 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7441 */       logger.info("---------------------------------------------------------");
/* 7442 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7443 */       logger.info("---------------------------------------------------------");
/* 7444 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7445 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7446 */       logger.info("registeredUserId.." + registeredUserId);
/* 7447 */       getDpsBudgamOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7448 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 7450 */       if (AmountValidation(getDpsBudgamOnlineFormBean().getAmount(), getDpsBudgamOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 7452 */         String responseString = studentRegistrationService.insertdpsBudgamDetails(getDpsBudgamOnlineFormBean(), billerId);
/* 7453 */         logger.info("Delhi Public School Budgam Registration: " + responseString);
/*      */         
/* 7455 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7456 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7457 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7458 */             addActionMessage("Failed to add student data.");
/* 7459 */             return "dpsBudgamfaliure";
/*      */           } 
/* 7461 */           addActionMessage("Error occured contact administrator.");
/* 7462 */           return "dpsBudgamfaliure"; }
/*      */ 
/*      */         
/* 7465 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getDpsBudgamOnlineFormBean().getStudentRegistrationId());
/* 7466 */         this.studentRegistrationFormBean.setTotalPayableFees(getDpsBudgamOnlineFormBean().getAmount());
/* 7467 */         this.studentRegistrationFormBean.setStudentId(getDpsBudgamOnlineFormBean().getApplicationNo());
/* 7468 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7470 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7471 */         this.appData1 = new PaymentRequestBean();
/* 7472 */         this.appData1.setStudentRegistrationId(getDpsBudgamOnlineFormBean().getStudentRegistrationId());
/* 7473 */         logger.info("Delhi Public School Budgam Registration--feesPayList :: " + this.feesPayList);
/* 7474 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 7476 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 7480 */         addActionMessage("Amount Mismatched.");
/* 7481 */         return "dpsBudgamfaliure";
/*      */       } 
/* 7483 */     } catch (Exception e) {
/*      */       
/* 7485 */       logger.error("Exception  " + e);
/* 7486 */       return "error";
/*      */     } 
/*      */     
/* 7489 */     return "success";
/*      */   }
/*      */   public String krishnaLawRegistration() {
/* 7492 */     if (!isValidSession()) {
/* 7493 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7496 */       logger.info("---------------------------------------------------------");
/* 7497 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7498 */       logger.info("---------------------------------------------------------");
/* 7499 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7500 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7501 */       logger.info("registeredUserId.." + registeredUserId);
/* 7502 */       getKrishnaLawOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7503 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 7505 */       if (AmountValidation(getKrishnaLawOnlineFormBean().getAmount(), getKrishnaLawOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 7507 */         String responseString = studentRegistrationService.insertKrishnaLawStudentDetails(getKrishnaLawOnlineFormBean(), billerId);
/* 7508 */         logger.info("KRISHNA INSTITUTE OF LAW Registration: " + responseString);
/*      */         
/* 7510 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7511 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7512 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7513 */             addActionMessage("Failed to add student data.");
/* 7514 */             return "krishnaLawfaliure";
/*      */           } 
/* 7516 */           addActionMessage("Error occured contact administrator.");
/* 7517 */           return "krishnaLawfaliure"; }
/*      */ 
/*      */         
/* 7520 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getKrishnaLawOnlineFormBean().getStudentRegistrationId());
/* 7521 */         this.studentRegistrationFormBean.setTotalPayableFees(getKrishnaLawOnlineFormBean().getAmount());
/* 7522 */         this.studentRegistrationFormBean.setStudentId(getKrishnaLawOnlineFormBean().getApplicationNo());
/* 7523 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7525 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7526 */         this.appData1 = new PaymentRequestBean();
/* 7527 */         this.appData1.setStudentRegistrationId(getKrishnaLawOnlineFormBean().getStudentRegistrationId());
/* 7528 */         logger.info("KRISHNA INSTITUTE OF LAW Registration--feesPayList :: " + this.feesPayList);
/* 7529 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 7531 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 7535 */         addActionMessage("Amount Mismatched.");
/* 7536 */         return "krishnaLawfaliure";
/*      */       } 
/* 7538 */     } catch (Exception e) {
/*      */       
/* 7540 */       logger.error("Exception  " + e);
/* 7541 */       return "error";
/*      */     } 
/*      */     
/* 7544 */     return "success";
/*      */   }
/*      */   public String biyaniRegistration() {
/* 7547 */     if (!isValidSession()) {
/* 7548 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7551 */       logger.info("---------------------------------------------------------");
/* 7552 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7553 */       logger.info("---------------------------------------------------------");
/* 7554 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7555 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7556 */       logger.info("registeredUserId.." + registeredUserId);
/* 7557 */       getBiyaniOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7558 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 7560 */       if (AmountValidation(getBiyaniOnlineFormBean().getTotalAmount(), getBiyaniOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 7562 */         String responseString = studentRegistrationService.insertBiyaniStudentDetails(getBiyaniOnlineFormBean(), billerId);
/* 7563 */         logger.info("Biyani Shikshan Samiti:" + responseString);
/*      */         
/* 7565 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7566 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7567 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7568 */             addActionMessage("Failed to add student data.");
/* 7569 */             return "Biyanifaliure";
/*      */           } 
/* 7571 */           addActionMessage("Error occured contact administrator.");
/* 7572 */           return "Biyanifaliure"; }
/*      */ 
/*      */         
/* 7575 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getBiyaniOnlineFormBean().getStudentRegistrationId());
/* 7576 */         this.studentRegistrationFormBean.setTotalPayableFees(getBiyaniOnlineFormBean().getTotalAmount());
/* 7577 */         this.studentRegistrationFormBean.setStudentId(getBiyaniOnlineFormBean().getApplicationNo());
/* 7578 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7580 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7581 */         this.appData1 = new PaymentRequestBean();
/* 7582 */         this.appData1.setStudentRegistrationId(getBiyaniOnlineFormBean().getStudentRegistrationId());
/* 7583 */         logger.info("Biyani Shikshan Samiti--feesPayList :: " + this.feesPayList);
/* 7584 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 7586 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 7590 */         addActionMessage("Amount Mismatched.");
/* 7591 */         return "Biyanifaliure";
/*      */       } 
/* 7593 */     } catch (Exception e) {
/*      */       
/* 7595 */       logger.error("Exception  " + e);
/* 7596 */       return "error";
/*      */     } 
/*      */     
/* 7599 */     return "success";
/*      */   }
/*      */   public String kulluRegistration() {
/* 7602 */     if (!isValidSession()) {
/* 7603 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7606 */       logger.info("---------------------------------------------------------");
/* 7607 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7608 */       logger.info("---------------------------------------------------------");
/* 7609 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7610 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7611 */       logger.info("registeredUserId.." + registeredUserId);
/* 7612 */       getKulluOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7613 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 7615 */       if (AmountValidation(getKulluOnlineFormBean().getTotalAmount(), getKulluOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 7617 */         String responseString = studentRegistrationService.insertKulluStudentDetails(getKulluOnlineFormBean(), billerId);
/* 7618 */         logger.info("Principal Govt College Kullu:" + responseString);
/*      */         
/* 7620 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7621 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7622 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7623 */             addActionMessage("Failed to add student data.");
/* 7624 */             return "Kullufaliure";
/*      */           } 
/* 7626 */           addActionMessage("Error occured contact administrator.");
/* 7627 */           return "Kullufaliure"; }
/*      */ 
/*      */         
/* 7630 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getKulluOnlineFormBean().getStudentRegistrationId());
/* 7631 */         this.studentRegistrationFormBean.setTotalPayableFees(getKulluOnlineFormBean().getTotalAmount());
/* 7632 */         this.studentRegistrationFormBean.setStudentId(getKulluOnlineFormBean().getApplicationNo());
/* 7633 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7635 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7636 */         this.appData1 = new PaymentRequestBean();
/* 7637 */         this.appData1.setStudentRegistrationId(getKulluOnlineFormBean().getStudentRegistrationId());
/* 7638 */         logger.info("Principal Govt College Kullu--feesPayList :: " + this.feesPayList);
/* 7639 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 7641 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 7645 */         addActionMessage("Amount Mismatched.");
/* 7646 */         return "Kullufaliure";
/*      */       } 
/* 7648 */     } catch (Exception e) {
/*      */       
/* 7650 */       logger.error("Exception  " + e);
/* 7651 */       return "error";
/*      */     } 
/*      */     
/* 7654 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String jbciRegistration() {
/* 7659 */     if (!isValidSession()) {
/* 7660 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7663 */       logger.info("---------------------------------------------------------");
/* 7664 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7665 */       logger.info("---------------------------------------------------------");
/* 7666 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7667 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7668 */       logger.info("registeredUserId.." + registeredUserId);
/* 7669 */       getJbciOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7670 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 7672 */       if (AmountValidation(getJbciOnlineFormBean().getTotalAmount(), getJbciOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 7675 */         String responseString = studentRegistrationService.insertJbciStudentDetails(getJbciOnlineFormBean(), billerId);
/* 7676 */         logger.info("Jaipur Branch of CIRC of ICAI :" + responseString);
/*      */         
/* 7678 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7679 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7680 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7681 */             addActionMessage("Failed to add student data.");
/* 7682 */             return "jbcifailure";
/*      */           } 
/* 7684 */           addActionMessage("Error occured contact administrator.");
/* 7685 */           return "jbcifailure"; }
/*      */ 
/*      */         
/* 7688 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getJbciOnlineFormBean().getStudentRegistrationId());
/* 7689 */         this.studentRegistrationFormBean.setTotalPayableFees(getJbciOnlineFormBean().getTotalAmount());
/* 7690 */         this.studentRegistrationFormBean.setStudentId(getJbciOnlineFormBean().getApplicationNo());
/* 7691 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7693 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7694 */         this.appData1 = new PaymentRequestBean();
/* 7695 */         this.appData1.setStudentRegistrationId(getJbciOnlineFormBean().getStudentRegistrationId());
/* 7696 */         logger.info("Jaipur Branch of CIRC of ICAI--feesPayList :: " + this.feesPayList);
/* 7697 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 7699 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 7703 */         addActionMessage("Amount Mismatched.");
/* 7704 */         return "jbcifailure";
/*      */       } 
/* 7706 */     } catch (Exception e) {
/*      */       
/* 7708 */       logger.error("Exception  " + e);
/* 7709 */       return "error";
/*      */     } 
/*      */     
/* 7712 */     return "success";
/*      */   }
/*      */   public String naiminathRegistration() {
/* 7715 */     if (!isValidSession()) {
/* 7716 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7719 */       logger.info("---------naiminathRegistration------------------------------------------------");
/* 7720 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7721 */       logger.info("---------------------------------------------------------");
/* 7722 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7723 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7724 */       logger.info("registeredUserId.." + registeredUserId);
/* 7725 */       getNaiminathOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7726 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */ 
/*      */       
/* 7729 */       if (AmountValidation(getNaiminathOnlineFormBean().getFeesAmount(), getNaiminathOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 7731 */         String responseString = studentRegistrationService.insertNaiminathDetails(getNaiminathOnlineFormBean(), billerId);
/* 7732 */         logger.info("naiminathRegistration :" + responseString);
/*      */         
/* 7734 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7735 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7736 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7737 */             addActionMessage("Failed to add Naiminath data.");
/* 7738 */             return "Naiminathfaliure";
/*      */           } 
/* 7740 */           addActionMessage("Error occured contact administrator.");
/* 7741 */           return "Naiminathfaliure"; }
/*      */ 
/*      */         
/* 7744 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getNaiminathOnlineFormBean().getStudentRegistrationId());
/* 7745 */         this.studentRegistrationFormBean.setTotalPayableFees(getNaiminathOnlineFormBean().getFeesAmount());
/* 7746 */         this.studentRegistrationFormBean.setStudentId(getNaiminathOnlineFormBean().getApplicationNo());
/* 7747 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7749 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7750 */         this.appData1 = new PaymentRequestBean();
/* 7751 */         this.appData1.setStudentRegistrationId(getNaiminathOnlineFormBean().getStudentRegistrationId());
/* 7752 */         logger.info("Naiminath --feesPayList :: " + this.feesPayList);
/* 7753 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 7755 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 7759 */         addActionMessage("Amount Mismatched.");
/* 7760 */         return "Naiminathfaliure";
/*      */       } 
/* 7762 */     } catch (Exception e) {
/*      */       
/* 7764 */       logger.error("Exception  " + e);
/* 7765 */       return "error";
/*      */     } 
/*      */     
/* 7768 */     return "success";
/*      */   }
/*      */   public String sphSchoolRegistration() {
/* 7771 */     if (!isValidSession()) {
/* 7772 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7775 */       logger.info("---------sphSchoolRegistration------------------------------------------------");
/* 7776 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7777 */       logger.info("---------------------------------------------------------");
/* 7778 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7779 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7780 */       logger.info("registeredUserId.." + registeredUserId);
/* 7781 */       getSphSchoolOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7782 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */ 
/*      */       
/* 7785 */       if (AmountValidation(getSphSchoolOnlineFormBean().getSchoolFee(), getSphSchoolOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 7787 */         String responseString = studentRegistrationService.insertSPHSchoolDetails(getSphSchoolOnlineFormBean(), billerId);
/* 7788 */         logger.info("sphSchoolRegistration :" + responseString);
/*      */         
/* 7790 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7791 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7792 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7793 */             addActionMessage("Failed to add SPHSchool data.");
/* 7794 */             return "SPHSchoolfaliure";
/*      */           } 
/* 7796 */           addActionMessage("Error occured contact administrator.");
/* 7797 */           return "SPHSchoolfaliure"; }
/*      */ 
/*      */         
/* 7800 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getSphSchoolOnlineFormBean().getStudentRegistrationId());
/* 7801 */         this.studentRegistrationFormBean.setTotalPayableFees(getSphSchoolOnlineFormBean().getSchoolFee());
/* 7802 */         this.studentRegistrationFormBean.setStudentId(getSphSchoolOnlineFormBean().getApplicationNo());
/* 7803 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7805 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7806 */         this.appData1 = new PaymentRequestBean();
/* 7807 */         this.appData1.setStudentRegistrationId(getSphSchoolOnlineFormBean().getStudentRegistrationId());
/* 7808 */         logger.info("SPHSchool --feesPayList :: " + this.feesPayList);
/* 7809 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 7811 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 7815 */         addActionMessage("Amount Mismatched.");
/* 7816 */         return "SPHSchoolfaliure";
/*      */       } 
/* 7818 */     } catch (Exception e) {
/*      */       
/* 7820 */       logger.error("Exception  " + e);
/* 7821 */       return "error";
/*      */     } 
/*      */     
/* 7824 */     return "success";
/*      */   }
/*      */   public String jainSubodhRegistration() {
/* 7827 */     if (!isValidSession()) {
/* 7828 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7831 */       logger.info("---------jainSubodhRegistration------------------------------------------------");
/* 7832 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7833 */       logger.info("---------------------------------------------------------");
/* 7834 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7835 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7836 */       logger.info("registeredUserId.." + registeredUserId);
/* 7837 */       getJainSubodhOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7838 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */ 
/*      */       
/* 7841 */       if (AmountValidation(getJainSubodhOnlineFormBean().getFeeAmount(), getJainSubodhOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 7843 */         String responseString = studentRegistrationService.insertJainSubodhDetails(getJainSubodhOnlineFormBean(), billerId);
/* 7844 */         logger.info("JainSubodhRegistration :" + responseString);
/*      */         
/* 7846 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7847 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7848 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7849 */             addActionMessage("Failed to add Jain Subodh data.");
/* 7850 */             return "JainSubodhfaliure";
/*      */           } 
/* 7852 */           addActionMessage("Error occured contact administrator.");
/* 7853 */           return "JainSubodhfaliure"; }
/*      */ 
/*      */         
/* 7856 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getJainSubodhOnlineFormBean().getStudentRegistrationId());
/* 7857 */         this.studentRegistrationFormBean.setTotalPayableFees(getJainSubodhOnlineFormBean().getFeeAmount());
/* 7858 */         this.studentRegistrationFormBean.setStudentId(getJainSubodhOnlineFormBean().getApplicationNo());
/* 7859 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7861 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7862 */         this.appData1 = new PaymentRequestBean();
/* 7863 */         this.appData1.setStudentRegistrationId(getJainSubodhOnlineFormBean().getStudentRegistrationId());
/* 7864 */         logger.info("Jain Subodh --feesPayList :: " + this.feesPayList);
/* 7865 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 7867 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 7871 */         addActionMessage("Amount Mismatched.");
/* 7872 */         return "JainSubodhfaliure";
/*      */       } 
/* 7874 */     } catch (Exception e) {
/*      */       
/* 7876 */       logger.error("Exception  " + e);
/* 7877 */       return "error";
/*      */     } 
/*      */     
/* 7880 */     return "success";
/*      */   }
/*      */   public String teamWorkRegistration() {
/* 7883 */     if (!isValidSession()) {
/* 7884 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7887 */       logger.info("---------teamWorkRegistration------------------------------------------------");
/* 7888 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7889 */       logger.info("---------------------------------------------------------");
/* 7890 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7891 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7892 */       logger.info("registeredUserId.." + registeredUserId);
/* 7893 */       getTeamworkEducationOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7894 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */ 
/*      */       
/* 7897 */       if (AmountValidation(getTeamworkEducationOnlineFormBean().getAmount(), getTeamworkEducationOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 7899 */         String responseString = studentRegistrationService.insertTeamWorkEducationDetails(getTeamworkEducationOnlineFormBean(), billerId);
/* 7900 */         logger.info("teamWorkRegistration :" + responseString);
/*      */         
/* 7902 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7903 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7904 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7905 */             addActionMessage("Failed to add Team Work data.");
/* 7906 */             return "TeamWorkfaliure";
/*      */           } 
/* 7908 */           addActionMessage("Error occured contact administrator.");
/* 7909 */           return "TeamWorkfaliure"; }
/*      */ 
/*      */         
/* 7912 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getTeamworkEducationOnlineFormBean().getStudentRegistrationId());
/* 7913 */         this.studentRegistrationFormBean.setTotalPayableFees(getTeamworkEducationOnlineFormBean().getAmount());
/* 7914 */         this.studentRegistrationFormBean.setStudentId(getTeamworkEducationOnlineFormBean().getApplicationNo());
/* 7915 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7917 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7918 */         this.appData1 = new PaymentRequestBean();
/* 7919 */         this.appData1.setStudentRegistrationId(getTeamworkEducationOnlineFormBean().getStudentRegistrationId());
/* 7920 */         logger.info("Teamwork Educational --feesPayList :: " + this.feesPayList);
/* 7921 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 7923 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 7927 */         addActionMessage("Amount Mismatched.");
/* 7928 */         return "TeamWorkfaliure";
/*      */       } 
/* 7930 */     } catch (Exception e) {
/*      */       
/* 7932 */       logger.error("Exception  " + e);
/* 7933 */       return "error";
/*      */     } 
/*      */     
/* 7936 */     return "success";
/*      */   }
/*      */   public String goenkaRegistration() {
/* 7939 */     if (!isValidSession()) {
/* 7940 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7943 */       logger.info("--------------------goenkaRegistration-------------------");
/* 7944 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 7945 */       logger.info("---------------------------------------------------------");
/* 7946 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 7947 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 7948 */       logger.info("registeredUserId.." + registeredUserId);
/* 7949 */       getGoenkaOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 7950 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */ 
/*      */       
/* 7953 */       if (AmountValidation(getGoenkaOnlineFormBean().getTotalAmount(), getGoenkaOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 7955 */         String responseString = studentRegistrationService.insertGOENKADetails(getGoenkaOnlineFormBean(), billerId);
/* 7956 */         logger.info("goenkaRegistration :" + responseString);
/*      */         
/* 7958 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 7959 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 7960 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 7961 */             addActionMessage("Failed to add GOENKA data.");
/* 7962 */             return "goenkafailure";
/*      */           } 
/* 7964 */           addActionMessage("Error occured contact administrator.");
/* 7965 */           return "goenkafailure"; }
/*      */ 
/*      */         
/* 7968 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getGoenkaOnlineFormBean().getStudentRegistrationId());
/* 7969 */         this.studentRegistrationFormBean.setTotalPayableFees(getGoenkaOnlineFormBean().getTotalAmount());
/* 7970 */         this.studentRegistrationFormBean.setStudentId(getGoenkaOnlineFormBean().getApplicationNo());
/* 7971 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 7973 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 7974 */         this.appData1 = new PaymentRequestBean();
/* 7975 */         this.appData1.setStudentRegistrationId(getGoenkaOnlineFormBean().getStudentRegistrationId());
/* 7976 */         logger.info("GOENKA --feesPayList :: " + this.feesPayList);
/* 7977 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 7979 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 7983 */         addActionMessage("Amount Mismatched.");
/* 7984 */         return "goenkafailure";
/*      */       } 
/* 7986 */     } catch (Exception e) {
/*      */       
/* 7988 */       logger.error("Exception  " + e);
/* 7989 */       return "error";
/*      */     } 
/*      */     
/* 7992 */     return "success";
/*      */   }
/*      */   public String GRCosmicRegister() {
/* 7995 */     if (!isValidSession()) {
/* 7996 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 7999 */       logger.info("---------GRCosmicRegister------------------------------------------------");
/* 8000 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 8001 */       logger.info("---------------------------------------------------------");
/* 8002 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8003 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8004 */       logger.info("registeredUserId.." + registeredUserId);
/* 8005 */       getGrCosmicOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 8006 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 8008 */       if (AmountValidation(getGrCosmicOnlineFormBean().getFeesAmount(), getGrCosmicOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 8010 */         String responseString = studentRegistrationService.insertGRCosmicStudentDetails(getGrCosmicOnlineFormBean(), billerId);
/* 8011 */         logger.info("GRCosmicRegister :" + responseString);
/*      */         
/* 8013 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8014 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8015 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8016 */             addActionMessage("Failed to add GRCosmicRegister data.");
/* 8017 */             return "GRCosmicfaliure";
/*      */           } 
/* 8019 */           addActionMessage("Error occured contact administrator.");
/* 8020 */           return "GRCosmicfaliure"; }
/*      */ 
/*      */         
/* 8023 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getGrCosmicOnlineFormBean().getStudentRegistrationId());
/* 8024 */         this.studentRegistrationFormBean.setTotalPayableFees(getGrCosmicOnlineFormBean().getFeesAmount());
/* 8025 */         this.studentRegistrationFormBean.setStudentId(getGrCosmicOnlineFormBean().getApplicationNo());
/* 8026 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8028 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8029 */         this.appData1 = new PaymentRequestBean();
/* 8030 */         this.appData1.setStudentRegistrationId(getGrCosmicOnlineFormBean().getStudentRegistrationId());
/* 8031 */         logger.info("GRCosmicRegister --feesPayList :: " + this.feesPayList);
/* 8032 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8034 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8038 */         addActionMessage("Amount Mismatched.");
/* 8039 */         return "GRCosmicfaliure";
/*      */       } 
/* 8041 */     } catch (Exception e) {
/*      */       
/* 8043 */       logger.error("Exception  " + e);
/* 8044 */       return "error";
/*      */     } 
/*      */     
/* 8047 */     return "success";
/*      */   }
/*      */   public String venkatEduRegisterStudent() {
/* 8050 */     if (!isValidSession()) {
/* 8051 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8054 */       logger.info("--------------------venkatEduRegisterStudent-------------------");
/* 8055 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 8056 */       logger.info("---------------------------------------------------------");
/* 8057 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8058 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8059 */       logger.info("------billerId :------" + billerId);
/* 8060 */       logger.info("registeredUserId.." + registeredUserId);
/* 8061 */       getVenkatEduOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 8062 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 8064 */       if (AmountValidation(getVenkatEduOnlineFormBean().getFeesamount(), getVenkatEduOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 8066 */         String responseString = studentRegistrationService.insertVenkatEduDetails(getVenkatEduOnlineFormBean(), billerId);
/* 8067 */         logger.info("venkatEduRegisterStudent :" + responseString);
/*      */         
/* 8069 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8070 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8071 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8072 */             addActionMessage("Failed to add Student data in venkat online form.");
/* 8073 */             return "venkatfailure";
/*      */           } 
/* 8075 */           addActionMessage("Error occured contact administrator.");
/* 8076 */           return "venkatfailure"; }
/*      */ 
/*      */         
/* 8079 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getVenkatEduOnlineFormBean().getStudentRegistrationId());
/* 8080 */         this.studentRegistrationFormBean.setTotalPayableFees(getVenkatEduOnlineFormBean().getFeesamount());
/* 8081 */         this.studentRegistrationFormBean.setStudentId(getVenkatEduOnlineFormBean().getApplicationNo());
/* 8082 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8084 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8085 */         this.appData1 = new PaymentRequestBean();
/* 8086 */         this.appData1.setStudentRegistrationId(getVenkatEduOnlineFormBean().getStudentRegistrationId());
/* 8087 */         logger.info("venkat--feesPayList :: " + this.feesPayList);
/* 8088 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8090 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8094 */         addActionMessage("Amount Mismatched.");
/* 8095 */         return "venkatfailure";
/*      */       } 
/* 8097 */     } catch (Exception e) {
/*      */       
/* 8099 */       logger.error("Exception  " + e);
/* 8100 */       return "error";
/*      */     } 
/*      */     
/* 8103 */     return "success";
/*      */   }
/*      */   public String mahaEduRegisterStudent() {
/* 8106 */     if (!isValidSession()) {
/* 8107 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8110 */       logger.info("--------------------mahaEduRegisterStudent-------------------");
/* 8111 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 8112 */       logger.info("---------------------------------------------------------");
/* 8113 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8114 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8115 */       logger.info("------billerId :------" + billerId);
/* 8116 */       logger.info("registeredUserId.." + registeredUserId);
/* 8117 */       getMahaEduOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 8118 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 8120 */       if (AmountValidation(getMahaEduOnlineFormBean().getAmount(), getMahaEduOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 8122 */         String responseString = studentRegistrationService.insertMahaEduDetails(getMahaEduOnlineFormBean(), billerId);
/* 8123 */         logger.info("mahaEduRegisterStudent :" + responseString);
/*      */         
/* 8125 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8126 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8127 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8128 */             addActionMessage("Failed to add Student data in mahaEdu.");
/* 8129 */             return "mahafailure";
/*      */           } 
/* 8131 */           addActionMessage("Error occured contact administrator.");
/* 8132 */           return "mahafailure"; }
/*      */ 
/*      */         
/* 8135 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getMahaEduOnlineFormBean().getStudentRegistrationId());
/* 8136 */         this.studentRegistrationFormBean.setTotalPayableFees(getMahaEduOnlineFormBean().getAmount());
/* 8137 */         this.studentRegistrationFormBean.setStudentId(getMahaEduOnlineFormBean().getApplicationNo());
/* 8138 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8140 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8141 */         this.appData1 = new PaymentRequestBean();
/* 8142 */         this.appData1.setStudentRegistrationId(getMahaEduOnlineFormBean().getStudentRegistrationId());
/* 8143 */         logger.info("maha--feesPayList :: " + this.feesPayList);
/* 8144 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8146 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8150 */         addActionMessage("Amount Mismatched.");
/* 8151 */         return "mahafailure";
/*      */       } 
/* 8153 */     } catch (Exception e) {
/*      */       
/* 8155 */       logger.error("Exception  " + e);
/* 8156 */       return "error";
/*      */     } 
/*      */     
/* 8159 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String smartrepEductionRegisterStudent() {
/* 8164 */     if (!isValidSession()) {
/* 8165 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8168 */       logger.info("--------------------Start smartrepEductionRegisterStudent-------------------");
/* 8169 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 8170 */       logger.info("---------------------------------------------------------");
/* 8171 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8172 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8173 */       logger.info("------billerId :------" + billerId);
/* 8174 */       logger.info("registeredUserId.." + registeredUserId);
/* 8175 */       getSmartrepEductionOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 8176 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 8178 */       if (AmountValidation(getSmartrepEductionOnlineFormBean().getTotalamount(), getSmartrepEductionOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 8180 */         String responseString = studentRegistrationService.insertSmartrepEdu(getSmartrepEductionOnlineFormBean(), billerId);
/* 8181 */         logger.info("smartrepEductionRegisterStudent :" + responseString);
/*      */         
/* 8183 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8184 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8185 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8186 */             addActionMessage("Failed to add Student data in mahaEdu.");
/* 8187 */             return "SEfailure";
/*      */           } 
/* 8189 */           addActionMessage("Error occured contact administrator.");
/* 8190 */           return "SEfailure"; }
/*      */ 
/*      */         
/* 8193 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getSmartrepEductionOnlineFormBean().getStudentRegistrationId());
/* 8194 */         this.studentRegistrationFormBean.setTotalPayableFees(getSmartrepEductionOnlineFormBean().getTotalamount());
/* 8195 */         this.studentRegistrationFormBean.setStudentId(getSmartrepEductionOnlineFormBean().getApplicationNo());
/* 8196 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8198 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8199 */         this.appData1 = new PaymentRequestBean();
/* 8200 */         this.appData1.setStudentRegistrationId(getSmartrepEductionOnlineFormBean().getStudentRegistrationId());
/* 8201 */         logger.info("SE--feesPayList :: " + this.feesPayList);
/* 8202 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8204 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8208 */         addActionMessage("Amount Mismatched.");
/* 8209 */         return "SEfailure";
/*      */       } 
/* 8211 */     } catch (Exception e) {
/*      */       
/* 8213 */       logger.error("Exception  " + e);
/* 8214 */       return "error";
/*      */     } 
/*      */     
/* 8217 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String asianRegisterStudent() {
/* 8223 */     if (!isValidSession()) {
/* 8224 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8227 */       logger.info("--------------------asianRegisterStudent-------------------");
/* 8228 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 8229 */       logger.info("---------------------------------------------------------");
/* 8230 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8231 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8232 */       logger.info("------billerId :------" + billerId);
/* 8233 */       logger.info("registeredUserId.." + registeredUserId);
/* 8234 */       getAsianOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 8235 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 8237 */       if (AmountValidation(getAsianOnlineFormBean().getAmount(), getAsianOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 8239 */         String responseString = studentRegistrationService.insertAsianDetails(getAsianOnlineFormBean(), billerId);
/* 8240 */         logger.info("asianRegisterStudent :" + responseString);
/*      */         
/* 8242 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8243 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8244 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8245 */             addActionMessage("Failed to add Student data in asianRegisterStudent.");
/* 8246 */             return "asianfailure";
/*      */           } 
/* 8248 */           addActionMessage("Error occured contact administrator.");
/* 8249 */           return "asianfailure"; }
/*      */ 
/*      */         
/* 8252 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getAsianOnlineFormBean().getStudentRegistrationId());
/* 8253 */         this.studentRegistrationFormBean.setTotalPayableFees(getAsianOnlineFormBean().getAmount());
/* 8254 */         this.studentRegistrationFormBean.setStudentId(getAsianOnlineFormBean().getApplicationNo());
/* 8255 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8257 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8258 */         this.appData1 = new PaymentRequestBean();
/* 8259 */         this.appData1.setStudentRegistrationId(getAsianOnlineFormBean().getStudentRegistrationId());
/* 8260 */         logger.info("asianRegisterStudent--feesPayList :: " + this.feesPayList);
/* 8261 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8263 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8267 */         addActionMessage("Amount Mismatched.");
/* 8268 */         return "asianfailure";
/*      */       } 
/* 8270 */     } catch (Exception e) {
/*      */       
/* 8272 */       logger.error("Exception  " + e);
/* 8273 */       return "error";
/*      */     } 
/*      */     
/* 8276 */     return "success";
/*      */   }
/*      */   public String rajashtanRegisterStudent() {
/* 8279 */     if (!isValidSession()) {
/* 8280 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8283 */       logger.info("--------------------rajashtanRegisterStudent-------------------");
/* 8284 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 8285 */       logger.info("---------------------------------------------------------");
/* 8286 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8287 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8288 */       logger.info("registeredUserId.." + registeredUserId);
/* 8289 */       getRajsthanOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 8290 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */ 
/*      */       
/* 8293 */       if (AmountValidation(getRajsthanOnlineFormBean().getTotalAmount(), getRajsthanOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 8295 */         String responseString = studentRegistrationService.insertRajashtanDetails(getRajsthanOnlineFormBean(), billerId);
/* 8296 */         logger.info("rajashtanRegisterStudent :" + responseString);
/*      */         
/* 8298 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8299 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8300 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8301 */             addActionMessage("Failed to add rajashtan institute data.");
/* 8302 */             return "rajashtanfaliure";
/*      */           } 
/* 8304 */           addActionMessage("Error occured contact administrator.");
/* 8305 */           return "rajashtanfaliure"; }
/*      */ 
/*      */         
/* 8308 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getRajsthanOnlineFormBean().getStudentRegistrationId());
/* 8309 */         this.studentRegistrationFormBean.setTotalPayableFees(getRajsthanOnlineFormBean().getTotalAmount());
/* 8310 */         this.studentRegistrationFormBean.setStudentId(getRajsthanOnlineFormBean().getApplicationNo());
/* 8311 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8313 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8314 */         this.appData1 = new PaymentRequestBean();
/* 8315 */         this.appData1.setStudentRegistrationId(getRajsthanOnlineFormBean().getStudentRegistrationId());
/* 8316 */         logger.info("Rajashtan--feesPayList :: " + this.feesPayList);
/* 8317 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8319 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8323 */         addActionMessage("Amount Mismatched.");
/* 8324 */         return "rajashtanfaliure";
/*      */       } 
/* 8326 */     } catch (Exception e) {
/*      */       
/* 8328 */       logger.error("Exception  " + e);
/* 8329 */       return "error";
/*      */     } 
/*      */     
/* 8332 */     return "success";
/*      */   }
/*      */   
/*      */   public String successEaseRegisterStudent() {
/* 8336 */     if (!isValidSession()) {
/* 8337 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8340 */       logger.info("---------successEaseRegisterStudent------------------------------------------------");
/* 8341 */       logger.info("successEaseRegisterStudent : - " + getAppData().getStudentRegistrationId());
/* 8342 */       logger.info("---------------------------------------------------------");
/* 8343 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8344 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8345 */       logger.info("registeredUserId.." + registeredUserId);
/* 8346 */       getSuccessEaseFormBeanFormBean().setRegisteredUserId(registeredUserId);
/* 8347 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */ 
/*      */       
/* 8350 */       if (AmountValidation(getSuccessEaseFormBeanFormBean().getTotalFee(), getSuccessEaseFormBeanFormBean().getPayment()).booleanValue()) {
/*      */         
/* 8352 */         String responseString = studentRegistrationService.insertSuccessEaseDetails(getSuccessEaseFormBeanFormBean(), billerId);
/* 8353 */         logger.info("SuccessEaseRegisterStudent :" + responseString);
/*      */         
/* 8355 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8356 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8357 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8358 */             addActionMessage("Failed to add Success Ease data.");
/* 8359 */             return "faliure";
/*      */           } 
/* 8361 */           addActionMessage("Error occured contact administrator.");
/* 8362 */           return "faliure"; }
/*      */ 
/*      */         
/* 8365 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getSuccessEaseFormBeanFormBean().getStudentRegistrationId());
/* 8366 */         this.studentRegistrationFormBean.setTotalPayableFees(getSuccessEaseFormBeanFormBean().getTotalFee());
/* 8367 */         this.studentRegistrationFormBean.setStudentId(getSuccessEaseFormBeanFormBean().getApplicationNo());
/* 8368 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8370 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8371 */         this.appData1 = new PaymentRequestBean();
/* 8372 */         this.appData1.setStudentRegistrationId(getSuccessEaseFormBeanFormBean().getStudentRegistrationId());
/* 8373 */         logger.info("Jain Subodh --feesPayList :: " + this.feesPayList);
/* 8374 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8376 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8380 */         addActionMessage("Amount Mismatched.");
/* 8381 */         return "faliure";
/*      */       } 
/* 8383 */     } catch (Exception e) {
/*      */       
/* 8385 */       logger.error("Exception  " + e);
/* 8386 */       return "error";
/*      */     } 
/*      */     
/* 8389 */     return "success";
/*      */   }
/*      */   
/*      */   public String kashiRegisterStudent() {
/* 8393 */     if (!isValidSession()) {
/* 8394 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8397 */       logger.info("---------KashiRegisterStudent------------------------------------------------");
/* 8398 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 8399 */       logger.info("---------------------------------------------------------");
/* 8400 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8401 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8402 */       logger.info("registeredUserId.." + registeredUserId);
/* 8403 */       getKashiInstituteFormBean().setRegisteredUserId(registeredUserId);
/* 8404 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 8406 */       if (AmountValidation(getKashiInstituteFormBean().getTotalFee(), getKashiInstituteFormBean().getPayment()).booleanValue()) {
/*      */         
/* 8408 */         String responseString = studentRegistrationService.insertKashiInstituteDetails(getKashiInstituteFormBean(), billerId);
/* 8409 */         logger.info("indianpoliticalRegisterStudent :" + responseString);
/*      */         
/* 8411 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8412 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8413 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8414 */             addActionMessage("Failed to add Indian Political data.");
/* 8415 */             return "faliure";
/*      */           } 
/* 8417 */           addActionMessage("Error occured contact administrator.");
/* 8418 */           return "faliure"; }
/*      */ 
/*      */         
/* 8421 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getKashiInstituteFormBean().getStudentRegistrationId());
/* 8422 */         this.studentRegistrationFormBean.setTotalPayableFees(getKashiInstituteFormBean().getTotalFee());
/* 8423 */         this.studentRegistrationFormBean.setStudentId(getKashiInstituteFormBean().getApplicationNo());
/* 8424 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8426 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8427 */         this.appData1 = new PaymentRequestBean();
/* 8428 */         this.appData1.setStudentRegistrationId(getKashiInstituteFormBean().getStudentRegistrationId());
/* 8429 */         logger.info("Jain Subodh --feesPayList :: " + this.feesPayList);
/* 8430 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8432 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8436 */         addActionMessage("Amount Mismatched.");
/* 8437 */         return "faliure";
/*      */       } 
/* 8439 */     } catch (Exception e) {
/*      */       
/* 8441 */       logger.error("Exception  " + e);
/* 8442 */       return "error";
/*      */     } 
/*      */     
/* 8445 */     return "success";
/*      */   }
/*      */   public String iicsEductionRegisterStudent() {
/* 8448 */     if (!isValidSession()) {
/* 8449 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8452 */       logger.info("--------------------Start iicsEductionRegisterStudent-------------------");
/* 8453 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 8454 */       logger.info("---------------------------------------------------------");
/* 8455 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8456 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8457 */       logger.info("------billerId :------" + billerId);
/* 8458 */       logger.info("registeredUserId.." + registeredUserId);
/* 8459 */       getIicsEductionOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 8460 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 8462 */       if (AmountValidation(getIicsEductionOnlineFormBean().getTotalamount(), getIicsEductionOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 8464 */         String responseString = studentRegistrationService.insertIICSEdu(getIicsEductionOnlineFormBean(), billerId);
/* 8465 */         logger.info("smartrepEductionRegisterStudent :" + responseString);
/*      */         
/* 8467 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8468 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8469 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8470 */             addActionMessage("Failed to add Student data in IICS Education.");
/* 8471 */             return "iicsfailure";
/*      */           } 
/* 8473 */           addActionMessage("Error occured contact administrator.");
/* 8474 */           return "iicsfailure"; }
/*      */ 
/*      */         
/* 8477 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getIicsEductionOnlineFormBean().getStudentRegistrationId());
/* 8478 */         this.studentRegistrationFormBean.setTotalPayableFees(getIicsEductionOnlineFormBean().getTotalamount());
/* 8479 */         this.studentRegistrationFormBean.setStudentId(getIicsEductionOnlineFormBean().getApplicationNo());
/* 8480 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8482 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8483 */         this.appData1 = new PaymentRequestBean();
/* 8484 */         this.appData1.setStudentRegistrationId(getIicsEductionOnlineFormBean().getStudentRegistrationId());
/* 8485 */         logger.info("iicsEduction--feesPayList :: " + this.feesPayList);
/* 8486 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8488 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8492 */         addActionMessage("Amount Mismatched.");
/* 8493 */         return "iicsfailure";
/*      */       } 
/* 8495 */     } catch (Exception e) {
/*      */       
/* 8497 */       logger.error("Exception  " + e);
/* 8498 */       return "error";
/*      */     } 
/*      */     
/* 8501 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String jawaharRegisterStudent() {
/* 8506 */     if (!isValidSession()) {
/* 8507 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8510 */       logger.info("--------------------Start jawaharRegisterStudent-------------------");
/* 8511 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 8512 */       logger.info("---------------------------------------------------------");
/* 8513 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8514 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8515 */       logger.info("------billerId :------" + billerId);
/* 8516 */       logger.info("registeredUserId.." + registeredUserId);
/* 8517 */       getJawaharOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 8518 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 8520 */       if (AmountValidation(getJawaharOnlineFormBean().getFeeAmount(), getJawaharOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 8522 */         String responseString = studentRegistrationService.insertJawaharStudent(getJawaharOnlineFormBean(), billerId);
/* 8523 */         logger.info("JawaharRegisterStudent :" + responseString);
/*      */         
/* 8525 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8526 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8527 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8528 */             addActionMessage("Failed to add Student data in IICS Education.");
/* 8529 */             return "iicsfailure";
/*      */           } 
/* 8531 */           addActionMessage("Error occured contact administrator.");
/* 8532 */           return "jawaharfailure"; }
/*      */ 
/*      */         
/* 8535 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getJawaharOnlineFormBean().getStudentRegistrationId());
/* 8536 */         this.studentRegistrationFormBean.setTotalPayableFees(getJawaharOnlineFormBean().getFeeAmount());
/* 8537 */         this.studentRegistrationFormBean.setStudentId(getJawaharOnlineFormBean().getApplicationNo());
/* 8538 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8540 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8541 */         this.appData1 = new PaymentRequestBean();
/* 8542 */         this.appData1.setStudentRegistrationId(getJawaharOnlineFormBean().getStudentRegistrationId());
/* 8543 */         logger.info("SE--feesPayList :: " + this.feesPayList);
/* 8544 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8546 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8550 */         addActionMessage("Amount Mismatched.");
/* 8551 */         return "jawaharfailure";
/*      */       } 
/* 8553 */     } catch (Exception e) {
/*      */       
/* 8555 */       logger.error("Exception  " + e);
/* 8556 */       return "error";
/*      */     } 
/*      */     
/* 8559 */     return "success";
/*      */   }
/*      */   
/*      */   public String horizonRegisterStudent() {
/* 8563 */     if (!isValidSession()) {
/* 8564 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8567 */       logger.info("---------horizonRegisterStudent------------------------------------------------");
/* 8568 */       logger.info("horizonRegisterStudent : - " + getAppData().getStudentRegistrationId());
/* 8569 */       logger.info("---------------------------------------------------------");
/* 8570 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8571 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8572 */       logger.info("registeredUserId.." + registeredUserId);
/* 8573 */       getHorizonOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 8574 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */ 
/*      */       
/* 8577 */       if (AmountValidation(getHorizonOnlineFormBean().getTotalFee(), getHorizonOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 8579 */         String responseString = studentRegistrationService.insertHorizonDetails(getHorizonOnlineFormBean(), billerId);
/* 8580 */         logger.info("Horizon RegisterStudent :" + responseString);
/*      */         
/* 8582 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8583 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8584 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8585 */             addActionMessage("Failed Horizon School to add  data.");
/* 8586 */             return "faliure";
/*      */           } 
/* 8588 */           addActionMessage("Error occured contact administrator.");
/* 8589 */           return "faliure"; }
/*      */         
/* 8591 */         String studIDandreg = String.valueOf(getHorizonOnlineFormBean().getName()) + "::" + getHorizonOnlineFormBean().getRegNo();
/* 8592 */         logger.info("StudentName:------------**StudentName***------------------------" + studIDandreg);
/* 8593 */         this.studentRegistrationFormBean.setStudentName(studIDandreg);
/* 8594 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getHorizonOnlineFormBean().getStudentRegistrationId());
/* 8595 */         this.studentRegistrationFormBean.setTotalPayableFees(getHorizonOnlineFormBean().getTotalFee());
/* 8596 */         this.studentRegistrationFormBean.setStudentId(getHorizonOnlineFormBean().getApplicationNo());
/* 8597 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8599 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8600 */         this.appData1 = new PaymentRequestBean();
/* 8601 */         this.appData1.setStudentRegistrationId(getHorizonOnlineFormBean().getStudentRegistrationId());
/* 8602 */         logger.info("Horizon School --feesPayList :: " + this.feesPayList);
/* 8603 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8605 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8609 */         addActionMessage("Amount Mismatched.");
/* 8610 */         return "faliure";
/*      */       } 
/* 8612 */     } catch (Exception e) {
/*      */       
/* 8614 */       logger.error("Exception  " + e);
/* 8615 */       return "error";
/*      */     } 
/*      */     
/* 8618 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String brainStormRegisterStudent() {
/* 8624 */     if (!isValidSession()) {
/* 8625 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8628 */       logger.info("---------brainStormRegisterStudent------------------------------------------------");
/* 8629 */       logger.info("brainStormRegisterStudent : - " + getAppData().getStudentRegistrationId());
/* 8630 */       logger.info("---------------------------------------------------------");
/* 8631 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8632 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8633 */       logger.info("registeredUserId.." + registeredUserId);
/* 8634 */       getBrainStormFormBean().setRegisteredUserId(registeredUserId);
/* 8635 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */ 
/*      */       
/* 8638 */       if (AmountValidation(getBrainStormFormBean().getTotalFee(), getBrainStormFormBean().getPayment()).booleanValue()) {
/*      */         
/* 8640 */         String responseString = studentRegistrationService.insertBrainStormEaseDetails(getBrainStormFormBean(), billerId);
/* 8641 */         logger.info("brainStormRegisterStudent :" + responseString);
/*      */         
/* 8643 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8644 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8645 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8646 */             addActionMessage("Failed to add Success Ease data.");
/* 8647 */             return "faliure";
/*      */           } 
/* 8649 */           addActionMessage("Error occured contact administrator.");
/* 8650 */           return "faliure"; }
/*      */ 
/*      */         
/* 8653 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getBrainStormFormBean().getStudentRegistrationId());
/* 8654 */         this.studentRegistrationFormBean.setTotalPayableFees(getBrainStormFormBean().getTotalFee());
/* 8655 */         this.studentRegistrationFormBean.setStudentId(getBrainStormFormBean().getApplicationNo());
/* 8656 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8658 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8659 */         this.appData1 = new PaymentRequestBean();
/* 8660 */         this.appData1.setStudentRegistrationId(getBrainStormFormBean().getStudentRegistrationId());
/* 8661 */         logger.info("BrainStorm --feesPayList :: " + this.feesPayList);
/* 8662 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8664 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8668 */         addActionMessage("Amount Mismatched.");
/* 8669 */         return "faliure";
/*      */       } 
/* 8671 */     } catch (Exception e) {
/*      */       
/* 8673 */       logger.error("Exception  " + e);
/* 8674 */       return "error";
/*      */     } 
/*      */     
/* 8677 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String delhiSchoolRegisterStudent() {
/* 8682 */     if (!isValidSession()) {
/* 8683 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8686 */       logger.info("--------------------Start delhiSchoolRegisterStudent-------------------");
/* 8687 */       logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 8688 */       logger.info("---------------------------------------------------------");
/* 8689 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8690 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8691 */       logger.info("------billerId :------" + billerId);
/* 8692 */       logger.info("registeredUserId.." + registeredUserId);
/* 8693 */       getDelhiSchoolOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 8694 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 8696 */       if (AmountValidation(getDelhiSchoolOnlineFormBean().getTotalamount(), getDelhiSchoolOnlineFormBean().getPayment()).booleanValue()) {
/*      */         
/* 8698 */         String responseString = studentRegistrationService.insertDelhiSchool(getDelhiSchoolOnlineFormBean(), billerId);
/* 8699 */         logger.info("smartrepEductionRegisterStudent :" + responseString);
/*      */         
/* 8701 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8702 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8703 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8704 */             addActionMessage("Failed to add Student data in Delhi school.");
/* 8705 */             return "delhischoolfailure";
/*      */           } 
/* 8707 */           addActionMessage("Error occured contact administrator.");
/* 8708 */           return "delhischoolfailure"; }
/*      */ 
/*      */         
/* 8711 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getDelhiSchoolOnlineFormBean().getStudentRegistrationId());
/* 8712 */         this.studentRegistrationFormBean.setTotalPayableFees(getDelhiSchoolOnlineFormBean().getTotalamount());
/* 8713 */         this.studentRegistrationFormBean.setStudentId(getDelhiSchoolOnlineFormBean().getApplicationNo());
/* 8714 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8716 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8717 */         this.appData1 = new PaymentRequestBean();
/* 8718 */         this.appData1.setStudentRegistrationId(getDelhiSchoolOnlineFormBean().getStudentRegistrationId());
/* 8719 */         logger.info("SE--feesPayList :: " + this.feesPayList);
/* 8720 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8722 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8726 */         addActionMessage("Amount Mismatched.");
/* 8727 */         return "delhischoolfailure";
/*      */       } 
/* 8729 */     } catch (Exception e) {
/*      */       
/* 8731 */       logger.error("Exception  " + e);
/* 8732 */       return "error";
/*      */     } 
/*      */     
/* 8735 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String sisRegisterStudent() {
/* 8742 */     if (!isValidSession()) {
/* 8743 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8746 */       logger.info("---------SISRegisterStudent------------------------------------------------");
/* 8747 */       logger.info("SISRegisterStudent : - " + getAppData().getStudentRegistrationId());
/* 8748 */       logger.info("---------------------------------------------------------");
/* 8749 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8750 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8751 */       logger.info("registeredUserId.." + registeredUserId);
/* 8752 */       getSisFormBean().setRegisteredUserId(registeredUserId);
/* 8753 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */ 
/*      */       
/* 8756 */       if (AmountValidation(getSisFormBean().getTotalFee(), getSisFormBean().getPayment()).booleanValue()) {
/*      */         
/* 8758 */         String responseString = studentRegistrationService.insertSISDetails(getSisFormBean(), billerId);
/* 8759 */         logger.info("SIS Gurukul trust RegisterStudent :" + responseString);
/*      */         
/* 8761 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8762 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8763 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8764 */             addActionMessage("Failed to SIS Gurukul trust add  data.");
/* 8765 */             return "faliure";
/*      */           } 
/* 8767 */           addActionMessage("Error occured contact administrator.");
/* 8768 */           return "faliure"; }
/*      */ 
/*      */         
/* 8771 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getSisFormBean().getStudentRegistrationId());
/* 8772 */         this.studentRegistrationFormBean.setTotalPayableFees(getSisFormBean().getTotalFee());
/* 8773 */         this.studentRegistrationFormBean.setStudentId(getSisFormBean().getApplicationNo());
/* 8774 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8776 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8777 */         this.appData1 = new PaymentRequestBean();
/* 8778 */         this.appData1.setStudentRegistrationId(getSisFormBean().getStudentRegistrationId());
/* 8779 */         logger.info("SIS Gurukul trust --feesPayList :: " + this.feesPayList);
/* 8780 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8782 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8786 */         addActionMessage("Amount Mismatched.");
/* 8787 */         return "faliure";
/*      */       } 
/* 8789 */     } catch (Exception e) {
/*      */       
/* 8791 */       logger.error("Exception  " + e);
/* 8792 */       return "error";
/*      */     } 
/*      */     
/* 8795 */     return "success";
/*      */   }
/*      */   
/*      */   public String getICEStudent() {
/* 8799 */     if (!isValidSession()) {
/* 8800 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8803 */       logger.info("---------ICERegisterStudent------------START-----" + System.currentTimeMillis());
/* 8804 */       logger.info("---------ICERegisterStudent------------------------------------------------");
/* 8805 */       logger.info("iceRegisterStudent : - " + getAppData().getStudentRegistrationId());
/* 8806 */       logger.info("---------------------------------------------------------");
/* 8807 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8808 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8809 */       logger.info("registeredUserId.." + registeredUserId);
/* 8810 */       getIceFormBean().setRegisteredUserId(registeredUserId);
/* 8811 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/* 8812 */       logger.info("Test Branch: " + getIceFormBean().getBranch());
/*      */       
/* 8814 */       if (AmountValidation(getIceFormBean().getAmount(), getIceFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 8817 */         String responseString = studentRegistrationService.insertIceDetails(getIceFormBean(), billerId);
/* 8818 */         logger.info("ICERegisterStudent :" + responseString);
/*      */         
/* 8820 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8821 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8822 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8823 */             addActionMessage("Failed to add Success Ease data.");
/* 8824 */             return "faliure";
/*      */           } 
/* 8826 */           addActionMessage("Error occured contact administrator.");
/* 8827 */           return "faliure"; }
/*      */ 
/*      */         
/* 8830 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getIceFormBean().getStudentRegistrationId());
/* 8831 */         this.studentRegistrationFormBean.setTotalPayableFees(getIceFormBean().getAmount());
/* 8832 */         this.studentRegistrationFormBean.setStudentId(getIceFormBean().getApplicationNo());
/* 8833 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8835 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8836 */         this.appData1 = new PaymentRequestBean();
/* 8837 */         this.appData1.setStudentRegistrationId(getIceFormBean().getStudentRegistrationId());
/* 8838 */         logger.info("ICE --feesPayList :: " + this.feesPayList);
/* 8839 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8841 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8845 */         addActionMessage("Amount Mismatched.");
/* 8846 */         return "faliure";
/*      */       } 
/* 8848 */     } catch (Exception e) {
/*      */       
/* 8850 */       logger.error("Exception  " + e);
/* 8851 */       logger.info("---------ICERegisterStudent--------ERROR--END-----" + System.currentTimeMillis());
/* 8852 */       return "error";
/*      */     } 
/*      */     
/* 8855 */     logger.info("---------ICERegisterStudent------------END-----" + System.currentTimeMillis());
/* 8856 */     return "success";
/*      */   }
/*      */   
/*      */   public String iEIIndiaRegisterStudent() {
/* 8860 */     if (!isValidSession()) {
/* 8861 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8864 */       logger.info("---------iEIIndiaRegisterStudent ~Start~---------------" + System.currentTimeMillis());
/* 8865 */       logger.info("iEIIndiaRegisterStudent : - " + getAppData().getStudentRegistrationId());
/* 8866 */       logger.info("---------------------------------------------------------");
/* 8867 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8868 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8869 */       logger.info("registeredUserId.." + registeredUserId);
/* 8870 */       getIeiIndiaFormBean().setRegisteredUserId(registeredUserId);
/* 8871 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 8873 */       if (AmountValidation(getIeiIndiaFormBean().getTotalFee(), getIeiIndiaFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 8876 */         String responseString = studentRegistrationService.insertIEIIndiaDetails(getIeiIndiaFormBean(), billerId);
/* 8877 */         logger.info("iEIIndiaRegisterStudent :" + responseString);
/*      */         
/* 8879 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8880 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8881 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8882 */             addActionMessage("Failed to add Success Ease data.");
/* 8883 */             return "faliure";
/*      */           } 
/* 8885 */           addActionMessage("Error occured contact administrator.");
/* 8886 */           return "faliure"; }
/*      */ 
/*      */         
/* 8889 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getIeiIndiaFormBean().getStudentRegistrationId());
/* 8890 */         this.studentRegistrationFormBean.setTotalPayableFees(getIeiIndiaFormBean().getTotalFee());
/* 8891 */         this.studentRegistrationFormBean.setStudentId(getIeiIndiaFormBean().getApplicationNo());
/* 8892 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8894 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8895 */         this.appData1 = new PaymentRequestBean();
/* 8896 */         this.appData1.setStudentRegistrationId(getIeiIndiaFormBean().getStudentRegistrationId());
/* 8897 */         logger.info("BrainStorm --feesPayList :: " + this.feesPayList);
/* 8898 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8900 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8904 */         addActionMessage("Amount Mismatched.");
/* 8905 */         return "faliure";
/*      */       } 
/* 8907 */     } catch (Exception e) {
/*      */       
/* 8909 */       logger.error("Exception  " + e);
/* 8910 */       return "error";
/*      */     } 
/*      */     
/* 8913 */     logger.info("---------iEIIndiaRegisterStudent ~END~---------------" + System.currentTimeMillis());
/* 8914 */     return "success";
/*      */   }
/*      */   
/*      */   public String getBhartiConceptStudent() {
/* 8918 */     if (!isValidSession()) {
/* 8919 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 8922 */       logger.info("START---------getBhartiConceptStudent------------------------------------------------");
/* 8923 */       logger.info("getBhartiConceptStudent : - " + getAppData().getStudentRegistrationId());
/* 8924 */       logger.info("---------------------------------------------------------");
/* 8925 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 8926 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 8927 */       logger.info("registeredUserId.." + registeredUserId);
/* 8928 */       getBhartiConceptFormBean().setRegisteredUserId(registeredUserId);
/* 8929 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 8931 */       if (AmountValidation(getBhartiConceptFormBean().getFinalAmount(), getBhartiConceptFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 8934 */         String responseString = studentRegistrationService.insertBhartiConceptDetails(getBhartiConceptFormBean(), billerId);
/* 8935 */         logger.info("getBhartiConceptFormBean response :" + responseString);
/*      */         
/* 8937 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 8938 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 8939 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 8940 */             addActionMessage("Failed to add Success Ease data.");
/* 8941 */             return "faliure";
/*      */           } 
/* 8943 */           addActionMessage("Error occured contact administrator.");
/* 8944 */           return "faliure"; }
/*      */ 
/*      */         
/* 8947 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getBhartiConceptFormBean().getStudentRegistrationId());
/* 8948 */         this.studentRegistrationFormBean.setTotalPayableFees(getBhartiConceptFormBean().getFinalAmount());
/* 8949 */         this.studentRegistrationFormBean.setStudentId(getBhartiConceptFormBean().getApplicationNo());
/* 8950 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 8952 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 8953 */         this.appData1 = new PaymentRequestBean();
/* 8954 */         this.appData1.setStudentRegistrationId(getBhartiConceptFormBean().getStudentRegistrationId());
/* 8955 */         logger.info("NavJagriti --feesPayList :: " + this.feesPayList);
/* 8956 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 8958 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 8962 */         addActionMessage("Amount Mismatched.");
/* 8963 */         return "faliure";
/*      */       } 
/* 8965 */     } catch (Exception e) {
/*      */       
/* 8967 */       logger.error("Exception  " + e);
/* 8968 */       return "error";
/*      */     } 
/*      */     
/* 8971 */     logger.info("END---getBhartiConceptStudent");
/* 8972 */     return "success";
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
/*      */   public String getTrinityStudent() {
/* 9034 */     if (!isValidSession()) {
/* 9035 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 9038 */       logger.info("---------TrinityRegisterStudent------------------------------------------------");
/* 9039 */       logger.info("trinityRegisterStudent : - " + getAppData().getStudentRegistrationId());
/* 9040 */       logger.info("---------------------------------------------------------");
/* 9041 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9042 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9043 */       logger.info("registeredUserId.." + registeredUserId);
/* 9044 */       getTrinityOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 9045 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 9047 */       if (AmountValidation(getTrinityOnlineFormBean().getTotalAmount(), getTrinityOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 9050 */         String responseString = studentRegistrationService.insertTrinityDetails(getTrinityOnlineFormBean(), billerId);
/* 9051 */         logger.info("TrinityRegisterStudent :" + responseString);
/*      */         
/* 9053 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 9054 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 9055 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 9056 */             addActionMessage("Failed to add Success Ease data.");
/* 9057 */             return "faliure";
/*      */           } 
/* 9059 */           addActionMessage("Error occured contact administrator.");
/* 9060 */           return "faliure"; }
/*      */ 
/*      */         
/* 9063 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getTrinityOnlineFormBean().getStudentRegistrationId());
/* 9064 */         this.studentRegistrationFormBean.setTotalPayableFees(getTrinityOnlineFormBean().getTotalAmount());
/* 9065 */         this.studentRegistrationFormBean.setStudentId(getTrinityOnlineFormBean().getApplicationNo());
/* 9066 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 9068 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 9069 */         this.appData1 = new PaymentRequestBean();
/* 9070 */         this.appData1.setStudentRegistrationId(getTrinityOnlineFormBean().getStudentRegistrationId());
/* 9071 */         logger.info("trinityRegisterStudent --feesPayList :: " + this.feesPayList);
/* 9072 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 9074 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 9078 */         addActionMessage("Amount Mismatched.");
/* 9079 */         return "faliure";
/*      */       } 
/* 9081 */     } catch (Exception e) {
/*      */       
/* 9083 */       logger.error("Exception  " + e);
/* 9084 */       return "error";
/*      */     } 
/*      */     
/* 9087 */     return "success";
/*      */   }
/*      */   
/*      */   public String getNavJagritiStudent() {
/* 9091 */     if (!isValidSession()) {
/* 9092 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 9095 */       logger.info("---------getNavJagritiStudent------------------------------------------------");
/* 9096 */       logger.info("getNavJagritiStudent : - " + getAppData().getStudentRegistrationId());
/* 9097 */       logger.info("---------------------------------------------------------");
/* 9098 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9099 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9100 */       logger.info("registeredUserId.." + registeredUserId);
/* 9101 */       getNavJagritiBean().setRegisteredUserId(registeredUserId);
/* 9102 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 9104 */       if (AmountValidation(getNavJagritiBean().getAmount(), getNavJagritiBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 9107 */         String responseString = studentRegistrationService.insertNavJagritiDetails(getNavJagritiBean(), billerId);
/* 9108 */         logger.info("getNavJagritiBean :" + responseString);
/*      */         
/* 9110 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 9111 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 9112 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 9113 */             addActionMessage("Failed to add Success Ease data.");
/* 9114 */             return "faliure";
/*      */           } 
/* 9116 */           addActionMessage("Error occured contact administrator.");
/* 9117 */           return "faliure"; }
/*      */ 
/*      */         
/* 9120 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getNavJagritiBean().getStudentRegistrationId());
/* 9121 */         this.studentRegistrationFormBean.setTotalPayableFees(getNavJagritiBean().getAmount());
/* 9122 */         this.studentRegistrationFormBean.setStudentId(getNavJagritiBean().getApplicationNo());
/* 9123 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 9125 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 9126 */         this.appData1 = new PaymentRequestBean();
/* 9127 */         this.appData1.setStudentRegistrationId(getNavJagritiBean().getStudentRegistrationId());
/* 9128 */         logger.info("NavJagriti --feesPayList :: " + this.feesPayList);
/* 9129 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 9131 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 9135 */         addActionMessage("Amount Mismatched.");
/* 9136 */         return "faliure";
/*      */       } 
/* 9138 */     } catch (Exception e) {
/*      */       
/* 9140 */       logger.error("Exception  " + e);
/* 9141 */       return "error";
/*      */     } 
/*      */     
/* 9144 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDpsPanipatDetails() {
/* 9150 */     if (!isValidSession()) {
/* 9151 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 9154 */       logger.info("---------DPS Panipat details------------------------------------------------");
/* 9155 */       logger.info("DPS Panipat details : - " + getAppData().getStudentRegistrationId());
/* 9156 */       logger.info("---------------------------------------------------------");
/* 9157 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9158 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9159 */       logger.info("registeredUserId.." + registeredUserId);
/* 9160 */       getDpsPanipatOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 9161 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 9163 */       if (AmountValidation(getDpsPanipatOnlineFormBean().getTotalAmount(), getDpsPanipatOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 9166 */         String responseString = studentRegistrationService.insertDpsPanipatDetails(getDpsPanipatOnlineFormBean(), billerId);
/* 9167 */         logger.info("DPS Panipat Student :" + responseString);
/*      */         
/* 9169 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 9170 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 9171 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 9172 */             addActionMessage("Failed to add Success Ease data.");
/* 9173 */             return "faliure";
/*      */           } 
/* 9175 */           addActionMessage("Error occured contact administrator.");
/* 9176 */           return "faliure"; }
/*      */ 
/*      */         
/* 9179 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getDpsPanipatOnlineFormBean().getStudentRegistrationId());
/* 9180 */         this.studentRegistrationFormBean.setTotalPayableFees(getDpsPanipatOnlineFormBean().getTotalAmount());
/* 9181 */         this.studentRegistrationFormBean.setStudentId(getDpsPanipatOnlineFormBean().getApplicationNo());
/* 9182 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 9184 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 9185 */         this.appData1 = new PaymentRequestBean();
/* 9186 */         this.appData1.setStudentRegistrationId(getDpsPanipatOnlineFormBean().getStudentRegistrationId());
/* 9187 */         logger.info("DPS Panipat Student --feesPayList :: " + this.feesPayList);
/* 9188 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 9190 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 9194 */         addActionMessage("Amount Mismatched.");
/* 9195 */         return "faliure";
/*      */       } 
/* 9197 */     } catch (Exception e) {
/*      */       
/* 9199 */       logger.error("Exception  " + e);
/* 9200 */       return "error";
/*      */     } 
/*      */     
/* 9203 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DronacharyaOnlineFormBean getDronacharyaOnlineFormBean() {
/* 9210 */     return this.dronacharyaOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setDronacharyaOnlineFormBean(DronacharyaOnlineFormBean dronacharyaOnlineFormBean) {
/* 9214 */     this.dronacharyaOnlineFormBean = dronacharyaOnlineFormBean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDronacharyaFormData() {
/* 9221 */     if (!isValidSession()) {
/* 9222 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 9225 */       logger.info("---------Dronacharya RegisterStudent------------------------------------------------");
/* 9226 */       logger.info("Dronacharya RegisterStudent : - " + getAppData().getStudentRegistrationId());
/* 9227 */       logger.info("---------------------------------------------------------");
/* 9228 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9229 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9230 */       logger.info("registeredUserId.." + registeredUserId);
/* 9231 */       getDronacharyaOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 9232 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 9234 */       if (AmountValidation(getDronacharyaOnlineFormBean().getTotalAmount(), getDronacharyaOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 9237 */         String responseString = studentRegistrationService.insertDronacharyaDetails(getDronacharyaOnlineFormBean(), billerId);
/* 9238 */         logger.info("DronacharyaRegisterStudent :" + responseString);
/*      */         
/* 9240 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 9241 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 9242 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 9243 */             addActionMessage("Failed to add Success Ease data.");
/* 9244 */             return "faliure";
/*      */           } 
/* 9246 */           addActionMessage("Error occured contact administrator.");
/* 9247 */           return "faliure"; }
/*      */ 
/*      */         
/* 9250 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getDronacharyaOnlineFormBean().getStudentRegistrationId());
/* 9251 */         this.studentRegistrationFormBean.setTotalPayableFees(getDronacharyaOnlineFormBean().getTotalAmount());
/* 9252 */         this.studentRegistrationFormBean.setStudentId(getDronacharyaOnlineFormBean().getApplicationNo());
/* 9253 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 9255 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 9256 */         this.appData1 = new PaymentRequestBean();
/* 9257 */         this.appData1.setStudentRegistrationId(getDronacharyaOnlineFormBean().getStudentRegistrationId());
/* 9258 */         logger.info("dronacharyaRegisterStudent --feesPayList :: " + this.feesPayList);
/* 9259 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 9261 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 9265 */         addActionMessage("Amount Mismatched.");
/* 9266 */         return "faliure";
/*      */       } 
/* 9268 */     } catch (Exception e) {
/*      */       
/* 9270 */       logger.error("Exception  " + e);
/* 9271 */       return "error";
/*      */     } 
/*      */     
/* 9274 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DronacharyaGOIOnlineFormBean getDronacharyaGOIOnlineFormBean() {
/* 9283 */     return this.dronacharyaGOIOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setDronacharyaGOIOnlineFormBean(DronacharyaGOIOnlineFormBean dronacharyaGOIOnlineFormBean) {
/* 9287 */     this.dronacharyaGOIOnlineFormBean = dronacharyaGOIOnlineFormBean;
/*      */   }
/*      */   
/*      */   public String getDronacharyaGOIStudent() {
/* 9291 */     if (!isValidSession()) {
/* 9292 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 9295 */       logger.info("---------Dronacharya RegisterStudent------------------------------------------------");
/* 9296 */       logger.info("Dronacharya RegisterStudent : - " + getAppData().getStudentRegistrationId());
/* 9297 */       logger.info("---------------------------------------------------------");
/* 9298 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9299 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9300 */       logger.info("registeredUserId.." + registeredUserId);
/* 9301 */       getDronacharyaGOIOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 9302 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 9304 */       if (AmountValidation(getDronacharyaGOIOnlineFormBean().getTotalAmount(), getDronacharyaGOIOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 9307 */         String responseString = studentRegistrationService.insertDronacharyaGOIDetails(getDronacharyaGOIOnlineFormBean(), billerId);
/* 9308 */         logger.info("Dronacharya GOI RegisterStudent :" + responseString);
/*      */         
/* 9310 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 9311 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 9312 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 9313 */             addActionMessage("Failed to add Success Ease data.");
/* 9314 */             return "faliure";
/*      */           } 
/* 9316 */           addActionMessage("Error occured contact administrator.");
/* 9317 */           return "faliure"; }
/*      */ 
/*      */         
/* 9320 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getDronacharyaGOIOnlineFormBean().getStudentRegistrationId());
/* 9321 */         this.studentRegistrationFormBean.setTotalPayableFees(getDronacharyaGOIOnlineFormBean().getTotalAmount());
/* 9322 */         this.studentRegistrationFormBean.setStudentId(getDronacharyaGOIOnlineFormBean().getApplicationNo());
/* 9323 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 9325 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 9326 */         this.appData1 = new PaymentRequestBean();
/* 9327 */         this.appData1.setStudentRegistrationId(getDronacharyaGOIOnlineFormBean().getStudentRegistrationId());
/* 9328 */         logger.info("dronacharya GOI Gurgaon RegisterStudent --feesPayList :: " + this.feesPayList);
/* 9329 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 9331 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 9335 */         addActionMessage("Amount Mismatched.");
/* 9336 */         return "faliure";
/*      */       } 
/* 9338 */     } catch (Exception e) {
/*      */       
/* 9340 */       logger.error("Exception  " + e);
/* 9341 */       return "error";
/*      */     } 
/*      */     
/* 9344 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AlmAcademyOnlineFormBean getAlmAcademyOnlineFormBean() {
/* 9354 */     return this.almAcademyOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setAlmAcademyOnlineFormBean(AlmAcademyOnlineFormBean almAcademyOnlineFormBean) {
/* 9358 */     this.almAcademyOnlineFormBean = almAcademyOnlineFormBean;
/*      */   }
/*      */   
/*      */   public String getAlmAcademyStudent() {
/* 9362 */     if (!isValidSession()) {
/* 9363 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 9366 */       logger.info("--------ALM academy  RegisterStudent------------------------------------------------");
/* 9367 */       logger.info("getAlmAcademyStudent : - " + getAppData().getStudentRegistrationId());
/* 9368 */       logger.info("---------------------------------------------------------");
/* 9369 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9370 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9371 */       logger.info("registeredUserId.." + registeredUserId);
/* 9372 */       getAlmAcademyOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 9373 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 9375 */       if (AmountValidation(getAlmAcademyOnlineFormBean().getAmountToBePaid(), getAlmAcademyOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 9378 */         String responseString = studentRegistrationService.insertAlmAcademyDetails(getAlmAcademyOnlineFormBean(), billerId);
/* 9379 */         logger.info("Dronacharya GOI RegisterStudent :" + responseString);
/*      */         
/* 9381 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 9382 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 9383 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 9384 */             addActionMessage("Failed to add Success Ease data.");
/* 9385 */             return "faliure";
/*      */           } 
/* 9387 */           addActionMessage("Error occured contact administrator.");
/* 9388 */           return "faliure"; }
/*      */ 
/*      */         
/* 9391 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getAlmAcademyOnlineFormBean().getStudentRegistrationId());
/* 9392 */         this.studentRegistrationFormBean.setTotalPayableFees(getAlmAcademyOnlineFormBean().getAmountToBePaid());
/* 9393 */         this.studentRegistrationFormBean.setStudentId(getAlmAcademyOnlineFormBean().getApplicationNo());
/* 9394 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 9396 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 9397 */         this.appData1 = new PaymentRequestBean();
/* 9398 */         this.appData1.setStudentRegistrationId(getAlmAcademyOnlineFormBean().getStudentRegistrationId());
/* 9399 */         logger.info("dronacharya GOI Gurgaon RegisterStudent --feesPayList :: " + this.feesPayList);
/* 9400 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 9402 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 9406 */         addActionMessage("Amount Mismatched.");
/* 9407 */         return "faliure";
/*      */       } 
/* 9409 */     } catch (Exception e) {
/*      */       
/* 9411 */       logger.error("Exception  " + e);
/* 9412 */       return "error";
/*      */     } 
/*      */     
/* 9415 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HisarSchoolOnlineFormBean getHisarSchoolOnlineFormBean() {
/* 9425 */     return this.hisarSchoolOnlineFormBean;
/*      */   }
/*      */   
/*      */   public void setHisarSchoolOnlineFormBean(HisarSchoolOnlineFormBean hisarSchoolOnlineFormBean) {
/* 9429 */     this.hisarSchoolOnlineFormBean = hisarSchoolOnlineFormBean;
/*      */   }
/*      */   
/*      */   public String getHisarSchoolStudent() {
/* 9433 */     if (!isValidSession()) {
/* 9434 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 9437 */       logger.info("--------IDDAV   RegisterStudent------------------------------------------------");
/* 9438 */       logger.info("getHisarSchoolStudent()  Start : - " + getAppData().getStudentRegistrationId());
/* 9439 */       logger.info("---------------------------------------------------------");
/* 9440 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9441 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9442 */       logger.info("registeredUserId.." + registeredUserId);
/* 9443 */       getHisarSchoolOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 9444 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 9446 */       if (AmountValidation(getHisarSchoolOnlineFormBean().getTotalFee(), getHisarSchoolOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 9449 */         String responseString = studentRegistrationService.insertHisarSchoolDetails(getHisarSchoolOnlineFormBean(), billerId);
/* 9450 */         logger.info("IDDAV Hisar RegisterStudent :" + getHisarSchoolOnlineFormBean().toString());
/*      */         
/* 9452 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 9453 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 9454 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 9455 */             addActionMessage("Failed to add Success Ease data.");
/* 9456 */             return "faliure";
/*      */           } 
/* 9458 */           addActionMessage("Error occured contact administrator.");
/* 9459 */           return "faliure"; }
/*      */ 
/*      */         
/* 9462 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getHisarSchoolOnlineFormBean().getStudentRegistrationId());
/* 9463 */         this.studentRegistrationFormBean.setTotalPayableFees(getHisarSchoolOnlineFormBean().getTotalFee());
/* 9464 */         this.studentRegistrationFormBean.setStudentId(getHisarSchoolOnlineFormBean().getApplicationNo());
/* 9465 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 9467 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 9468 */         this.appData1 = new PaymentRequestBean();
/* 9469 */         this.appData1.setStudentRegistrationId(getHisarSchoolOnlineFormBean().getStudentRegistrationId());
/* 9470 */         logger.info("IDDAV hisar  RegisterStudent --feesPayList :: " + this.feesPayList);
/* 9471 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 9473 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 9477 */         addActionMessage("Amount Mismatched.");
/* 9478 */         return "faliure";
/*      */       } 
/* 9480 */     } catch (Exception e) {
/*      */       
/* 9482 */       logger.error("Exception  " + e);
/* 9483 */       return "error";
/*      */     } 
/*      */     
/* 9486 */     logger.info("getHisarSchoolStudent()--  END --");
/* 9487 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDAVSchoolDetails() {
/* 9493 */     if (!isValidSession()) {
/* 9494 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 9497 */       logger.info("---------DAVSchoolRegisterStudent------------------------------------------------");
/* 9498 */       logger.info("DAVSchoolRegisterStudent : - " + getAppData().getStudentRegistrationId());
/* 9499 */       logger.info("---------------------------------------------------------");
/* 9500 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9501 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9502 */       logger.info("registeredUserId.." + registeredUserId);
/* 9503 */       getDavschoolOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 9504 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 9506 */       if (AmountValidation(getDavschoolOnlineFormBean().getTotalAmount(), getDavschoolOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 9509 */         String responseString = studentRegistrationService.insertDAVSchoolDetails(getDavschoolOnlineFormBean(), billerId);
/* 9510 */         logger.info("DAVSchoolRegisterStudent :" + responseString);
/*      */         
/* 9512 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 9513 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 9514 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 9515 */             addActionMessage("Failed to add Success Ease data.");
/* 9516 */             return "faliure";
/*      */           } 
/* 9518 */           addActionMessage("Error occured contact administrator.");
/* 9519 */           return "faliure"; }
/*      */ 
/*      */         
/* 9522 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getDavschoolOnlineFormBean().getStudentRegistrationId());
/* 9523 */         this.studentRegistrationFormBean.setTotalPayableFees(getDavschoolOnlineFormBean().getTotalAmount());
/* 9524 */         this.studentRegistrationFormBean.setStudentId(getDavschoolOnlineFormBean().getApplicationNo());
/* 9525 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 9527 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 9528 */         this.appData1 = new PaymentRequestBean();
/* 9529 */         this.appData1.setStudentRegistrationId(getDavschoolOnlineFormBean().getStudentRegistrationId());
/* 9530 */         logger.info("DAVSchoolRegisterStudent --feesPayList :: " + this.feesPayList);
/* 9531 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 9533 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 9537 */         addActionMessage("Amount Mismatched.");
/* 9538 */         return "faliure";
/*      */       } 
/* 9540 */     } catch (Exception e) {
/*      */       
/* 9542 */       logger.error("Exception  " + e);
/* 9543 */       return "error";
/*      */     } 
/*      */     
/* 9546 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String getAPSNoidaStudent() {
/* 9551 */     if (!isValidSession()) {
/* 9552 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 9555 */       logger.info("---------getAPSNoidaStudent------------------------------------------------");
/* 9556 */       logger.info("apsNoidaRegisterStudent : - " + getAppData().getStudentRegistrationId());
/* 9557 */       logger.info("---------------------------------------------------------");
/* 9558 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9559 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9560 */       logger.info("registeredUserId.." + registeredUserId);
/* 9561 */       getNoidaApsOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 9562 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 9564 */       if (AmountValidation(getNoidaApsOnlineFormBean().getTotalAmount(), getNoidaApsOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 9567 */         String responseString = studentRegistrationService.insertAPSNoidaDetails(getNoidaApsOnlineFormBean(), billerId);
/* 9568 */         logger.info("apsNoidaRegisterStudent :" + responseString);
/*      */         
/* 9570 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 9571 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 9572 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 9573 */             addActionMessage("Failed to add Success Ease data.");
/* 9574 */             return "faliure";
/*      */           } 
/* 9576 */           addActionMessage("Error occured contact administrator.");
/* 9577 */           return "faliure"; }
/*      */ 
/*      */         
/* 9580 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getNoidaApsOnlineFormBean().getStudentRegistrationId());
/* 9581 */         this.studentRegistrationFormBean.setTotalPayableFees(getNoidaApsOnlineFormBean().getTotalAmount());
/* 9582 */         this.studentRegistrationFormBean.setStudentId(getNoidaApsOnlineFormBean().getApplicationNo());
/* 9583 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 9585 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 9586 */         this.appData1 = new PaymentRequestBean();
/* 9587 */         this.appData1.setStudentRegistrationId(getNoidaApsOnlineFormBean().getStudentRegistrationId());
/* 9588 */         logger.info("apsNoidaRegisterStudent --feesPayList :: " + this.feesPayList);
/* 9589 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 9591 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 9595 */         addActionMessage("Amount Mismatched.");
/* 9596 */         return "faliure";
/*      */       } 
/* 9598 */     } catch (Exception e) {
/*      */       
/* 9600 */       logger.error("Exception  " + e);
/* 9601 */       return "error";
/*      */     } 
/*      */     
/* 9604 */     return "success";
/*      */   }
/*      */   
/*      */   public String getSriAurobindoDetails() {
/* 9608 */     if (!isValidSession()) {
/* 9609 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 9612 */       logger.info("---------SriAurobindoSchoolRegisterStudent------------------------------------------------");
/* 9613 */       logger.info("SriAurobindoSchoolRegisterStudent : - " + getAppData().getStudentRegistrationId());
/* 9614 */       logger.info("---------------------------------------------------------");
/* 9615 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9616 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9617 */       logger.info("registeredUserId.." + registeredUserId);
/* 9618 */       getSriAurobindoSchoolOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 9619 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 9621 */       if (AmountValidation(getSriAurobindoSchoolOnlineFormBean().getTotalAmount(), getSriAurobindoSchoolOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 9624 */         String responseString = studentRegistrationService.insertSriAurobindoSchoolDetails(getSriAurobindoSchoolOnlineFormBean(), billerId);
/* 9625 */         logger.info("SriAurobindoSchoolRegisterStudent :" + responseString);
/*      */         
/* 9627 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 9628 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 9629 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 9630 */             addActionMessage("Failed to add Success Ease data.");
/* 9631 */             return "faliure";
/*      */           } 
/* 9633 */           addActionMessage("Error occured contact administrator.");
/* 9634 */           return "faliure"; }
/*      */ 
/*      */         
/* 9637 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getSriAurobindoSchoolOnlineFormBean().getStudentRegistrationId());
/* 9638 */         this.studentRegistrationFormBean.setTotalPayableFees(getSriAurobindoSchoolOnlineFormBean().getTotalAmount());
/* 9639 */         this.studentRegistrationFormBean.setStudentId(getSriAurobindoSchoolOnlineFormBean().getApplicationNo());
/* 9640 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 9642 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 9643 */         this.appData1 = new PaymentRequestBean();
/* 9644 */         this.appData1.setStudentRegistrationId(getSriAurobindoSchoolOnlineFormBean().getStudentRegistrationId());
/* 9645 */         logger.info("SriAurobindoSchoolRegisterStudent --feesPayList :: " + this.feesPayList);
/* 9646 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 9648 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 9652 */         addActionMessage("Amount Mismatched.");
/* 9653 */         return "faliure";
/*      */       } 
/* 9655 */     } catch (Exception e) {
/*      */       
/* 9657 */       logger.error("Exception  " + e);
/* 9658 */       return "error";
/*      */     } 
/*      */     
/* 9661 */     return "success";
/*      */   }
/*      */   
/*      */   public String getDpsBudgamRegistrationDetails() {
/* 9665 */     if (!isValidSession()) {
/* 9666 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 9669 */       logger.info("---------DpsBudgamRegistrationStudent------------------------------------------------");
/* 9670 */       logger.info("DpsBudgamRegistrationStudent : - " + getAppData().getStudentRegistrationId());
/* 9671 */       logger.info("---------------------------------------------------------");
/* 9672 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9673 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9674 */       logger.info("registeredUserId.." + registeredUserId);
/* 9675 */       getDpsBudgamRegistrationOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 9676 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 9678 */       if (AmountValidation(getDpsBudgamRegistrationOnlineFormBean().getAmount(), getDpsBudgamRegistrationOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 9681 */         String responseString = studentRegistrationService.insertDpsBudgamregistrationDetails(getDpsBudgamRegistrationOnlineFormBean(), billerId);
/* 9682 */         logger.info("DpsBudgamRegistrationStudent :" + responseString);
/*      */         
/* 9684 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 9685 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 9686 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 9687 */             addActionMessage("Failed to add Success Ease data.");
/* 9688 */             return "faliure";
/*      */           } 
/* 9690 */           addActionMessage("Error occured contact administrator.");
/* 9691 */           return "faliure"; }
/*      */ 
/*      */         
/* 9694 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getDpsBudgamRegistrationOnlineFormBean().getStudentRegistrationId());
/* 9695 */         this.studentRegistrationFormBean.setTotalPayableFees(getDpsBudgamRegistrationOnlineFormBean().getAmount());
/* 9696 */         this.studentRegistrationFormBean.setStudentId(getDpsBudgamRegistrationOnlineFormBean().getApplicationNo());
/* 9697 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 9699 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 9700 */         this.appData1 = new PaymentRequestBean();
/* 9701 */         this.appData1.setStudentRegistrationId(getDpsBudgamRegistrationOnlineFormBean().getStudentRegistrationId());
/* 9702 */         logger.info("DpsBudgamRegistrationStudent --feesPayList :: " + this.feesPayList);
/* 9703 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 9705 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 9709 */         addActionMessage("Amount Mismatched.");
/* 9710 */         return "faliure";
/*      */       } 
/* 9712 */     } catch (Exception e) {
/*      */       
/* 9714 */       logger.error("Exception  " + e);
/* 9715 */       return "error";
/*      */     } 
/*      */     
/* 9718 */     return "success";
/*      */   }
/*      */   
/*      */   public String getInderPrastaDetails() {
/* 9722 */     if (!isValidSession()) {
/* 9723 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 9726 */       logger.info("---------InderPrastaStudent------------------------------------------------");
/* 9727 */       logger.info("InderPrastaStudent : - " + getAppData().getStudentRegistrationId());
/* 9728 */       logger.info("---------------------------------------------------------");
/* 9729 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9730 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9731 */       logger.info("registeredUserId.." + registeredUserId);
/* 9732 */       getInderPrasthaOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 9733 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 9735 */       if (AmountValidation(getInderPrasthaOnlineFormBean().getAmount(), getInderPrasthaOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 9738 */         String responseString = studentRegistrationService.insertInderPrasthaDetails(getInderPrasthaOnlineFormBean(), billerId);
/* 9739 */         logger.info("InderPrastaStudent :" + responseString);
/*      */         
/* 9741 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 9742 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 9743 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 9744 */             addActionMessage("Failed to add Success Ease data.");
/* 9745 */             return "faliure";
/*      */           } 
/* 9747 */           addActionMessage("Error occured contact administrator.");
/* 9748 */           return "faliure"; }
/*      */ 
/*      */         
/* 9751 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getInderPrasthaOnlineFormBean().getStudentRegistrationId());
/* 9752 */         this.studentRegistrationFormBean.setTotalPayableFees(getInderPrasthaOnlineFormBean().getAmount());
/* 9753 */         this.studentRegistrationFormBean.setStudentId(getInderPrasthaOnlineFormBean().getApplicationNo());
/* 9754 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 9756 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 9757 */         this.appData1 = new PaymentRequestBean();
/* 9758 */         this.appData1.setStudentRegistrationId(getInderPrasthaOnlineFormBean().getStudentRegistrationId());
/* 9759 */         logger.info("InderPrastaStudent --feesPayList :: " + this.feesPayList);
/* 9760 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 9762 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 9766 */         addActionMessage("Amount Mismatched.");
/* 9767 */         return "faliure";
/*      */       } 
/* 9769 */     } catch (Exception e) {
/*      */       
/* 9771 */       logger.error("Exception  " + e);
/* 9772 */       return "error";
/*      */     } 
/*      */     
/* 9775 */     return "success";
/*      */   }
/*      */ 
/*      */   
/*      */   public String getInderPrastaNewDetails() {
/* 9780 */     if (!isValidSession()) {
/* 9781 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 9784 */       logger.info("---------InderPrastaStudent------------------------------------------------");
/* 9785 */       logger.info("InderPrastaNewStudent : - " + getAppData().getStudentRegistrationId());
/* 9786 */       logger.info("---------------------------------------------------------");
/* 9787 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9788 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9789 */       logger.info("registeredUserId.." + registeredUserId);
/* 9790 */       getInderPrasthaNewOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 9791 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 9793 */       if (AmountValidation(getInderPrasthaNewOnlineFormBean().getAmount(), getInderPrasthaNewOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 9796 */         String responseString = studentRegistrationService.insertInderPrasthaNewDetails(getInderPrasthaNewOnlineFormBean(), billerId);
/* 9797 */         logger.info("InderPrastaStudent :" + responseString);
/*      */         
/* 9799 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 9800 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 9801 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 9802 */             addActionMessage("Failed to add Success Ease data.");
/* 9803 */             return "faliure";
/*      */           } 
/* 9805 */           addActionMessage("Error occured contact administrator.");
/* 9806 */           return "faliure"; }
/*      */ 
/*      */         
/* 9809 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getInderPrasthaNewOnlineFormBean().getStudentRegistrationId());
/* 9810 */         this.studentRegistrationFormBean.setTotalPayableFees(getInderPrasthaNewOnlineFormBean().getAmount());
/* 9811 */         this.studentRegistrationFormBean.setStudentId(getInderPrasthaNewOnlineFormBean().getApplicationNo());
/* 9812 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 9814 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 9815 */         this.appData1 = new PaymentRequestBean();
/* 9816 */         this.appData1.setStudentRegistrationId(getInderPrasthaNewOnlineFormBean().getStudentRegistrationId());
/* 9817 */         logger.info("InderPrastaNewStudent --feesPayList :: " + this.feesPayList);
/* 9818 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 9820 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 9824 */         addActionMessage("Amount Mismatched.");
/* 9825 */         return "faliure";
/*      */       } 
/* 9827 */     } catch (Exception e) {
/*      */       
/* 9829 */       logger.error("Exception  " + e);
/* 9830 */       return "error";
/*      */     } 
/*      */     
/* 9833 */     return "success";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getInderPrastaExistDetails() {
/* 9839 */     if (!isValidSession()) {
/* 9840 */       return INVALID_SESSION;
/*      */     }
/*      */     try {
/* 9843 */       logger.info("---------InderPrastaExistStudent------------------------------------------------");
/* 9844 */       logger.info("InderPrastaExistStudent : - " + getAppData().getStudentRegistrationId());
/* 9845 */       logger.info("---------------------------------------------------------");
/* 9846 */       String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9847 */       String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9848 */       logger.info("registeredUserId.." + registeredUserId);
/* 9849 */       getInderPrasthaExistOnlineFormBean().setRegisteredUserId(registeredUserId);
/* 9850 */       StudentRegistrationService studentRegistrationService = new StudentRegistrationService();
/*      */       
/* 9852 */       if (AmountValidation(getInderPrasthaExistOnlineFormBean().getAmount(), getInderPrasthaExistOnlineFormBean().getPayment()).booleanValue()) {
/*      */ 
/*      */         
/* 9855 */         String responseString = studentRegistrationService.insertInderPrasthaExistDetails(getInderPrasthaExistOnlineFormBean(), billerId);
/* 9856 */         logger.info("InderPrastaExistStudent :" + responseString);
/*      */         
/* 9858 */         if (responseString != null && !"".equalsIgnoreCase(responseString) && "success".equalsIgnoreCase(responseString))
/* 9859 */         { addActionMessage(ErrorPropertyReader.getProperty("student.data.added.successfully")); }
/* 9860 */         else { if ("NA".equalsIgnoreCase(responseString)) {
/* 9861 */             addActionMessage("Failed to add Success Ease data.");
/* 9862 */             return "faliure";
/*      */           } 
/* 9864 */           addActionMessage("Error occured contact administrator.");
/* 9865 */           return "faliure"; }
/*      */ 
/*      */         
/* 9868 */         this.studentRegistrationFormBean = getRegisteredStudentDetails(getInderPrasthaExistOnlineFormBean().getStudentRegistrationId());
/* 9869 */         this.studentRegistrationFormBean.setTotalPayableFees(getInderPrasthaExistOnlineFormBean().getAmount());
/* 9870 */         this.studentRegistrationFormBean.setStudentId(getInderPrasthaExistOnlineFormBean().getApplicationNo());
/* 9871 */         applyFees(this.studentRegistrationFormBean);
/*      */         
/* 9873 */         QuickPayAction quickPayAction = new QuickPayAction();
/* 9874 */         this.appData1 = new PaymentRequestBean();
/* 9875 */         this.appData1.setStudentRegistrationId(getInderPrasthaExistOnlineFormBean().getStudentRegistrationId());
/* 9876 */         logger.info("InderPrastaStudent --feesPayList :: " + this.feesPayList);
/* 9877 */         quickPayAction.setAppDataFromStudentBean(this.appData1, this.studentRegistrationFormBean, this.feesPayList);
/*      */         
/* 9879 */         getUserSessionMap().put("APPDATA", getAppData1());
/*      */       }
/*      */       else {
/*      */         
/* 9883 */         addActionMessage("Amount Mismatched.");
/* 9884 */         return "faliure";
/*      */       } 
/* 9886 */     } catch (Exception e) {
/*      */       
/* 9888 */       logger.error("Exception  " + e);
/* 9889 */       return "error";
/*      */     } 
/*      */     
/* 9892 */     return "success";
/*      */   }
/*      */   
/*      */   public String inderPrasthaFirstForm() {
/* 9896 */     logger.info("-------------------------inderPrasthaFirstForm()--------------------------------");
/* 9897 */     logger.info("StudentRegistrationId : - " + getAppData().getStudentRegistrationId());
/* 9898 */     logger.info("---------------------------------------------------------");
/* 9899 */     String billerId = ((FJBean)getUserSessionMap().get("BASEDATA")).getBillerId();
/* 9900 */     String registeredUserId = ((FJBean)getUserSessionMap().get("BASEDATA")).getRegisteredUserId();
/* 9901 */     String instCode = (String)getUserSessionMap().get("_institutecode");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 9909 */     return "success";
/*      */   }
/*      */ }


/* Location:              C:\SmartFees.war\SmartFees.war\WEB-INF\classes\!\com\app\feejunction\action\StudentRegistrationAction.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */