const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

let n;
const arr = [];
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr.push(input.split(' '));
    if(arr.length === n) rl.close();
  }
}).on('close', () => {
  console.log(solution());
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
      this.tail = node;
    }
    else {
      this.tail.next = node;
      this.tail = node;
    }
    this.size++;
  }

  pop() {
    if(this.size === 0) return -1;

    const node = this.head;
    this.head = node.next;
    this.size--;
    if(!this.head) this.tail = null;
    return node.value;
  }
  
  isEmpty() {
    return +(this.size === 0);
  }

  front() {
    return this.head?.value || -1;
  }

  back() {
    return this.tail?.value || -1;
  }
}

const solution = () => {
  const q = new Queue();
  const ans = [];

  for(let i = 0; i < n; i++) {
    const [cmd, x] = arr[i];

    if(cmd === 'push') q.push(+x); 
    else if(cmd === 'pop') ans.push(q.pop());
    else if(cmd === 'size') ans.push(q.size);
    else if(cmd === 'empty') ans.push(q.isEmpty());
    else if(cmd === 'front') ans.push(q.front());
    else if(cmd === 'back') ans.push(q.back());
  }
  
  return ans.join('\n');
}