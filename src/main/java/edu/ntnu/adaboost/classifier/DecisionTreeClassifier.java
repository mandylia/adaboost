package edu.ntnu.adaboost.classifier;

import edu.ntnu.adaboost.model.Instance;

import java.util.ArrayList;
import java.util.List;

public class DecisionTreeClassifier implements Classifier {

    private final int dtcMaxDepth;
    private Node rootNode;
    private final DecisionTreeClassifierHelper decisionTreeClassifierHelper;

    public DecisionTreeClassifier(int dtcMaxDepth, final DecisionTreeClassifierHelper decisionTreeClassifierHelper) {
        this.dtcMaxDepth = dtcMaxDepth;
        this.rootNode = new Node();
        this.decisionTreeClassifierHelper = decisionTreeClassifierHelper;
    }
<<<<<<< HEAD
    
=======

>>>>>>> 93667a3404a2e8deedb2a067bfd95e882e202f8e
    public void train(List<Instance> trainingSet) {
        List<Integer> featureIds = new ArrayList<Integer>();
        for (int i = 0; i < trainingSet.get(0).featureCount(); i++) {
            featureIds.add(new Integer(i));
        }
        this.rootNode = decisionTreeClassifierHelper.QuinlanDT(trainingSet, featureIds, dtcMaxDepth);
    }
<<<<<<< HEAD
   
=======

>>>>>>> 93667a3404a2e8deedb2a067bfd95e882e202f8e
    public int predict(List<Double> features) {
        int currentFeatureId = rootNode.getFeatureId();
        double currentFeatureValue = features.get(currentFeatureId);
        int classPredicted = rootNode.getClazz();
        Node currentNode = rootNode;
        while (!currentNode.isLeaf() || currentNode == null) {
            currentFeatureValue = features.get(currentFeatureId);
            currentNode = currentNode.getSuccessors().get(currentFeatureValue);

            if (currentNode == null) { // unknown feature value
                classPredicted = -1;
                break;
            }

            classPredicted = currentNode.getClazz();
            currentFeatureId = currentNode.getFeatureId();
        }
        return classPredicted;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }

}
