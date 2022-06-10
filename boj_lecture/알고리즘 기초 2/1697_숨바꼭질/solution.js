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
    if(this.size === 0) {
      return undefined;
    }
    
    const node = this.head;
    if(this.size === 1) {
      this.head = null;
      this.tail = null;
    }
    else {
      this.head = node.next;
    }
    this.size--;
    return node.value;
  }
}

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const functions = [(n) => n - 1, (n) => n + 1, (n) => 2 * n];
let n, k;

rl.on('line', (input) => {
  [n, k] = input.split(' ').map(i => +i);
  rl.close();
}).on('close', () => {
  const q = new Queue();
  const isVisited = Array(100001).fill(false);
  isVisited[n] = true;
  q.enqueue({ cur: n, depth: 0 });

  while(q.size > 0) {
    const { cur, depth } = q.dequeue();
    if(cur === k) {
      console.log(depth);
      return;
    }
    
    for(let i = 0; i < 3; i++) {
      const nextFunction = functions[i];
      const next = nextFunction(cur);

      if(next >= 0 && next <= 100000 && !isVisited[next]) {
        isVisited[next] = true;
        q.enqueue({ cur: next, depth: depth + 1 });
      }
    }
  }
});