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

const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let t;
let cur = 1;
const nList = [];
const startList = [];
const endList = [];
rl.on('line', (input) => {
  if(!t) t = +input;
  else {
    if(nList.length < cur) {
      nList.push(+input);
    }
    else if(startList.length < cur) {
      startList.push(input.split(' ').map(i => +i));
    }
    else {
      endList.push(input.split(' ').map(i => +i));
      cur++;
    }
  }
  if(cur > t) rl.close();
}).on('close', () => {
  const ans = [];
  const dx = [-2, -2, -1, -1, 1, 1, 2, 2];
  const dy = [1, -1, 2, -2, 2, -2, 1, -1];
  
  for(let i = 0; i < t; i++) {
    const n = nList[i];
    const start = startList[i];
    const end = endList[i];
    const isVisited = Array.from({ length: n }, () => Array(n).fill(false));
    isVisited[start[0]][start[1]] = true;

    const q = new Queue();
    q.enqueue({ cx: start[0], cy: start[1], depth: 0 });

    while(q.size > 0) {
      const { cx, cy, depth } = q.dequeue();
      if(cx === end[0] && cy === end[1]) {
        ans.push(depth);
        break;
      }
      
      for(let j = 0; j < 8; j++) {
        const [nx, ny] = [cx + dx[j], cy + dy[j]];
        
        if(nx >= 0 && nx < n && ny >= 0 && ny < n)  {
          if(!isVisited[nx][ny]) {
            isVisited[nx][ny] = true;
            q.enqueue({ cx: nx, cy: ny, depth: depth + 1 });
          }
        }
      }
    }
  }
  console.log(ans.join('\n'));
});