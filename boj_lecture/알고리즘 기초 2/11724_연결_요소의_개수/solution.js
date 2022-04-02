const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n, m;
const arr = [];
rl.on('line', (input) => {
  if(!n) [n, m] = input.split(' ').map(i => +i);
  else {
    arr.push(input.split(' ').map(i => +i));
    if(arr.length === m) rl.close();
  }
}).on('close', () => {
  const adj_list = Array.from({ length: n+1 }, () => []);
  
  for(let i = 0; i < m; i++) {
    adj_list[arr[i][0]].push(arr[i][1]);
    adj_list[arr[i][1]].push(arr[i][0]);
  }
  
  let ans = 0;
  const isVisited = Array(n+1).fill(false);
  const q = new Queue();
  
  for(let i = 1; i <= n; i++) {
    if(!isVisited[i]) {
      q.push(i);
      isVisited[i] = true;
      
      while(q.size !== 0) {
        const cur = q.pop();
        const adj = adj_list[cur];

        adj.forEach(next => {
          if(!isVisited[next]) {
            q.push(next);
            isVisited[next] = true;
          }
        })
      }
      ans++;
    }
  }

  console.log(ans);
});

class Node {
  constructor(value) {
    this.value = value;
    this.prev = null;
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

  pop() {
    if(this.size === 0) {
      return;
    }
    
    const node = this.head;

    if(this.size === 1) {
      this.head = null;
      this.tail = null;
    }
    else {
      this.head = this.head.next;
      this.head.prev = null;
    }
    this.size--;

    return node.value;
  }
}