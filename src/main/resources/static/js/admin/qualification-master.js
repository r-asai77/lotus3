document.querySelectorAll('[data-expand-id]').forEach(btn => {
    btn.addEventListener('click', function () {
        const id = this.dataset.expandId;
        const isCollapsed = this.classList.contains('collapsed');
        if (isCollapsed) {
            const rows = document.querySelectorAll(`[data-child-of="${id}"]`);
            rows.forEach((row, i) => {
                row.classList.remove('d-none');
                row.style.animationDelay = (i * 60) + 'ms';
                row.classList.remove('row-entering');
                void row.offsetWidth; // reflow to restart animation
                row.classList.add('row-entering');
                row.addEventListener('animationend', () => {
                    row.classList.remove('row-entering');
                    row.style.animationDelay = '';
                }, { once: true });
            });
        } else {
            collapseGroup(id);
        }
        this.classList.toggle('collapsed');
    });
});

function collapseGroup(id) {
    document.querySelectorAll(`[data-child-of="${id}"]`).forEach(row => {
        row.classList.add('d-none');
        row.querySelectorAll('[data-expand-id]').forEach(subBtn => {
            if (!subBtn.classList.contains('collapsed')) {
                subBtn.classList.add('collapsed');
                collapseGroup(subBtn.dataset.expandId);
            }
        });
    });
}
