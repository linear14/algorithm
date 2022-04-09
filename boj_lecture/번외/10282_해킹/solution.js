const rl = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let t;
let cur = 0;
let next = 0;
const ndc = [];
const abs = [];
rl.on("line", (input) => {
  if (!t) t = +input;
  else {
    if (cur === next) {
      const [n, d, c] = input.split(" ").map((i) => +i);
      ndc.push([n, d, c]);
      cur++;
      next += d + 1;
    } else {
      abs.push(input.split(" ").map((i) => +i));
      cur++;
    }

    if (cur === next && ndc.length === t) {
      rl.close();
    }
  }
}).on("close", () => {
  const ans = [];
  let s = 0;
  for (let tc = 0; tc < t; tc++) {
    const [n, d, c] = ndc[tc];
    const graph = Array.from({ length: n + 1 }, () => []);

    for (let i = s; i < s + d; i++) {
      const [a, b, s] = abs[i];
      graph[b].push({ value: a, weight: s });
    }
    s += d;

    // dijkstra
    const distance = Array.from({ length: n + 1 }, () => Infinity);
    distance[c] = 0;

    const pq = new PriorityQueue();
    pq.enqueue(c, 0);

    while (!pq.isEmpty()) {
      const cur = pq.dequeue();
      const { value: curValue } = cur;

      for (let i = 0; i < graph[curValue].length; i++) {
        const { value: nextValue, weight } = graph[curValue][i];

        if(distance[nextValue] > distance[curValue] + weight) {
          distance[nextValue] = distance[curValue] + weight;
          pq.enqueue(nextValue, distance[nextValue]);
        }
      }
    }

    const infectedNodes = distance.filter((i) => i !== Infinity);
    ans.push(`${infectedNodes.length} ${Math.max(...infectedNodes)}`);
  }

  console.log(ans.join("\n"));
});

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
