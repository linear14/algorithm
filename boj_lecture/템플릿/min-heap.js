class Node {
  constructor(value, priority) {
    this.value = value;
    this.priority = priority;
  }
}

// 최소 힙
class Heap {
  constructor() {
    this.heap = [];
  }

  getLeftChildIndex(parentIdx) {
    return 2 * parentIdx + 1;
  }

  getRightChildIndex(parentIdx) {
    return 2 * parentIdx + 2;
  }

  getParentIndex(childIdx) {
    return Math.floor((childIdx - 1) / 2);
  }

  peek() {
    return this.heap[0];
  }

  insert(value, priority) {
    const node = new Node(value, priority);
    this.heap.push(node);
    this.heapifyUp();
  }

  remove() {
    const count = this.heap.length;
    if(count === 0) return undefined;

    const rootNode = this.peek();
    if(count === 1) this.heap = [];
    else {
      this.heap[0] = this.heap.pop();
      this.heapifyDown();
    }
    return rootNode;
  }

  heapifyUp() {
    let curIndex = this.heap.length - 1;
    const targetNode = this.heap[curIndex];

    // Root Node에 도달하기 전 까지 돌리기
    while(curIndex > 0) {
      const parentIndex = this.getParentIndex(curIndex);
      
      if(this.heap[parentIndex].priority > targetNode.priority) {
        this.heap[curIndex] = this.heap[parentIndex];
        curIndex = parentIndex;
      }
      else {
        break;
      }
    }
    this.heap[curIndex] = targetNode;
  }

  heapifyDown() {
    let curIndex = 0;
    const targetNode = this.heap[curIndex];

    // Child Node가 존재할 때 까지 돌리기
    while(this.getLeftChildIndex(curIndex) < this.heap.length) {
      const leftChildIndex = this.getLeftChildIndex(curIndex);
      const rightChildIndex = this.getRightChildIndex(curIndex);

      const nextChildIndex = rightChildIndex >= this.heap.length 
        ? leftChildIndex
        : this.heap[leftChildIndex].priority < this.heap[rightChildIndex].priority 
        ? leftChildIndex
        : rightChildIndex

      if(this.heap[nextChildIndex].priority < targetNode.priority) {
        this.heap[curIndex] = this.heap[nextChildIndex];
        curIndex = nextChildIndex;
      }
      else {
        break;
      }
    }
    this.heap[curIndex] = targetNode;
  }
}

export default Heap;