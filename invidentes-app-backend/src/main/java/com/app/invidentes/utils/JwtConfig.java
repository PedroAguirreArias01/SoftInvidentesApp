package com.app.invidentes.utils;

public class JwtConfig {
	
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEowIBAAKCAQEAnJVSJiuCgGLqmaeGDkprxd17WAGPtZ1S6IeLNV+6Tss5OhVD\r\n" + 
			"yKnrhcVPVt4bu8zNDmKEfUaf8065n3rLnI83WuR8CE0rFwDkgK9KLeXpprBhq66R\r\n" + 
			"9+Nl3pBbudS5upSWS46Ica3fvfh+udVA6q9NuCU8QiJc9BvGzybAfvRGj/Ii5vbq\r\n" + 
			"PAyyTgtqHdRdwx6nMeUm5aEM5iFh/4aKzUQXwLqFRvULKiyItpcGkp4Gc/22us4g\r\n" + 
			"tsjdJ8BeAzECTrXpFNTa5uPZ06tM85UTBHcPnZsMbZzD26A1nukTmpYlrGHlqsCX\r\n" + 
			"KoQ2Rmx9uBg+lFyl5Wo0NmxJA+ifcno/KmMSEwIDAQABAoIBACNgAL0q20LSFho8\r\n" + 
			"pKaZ3ZtIHFOXlrX7Iv3xkVuvktG2S+l5YGT3LoR8PR5s82sMK89yJmh/CifXw0vq\r\n" + 
			"XBG0sVbRg8wEUxXRV85Sy7lu1ciY1JgKymNsdlk/19k12/fxFbtgKic0lvW+LDMj\r\n" + 
			"oJTkofRWRTTTuphTpiiqopaL7V0bhpflxYawqzvGmMtsDVJbDJ4GP3eyth7Wdo1p\r\n" + 
			"k6d3NPdIulH8EY3kzGKh+JbGRNz6A/mELH638+NmpFFits0wf6NHML8KpwIXll0J\r\n" + 
			"dkDWbj92iMmk1KkVTeI3vQLIdvOUeURzCUgKNAIItgLcvmejnD2Kg7bfgTrNcoof\r\n" + 
			"lXbbfaECgYEAzAlYVChgrR51EGwDEaelr/Ngac7dZYQ9GVo6LMxt03u+8KLibxyt\r\n" + 
			"coPy8WWvvnnOXl5DmLcFAzDNNE+M9B5+FOsMeTkAbzJUB/EVmVQy0tuYQsxSSDzQ\r\n" + 
			"aDOnJxBusEhxSTCvMDPOSCSgKHdKauNhEfoFVRiLjdI39pXTFeN74csCgYEAxHYl\r\n" + 
			"6PVgQWrlW2xdeV3Bz2xkWG0BUGuHlXOI3WFNSRotYizvlmHVFXJmwA9QonP/Qv+w\r\n" + 
			"kdbQW+37/F25j7G8BBiDQStkQ0ybsle9+YcalWPD6nGlQGt+qOAlej3pvKAnlGdR\r\n" + 
			"7yhySi5xNmFL9HeUJj6dzdZGZXaqp2q+D4qYZ9kCgYA+ID5P6bd+Hv8AEBNjJcvS\r\n" + 
			"ZmWd8goBpiFAffOmvlxWf6Bk/wO5V18Mtlab4B2B/u6yVzt33YpeLVbeLba6gipb\r\n" + 
			"zjIPGychtI5XmLW96SBMieazuCj5q+K9R7UGtP8vF+++nF9LawrNdrF5gNEc+L0O\r\n" + 
			"zzUecwnTFgZKQ9ZxHMIUvwKBgBAGmz0PlxR/BcqZYl6eGUs0SlM0QSEwRFUaoZV9\r\n" + 
			"dHJ8IiuaAsk/ncQsGtmb5jX6RF5QwTSEU2bMWPvTIWnpU6752OseAQXEYAcCRUrv\r\n" + 
			"jGmXQ8oCDzrcCe74qdX46vIqFlByxSo/IGOQukd3VFzSzFD6VqEN05w/O9iASpS1\r\n" + 
			"94yxAoGBAMYZRb6tV2+D40L2q/+R2vgRWjxXPqDKCfQsdQIChqiqss5dQggSf27s\r\n" + 
			"Bl8Bl+ELZGJwzvPdTUapQNAzDpLkzSPcdgFUKbPghHcKjZ9XkCTt68bIdtY3drDY\r\n" + 
			"hk3SKj/bRy70EdyySo8UipHn07QxlIIdMCjxBApBk0d+UCbPQhru\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnJVSJiuCgGLqmaeGDkpr\r\n" + 
			"xd17WAGPtZ1S6IeLNV+6Tss5OhVDyKnrhcVPVt4bu8zNDmKEfUaf8065n3rLnI83\r\n" + 
			"WuR8CE0rFwDkgK9KLeXpprBhq66R9+Nl3pBbudS5upSWS46Ica3fvfh+udVA6q9N\r\n" + 
			"uCU8QiJc9BvGzybAfvRGj/Ii5vbqPAyyTgtqHdRdwx6nMeUm5aEM5iFh/4aKzUQX\r\n" + 
			"wLqFRvULKiyItpcGkp4Gc/22us4gtsjdJ8BeAzECTrXpFNTa5uPZ06tM85UTBHcP\r\n" + 
			"nZsMbZzD26A1nukTmpYlrGHlqsCXKoQ2Rmx9uBg+lFyl5Wo0NmxJA+ifcno/KmMS\r\n" + 
			"EwIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";

}
