class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  enqueue(value) {
    const node = new Node(value);
    
    if(this.head === null) {
      this.head = node;
      this.tail = node;
    }
    else {
      this.tail.next = node;
      this.tail = node;
    }

    this.size++;
  }

  dequeue() {
    if(this.head === null) {
      return undefined;
    }

    const node = this.head;
    this.head = node.next;
    this.size--;

    if(this.size === 0) {
      this.head = null;
      this.tail = null;
    }

    return node.value;
  }
}