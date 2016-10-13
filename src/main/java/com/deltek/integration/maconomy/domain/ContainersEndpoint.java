package com.deltek.integration.maconomy.domain;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "shortname" })
public class ContainersEndpoint {

	@JsonProperty("shortname")
	private String shortname;
	
    /*
{
  "shortname": "w17",
  "versions": {
    "tpu": {
      "major": "17",
      "minor": "0",
      "sp": "105",
      "fix": "0",
      "beta": "99999999"
    },
    "apu": {
      "major": "17",
      "minor": "0",
      "patch": "0",
      "hotfix": ""
    }
  },
  "languages": [
    {
      "title": "Dansk (Danmark)",
      "locale": "da_DK",
      "tag": "da-DK"
    },
    {
      "title": "Dansk (Danmark,MAS)",
      "locale": "da_DK_MAS",
      "tag": "da-DK-x-lvariant-MAS"
    },
    {
      "title": "Dansk (Danmark,MCS)",
      "locale": "da_DK_MCS",
      "tag": "da-DK-x-lvariant-MCS"
    },
    {
      "title": "Deutsch (Deutschland)",
      "locale": "de_DE",
      "tag": "de-DE"
    },
    {
      "title": "Deutsch (Deutschland,MAS)",
      "locale": "de_DE_MAS",
      "tag": "de-DE-x-lvariant-MAS"
    },
    {
      "title": "Deutsch (Deutschland,MCS)",
      "locale": "de_DE_MCS",
      "tag": "de-DE-x-lvariant-MCS"
    },
    {
      "title": "English (United Kingdom)",
      "locale": "en_GB",
      "tag": "en-GB"
    },
    {
      "title": "English (United Kingdom,MAS)",
      "locale": "en_GB_MAS",
      "tag": "en-GB-x-lvariant-MAS"
    },
    {
      "title": "English (United Kingdom,MCS)",
      "locale": "en_GB_MCS",
      "tag": "en-GB-x-lvariant-MCS"
    },
    {
      "title": "English (United States)",
      "locale": "en_US",
      "tag": "en-US"
    },
    {
      "title": "English (United States,CPA)",
      "locale": "en_US_CPA",
      "tag": "en-US-x-lvariant-CPA"
    },
    {
      "title": "English (United States,MAS)",
      "locale": "en_US_MAS",
      "tag": "en-US-x-lvariant-MAS"
    },
    {
      "title": "English (United States,MCS)",
      "locale": "en_US_MCS",
      "tag": "en-US-x-lvariant-MCS"
    },
    {
      "title": "Español (España)",
      "locale": "es_ES",
      "tag": "es-ES"
    },
    {
      "title": "Français (France)",
      "locale": "fr_FR",
      "tag": "fr-FR"
    },
    {
      "title": "Italiano (Italia)",
      "locale": "it_IT",
      "tag": "it-IT"
    },
    {
      "title": "Nederlands (Nederland)",
      "locale": "nl_NL",
      "tag": "nl-NL"
    },
    {
      "title": "Nederlands (Nederland,MCS)",
      "locale": "nl_NL_MCS",
      "tag": "nl-NL-x-lvariant-MCS"
    },
    {
      "title": "Norsk (Norge)",
      "locale": "no_NO",
      "tag": "no-NO"
    },
    {
      "title": "Norsk (Norge,MCS)",
      "locale": "no_NO_MCS",
      "tag": "no-NO-x-lvariant-MCS"
    },
    {
      "title": "Português (Portugal)",
      "locale": "pt_PT",
      "tag": "pt-PT"
    },
    {
      "title": "Svenska (Sverige)",
      "locale": "sv_SE",
      "tag": "sv-SE"
    },
    {
      "title": "Svenska (Sverige,MCS)",
      "locale": "sv_SE_MCS",
      "tag": "sv-SE-x-lvariant-MCS"
    }
  ],
  "authenticated": true,
  "authentication": {
    "useDomainCredentialsForBasicAuthentication": false,
    "schemes": {
      "basic": {
        "name": "basic"
      },
      "x-changepassword": {
        "name": "x-changepassword"
      },
      "x-reconnect": {
        "name": "x-reconnect"
      },
      "x-resetpassword": {
        "name": "x-resetpassword"
      }
    }
  }
}
     
     */

}
