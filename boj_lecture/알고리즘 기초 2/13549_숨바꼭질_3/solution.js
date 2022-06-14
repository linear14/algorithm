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
    
    if(this.size === 0) {
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
      this.head = this.head.next;
    }
    this.size--;

    return node.value;
  }
}


const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const nextFunctions = [
  ({ cur, time }) => ({ nCur: cur - 1, nTime: time + 1 }),
  ({ cur, time }) => ({ nCur: cur + 1, nTime: time + 1 }),
  ({ cur, time }) => ({ nCur: 2 * cur, nTime: time })
]

let n, k;

rl.on('line', (input) => {
  [n, k] = input.split(' ').map(i => +i);
  rl.close();
}).on('close', () => {
  if(n >= k) {
    console.log(n - k);
    return;
  }
  let ans = 100001;
  const DOUBLE_MAX_POS = (2 * k) + 1;
  const leastVisitTime = Array(DOUBLE_MAX_POS).fill(100001);

  const q = new Queue();
  q.enqueue({ cur: n, time: 0 });
  leastVisitTime[n] = 0;

  while(q.size > 0) {
    const { cur, time } = q.dequeue();

    if(cur === k) {
      ans = Math.min(ans, time);
      continue;
    }
    
    for(let i = 0; i < 3; i++) {
      const nextFunction = nextFunctions[i];
      const { nCur, nTime } = nextFunction({ cur, time });

      if(nCur >= 0 && nCur < DOUBLE_MAX_POS && leastVisitTime[nCur] > nTime) {
        q.enqueue({ cur: nCur, time: nTime });
        leastVisitTime[nCur] = nTime;
      }
    }
  }

  console.log(ans);
});