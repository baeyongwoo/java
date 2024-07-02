package examples;

import java.util.*;

class CreateUser {
	public String id;

	String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}
}

class Lotto {
	private Random random = new Random();

	List<List<Integer>> MultiLottoGet(int count) {
		List<List<Integer>> lottos = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			List<Integer> lotto = lottoGet();
			lotto.sort(Comparator.naturalOrder());
			lottos.add(lotto);
		}
		
		return lottos;
	}

	final List<Integer> lottoWinning() {
		return lottoGet();
	}

	List<Integer> lottoGet() {
		Set<Integer> lottoSet = new HashSet<>();

		while (lottoSet.size() < 6) {
			int lottoNum = random.nextInt(45) + 1;
			lottoSet.add(lottoNum);
		}

		return new ArrayList<>(lottoSet);
	}

	int checkWinning(List<List<Integer>> buyLottos, List<Integer> lottoWinning) {
		System.out.println("lotto 받은 값 : " + buyLottos + "\n당첨값 : " + lottoWinning);
		int receiveMonney = 0;
		for(int i =0; i < buyLottos.size(); i++) {
			List<Integer> lotto = buyLottos.get(i);
			int matchCount = countMatchNumbers(lotto, lottoWinning);

			System.out.println("로또" +(i+1) +"번째 번호 : " + lotto);
			System.out.println("일치하는 번호 갯수 : " + matchCount);
			switch (matchCount) {
			case 0: {
				receiveMonney-=5000;
				System.out.println("돈을 날렸어요~~");
				break;
				}
			case 1 : {
				receiveMonney-=5000;
				System.out.println("아쉽네요 1개만 더 맞추면 5천원인데");
				break;
				}
			case 2: {
				System.out.println("5000원 득템!!!");
				receiveMonney+=5000;
				break;
				}
			case 3:{
				System.out.println("2만원 치킨값 득템!!");
				receiveMonney+=20000;
				break;
				}
			case 4 : {
				receiveMonney+=100000;
				System.out.println("10만원 득템!!");
				break;
				}
			case 5: {
				receiveMonney+=1000000;
				System.out.println("100만원 축하합니다!!!");
				break;
				}
			case 6: {
				receiveMonney+=100000000;
				System.out.println("1억 당첨!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				break;
				}
			}
			

		}//for문 종료
		System.out.println("================lotto 총 결과 ====================");
		String format = String.format("\\%,d원", receiveMonney);
		System.out.println(format);
		return receiveMonney;
	}

	int countMatchNumbers(List<Integer> lotto, List<Integer> winningNumbers) {
		int count = 0;
		for(int i : lotto) {
			if(winningNumbers.contains(i)) {
				count++;
			}
		}
		return count;
	}


}

class HaveMoney {
	Random random = new Random();
	int haveMoney;

	void SetHaveMoney() {
		int haveMoney = random.nextInt(100) * 1000;
		this.haveMoney = haveMoney;
	}

	int setHaveMoney(int haveMoney) {
		return this.haveMoney = haveMoney;
	}

	int HaveMoneyShow() {
		return this.haveMoney;
	}
}

class BuyLotto extends HaveMoney {
	final static int lottoPrice = 5000;

	List<List<Integer>> buyLottoPlus(int count, int haveMoney) {
		if (haveMoney < 0) {
			System.out.println("현재 소지금액이 [" + haveMoney + "]이므로 구매가 불가능합니다.");
			return null;
		} else if (0 <= haveMoney - lottoPrice * count) {
			Lotto lotto = new Lotto();
//			System.out.println(lotto.MultiLottoGet(count));


			haveMoney = haveMoney - lottoPrice * count;
			setHaveMoney(haveMoney);
			System.out.println("구매하신 로또는 " + count + "장이며, 현재금액은 " + haveMoney + "원입니다.");
			return lotto.MultiLottoGet(count);
		} else {
			System.out.println("원하시는 갯수만큼 구매하기에는 소지금액이 부족합니다!!! 현재 소지금액: " + haveMoney);
			return null;
		}
	}
}

public class MyStudy {
	public static void main(String[] args) {
		
		Lotto lotto = new Lotto();
		List<Integer> winning = lotto.lottoWinning();
		winning.sort(Comparator.naturalOrder());
		
		Scanner scan = new Scanner(System.in);
		System.out.println("당첨번호!!!!\n" + winning);

		CreateUser user = new CreateUser();
		System.out.print("ID를 입력하세요: ");
		String id = scan.next();
		user.setId(id);

		HaveMoney tester1 = new HaveMoney();
		System.out.println(user.getId() + "님 환영합니다!!");
		tester1.SetHaveMoney();
		int money = tester1.HaveMoneyShow();
		System.out.println("현재 소지하신 금액은 " + money);

		System.out.print("Welcome to my Lotto\n몇 개를 구매하시겠습니까? >>");
		int count = scan.nextInt();
		BuyLotto buy = new BuyLotto();
		List<List<Integer>> lottos=  buy.buyLottoPlus(count, money);

		System.out.print("당첨 한 번에 보기 (Y/y를 눌러주세요): ");
		String check = scan.next();

		if (check.equalsIgnoreCase("y")) {
			System.out.println("==============응모하신 결과는==============");
			
			int recev = lotto.checkWinning(lottos, winning);
			System.out.println("로또 사기전 : " + money);
			System.out.println("로또 산 금액 " + count*5000);
			System.out.println("로또 구입 결과 : " + recev);
			System.out.println("로또 사고 난 후 : " + (money - count*5000 + recev));
			if(count*5000>recev) {
				System.out.println("로또하지마세요");
			}else {
				System.out.println("집가는 길에 한번 해봐도 될지도?");
			}
		}
	}
}