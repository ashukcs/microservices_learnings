package com.eagleeye.licenses.service;

import java.util.List;

import com.eagleeye.licenses.model.License;

public interface LicenseService {
	public License getLicense(String organizationId, String licenseId);

	public List<License> getLicensesByOrg(String organizationId);

	public void saveLicense(License license);

	public void updateLicense(License license);

	public void deleteLicense(License license);
}
