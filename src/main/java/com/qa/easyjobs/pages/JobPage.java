package com.qa.easyjobs.pages;

import java.nio.file.Path;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.IsVisibleOptions;
import com.qa.easyjobs.constants.AppConstants;

public class JobPage {


private Page page;

	//locator OR-

	private String jobs = "//div[normalize-space()='Jobs']";
	private String createJob = "//a[@class='button primary-button text-capitalize ml-auto']";
	private String jobTitleField = "//input[@id='job-title']";
	private String jobDescriptionField = "//p[@data-placeholder='Write job details here.']";
	private String jobResponsibilityButton= "//a[normalize-space()='Responsibilities']";
	private String writeResponsibility= "//p[@data-placeholder='Write responsibilities here.']";
	private String categoryDropdown= "//div[@class='col-12 d-none d-md-block']//div[@class='multiselect__select']";
	private String selectCategory= "//span[contains(text(),'3D Animator')]";
	private String countryDropdown= "//body/div/div/div/main/div/section/div/form/div/div/div/div[3]/div[1]";
	private String selectCountry= "(//span[contains(text(),'Bangladesh')])[2]";
	private String stateDropdown= "//body/div/div/div/main/div/section/div/form/div/div/div/div[3]/div[1]";
	private String selectState= "(//span[@class='multiselect__option multiselect__option--highlight'])[4]";
	private String cityDropdown= "//body/div/div/div/main/div/section/div/form/div/div/div/div[3]/div[1]";
	private String selectCity= "(//span[@class='multiselect__option multiselect__option--highlight'])[4]";
	private String skillDropdown= "(//div[@class='multiselect__select'])[7]";
	private String selectSkill= "//span[contains(text(),'1 year or more of relevant work experience')]";
	private String expiryDateField= "//input[@id='expire_date']";
	//private String selectExpiryDate= "//input[@id='expire_date']";
	private String jobTypeDropdown= "(//div[@class='multiselect'])[1]";
	private String selectJobType= "//span[contains(text(),'On-site')]";
	private String employeeTypeDropdown= "(//div[@class='multiselect__select'])[8]";
	private String selectEmployeeDropdown ="//span[contains(text(),'Permanent')]" ;
	private String salaryTypeDropdown= "(//div[@class='multiselect__select'])[10]";
	private String selectSalaryType= "//span[contains(text(),'Monthly')]";
	private String saveButton= "//button[normalize-space()='Save and Continue']";
	private String selectTemplate= "//a[normalize-space()='Select a template']";
	private String jobSelectFromTemplate= "//a[normalize-space()='HR Manager']";
	private String customJobApplyFieldSaveButton ="//button[normalize-space()='Save & Publish']";
	private String selectSQDropdown ="//div[@class='multiselect__select']";
	private String selectSQ ="//span[@class='multiselect__option multiselect__option--highlight']";
	private String screeningQuestionSaveButton = "//button[normalize-space()='Save & Continue']";
	private String selectQuizDropdown ="//div[@class='multiselect__select']";
	private String selectQuiz ="//span[@class='multiselect__option multiselect__option--highlight']";		
	private String setQuizMarks ="//input[@id='marks_per_question']";
	private String setQuizDuration ="//input[@id='exam_duration']";
	private String quizSaveButton ="//button[normalize-space()='Save and Publish']";
	private String jobPublishConfirmButton ="//span[contains(text(),'Yes')]";
	private String jobPublishModalClose = "//span[@aria-hidden='true']";
	private String viewCompanyPage = "//span[normalize-space()='View company page']";
	private String jobDetails = "//a[contains(text(),'Accountant / Account executive')]";
	private String jobApply ="//a[normalize-space()='Apply Now']";
	private String uploadBannerImage = "//span[normalize-space()='Update Banner Image']";
	private String jobPublishButton ="//button[normalize-space()='Publish']";
	private String toggleButton1 ="(//span[@class='off'][normalize-space()='off'])[14]";
    private String toggleButton2 ="(//span[@class='off'][normalize-space()='off'])[15]";
	private String toggleButton3 ="(//span[@class='off'][normalize-space()='off'])[16]";
	//private String jobPublishModalText = "//p[@class='text-center mt-5']";


	// 2. page constructor:
			public JobPage(Page page) {
				this.page = page;
			}


	//Actions

			public String getJobPageTitle() {
				String title =  page.title();
				System.out.println("page title: " + title);
				return title;
			}

			
			 public void clickJobs(String jobs) {
			        page.click(jobs);
			   }
			
			
			
			
			 // Method to get the current page URL
			
		    public String getJobPageURL() {
		        return page.url();
		    }


			// Method to navigate to the job creation page
			
		    public void clickCreateJobButton() {
		     
				page.click(createJob);
		    }

		    // Method to fill in the job details
		    
		    public void fillJobDetails(String jobTitle, String jobDescription, String jobResponsibility) {
		        // Click on the job title field first and then fill it
		    	
		        page.click(jobTitleField);
		        page.fill(jobTitleField, jobTitle);
		        page.waitForTimeout(3000);

		        // Click on the job description field first and then fill it
		        page.click(jobDescriptionField);
		        page.fill(jobDescriptionField, jobDescription);
		        page.waitForTimeout(3000);

		        // Click on the job responsibility tab first
		        page.click(jobResponsibilityButton);

		        // Then fill in the job responsibility field
		        page.fill(writeResponsibility, jobResponsibility);
		        page.waitForTimeout(3000);
		    }

		    // Method to select job type
		    public void selectJobType() {
		        page.click(jobTypeDropdown);
		        page.click(selectJobType);
		    }

		    // Method to set expiry date
		    public void setExpiryDate(String expiryDate) {
		        page.fill(expiryDateField, expiryDate);
		    }

		    // Method to select job category
		    public void selectJobCategory() {
		        page.click(categoryDropdown);
		        page.click(selectCategory);
		    }

		    // Method to select skills
		    public void selectSkills() {
		        page.click(skillDropdown);
		        page.click(selectSkill);
		    }

		    // Method to select employment type
		    public void selectEmploymentType() {
		        page.click(employeeTypeDropdown);
		        page.click(selectEmployeeDropdown);
		    }

		    // Method to select salary type
		    public void selectSalaryType() {
		        page.click(salaryTypeDropdown);
		        page.click(selectSalaryType);
		    }

		    // Method to upload banner image
		    public void uploadBannerImage(Path imagePath) {
		        page.setInputFiles(uploadBannerImage, imagePath);
		    }

		    // Method to click save and continue
		    public void clickSaveButton() {
		        page.click(saveButton);
		    }

		    // Method to add questions
		    public void addScreeningQuestions() {
		        page.click(selectSQDropdown);
		        page.click(selectSQ);
		    }
		    
		    
		    // Method to sqsave the job
		    public void screeningQuestionSaveButton() {
		        page.click(screeningQuestionSaveButton);
		    }
		    
		    
		    
		    // Method to add questions
		    public void addQuizQuestions() {
		        page.click(selectQuizDropdown);
		        page.click(selectQuiz);
		    }

		    public void setQuizDuration(String quizDuration) { 
		        page.click(setQuizDuration);
		        page.fill(setQuizDuration, quizDuration);
		    }
		    
		    
		    public void setQuizMarks(String quizMarks) { 
		        page.click(setQuizMarks);
		        page.fill(setQuizMarks, quizMarks);
		    }
		    
		    
		    
		    // Method to quizsave the job
		    public void quizSaveButton() {
		        page.click(quizSaveButton);
		    }


		    // Method to publish the job
		    public void clickCustomFieldsaveButton() {
		    	page.click(toggleButton1);
		    	page.click(toggleButton2);
		    	page.click(toggleButton3);
		        page.click(customJobApplyFieldSaveButton);
		    }

		
		    // Method to publish the job
		    public void jobPublishConfirmButton() {
		        page.click(jobPublishConfirmButton);
		    }

		    
		  
			public String getScreeningQuestionPageTitle() {
				String title =  page.title();
				System.out.println("page title: " + title);
				return title;
			}
			
			
			public String getQuizQuestionPageTitle() {
				String title =  page.title();
				System.out.println("page title: " + title);
				return title;
			}
		
			
			 // Method to get the current page URL
			
		    public String getScreeningQuestionPageURL() {
		        return page.url();
		    }


		    // Method to validate the success message on the job publish modal
		    public boolean isJobPublishedSuccessfully() {
		        return page.isVisible("text=" + AppConstants.text); // Checks if the confirmation text is visible on the modal
		    }
















}
