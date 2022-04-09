import Heap from './min-heap';

class PriorityQueue extends Heap {
  constructor() {
    super();
  }

  enqueue(value, priority) {
    this.insert(value, priority);
  }

  dequeue() {
    return this.remove();
  }

  isEmpty() {
    return this.heap.length === 0;
  }
}