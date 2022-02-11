const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

let n;
const cmds = [];
rl.on('line', (input) => {
  if(!n) n = + input;
  else {
    cmds.push(input.split(' '));
    if(cmds.length === n) rl.close();
  }
}).on('close', () => {
  console.log(solution());
})

class Node {
  constructor(value) {
    this.value = value;
    this.prev = null;
    this.next = null;
  }
}

class Deque {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  push_front(value) {
    const node = new Node(value);
    if(!this.head && !this.tail) {
      this.head = node;
      this.tail = node;
    }
    else {
      node.next = this.head;
      this.head.prev = node;
      this.head = node;
    }
    this.size++;
  }

  push_back(value) {
    const node = new Node(value);
    if(!this.head && !this.tail) {
      this.head = node;
      this.tail = node;
    }
    else {
      node.prev = this.tail;
      this.tail.next = node;
      this.tail = node;
    }
    this.size++;
  }

  pop_front() {
    const node = this.head;
    if(node) {
      if(this.size > 1) this.head.next.prev = null;
      this.head = this.head.next;
      if(--this.size === 0) {
        this.head = null;
        this.tail = null;
      }
    }
    return node?.value ?? -1;
  }

  pop_back() {
    const node = this.tail;
    if(node) {
      if(this.size > 1) this.tail.prev.next = null;
      this.tail = this.tail.prev;
      if(--this.size === 0) {
        this.head = null;
        this.tail = null;
      }
    }
    return node?.value ?? -1;
  }

  empty() {
    return +(this.size === 0)
  }

  front() {
    return this.head?.value ?? -1;
  }

  back() {
    return this.tail?.value ?? -1;
  }

}

const solution = () => {
  const ans = [];
  const dq = new Deque();

  for(let i = 0; i < n; i++) {
    const [cmd, x] = cmds[i];

    if(cmd === 'push_front') dq.push_front(+x);
    else if(cmd === 'push_back') dq.push_back(+x);
    else if(cmd === 'pop_front') ans.push(dq.pop_front());
    else if(cmd === 'pop_back') ans.push(dq.pop_back());
    else if(cmd === 'size') ans.push(dq.size);
    else if(cmd === 'empty') ans.push(dq.empty());
    else if(cmd === 'front') ans.push(dq.front());
    else if(cmd === 'back') ans.push(dq.back());
  }

  return ans.join('\n');
}