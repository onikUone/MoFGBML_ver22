package method;

import java.io.File;
import java.util.ArrayList;

import fgbml.Results;
import fgbml.multitask.TaskManager;
import main.Consts;
import main.Setting;

public class ResultMaster {
	// ************************************************************
	String rootDir;
	String id;
	String trialRoot;
	int nowCV;
	int nowRep;


	public ArrayList<Double> traAve = new ArrayList<Double>();
	public ArrayList<Double> tstAve = new ArrayList<Double>();
	public ArrayList<Double> ruleNumAve = new ArrayList<Double>();
	public ArrayList<Double> lengthAve = new ArrayList<Double>();

	public ArrayList<Double> times = new ArrayList<Double>();
	public ArrayList<Double> evaTimes = new ArrayList<Double>();

	public ArrayList<String> population = new ArrayList<String>();
	public ArrayList<String> offspring = new ArrayList<String>();
	public ArrayList<String> ruleSetPopulation = new ArrayList<String>();
	public ArrayList<String> ruleSetOffspring = new ArrayList<String>();

	public ArrayList<String> bestIndividual = new ArrayList<>();
	public ArrayList<String> bestRuleSet = new ArrayList<>();

	public ArrayList<Results> results = new ArrayList<>();

	//MultiTask用
	public ArrayList<TaskManager> worlds = new ArrayList<>();

	//FAN2021用
	public int sameParentCount = 0;
	public int[] offspringNumWithRuleNum = new int[Consts.MAX_RULE_NUM];
	public ArrayList<Integer> truePopSize = new ArrayList<>();
	public ArrayList<Integer> updatedNum = new ArrayList<>();


	// ************************************************************
	public ResultMaster() {}

	public ResultMaster(String rootDir, String id) {
		this.rootDir = rootDir;
		this.id = id;
	}

	// ************************************************************

	public void outputTimes(String fileName) {
		String str = "";
		ArrayList<String> strs = new ArrayList<String>();

		//Header
		str = "CV";
		str += "," + "Time";
		str += "," + "evaTime";
		strs.add(str);

		//Contains
		for(int cv = 0; cv < times.size(); cv++) {
			str = String.valueOf(cv);
			str += "," + String.valueOf(times.get(cv));
			str += "," + String.valueOf(evaTimes.get(cv));
			strs.add(str);
		}

		Output.writeln(fileName, strs);
	}

	public void outputIndividual(String populationDir, String offspringDir) {
		String sep = File.separator;
		String fileName;

		//Population
		for(int i = 0; i < population.size(); i++) {
			int genCount = i * Setting.timingOutput;
			fileName = populationDir + sep + Consts.INDIVIDUAL + sep + "gen" + genCount + ".csv";
			Output.writeln(fileName, population.get(i));
//			fileName = populationDir + sep + Consts.RULESET + sep + "gen" + genCount + ".txt";
//			Output.writeln(fileName, ruleSetPopulation.get(i));
		}

		//Offspring
		for(int i = 0; i < offspring.size(); i++) {
			int genCount = (i+1) * Setting.timingOutput;
			fileName = offspringDir + sep + Consts.INDIVIDUAL + sep + "gen" + genCount + ".csv";
			Output.writeln(fileName, offspring.get(i));
//			fileName = offspringDir + sep + Consts.RULESET + sep + "gen" + genCount + ".txt";
//			Output.writeln(fileName, ruleSetOffspring.get(i));
		}

	}

	public void addTaskManager(TaskManager world) {
		this.worlds.add(world);
	}

	public void addTraAve(double tra) {
		this.traAve.add(tra);
	}

	public void addTstAve(double tst) {
		this.tstAve.add(tst);
	}

	public void addRuleNumAve(double ruleNum) {
		ruleNumAve.add(ruleNum);
	}

	public void addLengthAve(double length) {
		lengthAve.add(length);
	}

	public void addTimes(double time) {
		times.add(time);
	}

	public void addEvaTimes(double evaTime) {
		evaTimes.add(evaTime);
	}

	public void addPopulation(String str) {
		this.population.add(str);
	}

	public void addOffspring(String str) {
		this.offspring.add(str);
	}

	public void addRuleSetPopulation(String str) {
		this.ruleSetPopulation.add(str);
	}

	public void addRuleSetOffspring(String str) {
		this.ruleSetOffspring.add(str);
	}

	public void addBestIndividual(String str) {
		this.bestIndividual.add(str);
	}

	public void addBestRuleSet(String str) {
		this.bestRuleSet.add(str);
	}

	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}

	public String getRootDir() {
		return this.rootDir;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getID() {
		return this.id;
	}

	public void setNowCV(int cv) {
		this.nowCV = cv;
	}

	public int getNowCV() {
		return this.nowCV;
	}

	public void setNowRep(int rep) {
		this.nowRep = rep;
	}

	public int getNowRep() {
		return this.nowRep;
	}

	public void setTrialRoot(String trialRoot) {
		this.trialRoot = trialRoot;
	}

	public String getTrialRoot() {
		return this.trialRoot;
	}

	public ArrayList<TaskManager> getWorlds() {
		return worlds;
	}

	public void addResults(Results result) {
		this.results.add(result);
	}

	public ArrayList<Results> getResults() {
		return this.results;
	}

	public Results getResults(int i) {
		return this.results.get(i);
	}

	public void clearSameParentCount() {
		this.sameParentCount = 0;
	}

	public int getSameParentCount() {
		return this.sameParentCount;
	}

	public void addSameParentCount(int count) {
		this.sameParentCount += count;
	}

	public void incrementSameParentCount() {
		this.sameParentCount++;
	}

	public int[] getOffspringNumWithRuleNum() {
		return this.offspringNumWithRuleNum;
	}

	public void incrementOffspringNumWithRuleNum(int ruleNum) {
		this.offspringNumWithRuleNum[ruleNum-1]++;
	}

	public void clearOffspringNumWithRuleNum() {
		this.offspringNumWithRuleNum = new int[Consts.MAX_RULE_NUM];
	}

	public void addTruePopSize(int truePopSize) {
		this.truePopSize.add(truePopSize);
	}

	public ArrayList<Integer> getTruePopSize() {
		return this.truePopSize;
	}

	public void addUpdatedNum(int updatedNum) {
		this.updatedNum.add(updatedNum);
	}

	public ArrayList<Integer> getUpdatedNum() {
		return this.updatedNum;
	}

}
