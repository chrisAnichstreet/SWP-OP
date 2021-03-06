# Generated by Django 2.1.7 on 2019-04-16 10:32

from django.conf import settings
import django.contrib.auth.models
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('Schulnotenerfassung', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Lehrer2',
            fields=[
                ('user_ptr', models.OneToOneField(auto_created=True, on_delete=django.db.models.deletion.CASCADE, parent_link=True, primary_key=True, serialize=False, to=settings.AUTH_USER_MODEL)),
            ],
            options={
                'verbose_name': 'Lehrer',
                'verbose_name_plural': 'Lehrer',
            },
            bases=('Schulnotenerfassung.user',),
            managers=[
                ('objects', django.contrib.auth.models.UserManager()),
            ],
        ),
        migrations.RemoveField(
            model_name='lehrer',
            name='user',
        ),
        migrations.RemoveField(
            model_name='schueler',
            name='k_id',
        ),
        migrations.RemoveField(
            model_name='schueler',
            name='user',
        ),
        migrations.AlterModelOptions(
            name='schueler2',
            options={'verbose_name': 'Schueler', 'verbose_name_plural': 'Schueler'},
        ),
        migrations.AlterField(
            model_name='noten',
            name='s_id',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='Schulnotenerfassung.Schueler2', verbose_name='Schueler'),
        ),
        migrations.AlterField(
            model_name='unterrichts_fach',
            name='l_id',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='Schulnotenerfassung.Lehrer2', verbose_name='Lehrer'),
        ),
        migrations.DeleteModel(
            name='Lehrer',
        ),
        migrations.DeleteModel(
            name='Schueler',
        ),
    ]
