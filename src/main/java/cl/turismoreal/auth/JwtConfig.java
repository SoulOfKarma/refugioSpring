package cl.turismoreal.auth;

public class JwtConfig {
		
		public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\n" + 
				"MIIEogIBAAKCAQEAsgY/XhboWhSUIjPckNpFX2HtsGgXnrqSSitiZEB30NZggZnm\n" + 
				"blRLDOXohZZfWg0dacayDgjtMLCEWquBVSePqGDjcsHY3D4iQuDs/5sDTDcRSDJe\n" + 
				"UetRdDa/pQ/PvM/K9IouIGxW1/0eiVoJSJZ3QTrXDG13gz/g3tGrR3IXVfi+3ddk\n" + 
				"QoNzMV8GKMXKOfc55JVobPHH5W9U0JJaBdTJF1TD4hnllePDFisx0bdKvXWaFYbD\n" + 
				"LrTaLKMMt/yHeJeHm3LjNjQKOP9eO1gDT8W++ZQoRPFOMlHIBlVo7qt6Sn9N5pN0\n" + 
				"oZZ6mTBqK04OwvkF7mA4DINHxf329NLQAvV4mQIDAQABAoIBADq8kvXBSyJFfeaX\n" + 
				"A+QLEC57SggVIA3v8spj7A+1sZKG2MqJ85xdVXHI/WHuDkHQ5+55b0/wJAoXg2PD\n" + 
				"CGYHKn/cj87SJHHuUjGMssVW6MyhsqMGc1ZF9NcKJUsZn2nliUoLuVJbTH/w9L1O\n" + 
				"ppd7hZdRCZkBGRiF3/TEauWkwAxN/A7ZtJ8Ma+G+/Vmg95LOEsW2u0QEBph/bb0K\n" + 
				"qqGRjy3nll7bsV4f5JePv2ylTUgmAIJTvJFqOubQH1ykynGxXQCBmqbf5NtsIGxF\n" + 
				"S2Jl5AS5ustSX08em3nnUNCYzYv3Y9mUC5+/ZsI+/XocEJkhKIvXYZDHjIEz8agF\n" + 
				"S38VfLECgYEA2TFkXeNrq7SQG1Ov5gZifld4LXTkBResl8ezdDlFt+EBIBK5Isga\n" + 
				"h3rgY9gOVePa86U58R9I5Vl7Wdpk25nFvosoSbXUF54SEYYVH6jm3JXYoqIVhFU+\n" + 
				"0tlPAEDw+LO1Ulu0P3M6+Bqr8x6NJze5DFIJUqRhQDWGrXxVtLo1gz0CgYEA0dVA\n" + 
				"Ch2V+X6Y9vjcJiYWo0iGAgZyYyX2eR6CDuPqWc4Stc/yDKvK4cDRjx2zrwRODeXf\n" + 
				"alKuzw6fkajGmeF/Vyvw0hxu6mifR+WIghOQQUYaE28nk27H162jINnYmZDz93tj\n" + 
				"LWq/yDtGBCwlEWS0Rpnv2rbKoP32OqLx3vVv8I0CgYBUuvcbxZ/4kW1yq7hAdZcx\n" + 
				"ELCakzJtZin34Hl6yukO7iGBQKynDAeFeQNXEC+vhD+js36iOYE3sCv2BsQ4A4po\n" + 
				"ZmNmNiAywoDsAzH0cvD1dyPXdoIMaTEkEpDGWY9ohrsjERGFe0+zALy6EN4iQZPY\n" + 
				"YZyvd99UrE0JGytYYRiFRQKBgGQRRMcOMPWY0C4HpEV1KJqZ/X59wJNUCWTdjby4\n" + 
				"KIzHX9jg4Ff2nXxnzghoa8ZtUSQDmjZEVCVene6DBKNiDK5vwBsTgDm9xygsaJtP\n" + 
				"5R2b5teZzM/cpuVOY1tJSKiDnjVJ3JROMkO1MMDQpKTU17xLsT0mqx93vbNc/egM\n" + 
				"OGQJAoGAW0QDtdzgiLTWcfifoBc1O2PP+U5j4a/nva1Bb2SofTWhyRR2VszQzeCJ\n" + 
				"Otpiq+fPE22JCtICWlHQZvaaw3Ses6uFM+OnMFW/rH+n3wak6cfxGaq2gw6/KubB\n" + 
				"c+ZI6G5PwTtMdgBKqb5r1YDZGT/c+ATxCKXYShhg/aeQlopBtFU=\n" + 
				"-----END RSA PRIVATE KEY-----";
		
		public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\n" + 
				"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsgY/XhboWhSUIjPckNpF\n" + 
				"X2HtsGgXnrqSSitiZEB30NZggZnmblRLDOXohZZfWg0dacayDgjtMLCEWquBVSeP\n" + 
				"qGDjcsHY3D4iQuDs/5sDTDcRSDJeUetRdDa/pQ/PvM/K9IouIGxW1/0eiVoJSJZ3\n" + 
				"QTrXDG13gz/g3tGrR3IXVfi+3ddkQoNzMV8GKMXKOfc55JVobPHH5W9U0JJaBdTJ\n" + 
				"F1TD4hnllePDFisx0bdKvXWaFYbDLrTaLKMMt/yHeJeHm3LjNjQKOP9eO1gDT8W+\n" + 
				"+ZQoRPFOMlHIBlVo7qt6Sn9N5pN0oZZ6mTBqK04OwvkF7mA4DINHxf329NLQAvV4\n" + 
				"mQIDAQAB\n" + 
				"-----END PUBLIC KEY-----";
}
