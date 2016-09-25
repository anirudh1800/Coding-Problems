"use strict";

class Node {
	constructor(data, left, right){
		this.data = data;
		this.left = left;
		this.right = right;
	}

	isBST(node){
		if(node !== null){
			if(!this.isBST(node.left, this.value))
				return false;

			if(this.value !== null && node.data <= this.value)
				return false;

			this.value = node.data;
			return this.isBST(node.right, this.value);
		}

		return true;
	}

	set leftTo(leftNode){
		this.left = leftNode;
	}

	set rightTo(rightNode){
		this.right = rightNode;
	}

	get leftTo(){
		return this.left;
	}

	get rightTo(){
		return this.right;
	}


}

var node = new Node(2, null, null);
node.leftTo = new Node(1, null, null);
node.rightTo = new Node(3, null, null);
var root = new Node(4, null, null);
root.leftTo = node;
root.rightTo = new Node(5, null, null);

console.log(root);
console.log(root.isBST(root));
