(function () {
      const form = document.getElementById('contact-form');

      const h1 = document.createElement('h1');
      h1.textContent = 'Contact Me!';
      form.appendChild(h1);

      // Helper to create an input group (label + control + error)
      function field({ id, label, type = 'text', attrs = {}, textarea = false, required = false }) {
        const wrap = document.createElement('div');
        wrap.className = 'field';

        const labelEl = document.createElement('label');
        labelEl.setAttribute('for', id);
        labelEl.textContent = label;

        const err = document.createElement('div');
        err.className = 'error';
        err.id = id + '-error';
        err.setAttribute('aria-live', 'polite');

        let control;
        if (textarea) {
          control = document.createElement('textarea');
          control.rows = 5;
        } else {
          control = document.createElement('input');
          control.type = type;
        }
        control.id = id;
        control.name = id;
        control.setAttribute('aria-describedby', err.id);

        if (required) {
          control.required = true;
          labelEl.insertAdjacentHTML('beforeend', '<span class="sr-only">* </span>');
        }

        Object.entries(attrs).forEach(([k, v]) => control.setAttribute(k, v));

        wrap.append(labelEl, control, err);
        return { wrap, control, err };
      }

      const nameFld = field({
        id: 'name',
        label: 'Name',
        required: true,
        attrs: { autocomplete: 'name', placeholder: 'Full name' }
      });
      const emailFld = field({
        id: 'email',
        label: 'Email',
        type: 'email',
        required: true,
        attrs: { autocomplete: 'email', placeholder: 'name@example.com', inputmode: 'email' }
      });
      const msgFld = field({
        id: 'message',
        label: 'Message',
        textarea: true,
        required: true,
        attrs: { placeholder: 'Any questions or inquiries? I will try to accomodate.' }
      });

      form.append(nameFld.wrap, emailFld.wrap, msgFld.wrap);

      const submit = document.createElement('button');
      submit.id = 'submit-btn';
      submit.type = 'submit';
      submit.textContent = 'Send';
      form.appendChild(submit);

      // Client side validation
      function validate() {
        let ok = true;

        [nameFld, emailFld, msgFld].forEach(({ err }) => (err.textContent = ''));

        if (!nameFld.control.value.trim()) {
          nameFld.err.textContent = 'Please enter your name.';
          ok = false;
        }

        const email = emailFld.control.value.trim();
        if (!email) {
          emailFld.err.textContent = 'Please enter your email.';
          ok = false;
        } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) {
          emailFld.err.textContent = 'Please enter a valid email address.';
          ok = false;
        }

        if (!msgFld.control.value.trim()) {
          msgFld.err.textContent = 'Please enter a message.';
          ok = false;
        }

        return ok;
      }

      form.addEventListener('submit', (e) => {
        e.preventDefault();

        if (!validate()) {
          return;
        }

        const data = {
          name: nameFld.control.value.trim(),
          email: emailFld.control.value.trim(),
          message: msgFld.control.value.trim()
        };

        // debugging output. Replace with toastr later.
        const result = document.getElementById('result');
        result.innerHTML = `
          <div class="success-message">
            <strong>Submitted!</strong><br/>
            <pre>${JSON.stringify(data, null, 2)}</pre>
          </div>
        `;

        // For future endpoint assist. Uncomment and adjust the URL as needed.
        // fetch('/api/contact', {
        //   method: 'POST',
        //   headers: { 'Content-Type': 'application/json' },
        //   body: JSON.stringify(data)
        // }).then(r => r.json()).then(console.log).catch(console.error);

        form.reset();
      });
    })();
