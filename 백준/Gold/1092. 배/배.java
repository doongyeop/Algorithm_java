import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 크레인 수 (N<=50)
		ArrayList<Integer> restricts = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			restricts.add(Integer.parseInt(st.nextToken())); // 크레인 무게 제한
		}

		int M = Integer.parseInt(br.readLine()); // 박스 수 (M<=10,000)
		ArrayList<Integer> boxes = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			boxes.add(Integer.parseInt(st.nextToken())); // 박스 무게
		}

		Collections.sort(restricts, Collections.reverseOrder());
		Collections.sort(boxes, Collections.reverseOrder());

		if (restricts.get(0) < boxes.get(0)) {
			bw.write("-1\n");
			bw.flush();
			br.close();
			bw.close();
			return;
		}

		int time = 0;

		while (!boxes.isEmpty()) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < boxes.size(); j++) {
					if (restricts.get(i) >= boxes.get(j)) {
						boxes.remove(j);
						break;
					}
				}
			}

			time++;
		}

		bw.write(time + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
