import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;

public class RestAPI {
	public static void main(String... ar) {
		try {
			System.out.println(httpGet("http://jira-test.highwire.org/rest/api/2/issue/PROJ00040-6"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String httpGet(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.addRequestProperty("Authorization", "Basic aGlnaHdpcmVAY2VsaWdvLmNvbTpDZWxpZ29IVzAx");
		Map<String, List<String>> hm = conn.getHeaderFields();
		System.out.println(hm);
		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		// Buffer the result into a string
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();

		conn.disconnect();
		return sb.toString();
	}
}
