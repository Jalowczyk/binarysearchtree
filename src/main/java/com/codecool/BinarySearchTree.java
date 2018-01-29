package com.codecool;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(int rootInt) {
        this.root = new Node(rootInt);
    }

    public void insert(int number) {
        Node current = this.root;
        boolean isInserted = false;

        while (isInserted == false) {

            if (number > current.getValue() && current.getRight() == null) {
                current.setRight(new Node(number));
                isInserted = true;
            } else if (number < current.getValue() && current.getLeft() == null) {
                current.setLeft(new Node(number));
                isInserted = true;
            } else if (number > current.getValue() && current.getRight() != null) {
                current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }
    }

    public boolean find(int number) {
        Node current = this.root;

        while (current != null) {
            if (current.getValue() != number) {
                if (number > current.getValue()) {
                    current = current.getRight();
                } else {
                    current = current.getLeft();
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean delete(int number) {
        Node parent = this.root;
        Node current = this.root;
        boolean isRightChild = false;

        while(current.getValue() != number){
            parent = current;

            if(number < current.getValue()){
                isRightChild = false;
                current = current.getLeft();

            } else {
                isRightChild = true;
                current = current.getRight();
            }

            if(current == null){
                return false;
            }
        }

        if (isRightChild) {
            if (current.getLeft() == null && current.getRight() == null) {
                parent.setRight(null);
            }
            else if (current.getLeft() != null || current.getRight() == null) {
                parent.setRight(current.getLeft());
            }
            else if (current.getLeft() == null || current.getRight() != null) {
                parent.setRight(current.getRight());
            } else {
                //find maximum in right, change, then delete duplicate
            }
        } else {
            if (current.getLeft() == null && current.getRight() == null) {
                parent.setLeft(null);
            }
            else if (current.getLeft() != null || current.getRight() == null) {
                parent.setLeft(current.getLeft());
            }
            else if (current.getLeft() == null || current.getRight() != null) {
                parent.setLeft(current.getRight());
            } else {
                //find maximum in right, change, then delete duplicate
            }
        }
        return true;

    }

    private class Node {
        private int value;
        private Node left = null;
        private Node right = null;

        private Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
