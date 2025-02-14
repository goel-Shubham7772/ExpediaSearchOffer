package com.expedia.model.response;

import lombok.Data;

@Data
public class PackageUrls {
    private String packageSearchUrl;
    private String decodedPackageSearchUrl;
    private String similarSearchLink;
}
