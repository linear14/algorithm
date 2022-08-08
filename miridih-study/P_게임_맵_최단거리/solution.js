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

    if (this.size === 0) {
      this.head = node;
      this.tail = node;
    } else {
      this.tail.next = node;
      this.tail = node;
    }
    this.size++;
  }

  dequeue() {
    if (this.size === 0) {
      return undefined;
    }

    if (this.size === 1) {
      const node = this.head;
      this.head = null;
      this.tail = null;
      this.size--;
      return node.value;
    }

    const node = this.head;
    this.head = this.head.next;
    this.size--;
    return node.value;
  }
}

const dn = [0, 0, -1, 1];
const dm = [1, -1, 0, 0];

const solution = (maps) => {
  const [n, m] = [maps.length, maps[0].length];
  const isVisited = Array.from({ length: n }, () => Array(m).fill(false));
  const q = new Queue();

  q.enqueue([0, 0, 1]);
  isVisited[0][0] = true;

  while (q.size > 0) {
    const [cn, cm, depth] = q.dequeue();

    if (cn === n - 1 && cm === m - 1) {
      return depth;
    }

    for (let i = 0; i < 4; i++) {
      const [nn, nm] = [cn + dn[i], cm + dm[i]];
      if (nn >= 0 && nn < n && nm >= 0 && nm < m && !isVisited[nn][nm]) {
        if (maps[nn][nm] === 1) {
          q.enqueue([nn, nm, depth + 1]);
        }
        isVisited[nn][nm] = true;
      }
    }
  }

  return -1;
};
