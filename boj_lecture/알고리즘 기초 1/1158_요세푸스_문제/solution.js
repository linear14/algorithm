const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

let n;
let k;
rl.on('line', (input) => {
  if(!n) {
    [n, k] = input.split(' ').map(i => +i);
    rl.close();
  }
}).on('close', () => {
  const ans = solution();
  console.log(`<${ans.join(', ')}>`);
})

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

  push(value) {
    const node = new Node(value);
    if(!this.head) {
      this.head = node;
    }
    if(this.tail) {
      this.tail.next = node;
    }
    this.tail = node;
    this.size++;
  }

  // not considered when queue is empty
  pop() {
    const node = this.head;
    this.head = this.head.next;
    this.size--;

    if(this.size === 0) {
      this.head = null;
      this.tail = null;
    }

    return node.value;
  }
}

const solution = () => {
  const ans = [];
  const q = new Queue();
  for(let i = 1; i <= n; i++) {
    q.push(i);
  }

  let count = 1;
  while(q.size > 0) {
    const next = q.pop();
    if(count === k) {
      ans.push(next);
      count = 1;
    }
    else {
      q.push(next);
      count++;
    }
  }
  return ans;
}