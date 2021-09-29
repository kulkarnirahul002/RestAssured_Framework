package PojoClass;

public class ProjectLibrary {
	
	String createdBy;
	String status;
	String projectName;
	int teamSize;
	public ProjectLibrary(String createdBy, String status, String projectName, int teamSize) {
		
		this.createdBy = createdBy;
		this.status = status;
		this.projectName = projectName;
		this.teamSize = teamSize;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

}
