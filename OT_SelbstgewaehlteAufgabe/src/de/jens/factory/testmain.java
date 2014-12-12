package de.jens.factory;

public class testmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person plantOwner=new Person("Mr. PlantOwner");
		Plant sifi= new Plant("Sindelfingen", plantOwner);
		
		Person meisterIB=new Person("Mr. MeisterImIB");
		Area ib=new Area("Inneneinbau",meisterIB);
		Person meisterCVM=new Person("Mr. MeisterInCVM");
		Area cvm=new Area("Cockpitvormontage", meisterCVM);
		Person meisterFinish=new Person("Mr. MeisterImFinish");
		Area finish = new Area("Finish",meisterFinish);
		
		
		Person meisterAsOneOfCVM=new Person("Mr. MeisterLinie1CVM");
		AsemblyLine AsOneOfCvm = new AsemblyLine("Linie 1 CVM",meisterAsOneOfCVM);
		Person meisterAsOneOfIB=new Person("Mr. MeisterLinie1IB");
		AsemblyLine AsOneOfib = new AsemblyLine("Linie 1 IB",meisterAsOneOfIB);
		Person meisterAsTwoOfIB=new Person("Mr. MeisterLinie2IB");
		AsemblyLine AsTwoOfib = new AsemblyLine("Linie 2 IB", meisterAsTwoOfIB);
		
		Person meisterStatOneOfCvm=new Person("Mr. MeisterStation1CVM");
		Station statOneOfCvm = new Station("Station 1 von CVM",meisterStatOneOfCvm);
		Person meisterStatTwoOfCvm=new Person("Mr. MeisterStation2CVM");
		Station statTwoOfCvm = new Station("Station 2 von CVM",meisterStatTwoOfCvm);
		Person meisterStatThreeOfCvm=new Person("Mr. MeisterStation3CVM");
		Station statThreeOfCvm = new Station("Station 3 von CVM",meisterStatThreeOfCvm);
		
		Person meisterStatOneOfIb=new Person("Mr. MeisterStation1IB");
		Station statOneOfib = new Station("Sation 1 von IB",meisterStatOneOfIb);
		Person meisterStatTwoOfIb=new Person("Mr. MeisterStation1IB");
		Station statTwoOfib = new Station("Sation 2 von IB",meisterStatTwoOfIb);
		Person meisterStatThreeOfIb=new Person("Mr. MeisterStation1IB");
		Station statThreeOfib = new Station("Sation 3 von IB",meisterStatThreeOfIb);
		Person meisterStatFourOfIb=new Person("Mr. MeisterStation1IB");
		Station statFourOfib = new Station("Sation 4 von IB",meisterStatFourOfIb);
		
		Person meisterStatFinish=new Person("Mr. MeisterStationFinish");
		Station finishStation = new Station("FinishStation",meisterStatFinish);
		
		Person person1=new Person("Mr. Worker1");
		ManuelProducer worker1=new ManuelProducer(100,"workerstation1",person1);
		Person person2=new Person("Mr. Worker2");
		ManuelProducer worker2=new ManuelProducer(200,"workerstation2",person2);
		Person person3=new Person("Mr. Worker3");
		ManuelProducer worker3=new ManuelProducer(100,"workerstation3",person3);
		Person person4=new Person("Mr. Worker4");
		ManuelProducer worker4=new ManuelProducer(100,"workerstation4",person4);
		
		Person person5=new Person("Mr. Worker5");
		ManuelProducer worker5=new ManuelProducer(100,"workerstation5",person5);
		Person person6=new Person("Mr. Worker6");
		ManuelProducer worker6=new ManuelProducer(100,"workerstation6",person6);
		
		Person personMach1=new Person("Mr. WorkerMach1");
		AutomaticProducer mach1=new AutomaticProducer(50,"Machine1",personMach1);
		Person personMach2=new Person("Mr. WorkerMach2");
		AutomaticProducer mach2=new AutomaticProducer(50,"Machine2",personMach2);
		
		Person person7=new Person("Mr. Worker7");
		ManuelProducer worker7=new ManuelProducer(100,"workerstation7",person7);
		Person person8=new Person("Mr. Worker8");
		ManuelProducer worker8=new ManuelProducer(100,"workerstation8",person8);
		
	
		sifi.addCom(cvm);
		cvm.addCom(AsOneOfCvm);
		AsOneOfCvm.addCom(statOneOfCvm);
		AsOneOfCvm.addCom(statTwoOfCvm);
		AsOneOfCvm.addCom(statThreeOfCvm);
		statOneOfCvm.addCom(worker1);
		statTwoOfCvm.addCom(worker2);
		statThreeOfCvm.addCom(worker3);
		statThreeOfCvm.addCom(worker4);

		
		sifi.addCom(ib);
		ib.addCom(AsOneOfib);
		ib.addCom(AsTwoOfib);
		AsOneOfib.addCom(statOneOfib);
		AsOneOfib.addCom(statTwoOfib);
		AsTwoOfib.addCom(statThreeOfib);
		AsTwoOfib.addCom(statFourOfib);
		statOneOfib.addCom(worker5);
		statTwoOfib.addCom(mach1);
		statThreeOfib.addCom(worker6);
		statFourOfib.addCom(mach2);
		
		
		sifi.addCom(finish);
		finish.addCom(finishStation);
		finishStation.addCom(worker7);
		finishStation.addCom(worker8);
		
		
		System.out.println(sifi.getReportedQualityIssues());
		
		new QualityAlertVisitor(1,1,1,1,1,1).visit(sifi);
		
		
		
		
		
		

	}

}
